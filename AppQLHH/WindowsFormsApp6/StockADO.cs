using System;
using System.Data;
using System.Data.SqlClient;

namespace WindowsFormsApp6
{
    class StockADO
    {
        private string ConnectionString = "Data Source=DESKTOP-101QR58;Initial Catalog=QLHANGHOA;Integrated Security=True";

        private SqlConnection conn;

        public DataSet selectAllStock()
        {

            // create Connect
            conn = new SqlConnection(ConnectionString);

            //new SQL string
            string queryString = "select Stocks.Id, Stocks.CreatedDate, Stocks.Amount, Stocks.Status, Products.ProductName, Employees.FullName from((Stocks inner join Products on Products.Id = Stocks.ProductId) inner join Employees on Employees.Id = Stocks.EmployeeId)";
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

        public void insertStock(DateTime CreateDate, int Amount, string Status, int ProductId, int EmployeeId)
        {


            SqlConnection connection = new SqlConnection(ConnectionString);

            conn = new SqlConnection(ConnectionString);
            string queryString = "insert into Stocks values (@CreateDate,@Amount,@Status,@ProductId,@EmployeeId)";
            SqlCommand command = new SqlCommand(queryString, connection);
            command.Parameters.AddWithValue("@CreateDate", CreateDate);
            command.Parameters.AddWithValue("@Amount", Amount);
            command.Parameters.AddWithValue("@Status", Status);
            command.Parameters.AddWithValue("@ProductId", ProductId);
            command.Parameters.AddWithValue("@EmployeeId", EmployeeId);
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

        public void updateStock(int StockId, DateTime CreateDate, int Amount, string Status, int ProductId, int EmployeeId)
        {
            SqlConnection connection = new SqlConnection(ConnectionString);

            conn = new SqlConnection(ConnectionString);
            string queryString = "update Stocks set CreatedDate = @CreateDate, Amount=@Amount, Status = @Status, ProductId=@ProductId, EmployeeId = @EmployeeId WHERE Id = @Id";
            SqlCommand command = new SqlCommand(queryString, connection);
            command.Parameters.AddWithValue("@CreateDate", CreateDate);
            command.Parameters.AddWithValue("@Amount", Amount);
            command.Parameters.AddWithValue("@Status", Status);
            command.Parameters.AddWithValue("@ProductId", ProductId);
            command.Parameters.AddWithValue("@EmployeeId", EmployeeId);
            command.Parameters.AddWithValue("@Id", StockId);
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

        public void deleteStock(int Id)
        {
            SqlConnection connection = new SqlConnection(ConnectionString);
            conn = new SqlConnection(ConnectionString);
            string queryString = "delete Stocks where Id = @Id";
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
