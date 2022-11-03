using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using Batch155SMSOnline3.Models;

namespace Batch155SMSOnline3.Controllers
{
    public class ServiceCusController : Controller
    {
        private dbBatch155SMS3Entities db = new dbBatch155SMS3Entities();

        // GET: ServiceCus
        public ActionResult Index()
        {

            var services = db.Services.Include(s => s.LevelService).Include(s =>
            s.User).Where(s => s.StopServices == false).OrderBy(s => s.ServiceName).ThenBy(s => s.Price);

            ChangeActiStatus();

            //cac service da duoc user dang ky
            Customer customer = db.Customers.Find(int.Parse(User.Identity.Name));
            ViewBag.RegisteredService = (from a in db.Services
                                         join b in db.Actives
                                         on a.Id equals b.IdService
                                         where b.IdCustomer == customer.Id && b.Status == true
                                         orderby b.EndService descending
                                         select a).ToList();



            return View(services.ToList());
        }

        // GET: ServiceCus/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Service service = db.Services.Find(id);
            if (service == null)
            {
                return HttpNotFound();
            }
            return View(service);
        }

        public ActionResult Detail_RegisteredService(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Service service = db.Services.Find(id);
            if (service == null)
            {
                return HttpNotFound();
            }

            //lấy thông tin actice service của customer
            Customer customer = db.Customers.Find(int.Parse(User.Identity.Name));
            /*ViewBag.acti = (from a in db.Actives
                            join b in db.Services
                             on a.IdService equals id
                            where a.IdCustomer == customer.Id
                            select a).ToList();*/
            ViewBag.acti = db.Actives.Include(a => a.Service).Where(s => s.Service.Id == id && s.IdCustomer == customer.Id).First();


            return View(service);
        }

        public void ChangeActiStatus()
        {

            var acti = db.Actives.ToList();
            foreach (var item in acti)
            {
                if (item.EndService <= DateTime.Now)
                {
                    item.Status = false;
                }
            }
            db.SaveChanges();
        }



        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }
    }
}
