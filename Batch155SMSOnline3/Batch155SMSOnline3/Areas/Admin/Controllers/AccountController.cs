using Batch155SMSOnline3.Models;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Security.Cryptography;
using System.Text;
using System.Web;
using System.Web.Mvc;
using System.Web.Security;

namespace Batch155SMSOnline3.Areas.Admin.Controllers
{
    public class AccountController : Controller
    {
        dbBatch155SMS3Entities db = new dbBatch155SMS3Entities();
        // GET: Admin/Account
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

        public ActionResult Login()
        {
            return View();
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Login(string username, string password)
        {
            var f_password = GetMD5(password);
            if (username != null && password != null)
            {
                using (dbBatch155SMS3Entities db = new dbBatch155SMS3Entities())
                {
                    User obj = db.Users.Where(x => x.Username == username && x.Password == f_password && x.Stop == false).FirstOrDefault();
                    if (obj != null)
                    {
                        FormsAuthentication.SetAuthCookie(obj.Id.ToString(), false);
                        //FormsAuthentication.SetAuthCookie(username, false);
                        return RedirectToAction("Index", "Home");
                    }
                }
            }
            return RedirectToAction("Login", "Account");
        }

        public ActionResult ChangePassword()
        {
            if (User.Identity.IsAuthenticated)
            {
                User user = db.Users.Find(int.Parse(User.Identity.Name));

                return View(user);
            }
            return RedirectToAction("Login", "Account");
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult ChangePassword(User user, string oldPassword, string newPassword)
        {
            if (user.Password.Equals(GetMD5(oldPassword)))
            {
                user.Password = GetMD5(newPassword);
                db.Entry(user).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Logout", "Account");
            }

            else
            {
                ViewBag.errorPassword = "Old Password is wrong";
            }
            return View();

        }
        [Authorize(Roles = "Admin")]
        public ActionResult Create()
        {
            return View();
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        [Authorize(Roles = "Admin")]
        public ActionResult Create(User user)
        {
            var checkPhoneNumber = db.Users.FirstOrDefault(s => s.PhoneNumber == user.PhoneNumber);
            var checkUsername = db.Users.FirstOrDefault(s => s.Username == user.Username);
            var checkIdentityCard = db.Users.FirstOrDefault(s => s.IdentityCard == user.IdentityCard);
            bool checkDayOfBirth = false;
            if (user.DateOfBirth != null)
            {
                int YearCustomer = int.Parse(user.DateOfBirth.Value.Year.ToString());
                int YearNow = int.Parse(DateTime.Now.Year.ToString());
                checkDayOfBirth = (YearNow - YearCustomer) > 18;
                if (!checkDayOfBirth) ViewBag.errorBirthDay = "You must be 18 year old";
            }
            else
            {
                ViewBag.errorBirthDay = "You must enter the Day Of Birth";
            }

            if ((checkPhoneNumber == null) && (checkUsername == null) && (checkIdentityCard == null) && checkDayOfBirth)
            {
                user.Password = GetMD5(user.Password);

                user.Stop = false;
                db.Users.Add(user);
                db.SaveChanges();




                return RedirectToAction("Index");
            }
            else
            {
                if (checkPhoneNumber != null) ViewBag.errorPhoneNumber = "THIS MOBILE NUMBER had been registered already";
                if (checkUsername != null) ViewBag.errorUsername = "THIS USERNAME had been registered already";
                if (checkIdentityCard != null) ViewBag.errorIdentityCard = "THIS Identity Card had been registered already";



            }
            return View();


        }
        [Authorize(Roles = "Admin")]
        public ActionResult Index()
        {
            return View(db.Users.ToList());
        }

        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            User user = db.Users.Find(id);
            if (user == null)
            {
                return HttpNotFound();
            }
            return View(user);
        }

        // POST: Admin/Users/Edit/5
        // To protect from overposting attacks, enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit(User user)
        {
            if (ModelState.IsValid)
            {
                db.Entry(user).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(user);
        }

        [Authorize(Roles = "Admin")]
        public ActionResult ResetPassword(int? id)
        {
            if (User.Identity.IsAuthenticated)
            {
                User user = db.Users.Find(id);

                return View(user);
            }
            return RedirectToAction("Login", "Account");
        }
        [Authorize(Roles = "Admin")]
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            User user = db.Users.Find(id);
            if (user == null)
            {
                return HttpNotFound();
            }
            return View(user);
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult ResetPassword(User user, string newPassword)
        {
            if (ModelState.IsValid)
            {
                user.Password = GetMD5(newPassword);
                db.Entry(user).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index", "Account");
            }

            
            return View();

        }

        public ActionResult Logout()
        {
            FormsAuthentication.SignOut();
            return RedirectToAction("Login", "Account");
        }
    }
}