
namespace WindowsFormsApp6
{
    partial class frmMain
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.ID = new System.Windows.Forms.StatusStrip();
            this.toolStripStatusLabel1 = new System.Windows.Forms.ToolStripStatusLabel();
            this.lblIDEmployees = new System.Windows.Forms.ToolStripStatusLabel();
            this.toolStripStatusLabel3 = new System.Windows.Forms.ToolStripStatusLabel();
            this.lblFullNameEmployees = new System.Windows.Forms.ToolStripStatusLabel();
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.userToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.UsersToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.resetPasswordToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.changePasswordToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.applicationToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.exitToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.tabCategory = new System.Windows.Forms.TabPage();
            this.dgvCategories = new System.Windows.Forms.DataGridView();
            this.btnDeleteCategory = new System.Windows.Forms.Button();
            this.btnEditCategory = new System.Windows.Forms.Button();
            this.btnAddCategory = new System.Windows.Forms.Button();
            this.txtDescriptionCategory = new System.Windows.Forms.TextBox();
            this.txtCategoryName = new System.Windows.Forms.TextBox();
            this.txtCategoryID = new System.Windows.Forms.TextBox();
            this.label8 = new System.Windows.Forms.Label();
            this.label7 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.tabControl1 = new System.Windows.Forms.TabControl();
            this.tabEmployee = new System.Windows.Forms.TabPage();
            this.label32 = new System.Windows.Forms.Label();
            this.cmbUserRange = new System.Windows.Forms.ComboBox();
            this.label25 = new System.Windows.Forms.Label();
            this.label24 = new System.Windows.Forms.Label();
            this.label23 = new System.Windows.Forms.Label();
            this.label22 = new System.Windows.Forms.Label();
            this.label21 = new System.Windows.Forms.Label();
            this.label20 = new System.Windows.Forms.Label();
            this.txtIdEmployee = new System.Windows.Forms.TextBox();
            this.txtAddressEmployee = new System.Windows.Forms.TextBox();
            this.txtPhoneEmployee = new System.Windows.Forms.TextBox();
            this.txtFullnameEmployee = new System.Windows.Forms.TextBox();
            this.label9 = new System.Windows.Forms.Label();
            this.btnDeleteEmployees = new System.Windows.Forms.Button();
            this.btnEditEmployees = new System.Windows.Forms.Button();
            this.btnAddEmployees = new System.Windows.Forms.Button();
            this.label6 = new System.Windows.Forms.Label();
            this.rdoFemale = new System.Windows.Forms.RadioButton();
            this.rdoMale = new System.Windows.Forms.RadioButton();
            this.dtmBirthdayEmployee = new System.Windows.Forms.DateTimePicker();
            this.label4 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.dgvEmployee = new System.Windows.Forms.DataGridView();
            this.tabProduct = new System.Windows.Forms.TabPage();
            this.label31 = new System.Windows.Forms.Label();
            this.txtProductPrice = new System.Windows.Forms.TextBox();
            this.cmbProductCategory = new System.Windows.Forms.ComboBox();
            this.label19 = new System.Windows.Forms.Label();
            this.dgvProducts = new System.Windows.Forms.DataGridView();
            this.btnDeleteProduct = new System.Windows.Forms.Button();
            this.btnEditProduct = new System.Windows.Forms.Button();
            this.btnAddProduct = new System.Windows.Forms.Button();
            this.txtProductDescription = new System.Windows.Forms.TextBox();
            this.txtProductName = new System.Windows.Forms.TextBox();
            this.txtProductID = new System.Windows.Forms.TextBox();
            this.label10 = new System.Windows.Forms.Label();
            this.label11 = new System.Windows.Forms.Label();
            this.label12 = new System.Windows.Forms.Label();
            this.tabStock = new System.Windows.Forms.TabPage();
            this.cmbStockProduct = new System.Windows.Forms.ComboBox();
            this.label30 = new System.Windows.Forms.Label();
            this.nudStockAmount = new System.Windows.Forms.NumericUpDown();
            this.label29 = new System.Windows.Forms.Label();
            this.label28 = new System.Windows.Forms.Label();
            this.label27 = new System.Windows.Forms.Label();
            this.label26 = new System.Windows.Forms.Label();
            this.txtStockID = new System.Windows.Forms.TextBox();
            this.txtStockStatus = new System.Windows.Forms.TextBox();
            this.label13 = new System.Windows.Forms.Label();
            this.btnDeleteStock = new System.Windows.Forms.Button();
            this.btnEditStock = new System.Windows.Forms.Button();
            this.btnAddStock = new System.Windows.Forms.Button();
            this.label14 = new System.Windows.Forms.Label();
            this.dtmStockCreateDay = new System.Windows.Forms.DateTimePicker();
            this.label15 = new System.Windows.Forms.Label();
            this.label16 = new System.Windows.Forms.Label();
            this.label17 = new System.Windows.Forms.Label();
            this.label18 = new System.Windows.Forms.Label();
            this.dgvStocks = new System.Windows.Forms.DataGridView();
            this.logOutToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.ID.SuspendLayout();
            this.menuStrip1.SuspendLayout();
            this.tabCategory.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dgvCategories)).BeginInit();
            this.tabControl1.SuspendLayout();
            this.tabEmployee.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dgvEmployee)).BeginInit();
            this.tabProduct.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dgvProducts)).BeginInit();
            this.tabStock.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.nudStockAmount)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.dgvStocks)).BeginInit();
            this.SuspendLayout();
            // 
            // ID
            // 
            this.ID.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.toolStripStatusLabel1,
            this.lblIDEmployees,
            this.toolStripStatusLabel3,
            this.lblFullNameEmployees});
            this.ID.Location = new System.Drawing.Point(0, 428);
            this.ID.Name = "ID";
            this.ID.Size = new System.Drawing.Size(800, 22);
            this.ID.TabIndex = 1;
            this.ID.Text = "statusStrip1";
            // 
            // toolStripStatusLabel1
            // 
            this.toolStripStatusLabel1.Name = "toolStripStatusLabel1";
            this.toolStripStatusLabel1.Size = new System.Drawing.Size(24, 17);
            this.toolStripStatusLabel1.Text = "ID: ";
            // 
            // lblIDEmployees
            // 
            this.lblIDEmployees.Name = "lblIDEmployees";
            this.lblIDEmployees.Size = new System.Drawing.Size(118, 17);
            this.lblIDEmployees.Text = "toolStripStatusLabel2";
            // 
            // toolStripStatusLabel3
            // 
            this.toolStripStatusLabel3.Name = "toolStripStatusLabel3";
            this.toolStripStatusLabel3.Size = new System.Drawing.Size(39, 17);
            this.toolStripStatusLabel3.Text = "Name";
            // 
            // lblFullNameEmployees
            // 
            this.lblFullNameEmployees.Name = "lblFullNameEmployees";
            this.lblFullNameEmployees.Size = new System.Drawing.Size(118, 17);
            this.lblFullNameEmployees.Text = "toolStripStatusLabel4";
            // 
            // menuStrip1
            // 
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.userToolStripMenuItem,
            this.applicationToolStripMenuItem});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Size = new System.Drawing.Size(800, 24);
            this.menuStrip1.TabIndex = 2;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // userToolStripMenuItem
            // 
            this.userToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.UsersToolStripMenuItem,
            this.resetPasswordToolStripMenuItem,
            this.changePasswordToolStripMenuItem,
            this.logOutToolStripMenuItem});
            this.userToolStripMenuItem.Name = "userToolStripMenuItem";
            this.userToolStripMenuItem.Size = new System.Drawing.Size(42, 20);
            this.userToolStripMenuItem.Text = "User";
            // 
            // UsersToolStripMenuItem
            // 
            this.UsersToolStripMenuItem.Name = "UsersToolStripMenuItem";
            this.UsersToolStripMenuItem.Size = new System.Drawing.Size(168, 22);
            this.UsersToolStripMenuItem.Text = "User";
            this.UsersToolStripMenuItem.Click += new System.EventHandler(this.UsersToolStripMenuItem_Click);
            // 
            // resetPasswordToolStripMenuItem
            // 
            this.resetPasswordToolStripMenuItem.Name = "resetPasswordToolStripMenuItem";
            this.resetPasswordToolStripMenuItem.Size = new System.Drawing.Size(180, 22);
            this.resetPasswordToolStripMenuItem.Text = "Reset Password";
            this.resetPasswordToolStripMenuItem.Click += new System.EventHandler(this.resetPasswordToolStripMenuItem_Click);
            // 
            // changePasswordToolStripMenuItem
            // 
            this.changePasswordToolStripMenuItem.Name = "changePasswordToolStripMenuItem";
            this.changePasswordToolStripMenuItem.Size = new System.Drawing.Size(180, 22);
            this.changePasswordToolStripMenuItem.Text = "Change Password";
            this.changePasswordToolStripMenuItem.Click += new System.EventHandler(this.changePasswordToolStripMenuItem_Click);
            // 
            // applicationToolStripMenuItem
            // 
            this.applicationToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.exitToolStripMenuItem});
            this.applicationToolStripMenuItem.Name = "applicationToolStripMenuItem";
            this.applicationToolStripMenuItem.Size = new System.Drawing.Size(80, 20);
            this.applicationToolStripMenuItem.Text = "Application";
            // 
            // exitToolStripMenuItem
            // 
            this.exitToolStripMenuItem.Name = "exitToolStripMenuItem";
            this.exitToolStripMenuItem.Size = new System.Drawing.Size(93, 22);
            this.exitToolStripMenuItem.Text = "Exit";
            this.exitToolStripMenuItem.Click += new System.EventHandler(this.exitToolStripMenuItem_Click_1);
            // 
            // tabCategory
            // 
            this.tabCategory.Controls.Add(this.dgvCategories);
            this.tabCategory.Controls.Add(this.btnDeleteCategory);
            this.tabCategory.Controls.Add(this.btnEditCategory);
            this.tabCategory.Controls.Add(this.btnAddCategory);
            this.tabCategory.Controls.Add(this.txtDescriptionCategory);
            this.tabCategory.Controls.Add(this.txtCategoryName);
            this.tabCategory.Controls.Add(this.txtCategoryID);
            this.tabCategory.Controls.Add(this.label8);
            this.tabCategory.Controls.Add(this.label7);
            this.tabCategory.Controls.Add(this.label5);
            this.tabCategory.Location = new System.Drawing.Point(4, 22);
            this.tabCategory.Name = "tabCategory";
            this.tabCategory.Padding = new System.Windows.Forms.Padding(3);
            this.tabCategory.Size = new System.Drawing.Size(768, 372);
            this.tabCategory.TabIndex = 2;
            this.tabCategory.Text = "Categories";
            this.tabCategory.UseVisualStyleBackColor = true;
            // 
            // dgvCategories
            // 
            this.dgvCategories.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dgvCategories.Location = new System.Drawing.Point(254, 7);
            this.dgvCategories.Name = "dgvCategories";
            this.dgvCategories.Size = new System.Drawing.Size(511, 359);
            this.dgvCategories.TabIndex = 9;
            this.dgvCategories.Click += new System.EventHandler(this.dgvCategories_Click);
            // 
            // btnDeleteCategory
            // 
            this.btnDeleteCategory.Location = new System.Drawing.Point(173, 159);
            this.btnDeleteCategory.Name = "btnDeleteCategory";
            this.btnDeleteCategory.Size = new System.Drawing.Size(75, 23);
            this.btnDeleteCategory.TabIndex = 8;
            this.btnDeleteCategory.Text = "Delete";
            this.btnDeleteCategory.UseVisualStyleBackColor = true;
            this.btnDeleteCategory.Click += new System.EventHandler(this.btnDeleteCategory_Click);
            // 
            // btnEditCategory
            // 
            this.btnEditCategory.Location = new System.Drawing.Point(92, 160);
            this.btnEditCategory.Name = "btnEditCategory";
            this.btnEditCategory.Size = new System.Drawing.Size(75, 23);
            this.btnEditCategory.TabIndex = 7;
            this.btnEditCategory.Text = "Edit";
            this.btnEditCategory.UseVisualStyleBackColor = true;
            this.btnEditCategory.Click += new System.EventHandler(this.btnEditCategory_Click);
            // 
            // btnAddCategory
            // 
            this.btnAddCategory.Location = new System.Drawing.Point(11, 160);
            this.btnAddCategory.Name = "btnAddCategory";
            this.btnAddCategory.Size = new System.Drawing.Size(75, 23);
            this.btnAddCategory.TabIndex = 6;
            this.btnAddCategory.Text = "Add";
            this.btnAddCategory.UseVisualStyleBackColor = true;
            this.btnAddCategory.Click += new System.EventHandler(this.btnAddCategory_Click);
            // 
            // txtDescriptionCategory
            // 
            this.txtDescriptionCategory.Location = new System.Drawing.Point(94, 75);
            this.txtDescriptionCategory.Multiline = true;
            this.txtDescriptionCategory.Name = "txtDescriptionCategory";
            this.txtDescriptionCategory.Size = new System.Drawing.Size(154, 78);
            this.txtDescriptionCategory.TabIndex = 5;
            // 
            // txtCategoryName
            // 
            this.txtCategoryName.Location = new System.Drawing.Point(94, 49);
            this.txtCategoryName.Name = "txtCategoryName";
            this.txtCategoryName.Size = new System.Drawing.Size(154, 20);
            this.txtCategoryName.TabIndex = 4;
            // 
            // txtCategoryID
            // 
            this.txtCategoryID.Location = new System.Drawing.Point(94, 22);
            this.txtCategoryID.Name = "txtCategoryID";
            this.txtCategoryID.ReadOnly = true;
            this.txtCategoryID.Size = new System.Drawing.Size(154, 20);
            this.txtCategoryID.TabIndex = 3;
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Location = new System.Drawing.Point(6, 79);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(60, 13);
            this.label8.TabIndex = 2;
            this.label8.Text = "Description";
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(8, 52);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(80, 13);
            this.label7.TabIndex = 1;
            this.label7.Text = "Category Name";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(6, 25);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(18, 13);
            this.label5.TabIndex = 0;
            this.label5.Text = "ID";
            // 
            // tabControl1
            // 
            this.tabControl1.Controls.Add(this.tabEmployee);
            this.tabControl1.Controls.Add(this.tabCategory);
            this.tabControl1.Controls.Add(this.tabProduct);
            this.tabControl1.Controls.Add(this.tabStock);
            this.tabControl1.Location = new System.Drawing.Point(12, 27);
            this.tabControl1.Name = "tabControl1";
            this.tabControl1.SelectedIndex = 0;
            this.tabControl1.Size = new System.Drawing.Size(776, 398);
            this.tabControl1.TabIndex = 0;
            // 
            // tabEmployee
            // 
            this.tabEmployee.Controls.Add(this.label32);
            this.tabEmployee.Controls.Add(this.cmbUserRange);
            this.tabEmployee.Controls.Add(this.label25);
            this.tabEmployee.Controls.Add(this.label24);
            this.tabEmployee.Controls.Add(this.label23);
            this.tabEmployee.Controls.Add(this.label22);
            this.tabEmployee.Controls.Add(this.label21);
            this.tabEmployee.Controls.Add(this.label20);
            this.tabEmployee.Controls.Add(this.txtIdEmployee);
            this.tabEmployee.Controls.Add(this.txtAddressEmployee);
            this.tabEmployee.Controls.Add(this.txtPhoneEmployee);
            this.tabEmployee.Controls.Add(this.txtFullnameEmployee);
            this.tabEmployee.Controls.Add(this.label9);
            this.tabEmployee.Controls.Add(this.btnDeleteEmployees);
            this.tabEmployee.Controls.Add(this.btnEditEmployees);
            this.tabEmployee.Controls.Add(this.btnAddEmployees);
            this.tabEmployee.Controls.Add(this.label6);
            this.tabEmployee.Controls.Add(this.rdoFemale);
            this.tabEmployee.Controls.Add(this.rdoMale);
            this.tabEmployee.Controls.Add(this.dtmBirthdayEmployee);
            this.tabEmployee.Controls.Add(this.label4);
            this.tabEmployee.Controls.Add(this.label3);
            this.tabEmployee.Controls.Add(this.label2);
            this.tabEmployee.Controls.Add(this.label1);
            this.tabEmployee.Controls.Add(this.dgvEmployee);
            this.tabEmployee.Location = new System.Drawing.Point(4, 22);
            this.tabEmployee.Name = "tabEmployee";
            this.tabEmployee.Padding = new System.Windows.Forms.Padding(3);
            this.tabEmployee.Size = new System.Drawing.Size(768, 372);
            this.tabEmployee.TabIndex = 1;
            this.tabEmployee.Text = "Employees";
            this.tabEmployee.UseVisualStyleBackColor = true;
            // 
            // label32
            // 
            this.label32.AutoSize = true;
            this.label32.Location = new System.Drawing.Point(313, 89);
            this.label32.Name = "label32";
            this.label32.Size = new System.Drawing.Size(64, 13);
            this.label32.TabIndex = 28;
            this.label32.Text = "User Range";
            // 
            // cmbUserRange
            // 
            this.cmbUserRange.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cmbUserRange.FormattingEnabled = true;
            this.cmbUserRange.Items.AddRange(new object[] {
            "ADMIN",
            "MANAGEMENT",
            "STOCK STAFF"});
            this.cmbUserRange.Location = new System.Drawing.Point(396, 86);
            this.cmbUserRange.Name = "cmbUserRange";
            this.cmbUserRange.Size = new System.Drawing.Size(206, 21);
            this.cmbUserRange.TabIndex = 27;
            // 
            // label25
            // 
            this.label25.AutoSize = true;
            this.label25.Location = new System.Drawing.Point(313, 35);
            this.label25.Name = "label25";
            this.label25.Size = new System.Drawing.Size(45, 13);
            this.label25.TabIndex = 26;
            this.label25.Text = "Address";
            // 
            // label24
            // 
            this.label24.AutoSize = true;
            this.label24.Location = new System.Drawing.Point(20, 89);
            this.label24.Name = "label24";
            this.label24.Size = new System.Drawing.Size(42, 13);
            this.label24.TabIndex = 25;
            this.label24.Text = "Gender";
            // 
            // label23
            // 
            this.label23.AutoSize = true;
            this.label23.Location = new System.Drawing.Point(314, 13);
            this.label23.Name = "label23";
            this.label23.Size = new System.Drawing.Size(38, 13);
            this.label23.TabIndex = 24;
            this.label23.Text = "Phone";
            // 
            // label22
            // 
            this.label22.AutoSize = true;
            this.label22.Location = new System.Drawing.Point(20, 62);
            this.label22.Name = "label22";
            this.label22.Size = new System.Drawing.Size(45, 13);
            this.label22.TabIndex = 23;
            this.label22.Text = "Birthday";
            // 
            // label21
            // 
            this.label21.AutoSize = true;
            this.label21.Location = new System.Drawing.Point(20, 36);
            this.label21.Name = "label21";
            this.label21.Size = new System.Drawing.Size(52, 13);
            this.label21.TabIndex = 22;
            this.label21.Text = "Full name";
            // 
            // label20
            // 
            this.label20.AutoSize = true;
            this.label20.Location = new System.Drawing.Point(20, 13);
            this.label20.Name = "label20";
            this.label20.Size = new System.Drawing.Size(18, 13);
            this.label20.TabIndex = 21;
            this.label20.Text = "ID";
            // 
            // txtIdEmployee
            // 
            this.txtIdEmployee.Location = new System.Drawing.Point(87, 10);
            this.txtIdEmployee.Name = "txtIdEmployee";
            this.txtIdEmployee.ReadOnly = true;
            this.txtIdEmployee.Size = new System.Drawing.Size(200, 20);
            this.txtIdEmployee.TabIndex = 20;
            // 
            // txtAddressEmployee
            // 
            this.txtAddressEmployee.Location = new System.Drawing.Point(396, 33);
            this.txtAddressEmployee.Multiline = true;
            this.txtAddressEmployee.Name = "txtAddressEmployee";
            this.txtAddressEmployee.Size = new System.Drawing.Size(206, 47);
            this.txtAddressEmployee.TabIndex = 15;
            // 
            // txtPhoneEmployee
            // 
            this.txtPhoneEmployee.Location = new System.Drawing.Point(396, 10);
            this.txtPhoneEmployee.Name = "txtPhoneEmployee";
            this.txtPhoneEmployee.Size = new System.Drawing.Size(206, 20);
            this.txtPhoneEmployee.TabIndex = 11;
            // 
            // txtFullnameEmployee
            // 
            this.txtFullnameEmployee.Location = new System.Drawing.Point(87, 33);
            this.txtFullnameEmployee.Name = "txtFullnameEmployee";
            this.txtFullnameEmployee.Size = new System.Drawing.Size(200, 20);
            this.txtFullnameEmployee.TabIndex = 9;
            // 
            // label9
            // 
            this.label9.AutoSize = true;
            this.label9.Location = new System.Drawing.Point(40, 13);
            this.label9.Name = "label9";
            this.label9.Size = new System.Drawing.Size(0, 13);
            this.label9.TabIndex = 19;
            // 
            // btnDeleteEmployees
            // 
            this.btnDeleteEmployees.Location = new System.Drawing.Point(656, 68);
            this.btnDeleteEmployees.Name = "btnDeleteEmployees";
            this.btnDeleteEmployees.Size = new System.Drawing.Size(75, 23);
            this.btnDeleteEmployees.TabIndex = 18;
            this.btnDeleteEmployees.Text = "Delete";
            this.btnDeleteEmployees.UseVisualStyleBackColor = true;
            this.btnDeleteEmployees.Click += new System.EventHandler(this.btnDeleteEmployees_Click);
            // 
            // btnEditEmployees
            // 
            this.btnEditEmployees.Location = new System.Drawing.Point(656, 39);
            this.btnEditEmployees.Name = "btnEditEmployees";
            this.btnEditEmployees.Size = new System.Drawing.Size(75, 23);
            this.btnEditEmployees.TabIndex = 17;
            this.btnEditEmployees.Text = "Edit";
            this.btnEditEmployees.UseVisualStyleBackColor = true;
            this.btnEditEmployees.Click += new System.EventHandler(this.btnEditEmployees_Click);
            // 
            // btnAddEmployees
            // 
            this.btnAddEmployees.Location = new System.Drawing.Point(656, 10);
            this.btnAddEmployees.Name = "btnAddEmployees";
            this.btnAddEmployees.Size = new System.Drawing.Size(75, 23);
            this.btnAddEmployees.TabIndex = 16;
            this.btnAddEmployees.Text = "Add";
            this.btnAddEmployees.UseVisualStyleBackColor = true;
            this.btnAddEmployees.Click += new System.EventHandler(this.btnAddEmployees_Click);
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(349, 44);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(0, 13);
            this.label6.TabIndex = 14;
            // 
            // rdoFemale
            // 
            this.rdoFemale.AutoSize = true;
            this.rdoFemale.Location = new System.Drawing.Point(179, 87);
            this.rdoFemale.Name = "rdoFemale";
            this.rdoFemale.Size = new System.Drawing.Size(59, 17);
            this.rdoFemale.TabIndex = 13;
            this.rdoFemale.Text = "Female";
            this.rdoFemale.UseVisualStyleBackColor = true;
            // 
            // rdoMale
            // 
            this.rdoMale.AutoSize = true;
            this.rdoMale.Checked = true;
            this.rdoMale.Location = new System.Drawing.Point(87, 87);
            this.rdoMale.Name = "rdoMale";
            this.rdoMale.Size = new System.Drawing.Size(48, 17);
            this.rdoMale.TabIndex = 12;
            this.rdoMale.TabStop = true;
            this.rdoMale.Text = "Male";
            this.rdoMale.UseVisualStyleBackColor = true;
            // 
            // dtmBirthdayEmployee
            // 
            this.dtmBirthdayEmployee.Location = new System.Drawing.Point(87, 56);
            this.dtmBirthdayEmployee.Name = "dtmBirthdayEmployee";
            this.dtmBirthdayEmployee.Size = new System.Drawing.Size(200, 20);
            this.dtmBirthdayEmployee.TabIndex = 10;
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(352, 15);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(0, 13);
            this.label4.TabIndex = 7;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(40, 89);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(0, 13);
            this.label3.TabIndex = 6;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(40, 65);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(0, 13);
            this.label2.TabIndex = 5;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(40, 36);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(0, 13);
            this.label1.TabIndex = 4;
            // 
            // dgvEmployee
            // 
            this.dgvEmployee.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dgvEmployee.Location = new System.Drawing.Point(6, 110);
            this.dgvEmployee.Name = "dgvEmployee";
            this.dgvEmployee.Size = new System.Drawing.Size(756, 256);
            this.dgvEmployee.TabIndex = 0;
            this.dgvEmployee.Click += new System.EventHandler(this.dgvEmployee_Click);
            // 
            // tabProduct
            // 
            this.tabProduct.Controls.Add(this.label31);
            this.tabProduct.Controls.Add(this.txtProductPrice);
            this.tabProduct.Controls.Add(this.cmbProductCategory);
            this.tabProduct.Controls.Add(this.label19);
            this.tabProduct.Controls.Add(this.dgvProducts);
            this.tabProduct.Controls.Add(this.btnDeleteProduct);
            this.tabProduct.Controls.Add(this.btnEditProduct);
            this.tabProduct.Controls.Add(this.btnAddProduct);
            this.tabProduct.Controls.Add(this.txtProductDescription);
            this.tabProduct.Controls.Add(this.txtProductName);
            this.tabProduct.Controls.Add(this.txtProductID);
            this.tabProduct.Controls.Add(this.label10);
            this.tabProduct.Controls.Add(this.label11);
            this.tabProduct.Controls.Add(this.label12);
            this.tabProduct.Location = new System.Drawing.Point(4, 22);
            this.tabProduct.Name = "tabProduct";
            this.tabProduct.Padding = new System.Windows.Forms.Padding(3);
            this.tabProduct.Size = new System.Drawing.Size(768, 372);
            this.tabProduct.TabIndex = 3;
            this.tabProduct.Text = "Products";
            this.tabProduct.UseVisualStyleBackColor = true;
            // 
            // label31
            // 
            this.label31.AutoSize = true;
            this.label31.Location = new System.Drawing.Point(15, 79);
            this.label31.Name = "label31";
            this.label31.Size = new System.Drawing.Size(31, 13);
            this.label31.TabIndex = 13;
            this.label31.Text = "Price";
            // 
            // txtProductPrice
            // 
            this.txtProductPrice.Location = new System.Drawing.Point(106, 76);
            this.txtProductPrice.Name = "txtProductPrice";
            this.txtProductPrice.Size = new System.Drawing.Size(149, 20);
            this.txtProductPrice.TabIndex = 12;
            // 
            // cmbProductCategory
            // 
            this.cmbProductCategory.FormattingEnabled = true;
            this.cmbProductCategory.Location = new System.Drawing.Point(106, 186);
            this.cmbProductCategory.Name = "cmbProductCategory";
            this.cmbProductCategory.Size = new System.Drawing.Size(149, 21);
            this.cmbProductCategory.TabIndex = 11;
            // 
            // label19
            // 
            this.label19.AutoSize = true;
            this.label19.Location = new System.Drawing.Point(15, 189);
            this.label19.Name = "label19";
            this.label19.Size = new System.Drawing.Size(49, 13);
            this.label19.TabIndex = 10;
            this.label19.Text = "Category";
            // 
            // dgvProducts
            // 
            this.dgvProducts.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dgvProducts.Location = new System.Drawing.Point(261, 7);
            this.dgvProducts.Name = "dgvProducts";
            this.dgvProducts.Size = new System.Drawing.Size(504, 359);
            this.dgvProducts.TabIndex = 9;
            this.dgvProducts.Click += new System.EventHandler(this.dgvProducts_Click);
            // 
            // btnDeleteProduct
            // 
            this.btnDeleteProduct.Location = new System.Drawing.Point(180, 223);
            this.btnDeleteProduct.Name = "btnDeleteProduct";
            this.btnDeleteProduct.Size = new System.Drawing.Size(75, 23);
            this.btnDeleteProduct.TabIndex = 8;
            this.btnDeleteProduct.Text = "Delete";
            this.btnDeleteProduct.UseVisualStyleBackColor = true;
            this.btnDeleteProduct.Click += new System.EventHandler(this.btnDeleteProduct_Click);
            // 
            // btnEditProduct
            // 
            this.btnEditProduct.Location = new System.Drawing.Point(99, 223);
            this.btnEditProduct.Name = "btnEditProduct";
            this.btnEditProduct.Size = new System.Drawing.Size(75, 23);
            this.btnEditProduct.TabIndex = 7;
            this.btnEditProduct.Text = "Edit";
            this.btnEditProduct.UseVisualStyleBackColor = true;
            this.btnEditProduct.Click += new System.EventHandler(this.btnEditProduct_Click);
            // 
            // btnAddProduct
            // 
            this.btnAddProduct.Location = new System.Drawing.Point(18, 223);
            this.btnAddProduct.Name = "btnAddProduct";
            this.btnAddProduct.Size = new System.Drawing.Size(75, 23);
            this.btnAddProduct.TabIndex = 6;
            this.btnAddProduct.Text = "Add";
            this.btnAddProduct.UseVisualStyleBackColor = true;
            this.btnAddProduct.Click += new System.EventHandler(this.btnAddProduct_Click);
            // 
            // txtProductDescription
            // 
            this.txtProductDescription.Location = new System.Drawing.Point(106, 102);
            this.txtProductDescription.Multiline = true;
            this.txtProductDescription.Name = "txtProductDescription";
            this.txtProductDescription.Size = new System.Drawing.Size(149, 78);
            this.txtProductDescription.TabIndex = 5;
            // 
            // txtProductName
            // 
            this.txtProductName.Location = new System.Drawing.Point(106, 49);
            this.txtProductName.Name = "txtProductName";
            this.txtProductName.Size = new System.Drawing.Size(149, 20);
            this.txtProductName.TabIndex = 4;
            // 
            // txtProductID
            // 
            this.txtProductID.Location = new System.Drawing.Point(106, 22);
            this.txtProductID.Name = "txtProductID";
            this.txtProductID.ReadOnly = true;
            this.txtProductID.Size = new System.Drawing.Size(149, 20);
            this.txtProductID.TabIndex = 3;
            // 
            // label10
            // 
            this.label10.AutoSize = true;
            this.label10.Location = new System.Drawing.Point(15, 105);
            this.label10.Name = "label10";
            this.label10.Size = new System.Drawing.Size(60, 13);
            this.label10.TabIndex = 2;
            this.label10.Text = "Description";
            // 
            // label11
            // 
            this.label11.AutoSize = true;
            this.label11.Location = new System.Drawing.Point(15, 52);
            this.label11.Name = "label11";
            this.label11.Size = new System.Drawing.Size(75, 13);
            this.label11.TabIndex = 1;
            this.label11.Text = "Product Name";
            // 
            // label12
            // 
            this.label12.AutoSize = true;
            this.label12.Location = new System.Drawing.Point(15, 25);
            this.label12.Name = "label12";
            this.label12.Size = new System.Drawing.Size(18, 13);
            this.label12.TabIndex = 0;
            this.label12.Text = "ID";
            // 
            // tabStock
            // 
            this.tabStock.Controls.Add(this.cmbStockProduct);
            this.tabStock.Controls.Add(this.label30);
            this.tabStock.Controls.Add(this.nudStockAmount);
            this.tabStock.Controls.Add(this.label29);
            this.tabStock.Controls.Add(this.label28);
            this.tabStock.Controls.Add(this.label27);
            this.tabStock.Controls.Add(this.label26);
            this.tabStock.Controls.Add(this.txtStockID);
            this.tabStock.Controls.Add(this.txtStockStatus);
            this.tabStock.Controls.Add(this.label13);
            this.tabStock.Controls.Add(this.btnDeleteStock);
            this.tabStock.Controls.Add(this.btnEditStock);
            this.tabStock.Controls.Add(this.btnAddStock);
            this.tabStock.Controls.Add(this.label14);
            this.tabStock.Controls.Add(this.dtmStockCreateDay);
            this.tabStock.Controls.Add(this.label15);
            this.tabStock.Controls.Add(this.label16);
            this.tabStock.Controls.Add(this.label17);
            this.tabStock.Controls.Add(this.label18);
            this.tabStock.Controls.Add(this.dgvStocks);
            this.tabStock.Location = new System.Drawing.Point(4, 22);
            this.tabStock.Name = "tabStock";
            this.tabStock.Padding = new System.Windows.Forms.Padding(3);
            this.tabStock.Size = new System.Drawing.Size(768, 372);
            this.tabStock.TabIndex = 4;
            this.tabStock.Text = "Stocks";
            this.tabStock.UseVisualStyleBackColor = true;
            // 
            // cmbStockProduct
            // 
            this.cmbStockProduct.FormattingEnabled = true;
            this.cmbStockProduct.Location = new System.Drawing.Point(410, 36);
            this.cmbStockProduct.Name = "cmbStockProduct";
            this.cmbStockProduct.Size = new System.Drawing.Size(190, 21);
            this.cmbStockProduct.TabIndex = 27;
            // 
            // label30
            // 
            this.label30.AutoSize = true;
            this.label30.Location = new System.Drawing.Point(349, 39);
            this.label30.Name = "label30";
            this.label30.Size = new System.Drawing.Size(44, 13);
            this.label30.TabIndex = 26;
            this.label30.Text = "Product";
            // 
            // nudStockAmount
            // 
            this.nudStockAmount.Location = new System.Drawing.Point(107, 66);
            this.nudStockAmount.Name = "nudStockAmount";
            this.nudStockAmount.Size = new System.Drawing.Size(200, 20);
            this.nudStockAmount.TabIndex = 25;
            // 
            // label29
            // 
            this.label29.AutoSize = true;
            this.label29.Location = new System.Drawing.Point(349, 13);
            this.label29.Name = "label29";
            this.label29.Size = new System.Drawing.Size(37, 13);
            this.label29.TabIndex = 24;
            this.label29.Text = "Status";
            // 
            // label28
            // 
            this.label28.AutoSize = true;
            this.label28.Location = new System.Drawing.Point(22, 68);
            this.label28.Name = "label28";
            this.label28.Size = new System.Drawing.Size(43, 13);
            this.label28.TabIndex = 23;
            this.label28.Text = "Amount";
            // 
            // label27
            // 
            this.label27.AutoSize = true;
            this.label27.Location = new System.Drawing.Point(22, 39);
            this.label27.Name = "label27";
            this.label27.Size = new System.Drawing.Size(60, 13);
            this.label27.TabIndex = 22;
            this.label27.Text = "Create Day";
            // 
            // label26
            // 
            this.label26.AutoSize = true;
            this.label26.Location = new System.Drawing.Point(22, 13);
            this.label26.Name = "label26";
            this.label26.Size = new System.Drawing.Size(18, 13);
            this.label26.TabIndex = 21;
            this.label26.Text = "ID";
            // 
            // txtStockID
            // 
            this.txtStockID.Location = new System.Drawing.Point(107, 10);
            this.txtStockID.Name = "txtStockID";
            this.txtStockID.ReadOnly = true;
            this.txtStockID.Size = new System.Drawing.Size(200, 20);
            this.txtStockID.TabIndex = 20;
            // 
            // txtStockStatus
            // 
            this.txtStockStatus.Location = new System.Drawing.Point(410, 10);
            this.txtStockStatus.Name = "txtStockStatus";
            this.txtStockStatus.Size = new System.Drawing.Size(190, 20);
            this.txtStockStatus.TabIndex = 9;
            // 
            // label13
            // 
            this.label13.AutoSize = true;
            this.label13.Location = new System.Drawing.Point(40, 13);
            this.label13.Name = "label13";
            this.label13.Size = new System.Drawing.Size(0, 13);
            this.label13.TabIndex = 19;
            // 
            // btnDeleteStock
            // 
            this.btnDeleteStock.Location = new System.Drawing.Point(656, 68);
            this.btnDeleteStock.Name = "btnDeleteStock";
            this.btnDeleteStock.Size = new System.Drawing.Size(75, 23);
            this.btnDeleteStock.TabIndex = 18;
            this.btnDeleteStock.Text = "Delete";
            this.btnDeleteStock.UseVisualStyleBackColor = true;
            this.btnDeleteStock.Click += new System.EventHandler(this.btnDeleteStock_Click);
            // 
            // btnEditStock
            // 
            this.btnEditStock.Location = new System.Drawing.Point(656, 39);
            this.btnEditStock.Name = "btnEditStock";
            this.btnEditStock.Size = new System.Drawing.Size(75, 23);
            this.btnEditStock.TabIndex = 17;
            this.btnEditStock.Text = "Edit";
            this.btnEditStock.UseVisualStyleBackColor = true;
            this.btnEditStock.Click += new System.EventHandler(this.btnEditStock_Click);
            // 
            // btnAddStock
            // 
            this.btnAddStock.Location = new System.Drawing.Point(656, 10);
            this.btnAddStock.Name = "btnAddStock";
            this.btnAddStock.Size = new System.Drawing.Size(75, 23);
            this.btnAddStock.TabIndex = 16;
            this.btnAddStock.Text = "Add";
            this.btnAddStock.UseVisualStyleBackColor = true;
            this.btnAddStock.Click += new System.EventHandler(this.btnAddStock_Click);
            // 
            // label14
            // 
            this.label14.AutoSize = true;
            this.label14.Location = new System.Drawing.Point(349, 44);
            this.label14.Name = "label14";
            this.label14.Size = new System.Drawing.Size(0, 13);
            this.label14.TabIndex = 14;
            // 
            // dtmStockCreateDay
            // 
            this.dtmStockCreateDay.Location = new System.Drawing.Point(107, 36);
            this.dtmStockCreateDay.Name = "dtmStockCreateDay";
            this.dtmStockCreateDay.Size = new System.Drawing.Size(200, 20);
            this.dtmStockCreateDay.TabIndex = 10;
            // 
            // label15
            // 
            this.label15.AutoSize = true;
            this.label15.Location = new System.Drawing.Point(352, 15);
            this.label15.Name = "label15";
            this.label15.Size = new System.Drawing.Size(0, 13);
            this.label15.TabIndex = 7;
            // 
            // label16
            // 
            this.label16.AutoSize = true;
            this.label16.Location = new System.Drawing.Point(40, 89);
            this.label16.Name = "label16";
            this.label16.Size = new System.Drawing.Size(0, 13);
            this.label16.TabIndex = 6;
            // 
            // label17
            // 
            this.label17.AutoSize = true;
            this.label17.Location = new System.Drawing.Point(40, 65);
            this.label17.Name = "label17";
            this.label17.Size = new System.Drawing.Size(0, 13);
            this.label17.TabIndex = 5;
            // 
            // label18
            // 
            this.label18.AutoSize = true;
            this.label18.Location = new System.Drawing.Point(40, 36);
            this.label18.Name = "label18";
            this.label18.Size = new System.Drawing.Size(0, 13);
            this.label18.TabIndex = 4;
            // 
            // dgvStocks
            // 
            this.dgvStocks.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dgvStocks.Location = new System.Drawing.Point(6, 97);
            this.dgvStocks.Name = "dgvStocks";
            this.dgvStocks.Size = new System.Drawing.Size(756, 269);
            this.dgvStocks.TabIndex = 0;
            this.dgvStocks.Click += new System.EventHandler(this.dgvStock_Click);
            // 
            // logOutToolStripMenuItem
            // 
            this.logOutToolStripMenuItem.Name = "logOutToolStripMenuItem";
            this.logOutToolStripMenuItem.Size = new System.Drawing.Size(180, 22);
            this.logOutToolStripMenuItem.Text = "Log Out";
            this.logOutToolStripMenuItem.Click += new System.EventHandler(this.logOutToolStripMenuItem_Click);
            // 
            // frmMain
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.ID);
            this.Controls.Add(this.menuStrip1);
            this.Controls.Add(this.tabControl1);
            this.MainMenuStrip = this.menuStrip1;
            this.Name = "frmMain";
            this.Text = "Form2";
            this.FormClosed += new System.Windows.Forms.FormClosedEventHandler(this.frmMain_FormClosed);
            this.ID.ResumeLayout(false);
            this.ID.PerformLayout();
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            this.tabCategory.ResumeLayout(false);
            this.tabCategory.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dgvCategories)).EndInit();
            this.tabControl1.ResumeLayout(false);
            this.tabEmployee.ResumeLayout(false);
            this.tabEmployee.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dgvEmployee)).EndInit();
            this.tabProduct.ResumeLayout(false);
            this.tabProduct.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dgvProducts)).EndInit();
            this.tabStock.ResumeLayout(false);
            this.tabStock.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.nudStockAmount)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.dgvStocks)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private System.Windows.Forms.StatusStrip ID;
        private System.Windows.Forms.ToolStripStatusLabel toolStripStatusLabel1;
        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem userToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem UsersToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem resetPasswordToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem applicationToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem exitToolStripMenuItem;
        private System.Windows.Forms.TabPage tabCategory;
        private System.Windows.Forms.DataGridView dgvCategories;
        private System.Windows.Forms.Button btnDeleteCategory;
        private System.Windows.Forms.Button btnEditCategory;
        private System.Windows.Forms.Button btnAddCategory;
        private System.Windows.Forms.TextBox txtDescriptionCategory;
        private System.Windows.Forms.TextBox txtCategoryName;
        private System.Windows.Forms.TextBox txtCategoryID;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.TabControl tabControl1;
        private System.Windows.Forms.TabPage tabEmployee;
        private System.Windows.Forms.TextBox txtIdEmployee;
        private System.Windows.Forms.TextBox txtAddressEmployee;
        private System.Windows.Forms.TextBox txtPhoneEmployee;
        private System.Windows.Forms.TextBox txtFullnameEmployee;
        private System.Windows.Forms.Label label9;
        private System.Windows.Forms.Button btnDeleteEmployees;
        private System.Windows.Forms.Button btnEditEmployees;
        private System.Windows.Forms.Button btnAddEmployees;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.RadioButton rdoFemale;
        private System.Windows.Forms.RadioButton rdoMale;
        private System.Windows.Forms.DateTimePicker dtmBirthdayEmployee;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.DataGridView dgvEmployee;
        private System.Windows.Forms.TabPage tabProduct;
        private System.Windows.Forms.DataGridView dgvProducts;
        private System.Windows.Forms.Button btnDeleteProduct;
        private System.Windows.Forms.Button btnEditProduct;
        private System.Windows.Forms.Button btnAddProduct;
        private System.Windows.Forms.TextBox txtProductDescription;
        private System.Windows.Forms.TextBox txtProductName;
        private System.Windows.Forms.TextBox txtProductID;
        private System.Windows.Forms.Label label10;
        private System.Windows.Forms.Label label11;
        private System.Windows.Forms.Label label12;
        private System.Windows.Forms.TabPage tabStock;
        private System.Windows.Forms.TextBox txtStockID;
        private System.Windows.Forms.TextBox txtStockStatus;
        private System.Windows.Forms.Label label13;
        private System.Windows.Forms.Button btnDeleteStock;
        private System.Windows.Forms.Button btnEditStock;
        private System.Windows.Forms.Button btnAddStock;
        private System.Windows.Forms.Label label14;
        private System.Windows.Forms.DateTimePicker dtmStockCreateDay;
        private System.Windows.Forms.Label label15;
        private System.Windows.Forms.Label label16;
        private System.Windows.Forms.Label label17;
        private System.Windows.Forms.Label label18;
        private System.Windows.Forms.DataGridView dgvStocks;
        private System.Windows.Forms.ComboBox cmbProductCategory;
        private System.Windows.Forms.Label label19;
        private System.Windows.Forms.Label label25;
        private System.Windows.Forms.Label label24;
        private System.Windows.Forms.Label label23;
        private System.Windows.Forms.Label label22;
        private System.Windows.Forms.Label label21;
        private System.Windows.Forms.Label label20;
        private System.Windows.Forms.NumericUpDown nudStockAmount;
        private System.Windows.Forms.Label label29;
        private System.Windows.Forms.Label label28;
        private System.Windows.Forms.Label label27;
        private System.Windows.Forms.Label label26;
        private System.Windows.Forms.Label label30;
        private System.Windows.Forms.ComboBox cmbStockProduct;
        private System.Windows.Forms.ToolStripStatusLabel lblIDEmployees;
        private System.Windows.Forms.ToolStripStatusLabel toolStripStatusLabel3;
        private System.Windows.Forms.ToolStripStatusLabel lblFullNameEmployees;
        private System.Windows.Forms.ToolStripMenuItem changePasswordToolStripMenuItem;
        private System.Windows.Forms.Label label31;
        private System.Windows.Forms.TextBox txtProductPrice;
        private System.Windows.Forms.Label label32;
        private System.Windows.Forms.ComboBox cmbUserRange;
        private System.Windows.Forms.ToolStripMenuItem logOutToolStripMenuItem;
    }
}