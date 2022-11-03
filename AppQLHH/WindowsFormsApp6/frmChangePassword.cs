using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsApp6
{
    public partial class frmChangePassword : Form
    {
        int ID;
        private EmployeesADO employeesADO = new EmployeesADO();

        public frmChangePassword(int ID)
        {
            InitializeComponent();
            this.ID = ID;
        }

       

        private void btnChangePassword_Click(object sender, EventArgs e)
        {
       
            if (employeesADO.CheckIDPass(ID, txtOldPassword.Text) == true)
            {
                if (txtNewPassword.Text == txtConfirmNewPassword.Text)
                {
                    employeesADO.UpdatePassword(ID, txtNewPassword.Text);
                    MessageBox.Show("Password changed successfully ");
                }
                else MessageBox.Show("Failed to confirm new password");
            }
            else MessageBox.Show("Enter the old password incorrectly");


        }
    }
}
