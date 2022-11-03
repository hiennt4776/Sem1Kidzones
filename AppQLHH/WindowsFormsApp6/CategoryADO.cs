using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WindowsFormsApp6
{
    class CategoryADO
    {
        private string ConnectionString = "Data Source=DESKTOP-101QR58;Initial Catalog=QLHANGHOA;Integrated Security=True";

        private SqlConnection conn;
        public DataSet selectAllCategory()
        {

            // create Connect
            conn = new SqlConnection(ConnectionString);

            //new SQL string
            string queryString = "select * from Categories";

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

        public void insertCategory(string CategoryName, string CategoryDescription)
        {


            SqlConnection connection = new SqlConnection(ConnectionString);

            conn = new SqlConnection(ConnectionString);
            string queryString = "insert into Categories values (@CategoryName, @CategoryDescription)";
            SqlCommand command = new SqlCommand(queryString, connection);
            command.Parameters.AddWithValue("@CategoryName", CategoryName);
            command.Parameters.AddWithValue("@CategoryDescription", CategoryDescription);
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
        public void updateCategory(int Id, string CategoryName, string CategoryDescription)
        {
            SqlConnection connection = new SqlConnection(ConnectionString);

            conn = new SqlConnection(ConnectionString);
            string queryString = "update Categories set CategoryName = @CategoryName, Description = @CategoryDescription  where Id = @Id";
            SqlCommand command = new SqlCommand(queryString, connection);
            command.Parameters.AddWithValue("@CategoryName", CategoryName);
            command.Parameters.AddWithValue("@CategoryDescription", CategoryDescription);
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
        public void deleteCategory(int Id)
        {
            SqlConnection connection = new SqlConnection(ConnectionString);
            conn = new SqlConnection(ConnectionString);
            string queryString = "delete Categories where Id = @Id";
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

        public DataSet selectAllCategoryID(string Name)
        {
            conn = new SqlConnection(ConnectionString);
            string queryString = "select * from Categories where CategoryName = @Name";
            SqlCommand command = new SqlCommand();
            command.Connection = conn;
            command.CommandText = queryString;
            command.CommandType = CommandType.Text;
            command.Parameters.AddWithValue("@Name", Name);
            SqlDataAdapter dataAdapter = new SqlDataAdapter();
            DataSet ds = new DataSet();
            conn.Open();
            command.ExecuteNonQuery();
            dataAdapter.SelectCommand = command;
            dataAdapter.Fill(ds);
            conn.Close();
            return ds;

        }

    }
}
