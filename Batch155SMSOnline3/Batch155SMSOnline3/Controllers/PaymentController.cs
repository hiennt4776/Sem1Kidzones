using Batch155SMSOnline3.Models;
//using Batch155SMSOnline3.payment;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Batch155SMSOnline3.Others;
using Batch155SMSOnline3.SeSsIon;

namespace Batch155SMSOnline3.Controllers
{
    public class PaymentController : Controller
    {
        private dbBatch155SMS3Entities db = new dbBatch155SMS3Entities();
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult Create(int id)
        {

            Customer customer = db.Customers.Find(int.Parse(User.Identity.Name));

            ViewBag.Customer = customer;

            ViewBag.Service = db.Services.Find(id); ;

            //thoi gian cua goi dich vu
            ViewBag.timeService = viewLevel(id);
            int months = viewLevel(id);

            DateTime timenow = DateTime.Now;
            //dung session 
            var sevi = db.Services.Find(id);
            var acService = new Active();
            acService.IdCustomer = customer.Id;
            acService.IdService = sevi.Id;
            acService.Price = sevi.Price.Value;

            acService.StartService = timenow;
            acService.EndService = timenow.AddMonths(months);

            Session.Add(CommonConstant.ActiveSession, acService);


            return View();
        }

        /// <summary>
        /// Lấy thời gian chi tiết của gói dịch vụ
        /// </summary>
        /// <param name="serviceID"></param>
        /// <returns></returns>
        private int viewLevel(int serviceID)
        {
            var model = (from a in db.Services
                         join b in db.LevelServices
                         on a.IdLevel equals b.Id
                         where a.Id == serviceID
                         select b.TimeServerMonth).Single().Value;

            return model;
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create(int idser, int idcus, decimal price, DateTime startdate, DateTime endDate)
        {
            var active = new Active();
            active.IdService = idser;
            active.IdCustomer = idcus;
            active.Price = price;
            active.Status = true;
            active.StartService = startdate;
            active.EndService = endDate;

            db.Actives.Add(active);
            db.SaveChanges();

            return Redirect("/hoan-thanh");
        }


        //thanh-toan-online
        public ActionResult Payment(int id)
        {
            string url = ConfigurationManager.AppSettings["Url"];
            string returnUrl = ConfigurationManager.AppSettings["ReturnUrl"];
            string tmnCode = ConfigurationManager.AppSettings["TmnCode"];
            string hashSecret = ConfigurationManager.AppSettings["HashSecret"];

            PayLib pay = new PayLib();

            decimal price = db.Services.Find(id).Price.Value * 100;
            string p = price.ToString("0000000");



            pay.AddRequestData("vnp_Version", "2.0.0"); //Phiên bản api mà merchant kết nối. Phiên bản hiện tại là 2.0.0
            pay.AddRequestData("vnp_Command", "pay"); //Mã API sử dụng, mã cho giao dịch thanh toán là 'pay'
            pay.AddRequestData("vnp_TmnCode", tmnCode); //Mã website của merchant trên hệ thống của VNPAY (khi đăng ký tài khoản sẽ có trong mail VNPAY gửi về)
            pay.AddRequestData("vnp_Amount", p); //số tiền cần thanh toán, công thức: số tiền * 100 - ví dụ 10.000 (mười nghìn đồng) --> 1000000
            pay.AddRequestData("vnp_BankCode", ""); //Mã Ngân hàng thanh toán (tham khảo: https://sandbox.vnpayment.vn/apis/danh-sach-ngan-hang/), có thể để trống, người dùng có thể chọn trên cổng thanh toán VNPAY
            pay.AddRequestData("vnp_CreateDate", DateTime.Now.ToString("yyyyMMddHHmmss")); //ngày thanh toán theo định dạng yyyyMMddHHmmss
            pay.AddRequestData("vnp_CurrCode", "VND"); //Đơn vị tiền tệ sử dụng thanh toán. Hiện tại chỉ hỗ trợ VND
            pay.AddRequestData("vnp_IpAddr", Util.GetIpAddress()); //Địa chỉ IP của khách hàng thực hiện giao dịch
            pay.AddRequestData("vnp_Locale", "vn"); //Ngôn ngữ giao diện hiển thị - Tiếng Việt (vn), Tiếng Anh (en)
            pay.AddRequestData("vnp_OrderInfo", "Thanh toan don hang"); //Thông tin mô tả nội dung thanh toán
            pay.AddRequestData("vnp_OrderType", "other"); //topup: Nạp tiền điện thoại - billpayment: Thanh toán hóa đơn - fashion: Thời trang - other: Thanh toán trực tuyến
            pay.AddRequestData("vnp_ReturnUrl", returnUrl); //URL thông báo kết quả giao dịch khi Khách hàng kết thúc thanh toán
            pay.AddRequestData("vnp_TxnRef", DateTime.Now.Ticks.ToString()); //mã hóa đơn

            string paymentUrl = pay.CreateRequestUrl(url, hashSecret);

            return Redirect(paymentUrl);
        }

        public ActionResult PaymentConfirm()
        {
            var session = (Active)Session[CommonConstant.ActiveSession];

            if (Request.QueryString.Count > 0)
            {
                string hashSecret = ConfigurationManager.AppSettings["HashSecret"]; //Chuỗi bí mật
                var vnpayData = Request.QueryString;
                PayLib pay = new PayLib();

                //lấy toàn bộ dữ liệu được trả về
                foreach (string s in vnpayData)
                {
                    if (!string.IsNullOrEmpty(s) && s.StartsWith("vnp_"))
                    {
                        pay.AddResponseData(s, vnpayData[s]);
                    }
                }

                long orderId = Convert.ToInt64(pay.GetResponseData("vnp_TxnRef")); //mã hóa đơn
                long vnpayTranId = Convert.ToInt64(pay.GetResponseData("vnp_TransactionNo")); //mã giao dịch tại hệ thống VNPAY
                string vnp_ResponseCode = pay.GetResponseData("vnp_ResponseCode"); //response code: 00 - thành công, khác 00 - xem thêm https://sandbox.vnpayment.vn/apis/docs/bang-ma-loi/                
                string vnp_SecureHash = Request.QueryString["vnp_SecureHash"]; //hash của dữ liệu trả về

                bool checkSignature = pay.ValidateSignature(vnp_SecureHash, hashSecret); //check chữ ký đúng hay không?

                if (checkSignature)
                {
                    if (vnp_ResponseCode == "00")
                    {
                        //Thanh toán thành công
                        ViewBag.Message = "Thanh toán thành công hóa đơn " + orderId + " | Mã giao dịch: " + vnpayTranId;

                        var active = new Active();
                        active.IdService = session.IdService;
                        active.IdCustomer = session.IdCustomer;
                        active.Price = session.Price;
                        active.Status = true;
                        active.StartService = session.StartService;
                        active.EndService = session.EndService;

                        db.Actives.Add(active);
                        db.SaveChanges();

                    }
                    else
                    {
                        //Thanh toán không thành công. Mã lỗi: vnp_ResponseCode
                        ViewBag.Message = "Có lỗi xảy ra trong quá trình xử lý hóa đơn " + orderId + " | Mã giao dịch: " + vnpayTranId + " | Mã lỗi: " + vnp_ResponseCode;
                    }
                }
                else
                {
                    ViewBag.Message = "Có lỗi xảy ra trong quá trình xử lý";
                }
            }

            return View();
        }


    }
}