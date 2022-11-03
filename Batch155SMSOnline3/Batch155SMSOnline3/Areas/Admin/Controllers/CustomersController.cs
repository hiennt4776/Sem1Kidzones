using Batch155SMSOnline3.Models;
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;


namespace Batch155SMSOnline3.Areas.Admin.Controllers
{
    public class CustomersController : Controller
    {
        // GET: Admin/Customers
        dbBatch155SMS3Entities db = new dbBatch155SMS3Entities();
        public ActionResult Index()
        {
            return View(db.Customers.ToList());
        }

        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }

            Customer customer = db.Customers.Find(id);

            if (customer == null)
            {
                return HttpNotFound();
            }
            return View(customer);
        }


        public ActionResult Friends(int? id)
        {
        
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


        public ActionResult SentMessage(int? id)
        {
            List<Message> lstMessage = db.Messages.Where(n => n.IdUserSend == id).ToList();
            Customer customer = db.Customers.SingleOrDefault(s => s.Id == id);
            ViewBag.Username = customer.Username;
            return View(lstMessage);
        }

        public ActionResult ReceivedMessage(int? id)
        {
            List<Message> lstMessage = db.Messages.Where(n => n.IdUserReceive == id).ToList();


            return View(lstMessage);
        }

        public ActionResult DetailMessage(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }

            Message message = db.Messages.Find(id);
            if (message.IdUserReceive != null)
            {
                Customer customer = db.Customers.SingleOrDefault(s => s.Id == message.IdUserReceive);
                ViewBag.PhoneNumber = customer.PhoneNumber;

            }
            if (message == null)
            {
                return HttpNotFound();
            }
            return View(message);
        }
    }
}