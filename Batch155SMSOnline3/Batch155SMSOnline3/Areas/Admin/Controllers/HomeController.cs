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
    public class HomeController : Controller
    {
        // GET: Admin/Home
        private dbBatch155SMS3Entities db = new dbBatch155SMS3Entities();


        public ActionResult Index(string searchString, int? size, int? page)
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

            IQueryable<Active> actives = db.Actives;
            if (!string.IsNullOrEmpty(searchString))
            {
                actives = actives.Where(x => x.Service.ServiceName.Contains(searchString));
            }

            int pageSize = (size ?? 5);

            int pageNumber = (page ?? 1);

            ViewBag.SearchString = searchString;

            return View(actives.OrderBy(s => s.StartService).ToPagedList(pageNumber, pageSize));
        }


        public JsonResult GetSearchingData(string SearchBy, string SearchValue)
        {
            List<Active> actives = new List<Active>();
            if (SearchBy == "CusId")
            {
                try
                {
                    int id = Convert.ToInt32(SearchValue);
                    actives = db.Actives.Where(x => x.IdCustomer == id || SearchValue == null).ToList();
                }
                catch (FormatException)
                {
                    Console.WriteLine("{0 is not a CusID}", SearchValue);
                }
                return Json(actives, JsonRequestBehavior.AllowGet);
            }
            else
            {
                actives = db.Actives.Where(x => x.Service.ServiceName.Contains(SearchValue) || SearchValue == null).ToList();
                return Json(actives, JsonRequestBehavior.AllowGet);
            }
        }

        /*[HttpGet]
        public JsonResult LoadData()
        {
            List<Active> list = db.Actives.ToList();


            return Json(new
            {
                data = list,
                status = true
            }, JsonRequestBehavior.AllowGet);
        }*/
    }
}