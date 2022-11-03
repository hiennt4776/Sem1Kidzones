using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WindowsFormsApp6
{
    class EmployeesADO
    {
        private string ConnectionString = "Data Source=DESKTOP-101QR58;Initial Catalog=QLHANGHOA;Integrated Security=True";
        
        private SqlConnection conn;

        public int IdEmployessOfIdUser(int Id)
        {

            conn = new SqlConnection(ConnectionString);
            conn.Open();
            string queryString = "select * from Employees where Id = @Id";
            SqlCommand command = new SqlCommand(queryString, conn);
            command.Parameters.AddWithValue("@Id", Id.ToString());
            command.Connection = conn;
            command.CommandText = queryString;
            command.CommandType = CommandType.Text;
            SqlDataReader dataReader = command.ExecuteReader();
            int ID = -1;
            if (dataReader.Read() == true)
            {
                ID = int.Parse(dataReader[0].ToString());
            }
            conn.Close();
            return ID;
        }

        public string NameEmployessOfIdUser(int Id)
        {
            conn = new SqlConnection(ConnectionString);
            conn.Open();
            string queryString = "select * from Employees where Id = @Id";
            SqlCommand command = new SqlCommand(queryString, conn);
            command.Parameters.AddWithValue("@Id", Id.ToString());
            command.Connection = conn;
            command.CommandText = queryString;
            command.CommandType = CommandType.Text;
            SqlDataReader dataReader = command.ExecuteReader();
            string Name = "";
            if (dataReader.Read() == true)
            {
                Name = dataReader[1].ToString();
            }
            conn.Close();
            return Name;
        }

        public DataSet selectAllEmployees()
        {

            // create Connect
            conn = new SqlConnection(ConnectionString);

            //new SQL string
            string queryString = "select Id,FullName,Birthday,Phone,Address,Gender = (case Gender when 1 then 'Male' when 0 then 'Female' end),UserRange from Employees";
            //create Command
            SqlCommand command = new SqlCommand();
            //connect Command with Connection
            command.Connection = conn;
            //add queryString to Command
            command.CommandText = queryString;
            command.CommandType = CommandType.Text;

            //Create DataProvider and DataSet use Binding Data
            SqlDataAdapter dataAdapter = new SqlDataAdapter();
            DataSet ds = new DataSet();

            //Open Connection
            conn.Open();
            //Execute SQL
            command.ExecuteNonQuery();
            dataAdapter.SelectCommand = command;
            //binding dataset
            dataAdapter.Fill(ds);
            conn.Close();
            return ds;

        }



        public void insertEmployees(string FullName, DateTime Birthday, string Phone, string Address, bool Gender, string UserRange, string Username, string Password)
        {
            SqlConnection connection = new SqlConnection(ConnectionString);
            conn = new SqlConnection(ConnectionString);
            string queryString = "insert into Employees values (@FullName,@Birthday,@Phone,@Address,@Gender,@UserRange,@Username,@Password)";
            SqlCommand command = new SqlCommand(queryString, connection);
            command.Parameters.AddWithValue("@FullName", FullName); ;
            command.Parameters.AddWithValue("@Birthday", Birthday);
            command.Parameters.AddWithValue("@Phone", Phone);
            command.Parameters.AddWithValue("@Address", Address);
            command.Parameters.AddWithValue("@Gender", Gender);
            command.Parameters.AddWithValue("@UserRange", UserRange);
            command.Parameters.AddWithValue("@Username", Username);
            command.Parameters.AddWithValue("@Password", Encryptor.getHashSha256(Password));
            command.Connection = conn;
            command.CommandText = queryString;
            command.CommandType = CommandType.Text;
            SqlDataAdapter dataAdapter = new SqlDataAdapter();
            DataSet ds = new DataSet();
            conn.Open();
            var rowsAffected = command.ExecuteNonQuery();
            if (connection.State == System.Data.ConnectionState.Open)
            {
                connection.Close();
            }
        }

        public void updateEmployee(int EmployeeId, string FullName, DateTime Birthday, string Phone, string Address, string UserRange, bool Gender)
        {
            SqlConnection connection = new SqlConnection(ConnectionString);

            conn = new SqlConnection(ConnectionString);
            string queryString = "update Employees set FullName = @FullName, Birthday = @Birthday, Phone = @Phone, Address = @Address, Gender = @Gender, UserRange = @UserRange  WHERE Id = @Id";
            SqlCommand command = new SqlCommand(queryString, connection);
            command.Parameters.AddWithValue("@FullName", FullName);
            command.Parameters.AddWithValue("@Birthday", Birthday);
            command.Parameters.AddWithValue("@Phone", Phone);
            command.Parameters.AddWithValue("@Address", Address);
            command.Parameters.AddWithValue("@Gender", Gender);
            command.Parameters.AddWithValue("@UserRange", UserRange);
            command.Parameters.AddWithValue("@Id", EmployeeId);
            command.Connection = conn;
            command.CommandText = queryString;
            command.CommandType = CommandType.Text;
            SqlDataAdapter dataAdapter = new SqlDataAdapter();
            DataSet ds = new DataSet();
            conn.Open();
            var rowsAffected = command.ExecuteNonQuery();
            if (connection.State == System.Data.ConnectionState.Open)
            {
                connection.Close();
            }
        }
        public void deleteEmployee(int Id)
        {
             SqlConnection connection = new SqlConnection(ConnectionString);
             conn = new SqlConnection(ConnectionString);
             string queryString = "delete Employees where Id = @Id";
             SqlCommand command = new SqlCommand(queryString, connection);
             command.Parameters.AddWithValue("@Id", Id);
             command.Connection = conn;
             command.CommandText = queryString;
             command.CommandType = CommandType.Text;
             SqlDataAdapter dataAdapter = new SqlDataAdapter();
             DataSet ds = new DataSet();
             conn.Open();
             var rowsAffected = command.ExecuteNonQuery();
             if (connection.State == System.Data.ConnectionState.Open)
             {
                 connection.Close();
             }
        }

        public DataSet selectAllUsers()
        {

            // create Connect
            conn = new SqlConnection(ConnectionString);

            //new SQL string
            string queryString = "select Id,FullName,UserName from Employees";
            //create Command
            SqlCommand command = new SqlCommand();
            //connect Command with Connection
            command.Connection = conn;
            //add queryString to Command
            command.CommandText = queryString;
            command.CommandType = CommandType.Text;

            //Create DataProvider and DataSet use Binding Data
            SqlDataAdapter dataAdapter = new SqlDataAdapter();
            DataSet ds = new DataSet();

            //Open Connection
            conn.Open();
            //Execute SQL
            command.ExecuteNonQuery();
            dataAdapter.SelectCommand = command;
            //binding dataset
            dataAdapter.Fill(ds);
            conn.Close();
            return ds;

        }

        public bool CheckIDPass(int ID, string Password)
        {
            conn = new SqlConnection(ConnectionString);
            conn.Open();
            string queryString = "select * from Employees where Id = @Id and PassWord = @password";
            SqlCommand command = new SqlCommand(queryString, conn);
            command.Parameters.AddWithValue("@Id", ID);
            command.Parameters.AddWithValue("@password", Encryptor.getHashSha256(Password));
            command.Connection = conn;
            command.CommandText = queryString;
            command.CommandType = CommandType.Text;
            SqlDataReader dataReader = command.ExecuteReader();
            return dataReader.Read();
        }

        public void UpdatePassword(int ID, string Password)
        {
            SqlConnection connection = new SqlConnection(ConnectionString);
            conn = new SqlConnection(ConnectionString);
            string queryString = "update Employees set PassWord = @PassWord WHERE Id = @Id";
            SqlCommand command = new SqlCommand(queryString, connection);
            command.Parameters.AddWithValue("@Id", ID);
            command.Parameters.AddWithValue("@PassWord", Encryptor.getHashSha256(Password));
            command.Connection = conn;
            command.CommandText = queryString;
            command.CommandType = CommandType.Text;
            SqlDataAdapter dataAdapter = new SqlDataAdapter();
            DataSet ds = new DataSet();
            conn.Open();
            var rowsAffected = command.ExecuteNonQuery();
            if (connection.State == System.Data.ConnectionState.Open)
            {
                connection.Close();
            }
        }

    }
}
