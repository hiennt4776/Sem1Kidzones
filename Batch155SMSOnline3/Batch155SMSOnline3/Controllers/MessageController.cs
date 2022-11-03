using Batch155SMSOnline3.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;

namespace Batch155SMSOnline3.Controllers
{
    public class MessageController : Controller
    {
        dbBatch155SMS3Entities db = new dbBatch155SMS3Entities();
        // GET: Message
        public ActionResult Index()
        {
            return View();
        }

        private static string SendSMS(string Phone, string Content, string APIToken, string IdDevice)
        {
            SpeedSMSAPI api = new SpeedSMSAPI(APIToken);

            //String[] phones = new String[] { "84969823398" };
            //String[] phones = new String[] { "84921158684" };

            //String str = "Nội dung sms Duy";
            String[] phones = new String[] { Phone };
            String str = Content;

            String response = api.sendSMS(phones, str , 2, IdDevice);
            //String response = api.sendMMS(phones, str, "https://", "device ID");
            //Console.WriteLine(response);
            //Console.ReadLine();
            return response;
        }

        public PartialViewResult FriendsListPartial()
        {
            int id = int.Parse(User.Identity.Name);
            var friends = db.Friends;
            List<Customer> ListFriendCustomer = new List<Customer>();
            foreach (var itemfriend in friends)
            {
               
                if (itemfriend.IdUserFriendReceive == id && itemfriend.TimeFriend != null)
                {
                    Customer customer = db.Customers.Find(itemfriend.IdUserFriendSend);
                    ListFriendCustomer.Add(customer);
                    
                   
                }
                else if (itemfriend.IdUserFriendSend == id && itemfriend.TimeFriend != null)
                {
                    Customer customer = db.Customers.Find(itemfriend.IdUserFriendReceive);
                    ListFriendCustomer.Add(customer);
                    
                }
            }
          

            return PartialView(ListFriendCustomer);
        }

      
        public ActionResult MessageFriends(int? IdReceive)
        {
            if (User.Identity.IsAuthenticated)
            {

                Customer cus = db.Customers.Find(int.Parse(User.Identity.Name));
                if (cus.Active != true)
                {
                    return RedirectToAction("Verify", "Customer");
                }

                if (cus.deviceID == null || cus.SpeedSMSAPI == null)
                {
                    return RedirectToAction("ApiIdDevice", "Customer");
                }



                int IdSend = int.Parse(User.Identity.Name);
                var messages = db.Messages;
                List<Message> ListMessage = new List<Message>();
                if(IdReceive != null)
                {
                    Customer customer = db.Customers.Find(IdReceive);
                    ViewBag.CustomerReceive = customer.CustomerName;
                    Session["IdReceive"] = IdReceive;
                }
                else if(Session["IdReceive"] != null)
                {
                    IdReceive = (int)Session["IdReceive"];
                    Customer customer = db.Customers.Find(IdReceive);
                    ViewBag.CustomerReceive = customer.CustomerName;
                }    
                
                if (IdReceive == null && Session["IdReceive"] == null)
                {
                    ViewBag.CustomerReceive = "You must choose the recipient of the message";

                    return View(ListMessage);
                }
                
                foreach (var itemmessages in messages)
                {
                    if (itemmessages.IdUserReceive == IdReceive && itemmessages.IdUserSend == IdSend)
                    {
                        ListMessage.Add(itemmessages);
                    }
                    else if (itemmessages.IdUserReceive == IdSend && itemmessages.IdUserSend == IdReceive)
                    {
                        ListMessage.Add(itemmessages);

                    }
                }
                return View(ListMessage.OrderByDescending(x => x.TimeMessage));
            }
            return RedirectToAction("Login", "Customer");
        }
        
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult MessageFriends(Message message, string content)
        {
              if(Session["IdReceive"] != null)
                {
                    message.IdUserSend = int.Parse(User.Identity.Name);
                    message.IdUserReceive = (int)Session["IdReceive"];

                    message.TimeMessage = DateTime.Now;
                    message.ContentMessage = content;

                    Customer customerSend = db.Customers.Find(int.Parse(User.Identity.Name));
                    Customer customerReceive = db.Customers.Find((int)Session["IdReceive"]);

                    string phone = customerReceive.PhoneNumber;
                    string speedAPI = customerSend.SpeedSMSAPI;
                    string deviceID = customerSend.deviceID;




                    ViewBag.Respond = SendSMS(customerReceive.PhoneNumber, content, customerSend.SpeedSMSAPI, customerSend.deviceID);
                    db.Messages.Add(message);
                    db.SaveChanges();
                }
           

             return RedirectToAction("MessageFriends");
        }


        public ActionResult SendMessageNonFriends()
        {
            Customer customer = db.Customers.Find(int.Parse(User.Identity.Name));
            if (customer.Active != true)
            {
                return RedirectToAction("Verify", "Customer");
            }
            if (customer.deviceID == null || customer.SpeedSMSAPI == null)
            {
                return RedirectToAction("ApiIdDevice", "Customer");
            }
            return View();
        }

        // POST: Messages/Create
        // To protect from overposting attacks, enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult SendMessageNonFriends(Message message)
        {
            if (User.Identity.IsAuthenticated)
            {
                string PhoneNumber = message.PhoneNumberReceive;
                Customer customer = db.Customers.SingleOrDefault(s => s.PhoneNumber.Equals(PhoneNumber));
                bool checkFriends = false;

                if (customer != null)
                {
                    int IdSend = int.Parse(User.Identity.Name);

                    int IdReceive = customer.Id;
                    message.PhoneNumberReceive = null;



                    Friend friend = db.Friends.SingleOrDefault(s => ((s.IdUserFriendReceive.Value.Equals(IdReceive) && s.IdUserFriendSend.Value.Equals(IdSend)) || (s.IdUserFriendReceive.Value.Equals(IdSend) && s.IdUserFriendSend.Value.Equals(IdReceive))));
                    if (friend != null)
                    {
                        ViewBag.Friend = "This is the phone number of your friends";
                        checkFriends = true;
                    }    
                        
                    message.IdUserReceive = customer.Id;

                }
                else
                {
                    message.PhoneNumberReceive = PhoneNumber;
                }
                if (!checkFriends)
                {
                    message.IdUserSend = int.Parse(User.Identity.Name);
                    message.TimeMessage = DateTime.Now;

                    Customer customerSend = db.Customers.Find(int.Parse(User.Identity.Name));

                    string ContentMessage = message.ContentMessage;
                    string speedAPI = customerSend.SpeedSMSAPI;
                    string deviceID = customerSend.deviceID;

                    ViewBag.Respond = SendSMS(PhoneNumber, message.ContentMessage, customerSend.SpeedSMSAPI, customerSend.deviceID);

                    db.Messages.Add(message);
                    db.SaveChanges();
                }
              
                return RedirectToAction("SentMessageNonFriends", "Message"); ;
            }
            else
            {
                return RedirectToAction("Login", "Customer");
            }

        }

        public ActionResult SentMessageNonFriends()
        {
            if (User.Identity.IsAuthenticated)
            {
                {
                    Customer cus = db.Customers.Find(int.Parse(User.Identity.Name));
                    if (cus.Active != true)
                    {
                        return RedirectToAction("Verify", "Customer");
                    }
                    int idSend = int.Parse(User.Identity.Name);
                    var friends = db.Friends;
                    List<Customer> ListFriendCustomer = new List<Customer>();
                    foreach (var itemfriend in friends)
                    {

                        if (itemfriend.IdUserFriendReceive == idSend && itemfriend.TimeFriend != null)
                        {
                            Customer customer = db.Customers.Find(itemfriend.IdUserFriendSend);
                            ListFriendCustomer.Add(customer);


                        }
                        else if (itemfriend.IdUserFriendSend == idSend && itemfriend.TimeFriend != null)
                        {
                            Customer customer = db.Customers.Find(itemfriend.IdUserFriendReceive);
                            ListFriendCustomer.Add(customer);

                        }
                    }
                    var messages = db.Messages;
                    List<Message> ListNonFriendMessages = new List<Message>();
                    foreach (var itemmessage in messages)
                    {
                        if (itemmessage.IdUserSend == idSend)
                        {
                            bool IsFriend = false;
                            foreach (var itemfriend in ListFriendCustomer)
                            {
                                if (itemmessage.IdUserReceive == itemfriend.Id)
                                {
                                    IsFriend = true;
                                }
                            }
                            if (!IsFriend) ListNonFriendMessages.Add(itemmessage);

                        }
                    }
                    return View(ListNonFriendMessages);
                }
            }
            else
            {
                return RedirectToAction("Login", "Customer");
            }

        }

        public ActionResult ReceiveMessageNonFriends()
        {
            if (User.Identity.IsAuthenticated)
            {
                Customer cus = db.Customers.Find(int.Parse(User.Identity.Name));
                if (cus.Active != true)
                {
                    return RedirectToAction("Verify", "Customer");
                }

                int idReceive = int.Parse(User.Identity.Name);
                    var friends = db.Friends;
                    List<Customer> ListFriendCustomer = new List<Customer>();
                    foreach (var itemfriend in friends)
                    {

                        if (itemfriend.IdUserFriendReceive == idReceive && itemfriend.TimeFriend != null)
                        {
                            Customer customer = db.Customers.Find(itemfriend.IdUserFriendSend);
                            ListFriendCustomer.Add(customer);


                        }
                        else if (itemfriend.IdUserFriendSend == idReceive && itemfriend.TimeFriend != null)
                        {
                            Customer customer = db.Customers.Find(itemfriend.IdUserFriendReceive);
                            ListFriendCustomer.Add(customer);

                        }
                    }
                    var messages = db.Messages;
                    List<Message> ListNonFriendMessages = new List<Message>();
                    foreach (var itemmessage in messages)
                    {
                        if (itemmessage.IdUserReceive == idReceive)
                        {
                            bool IsFriend = false;
                            foreach (var itemfriend in ListFriendCustomer)
                            {
                                if (itemmessage.IdUserSend == itemfriend.Id)
                                {
                                    IsFriend = true;
                                }
                            }
                            if (!IsFriend) ListNonFriendMessages.Add(itemmessage);

                        }
                    }
                    return View(ListNonFriendMessages);
                
            }
            else
            {
                return RedirectToAction("Login", "Customer");
            }

        }


    }
}