using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


namespace WindowsFormsApp6
{
    class ProductADO
    {
        private string ConnectionString = "Data Source=DESKTOP-101QR58;Initial Catalog=QLHANGHOA;Integrated Security=True";

        private SqlConnection conn;
        public DataSet selectAllProducts()
        {

            // create Connect
            conn = new SqlConnection(ConnectionString);

            //new SQL string
            string queryString = "select p.Id, p.ProductName, p.Price, p.Description, c.CategoryName from Products as p inner join Categories as c on p.CategoryId = c.Id";

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

        public void insertProduct(string ProductsName, int Price, string Description, int CategoryId)
        {


            SqlConnection connection = new SqlConnection(ConnectionString);

            conn = new SqlConnection(ConnectionString);
            string queryString = "insert into Products(ProductName,Price,Description,CategoryId) values (@ProductName,@Price,@Description,@CategoryId)";
            SqlCommand command = new SqlCommand(queryString, connection);
            command.Parameters.AddWithValue("@ProductName", ProductsName);
            command.Parameters.AddWithValue("@Price", Price);
            command.Parameters.AddWithValue("@Description", Description);
            command.Parameters.AddWithValue("@CategoryId", CategoryId);
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

        public void updateProduct(int ProductID, string ProductName, int Price, string Description, int CategoryId)
        {
            SqlConnection connection = new SqlConnection(ConnectionString);

            conn = new SqlConnection(ConnectionString);
            string queryString = "update Products set ProductName = @ProductName, Price=@Price, CategoryId = @CategoryId, Description = @Description  WHERE Id = @Id";
            SqlCommand command = new SqlCommand(queryString, connection);
            command.Parameters.AddWithValue("@ProductName", ProductName);
            command.Parameters.AddWithValue("@Price", Price);
            command.Parameters.AddWithValue("@CategoryId", CategoryId);
            command.Parameters.AddWithValue("@Description", Description);
            command.Parameters.AddWithValue("@Id", ProductID);
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

        public void deleteProduct(int Id)
        {
            SqlConnection connection = new SqlConnection(ConnectionString);
            conn = new SqlConnection(ConnectionString);
            string queryString = "delete Products where Id = @Id";
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


    }
}
