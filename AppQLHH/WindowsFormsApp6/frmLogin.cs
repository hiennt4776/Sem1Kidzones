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
    public partial class frmLogin : Form
    {
        string ConnectionString = "Data Source=DESKTOP-101QR58;Initial Catalog=QLHANGHOA;Integrated Security=True";
        SqlConnection conn;
        public frmLogin()
        {
            InitializeComponent();
        }

        private void btnLogin_Click(object sender, EventArgs e)
        {
           
                string ConnectionString = "Data Source=DESKTOP-101QR58;Initial Catalog=QLHANGHOA;Integrated Security=True";
                SqlConnection conn;
                conn = new SqlConnection(ConnectionString);
                conn.Open();
                string queryString = "select * from Employees where UserName = @username and PassWord = @password";
                SqlCommand command = new SqlCommand(queryString, conn);
                command.Parameters.AddWithValue("@username", txtUserName.Text);
                command.Parameters.AddWithValue("@password", Encryptor.getHashSha256(txtPassword.Text));
                command.Connection = conn;
                command.CommandText = queryString;
                command.CommandType = CommandType.Text;
                SqlDataReader dataReader = command.ExecuteReader();
                if (dataReader.Read() == true)
                {
                    frmMain formMain = new frmMain(int.Parse(dataReader[0].ToString()), dataReader[6].ToString());
                    formMain.Show();
                    this.Hide();
                }
                else
                {
                    MessageBox.Show("The user name or password you entered isn't correct");
                }
                conn.Close();

        }

        private void btnExit_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }
    }
}
