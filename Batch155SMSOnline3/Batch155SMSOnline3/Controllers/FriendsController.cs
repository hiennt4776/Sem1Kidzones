using Batch155SMSOnline3.Models;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Batch155SMSOnline3.Controllers
{
    public class FriendsController : Controller
    {
        dbBatch155SMS3Entities db = new dbBatch155SMS3Entities();
        // GET: Friends
        public ActionResult YourFriends()
        {
            if (User.Identity.IsAuthenticated)
            {
                int id = int.Parse(User.Identity.Name);

                Customer customer = db.Customers.Find(int.Parse(User.Identity.Name));
                if (customer.Active != true)
                {
                    return RedirectToAction("Verify", "Customer");
                }

                List<Friend> ListFriend = new List<Friend>(); 
                foreach (var itemfriend in db.Friends)
                {
                    if (((itemfriend.IdUserFriendReceive == id) ||(itemfriend.IdUserFriendSend == id)) && (itemfriend.TimeFriend != null))
                    {   
                        ListFriend.Add(itemfriend);
                    }
                  
                }
                return View(ListFriend);
            }
            else
            {
                return RedirectToAction("Login", "Customer");
            }
        }
        public ActionResult SearchFriends()
        {
            Customer customer = db.Customers.Find(int.Parse(User.Identity.Name));
            if (customer.Active != true)
            {
                return RedirectToAction("Verify", "Customer");
            }
            return View();
        }
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult SearchFriends(string txtSearch)
        {
            Session["txtSearch"] = txtSearch;
            return RedirectToAction("SearchResultFriends");
        }
        public ActionResult SearchResultFriends()
        {
            if (User.Identity.IsAuthenticated)
            {
                int IdCustomer = int.Parse(User.Identity.Name);
                string txtSearch = Session["txtSearch"].ToString() ;
                List<Customer> lstCustomer = db.Customers.Where(n => n.CustomerName.Contains(txtSearch) || n.PhoneNumber.Contains(txtSearch)).ToList();
                List<Customer> lstCustomerNonFriends = new List<Customer>();
                foreach (var item in lstCustomer)
                {
                    Friend friend = db.Friends.SingleOrDefault(s => ((s.IdUserFriendReceive.Value.Equals(IdCustomer) && s.IdUserFriendSend.Value.Equals(item.Id)) || (s.IdUserFriendReceive.Value.Equals(item.Id) && s.IdUserFriendSend.Value.Equals(IdCustomer))));
                    if (friend == null && item.Id != IdCustomer)
                    {
                        lstCustomerNonFriends.Add(item);
                    }
                }
                return View(lstCustomerNonFriends);
            }
            else
            {
                return RedirectToAction("Login", "Customer");
            }
        }

        public ActionResult AddFriend(Friend friend, int idReceive)
        {
            if (User.Identity.IsAuthenticated)
            {
                friend.IdUserFriendReceive = idReceive;
                friend.IdUserFriendSend = int.Parse(User.Identity.Name);
                db.Friends.Add(friend);
                db.SaveChanges();
                return RedirectToAction("SearchResultFriends");
            }
            else
            {
                return RedirectToAction("Login", "Customer");
            }
        }

        public ActionResult ConfirmFriend(int id)
        {
            if (User.Identity.IsAuthenticated)
            {
                Friend friend = db.Friends.Find(id);
                friend.TimeFriend = DateTime.Now;
                db.Entry(friend).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("SendReceiveFriends");
            }
            else
            {
                return RedirectToAction("Login", "Customer");
            }
        }

        public ActionResult DeleteSendFriend(int id)
        {
            Friend friend = db.Friends.Find(id);
            db.Friends.Remove(friend);
            db.SaveChanges();
            return RedirectToAction("SendReceiveFriends");
        }

        public ActionResult DeleteFriend(int id)
        {
            Friend friend = db.Friends.Find(id);
            db.Friends.Remove(friend);
            db.SaveChanges();
            return RedirectToAction("YourFriends"); ;
        }

        public ActionResult SendReceiveFriends()
        {
            if (User.Identity.IsAuthenticated)
            {

                Customer customer = db.Customers.Find(int.Parse(User.Identity.Name));
                if (customer.Active != true)
                {
                    return RedirectToAction("Verify", "Customer");
                }

                int idCus = int.Parse(User.Identity.Name);   
                List<Friend> lstNonFriend = new List<Friend>();
                foreach (var item in db.Friends)
                {
                    if (((idCus == item.IdUserFriendReceive) || (idCus == item.IdUserFriendSend)) && (item.TimeFriend == null))
                        lstNonFriend.Add(item);
                }
                return View(lstNonFriend);
            }
            else
            {
                return RedirectToAction("Login", "Customer");
            }
        }
    }
}