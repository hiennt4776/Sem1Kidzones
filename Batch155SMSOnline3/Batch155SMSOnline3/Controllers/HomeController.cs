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
    public class HomeController : Controller
    {
        private dbBatch155SMS3Entities db = new dbBatch155SMS3Entities();
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult About()
        {
          
            return View();
        }

        public ActionResult Contact()
        {
           
            return View();
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Contact(Contact contact)
        {
            if (ModelState.IsValid)
            {
                db.Contacts.Add(contact);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            return View(contact);
        }
    }
}