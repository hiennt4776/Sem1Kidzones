using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using Batch155SMSOnline3.Models;

namespace Batch155SMSOnline3.Areas.Admin.Controllers
{
    public class LevelServicesController : Controller
    {
        private dbBatch155SMS3Entities db = new dbBatch155SMS3Entities();

        // GET: Admin/LevelServices
        public ActionResult Index()
        {
            var levelServices = db.LevelServices.Include(l => l.User);
            return View(levelServices.ToList());
        }

        // GET: Admin/LevelServices/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            LevelService levelService = db.LevelServices.Find(id);
            if (levelService == null)
            {
                return HttpNotFound();
            }
            return View(levelService);
        }

        // GET: Admin/LevelServices/Create
        public ActionResult Create()
        {
            Customer customer = db.Customers.Find(int.Parse(User.Identity.Name));
            ViewBag.cusID = customer.Id;

            return View();
        }

        // POST: Admin/LevelServices/Create
        // To protect from overposting attacks, enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "Id,LevelName,TimeServerMonth,IdUser")] LevelService levelService)
        {
            if (ModelState.IsValid)
            {
                db.LevelServices.Add(levelService);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            Customer customer = db.Customers.Find(int.Parse(User.Identity.Name));
            ViewBag.cusID = customer.Id;

            return View(levelService);
        }

        // GET: Admin/LevelServices/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            LevelService levelService = db.LevelServices.Find(id);
            if (levelService == null)
            {
                return HttpNotFound();
            }

            Customer customer = db.Customers.Find(int.Parse(User.Identity.Name));
            ViewBag.cusID = customer.Id;

            return View(levelService);
        }

        // POST: Admin/LevelServices/Edit/5
        // To protect from overposting attacks, enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "Id,LevelName,TimeServerMonth,IdUser")] LevelService levelService)
        {
            if (ModelState.IsValid)
            {
                db.Entry(levelService).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            Customer customer = db.Customers.Find(int.Parse(User.Identity.Name));
            ViewBag.cusID = customer.Id;

            return View(levelService);
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
