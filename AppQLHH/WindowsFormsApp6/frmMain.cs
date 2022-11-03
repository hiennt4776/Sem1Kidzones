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
    public partial class frmMain : Form
    {
        private EmployeesADO employeesADO = new EmployeesADO();
        private CategoryADO categoryADO = new CategoryADO();
        private ProductADO productADO = new ProductADO();
        private StockADO stockADO = new StockADO();

        void LoadUser(int IdUser)
        {
            lblIDEmployees.Text = employeesADO.IdEmployessOfIdUser(IdUser).ToString();
            lblFullNameEmployees.Text = employeesADO.NameEmployessOfIdUser(IdUser).ToString();
        }

        void Permission(string RangerUser)
        {
            if (RangerUser == "STOCK STAFF")
            {
                tabEmployee.Visible = false;
                tabCategory.Visible = false;
                tabProduct.Visible = false; ;
                resetPasswordToolStripMenuItem.Visible = false;
            }

            if (RangerUser == "MANAGEMENT")
            {
                resetPasswordToolStripMenuItem.Visible = false;
            }
        

        }
        void LoadEmployees()
        { 
            DataSet employees = employeesADO.selectAllEmployees();
            dgvEmployee.DataSource = employees.Tables[0];
            dgvEmployee.SelectionMode = DataGridViewSelectionMode.FullRowSelect;
            txtIdEmployee.Text = "";
            txtFullnameEmployee.Text = "";
            txtPhoneEmployee.Text = "";
            txtAddressEmployee.Text = "";


        }

        void LoadCategories()
        {
            DataSet data = categoryADO.selectAllCategory();
            dgvCategories.DataSource = data.Tables[0];
            dgvCategories.SelectionMode = DataGridViewSelectionMode.FullRowSelect;
            dgvCategories.Columns[0].Width = 30;
            dgvCategories.Columns[1].Width = 150;
            dgvCategories.Columns[2].Width = 300;
            txtCategoryID.Text = "";
            txtCategoryName.Text = "";
            txtDescriptionCategory.Text = "";

        }

        void LoadProducts()
        {
            DataSet products = productADO.selectAllProducts();
            dgvProducts.DataSource = products.Tables[0];
            dgvProducts.SelectionMode = DataGridViewSelectionMode.FullRowSelect;
            dgvProducts.Columns[0].Width = 50;
            dgvProducts.Columns[1].Width = 100;
            dgvProducts.Columns[2].Width = 70;
            dgvProducts.Columns[3].Width = 100;
            dgvProducts.Columns[4].Width = 120;
            txtProductID.Text = "";
            dgvProducts.Text = "";
            txtProductPrice.Text = "";
            txtProductDescription.Text = "";
        }

        int indexCategory(string NameCategory)
        {
            int index = -1;
            List<Category> lstCate = new List<Category>();
            DataSet catgories = categoryADO.selectAllCategory();
            foreach (DataRow item in catgories.Tables[0].Rows)
            {
                Category cate = new Category();
                cate.Id = item.Field<int>("Id");
                cate.CategoryName = item.Field<string>("CategoryName");
                lstCate.Add(cate);
            }
            for (int i = 0; i < lstCate.Count; i++)
            {
                if (lstCate[i].CategoryName == NameCategory) index = i;
            }
            return index;
        }


        void LoadComboboxCategory()
        {
            cmbProductCategory.Items.Clear();
            List<Category> lstCate = new List<Category>();
            DataSet catgories = categoryADO.selectAllCategory();
            foreach (DataRow item in catgories.Tables[0].Rows)
            {
                Category cate = new Category();
                cate.Id = item.Field<int>("Id");
                cate.CategoryName = item.Field<string>("CategoryName");
                lstCate.Add(cate);
            }
            cmbProductCategory.DataSource = lstCate;
            cmbProductCategory.DisplayMember = "CategoryName";
            cmbProductCategory.ValueMember = "Id";
        }

        

        void LoadStock()
        {
            DataSet stocks = stockADO.selectAllStock();
            dgvStocks.DataSource = stocks.Tables[0];
            dgvStocks.SelectionMode = DataGridViewSelectionMode.FullRowSelect;
            dgvStocks.Columns[0].Width = 50;
            dgvStocks.Columns[1].Width = 100;
            dgvStocks.Columns[2].Width = 50;
            dgvStocks.Columns[3].Width = 100;
            dgvStocks.Columns[4].Width = 200;
            dgvStocks.Columns[5].Width = 200;
            txtIdEmployee.Text = "";
            txtFullnameEmployee.Text = "";
            txtProductPrice.Text = "";
            txtAddressEmployee.Text = "";
        }

        int indexProduct(string NameProduct)
         {
            int index = -1;
            List<Product> lstPro = new List<Product>();
            DataSet products = productADO.selectAllProducts();
            foreach (DataRow item in products.Tables[0].Rows)
            {
                Product product = new Product();
                product.Id = item.Field<int>("Id");
                product.ProductName = item.Field<string>("ProductName");
                lstPro.Add(product);
            }
            for (int i = 0; i < lstPro.Count; i++)
            {
                if (lstPro[i].ProductName == NameProduct) index = i;
            }
            return index;

         }
        void LoadComboboxStockProduct()
        {
            cmbStockProduct.Items.Clear();
            List<Product> lstPro = new List<Product>();
            DataSet products = productADO.selectAllProducts();
            foreach (DataRow item in products.Tables[0].Rows)
            {
                Product product = new Product();
                product.Id = item.Field<int>("Id");
                product.ProductName = item.Field<string>("ProductName");
                lstPro.Add(product);
            }

            cmbStockProduct.DataSource = lstPro;
            cmbStockProduct.DisplayMember = "ProductName";
            cmbStockProduct.ValueMember = "Id";
        }

        public frmMain(int IdUser, string RangerUser)
        {
            InitializeComponent();
            LoadUser(IdUser);
            LoadEmployees();
            LoadCategories();
            LoadProducts();
            LoadComboboxCategory();
            LoadStock();
            LoadComboboxStockProduct();
            Permission(RangerUser);
        }

        
        private void exitToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void frmMain_FormClosed(object sender, FormClosedEventArgs e)
        {
            Application.Exit();
        }

        private void exitToolStripMenuItem_Click_1(object sender, EventArgs e)
        {
            Application.Exit();
        }

        #region Employee
        private void btnAddEmployees_Click(object sender, EventArgs e)
        {
            string FullNameEmployee = txtFullnameEmployee.Text;
            DateTime BirthdayEmployee = dtmBirthdayEmployee.Value;
            bool Gender = rdoMale.Checked;
            string PhoneEmloyee = txtPhoneEmployee.Text;
            string AddressEmployee = txtAddressEmployee.Text;
            string UserRange = cmbUserRange.SelectedItem.ToString();
            frmCreateUser formCreateUser = new frmCreateUser(FullNameEmployee, BirthdayEmployee, PhoneEmloyee, AddressEmployee, Gender, UserRange);
            formCreateUser.ShowDialog();
            LoadEmployees();
        }

        private void btnEditEmployees_Click(object sender, EventArgs e)
        {
            int IdEmployee = int.Parse(txtIdEmployee.Text);
            string FullNameEmployee = txtFullnameEmployee.Text;
            DateTime BirthdayEmployee = dtmBirthdayEmployee.Value;
            bool Gender = rdoMale.Checked;
            string PhoneEmloyee = txtPhoneEmployee.Text;
            string AddressEmployee = txtAddressEmployee.Text;
            string UserRange = cmbUserRange.SelectedItem.ToString();
            employeesADO.updateEmployee(IdEmployee, FullNameEmployee, BirthdayEmployee, PhoneEmloyee, AddressEmployee, UserRange, Gender);
            LoadEmployees();
            
        }

        private void btnDeleteEmployees_Click(object sender, EventArgs e)
        {
            int IdEmployee = int.Parse(txtIdEmployee.Text);
            employeesADO.deleteEmployee(IdEmployee);
            LoadEmployees();
        }

        private void dgvEmployee_Click(object sender, EventArgs e)
        {
            int index = dgvEmployee.SelectedCells[0].RowIndex;
            DataGridViewRow row = dgvEmployee.Rows[index];
            txtIdEmployee.Text = row.Cells[0].Value.ToString();
            txtFullnameEmployee.Text = row.Cells[1].Value.ToString();
            dtmBirthdayEmployee.Text= row.Cells[2].Value.ToString();
            txtPhoneEmployee.Text = row.Cells[3].Value.ToString();
            txtAddressEmployee.Text = row.Cells[4].Value.ToString();
            if (row.Cells[5].Value.ToString() == "Male") rdoMale.Checked = true;
            else rdoFemale.Checked = true;
            cmbUserRange.SelectedItem = row.Cells[6].Value.ToString();

        }


        #endregion

        #region Category

        private void btnAddCategory_Click(object sender, EventArgs e)
        {
            string NameCategory = txtCategoryName.Text;
            string DescriptionCategory = txtCategoryName.Text;
            categoryADO.insertCategory(NameCategory, DescriptionCategory);
            LoadCategories();
        }

        private void btnEditCategory_Click(object sender, EventArgs e)
        {
            int IDCategory = int.Parse(txtCategoryID.Text);
            string NameCategory = txtCategoryName.Text;
            string DescriptionCategory = txtCategoryName.Text;
            categoryADO.updateCategory(IDCategory, NameCategory, DescriptionCategory);
            LoadCategories();
        }

        private void btnDeleteCategory_Click(object sender, EventArgs e)
        {
            int IDCategory = int.Parse(txtCategoryID.Text);
            categoryADO.deleteCategory(IDCategory);
            LoadCategories();
        }

        private void dgvCategories_Click(object sender, EventArgs e)
        {
            int index = dgvCategories.SelectedCells[0].RowIndex;
            DataGridViewRow row = dgvCategories.Rows[index];
            txtCategoryID.Text = row.Cells[0].Value.ToString();
            txtCategoryName.Text = row.Cells[1].Value.ToString();
            txtDescriptionCategory.Text = row.Cells[2].Value.ToString();
        }


        #endregion

        #region Product
        private void btnAddProduct_Click(object sender, EventArgs e)
        {
            string ProductName = txtProductName.Text;
            int ProductPrice = int.Parse(txtProductPrice.Text);
            string ProductDescription = txtProductDescription.Text;
            int IdCategory = int.Parse(cmbProductCategory.SelectedValue.ToString());
            productADO.insertProduct(ProductName, ProductPrice, ProductDescription, IdCategory);
            LoadProducts();
        }

        private void btnEditProduct_Click(object sender, EventArgs e)
        {
            int ProductID = int.Parse(txtProductID.Text);
            string ProductName = txtProductName.Text;
            int ProductPrice = int.Parse(txtProductPrice.Text);
            string ProductDescription = txtProductDescription.Text;
            int IdCategory = int.Parse(cmbProductCategory.SelectedValue.ToString());
            productADO.updateProduct(ProductID, ProductName, ProductPrice, ProductDescription, IdCategory);
            LoadProducts();
        }

        private void btnDeleteProduct_Click(object sender, EventArgs e)
        {
            int IDProduct = int.Parse(txtProductID.Text);
            productADO.deleteProduct(IDProduct);
            LoadProducts();
        }

        private void dgvProducts_Click(object sender, EventArgs e)
        {
            int index = dgvProducts.SelectedCells[0].RowIndex;
            DataGridViewRow row = dgvProducts.Rows[index];
            int id = int.Parse(row.Cells[0].Value.ToString());
            string name = row.Cells[1].Value.ToString();
            txtProductID.Text = row.Cells[0].Value.ToString();
            txtProductName.Text = row.Cells[1].Value.ToString();
            txtProductPrice.Text = row.Cells[2].Value.ToString();
            txtProductDescription.Text = row.Cells[3].Value.ToString();
            cmbProductCategory.SelectedIndex = indexCategory(row.Cells[4].Value.ToString());
            
        }



        #endregion

        #region Stock
        private void btnAddStock_Click(object sender, EventArgs e)
        {
            DateTime CreateDate = dtmBirthdayEmployee.Value;
            int Amount = (int)nudStockAmount.Value;
            string Status = txtStockStatus.Text;
            int ProductId = int.Parse(cmbProductCategory.SelectedValue.ToString());
            int EmployeeId = int.Parse(lblIDEmployees.Text);
            stockADO.insertStock(CreateDate, Amount, Status, ProductId, EmployeeId);
            LoadStock();
        }

        private void btnEditStock_Click(object sender, EventArgs e)
        {
            int ID = int.Parse(txtStockID.Text);
            DateTime CreateDate = dtmBirthdayEmployee.Value;
            int Amount = (int)nudStockAmount.Value;
            string Status = txtStockStatus.Text;
            int ProductId = int.Parse(cmbProductCategory.SelectedValue.ToString());
            int EmployeeId = int.Parse(lblIDEmployees.Text);
            stockADO.updateStock(ID, CreateDate, Amount, Status, ProductId, EmployeeId);
            LoadStock();
        }

        private void btnDeleteStock_Click(object sender, EventArgs e)
        {
            int IDStock = int.Parse(txtStockID.Text);
            stockADO.deleteStock(IDStock);
            LoadStock();
        }
        


        private void dgvStock_Click(object sender, EventArgs e)
        {
            int index = dgvStocks.SelectedCells[0].RowIndex;
            DataGridViewRow row = dgvStocks.Rows[index];
            txtStockID.Text = row.Cells[0].Value.ToString();
            dtmStockCreateDay.Text = row.Cells[1].Value.ToString();
            nudStockAmount.Value = (int)row.Cells[2].Value;
            txtStockStatus.Text = row.Cells[3].Value.ToString();
            cmbStockProduct.SelectedIndex = indexProduct(row.Cells[4].Value.ToString());

        }
        #endregion
        private void UsersToolStripMenuItem_Click(object sender, EventArgs e)
        {
            frmUser formUser = new frmUser();
            formUser.ShowDialog();
        }

        private void resetPasswordToolStripMenuItem_Click(object sender, EventArgs e)
        {
            frmResetPassword formResetPassWord = new frmResetPassword();
            formResetPassWord.ShowDialog();
        }

        private void changePasswordToolStripMenuItem_Click(object sender, EventArgs e)
        {
            frmChangePassword formChangePassword = new frmChangePassword(int.Parse(lblIDEmployees.Text));
            formChangePassword.ShowDialog();

        }

        private void logOutToolStripMenuItem_Click(object sender, EventArgs e)
        {
            frmLogin formLogin = new frmLogin();
            this.Hide();
            formLogin.Show();
            
        }
    }
}
