using Batch155SMSOnline3.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Web;
using System.Web.Mvc;
using System.Web.Security;
using System.IO;
using System.Data.Entity;
using CaptchaMvc.HtmlHelpers;
using System.Net;
using System.Linq.Expressions;

namespace Batch155SMSOnline3.Controllers
{
    public class CustomerController : Controller
    {
        dbBatch155SMS3Entities db = new dbBatch155SMS3Entities();

        private static Random random = new Random();
        public static string RandomString(int length)
        {
            const string chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            return new string(Enumerable.Repeat(chars, length)
              .Select(s => s[random.Next(s.Length)]).ToArray());
        }

        public ActionResult Index()
        {
            return View();
        }

       

        public static string GetMD5(string str)
        {
            MD5 md5 = new MD5CryptoServiceProvider();
            byte[] fromData = Encoding.UTF8.GetBytes(str);
            byte[] targetData = md5.ComputeHash(fromData);
            string byte2String = null;

            for (int i = 0; i < targetData.Length; i++)
            {
                byte2String += targetData[i].ToString("x2");

            }
            return byte2String;
        }


        [HttpGet]
        public ActionResult Register()
        {
            return View();
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Register(Customer customer)
        {
            if (!this.IsCaptchaValid(""))
            {
                ViewBag.ErrorMessageCaptcha = "Captcha is not valid";
                return View("Register", customer);
            }
            else
            {
                if (ModelState.IsValid)
                {
                    var checkPhoneNumber = db.Customers.FirstOrDefault(s => s.PhoneNumber == customer.PhoneNumber);
                    var checkUsername = db.Customers.FirstOrDefault(s => s.Username == customer.Username);
                    var checkEmail = db.Customers.FirstOrDefault(s => s.Email == customer.Email);
                    bool checkDayOfBirth = false;
                    if (customer.DateOfBirth != null)
                    {
                        int YearCustomer = int.Parse(customer.DateOfBirth.Value.Year.ToString());
                        int YearNow = int.Parse(DateTime.Now.Year.ToString());
                        checkDayOfBirth = (YearNow - YearCustomer) > 15;
                        if (!checkDayOfBirth) ViewBag.errorBirthDay = "You must be 15 year old to use the service";
                    }
                    else
                    {
                        ViewBag.errorBirthDay = "You must enter the Day Of Birth";
                    }

                    if ((checkPhoneNumber == null)&& (checkUsername == null)&& (checkEmail == null) && checkDayOfBirth)
                    {
                        customer.Password = GetMD5(customer.Password);
                        customer.DateOfRegistration = DateTime.Now;
                        customer.VerifyCode = RandomString(5);
                        customer.Active = false;
                        db.Configuration.ValidateOnSaveEnabled = false;

                        db.Customers.Add(customer);
                        db.SaveChanges();


                        var Ticket = new FormsAuthenticationTicket(customer.Id.ToString(), true, 3000);
                        string Encrypt = FormsAuthentication.Encrypt(Ticket);
                        var cookie = new HttpCookie(FormsAuthentication.FormsCookieName, Encrypt);
                        cookie.Expires = DateTime.Now.AddHours(3000);
                        Response.Cookies.Add(cookie);


                        return RedirectToAction("Verify");
                    }
                    else
                    {
                        if(checkPhoneNumber != null) ViewBag.errorPhoneNumber = "THIS MOBILE NUMBER had been registered already";
                        if(checkUsername != null) ViewBag.errorUsername = "THIS USERNAME had been registered already";
                        if(checkEmail != null) ViewBag.errorEmail = "THIS EMAIL had been registered already";
                      


                    }


                }
            }

            return View();

        }

        private static string SendSMS(string Phone, string VerifyCode)
        {
            SpeedSMSAPI api = new SpeedSMSAPI("_6EwJ0iCyzKvV8-GDD_lUVukXNsWoh0C");

           
            String[] phones = new String[] { Phone };
            String response = api.sendSMS(phones, VerifyCode, 2, "c936bae4f1226714");

            return response;
        }


        public ActionResult Verify() 
        {
            if (User.Identity.IsAuthenticated)
            {
                Customer customer = db.Customers.Find(int.Parse(User.Identity.Name));
   
                ViewBag.username = customer.Username;

                String textSendVerify = "Verify : " + customer.VerifyCode;
                ViewBag.Respond = SendSMS(customer.PhoneNumber, textSendVerify);

                return View(customer);
            }
            return RedirectToAction("Login", "Customer");
        }


        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Verify(Customer customer, string verifycode)
        {
            

            if (customer.VerifyCode == verifycode)
            {

                customer.Active = true;
                db.Entry(customer).State = EntityState.Modified;
               
                db.SaveChanges();
                return RedirectToAction("ApiIdDevice");
            }
            return View(customer);
        }


        public ActionResult ApiIdDevice()
        {
            if (User.Identity.IsAuthenticated)
            {
                Customer customer = db.Customers.Find(int.Parse(User.Identity.Name));

                ViewBag.username = customer.Username;

                return View(customer);
            }
            return RedirectToAction("Login", "Customer");
        }


        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult ApiIdDevice(Customer customer, string speedSMSAPI, string deviceID)
        {

            if (ModelState.IsValid)
            {
                customer.SpeedSMSAPI = speedSMSAPI;
                customer.deviceID = deviceID;
                db.Entry(customer).State = EntityState.Modified;
                db.SaveChanges();
            }
            
            return RedirectToAction("UpdateProfile");

  
        }



        public ActionResult ChangePassword()
        {
            if (User.Identity.IsAuthenticated)
            {
                Customer customer = db.Customers.Find(int.Parse(User.Identity.Name));

                ViewBag.username = customer.Username;

                return View(customer);
            }
            return RedirectToAction("Login", "Customer");
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult ChangePassword(Customer customer, string oldPassword, string newPassword)
        {
            if (customer.Password.Equals(GetMD5(oldPassword)))
            {
                customer.Password = GetMD5(newPassword);
                db.Entry(customer).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Logout", "Customer");
            }

            else
            {
                ViewBag.errorPassword = "Old Password is wrong";
            }
            return View();

        }



        public ActionResult UpdateProfile()
        {
            if (User.Identity.IsAuthenticated)
            {
                Customer customer = db.Customers.Find(int.Parse(User.Identity.Name));
                ViewBag.username = customer.Username;
                if (customer == null)
                {
                    return RedirectToAction("Login", "Customer");
                }
                if(customer.Active != true)
                {
                    return RedirectToAction("Verify", "Customer");
                }
                ViewBag.MaritalStatusId = new SelectList(db.MaritalStatus, "Id", "MaritalStatusName", customer.MaritalStatusId);
                ViewBag.WorkStatus = new SelectList(db.WorkStatus, "Id", "WorkStatusName", customer.WorkStatus);
                return View(customer);
            }
            return RedirectToAction("Login", "Customer");

        }

        // POST: Customers/Edit/5
        // To protect from overposting attacks, enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult UpdateProfile(Customer customer, HttpPostedFileBase image)
        {
            if (ModelState.IsValid)
            {


                string path = Server.MapPath("/Content/UploadFile");
                if (!Directory.Exists(path)) Directory.CreateDirectory(path);
      
                image.SaveAs(path + "/" + image.FileName);
               
                customer.Image = "Content/UploadFile/" + image.FileName;

                ViewBag.MaritalStatusId = new SelectList(db.MaritalStatus, "Id", "MaritalStatusName", customer.MaritalStatusId);
                ViewBag.WorkStatus = new SelectList(db.WorkStatus, "Id", "WorkStatusName", customer.WorkStatus);

                bool checkDayOfBirth = false;
                if (customer.DateOfBirth != null)
                {
                    int YearCustomer = int.Parse(customer.DateOfBirth.Value.Year.ToString());
                    int YearNow = int.Parse(DateTime.Now.Year.ToString());
                    checkDayOfBirth = (YearNow - YearCustomer) > 15;
                    if (!checkDayOfBirth) ViewBag.errorBirthDay = "You must be 15 year old to use the service";
                }
                else
                {
                    ViewBag.errorBirthDay = "You must enter the Day Of Birth";

                }

                if (checkDayOfBirth)
                {
                    db.Entry(customer).State = EntityState.Modified;
                    db.SaveChanges();
                    return RedirectToAction("ProfilePage");
                }

                return View();
            }
           
            return View();
        }



       
        public ActionResult Login()
        {
            return View();
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Login(string username, string password)
        {
            var f_password = GetMD5(password);

            Customer customer = db.Customers.SingleOrDefault(s => s.Username.Equals(username) && s.Password.Equals(f_password));


            if (customer != null)
            {


                var Ticket = new FormsAuthenticationTicket(customer.Id.ToString(), true, 3000);
                string Encrypt = FormsAuthentication.Encrypt(Ticket);
                var cookie = new HttpCookie(FormsAuthentication.FormsCookieName, Encrypt);
                cookie.Expires = DateTime.Now.AddHours(3000);
                Response.Cookies.Add(cookie);

                if (customer.Active == true)
                {
                    return RedirectToAction("ProfilePage", "Customer");
                }
                else {
                    return RedirectToAction("Verify", "Customer");
                }
       
            }
            return View();
        }


       

        public ActionResult ForgotPassword()
        {
            return View();
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult ForgotPassword(string username, string phonenumber, string email)
        {
            Customer customer = db.Customers.SingleOrDefault(s => s.Username.Equals(username) && s.PhoneNumber.Equals(phonenumber) && s.Email.Equals(email));


            if (customer != null)
            {
                int cusid = customer.Id;
                string cusemail = customer.Email;
                string cusphone = customer.PhoneNumber;

                string newPassword = RandomString(12);
            
                String newPassMess = "New PassWord : " + newPassword;
                ViewBag.Respond = SendSMS(customer.PhoneNumber, newPassMess);
                customer.Password = GetMD5(newPassword);
                db.Entry(customer).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Logout", "Customer");
            }


            return RedirectToAction("Login", "Customer");
        }


        public PartialViewResult FriendsListPartial(int id)
        { 
         
   
            var friends = db.Friends;
            List<Customer> ListFriendCustomer = new List<Customer>();
           
            int count = 0;
            foreach (var itemfriend in friends)
            {
                if (count == 15) break;
                if(itemfriend.IdUserFriendReceive == id && itemfriend.TimeFriend != null)
                {
                    Customer customer = db.Customers.Find(itemfriend.IdUserFriendSend);
                    ListFriendCustomer.Add(customer);
                    count++;
                }
                else if (itemfriend.IdUserFriendSend == id && itemfriend.TimeFriend != null)
                {
                    Customer customer = db.Customers.Find(itemfriend.IdUserFriendReceive);
                    ListFriendCustomer.Add(customer);
                    count++;
                }
            }
     

            return PartialView(ListFriendCustomer);
        }


        public PartialViewResult FriendsListMiniPartial(int id)
        {


            var friends = db.Friends;
            List<Customer> ListFriendCustomer = new List<Customer>();

            int count = 0;
            foreach (var itemfriend in friends)
            {
                if (count == 5) break;
                if (itemfriend.IdUserFriendReceive == id && itemfriend.TimeFriend != null)
                {
                    Customer customer = db.Customers.Find(itemfriend.IdUserFriendSend);
                    ListFriendCustomer.Add(customer);
                    count++;
                }
                else if (itemfriend.IdUserFriendSend == id && itemfriend.TimeFriend != null)
                {
                    Customer customer = db.Customers.Find(itemfriend.IdUserFriendReceive);
                    ListFriendCustomer.Add(customer);
                    count++;
                }
            }


            return PartialView(ListFriendCustomer);
        }

        public ActionResult ProfilePage(int? id)
        {

            if (id == null)
            {
                if (User.Identity.IsAuthenticated)
                {
                    id = int.Parse(User.Identity.Name);
                    Customer customer = db.Customers.Find(id);
                    int count = 0;
                    foreach (var itemfriend in db.Friends)
                    {
                        if (itemfriend.IdUserFriendReceive == id && itemfriend.TimeFriend != null)
                        {
                            count++;
                        }
                        else if (itemfriend.IdUserFriendSend == id && itemfriend.TimeFriend != null)
                        {
                            count++;
                        }
                    }
                    ViewBag.CountFriend = count;
                    return View(customer);
                }
                else
                {
                    return RedirectToAction("Login", "Customer");
                }

            }
            else
            if ((id != null) && (User.Identity.IsAuthenticated))
            {

                Customer customer = db.Customers.Find(id);
                int count = 0;
               
                if (customer.Active != true)
                {
                    return RedirectToAction("Verify", "Customer");
                }
                foreach (var itemfriend in db.Friends)
                {
                    if (itemfriend.IdUserFriendReceive == id && itemfriend.TimeFriend != null)
                    {
                        count++;
                    }
                    else if (itemfriend.IdUserFriendSend == id && itemfriend.TimeFriend != null)
                    {
                        count++;
                    }
                }
                ViewBag.CountFriend = count;
                return View(customer);

            }
            else
            {
                return RedirectToAction("Login", "Customer");
            }
        }

       

        public ActionResult ListFriends(int? id)
        {

            if (id == null) id = int.Parse(User.Identity.Name);
            ViewBag.ID = id;
            Customer cus = db.Customers.Find(id);
            if (cus.Active != true)
            {
                return RedirectToAction("Verify", "Customer");
            }
            ViewBag.Customer = cus.CustomerName;
            var friends = db.Friends;
            List<Customer> ListFriendCustomer = new List<Customer>();
            int count = 0;
            foreach (var itemfriend in friends)
            {
                if (itemfriend.IdUserFriendReceive == id && itemfriend.TimeFriend != null)
                {
                    Customer customer = db.Customers.Find(itemfriend.IdUserFriendSend);
                    ListFriendCustomer.Add(customer);
                    count++;
                }
                else if (itemfriend.IdUserFriendSend == id && itemfriend.TimeFriend != null)
                {
                    Customer customer = db.Customers.Find(itemfriend.IdUserFriendReceive);
                    ListFriendCustomer.Add(customer);
                    count++;
                }
            }
            ViewBag.CountFriend = count;

            return View(ListFriendCustomer);
        }


        public ActionResult Logout()
        {
            FormsAuthentication.SignOut();
            return RedirectToAction("Login", "Customer");
        }
    }
}