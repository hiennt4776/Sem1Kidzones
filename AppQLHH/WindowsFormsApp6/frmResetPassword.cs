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
    public partial class frmResetPassword : Form
    {
        private EmployeesADO employeesADO = new EmployeesADO();
        void LoadUser()
        {
            DataSet employees = employeesADO.selectAllUsers();
            dgvUsers.DataSource = employees.Tables[0];
            dgvUsers.SelectionMode = DataGridViewSelectionMode.FullRowSelect;
            dgvUsers.Columns[0].Width = 30;
            dgvUsers.Columns[1].Width = 100;
            dgvUsers.Columns[2].Width = 70;


        }
        public frmResetPassword()
        {
            InitializeComponent();
            LoadUser();
        }

        private void dgvUsers_Click(object sender, EventArgs e)
        {
            int index = dgvUsers.SelectedCells[0].RowIndex;
            DataGridViewRow row = dgvUsers.Rows[index];
            txtIDReset.Text = row.Cells[0].Value.ToString();
        }

        private void btnResetPassword_Click(object sender, EventArgs e)
        {
            if (txtPasswordReset.Text == "") MessageBox.Show("You have not entered a new password");
            else
            {
                employeesADO.UpdatePassword(int.Parse(txtIDReset.Text), txtPasswordReset.Text);
                MessageBox.Show("Password reset successful");
            }



        }
    }
}
