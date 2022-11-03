using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsApp6
{
    public partial class frmCreateUser : Form
    {
        string FullName;
        DateTime Birthday;
        string Phone;
        string Address;
        bool Gender;
        string UserRange;
        private EmployeesADO employeesADO = new EmployeesADO();
       
        public frmCreateUser(string FullName, DateTime Birthday, string Phone, string Address, bool Gender, string UserRange)
        {
            InitializeComponent();
            this.FullName = FullName;
            this.Birthday = Birthday;
            this.Phone = Phone;
            this.Address = Address;
            this.Gender = Gender;
            this.UserRange = UserRange;
        }

        private void btnSave_Click(object sender, EventArgs e)
        {

            string Username = txtUsername.Text;
            string Password = txtPassword.Text;
            employeesADO.insertEmployees(FullName, Birthday, Phone, Address, Gender, UserRange, Username, Password);
            this.Close();
        }
    }
}
