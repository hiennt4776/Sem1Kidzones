using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Data.Entity.Validation;
using System.IO;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using Batch155SMSOnline3.Models;
using PagedList;

namespace Batch155SMSOnline3.Areas.Admin.Controllers
{
    public class ServicesController : Controller
    {
        private dbBatch155SMS3Entities db = new dbBatch155SMS3Entities();

        // GET: Admin/Services
        [HttpGet]
        public ActionResult Index(int? size, int? page)
        {
            // 1. list pageSize để chọn size để phân trang          
            List<SelectListItem> items = new List<SelectListItem>();
            items.Add(new SelectListItem { Text = "5", Value = "5" });
            items.Add(new SelectListItem { Text = "10", Value = "10" });


            foreach (var item in items)
            {
                if (item.Value == size.ToString())
                    item.Selected = true;
            }

            ViewBag.size = items; // ViewBag DropDownList
            ViewBag.currentSize = size;

            page = page ?? 1;

            var services = db.Services.Include(s => s.LevelService).Include(s
                                => s.User).OrderBy(s => s.ServiceName).ThenBy(s => s.Price);

            int pageSize = (size ?? 5);

            int pageNumber = (page ?? 1);


            return View(services.ToPagedList(pageNumber, pageSize));
        }

        // GET: Admin/Services/Details/5
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

        // GET: Admin/Services/Create
        public ActionResult Create()
        {
            Customer customer = db.Customers.Find(int.Parse(User.Identity.Name));
            ViewBag.cusID = customer.Id;

            ViewBag.IdLevel = new SelectList(db.LevelServices, "Id", "LevelName");

            return View();
        }

        // POST: Admin/Services/Create
        // To protect from overposting attacks, enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "Id,ServiceName,IdLevel,Price,StopServices,IdUser")] Service service,
            HttpPostedFileBase image)
        {


            string path = Server.MapPath("/Content/imageService");

            if (!Directory.Exists(path))
            {
                Directory.CreateDirectory(path);
            }

            if (image == null)
            {
                service.ServiceImage = "Content/imageService/no-image-available.jpg";
            }
            else
            {
                image.SaveAs(path + "/" + image.FileName);
                service.ServiceImage = "Content/imageService/" + image.FileName;

            }




            if (ModelState.IsValid)
            {



                service.Price = service.Price ?? 9999;



                db.Services.Add(service);

                db.SaveChanges();





                return RedirectToAction("Index");
            }

            ViewBag.IdLevel = new SelectList(db.LevelServices, "Id", "TimeServerMonth", service.IdLevel);
            Customer customer = db.Customers.Find(int.Parse(User.Identity.Name));
            ViewBag.cusID = customer.Id;

            return View(service);


        }

        public string getPath(string path)
        {
            //string[] path1 = Regex.Split(path, Regex.Escape("/"));
            if (path.Contains("Admin"))

                path = path.Replace("Admin/", "");


            return path;
        }

        // GET: Admin/Services/Edit/5
        public ActionResult Edit(int? id)
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

            Customer customer = db.Customers.Find(int.Parse(User.Identity.Name));
            ViewBag.cusID = customer.Id;

            ViewBag.IdLevel = new SelectList(db.LevelServices, "Id", "LevelName", service.IdLevel);

            return View(service);
        }

        // POST: Admin/Services/Edit/5
        // To protect from overposting attacks, enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "Id,ServiceName,IdLevel,Price,StopServices,IdUser")] Service service,
            HttpPostedFileBase image)
        {
            string path = Server.MapPath("/Content/imageService");

            if (!Directory.Exists(path))
            {
                Directory.CreateDirectory(path);
            }

            if (image == null)
            {
                service.ServiceImage = "Content/imageService/no-image-available.jpg";
            }
            else
            {
                image.SaveAs(path + "/" + image.FileName);
                service.ServiceImage = "Content/imageService/" + image.FileName;

            }



            if (ModelState.IsValid)
            {
                service.Price = service.Price ?? 9999;

                db.Entry(service).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.IdLevel = new SelectList(db.LevelServices, "Id", "LevelName", service.IdLevel);
            Customer customer = db.Customers.Find(int.Parse(User.Identity.Name));
            ViewBag.cusID = customer.Id;
            return View(service);
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
