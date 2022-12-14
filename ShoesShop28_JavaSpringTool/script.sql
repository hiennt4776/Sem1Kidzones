USE [master]
GO
/****** Object:  Database [ProjectSem4_ShoesShop]    Script Date: 3/10/2022 11:22:34 AM ******/
CREATE DATABASE [ProjectSem4_ShoesShop]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'ProjectSem4_ShoesShop', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL13.TONGF\MSSQL\DATA\ProjectSem4_ShoesShop.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'ProjectSem4_ShoesShop_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL13.TONGF\MSSQL\DATA\ProjectSem4_ShoesShop_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [ProjectSem4_ShoesShop] SET COMPATIBILITY_LEVEL = 130
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [ProjectSem4_ShoesShop].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [ProjectSem4_ShoesShop] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [ProjectSem4_ShoesShop] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [ProjectSem4_ShoesShop] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [ProjectSem4_ShoesShop] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [ProjectSem4_ShoesShop] SET ARITHABORT OFF 
GO
ALTER DATABASE [ProjectSem4_ShoesShop] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [ProjectSem4_ShoesShop] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [ProjectSem4_ShoesShop] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [ProjectSem4_ShoesShop] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [ProjectSem4_ShoesShop] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [ProjectSem4_ShoesShop] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [ProjectSem4_ShoesShop] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [ProjectSem4_ShoesShop] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [ProjectSem4_ShoesShop] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [ProjectSem4_ShoesShop] SET  DISABLE_BROKER 
GO
ALTER DATABASE [ProjectSem4_ShoesShop] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [ProjectSem4_ShoesShop] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [ProjectSem4_ShoesShop] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [ProjectSem4_ShoesShop] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [ProjectSem4_ShoesShop] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [ProjectSem4_ShoesShop] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [ProjectSem4_ShoesShop] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [ProjectSem4_ShoesShop] SET RECOVERY FULL 
GO
ALTER DATABASE [ProjectSem4_ShoesShop] SET  MULTI_USER 
GO
ALTER DATABASE [ProjectSem4_ShoesShop] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [ProjectSem4_ShoesShop] SET DB_CHAINING OFF 
GO
ALTER DATABASE [ProjectSem4_ShoesShop] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [ProjectSem4_ShoesShop] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [ProjectSem4_ShoesShop] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'ProjectSem4_ShoesShop', N'ON'
GO
ALTER DATABASE [ProjectSem4_ShoesShop] SET QUERY_STORE = OFF
GO
USE [ProjectSem4_ShoesShop]
GO
ALTER DATABASE SCOPED CONFIGURATION SET MAXDOP = 0;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET MAXDOP = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET LEGACY_CARDINALITY_ESTIMATION = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET LEGACY_CARDINALITY_ESTIMATION = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET PARAMETER_SNIFFING = ON;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET PARAMETER_SNIFFING = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET QUERY_OPTIMIZER_HOTFIXES = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET QUERY_OPTIMIZER_HOTFIXES = PRIMARY;
GO
USE [ProjectSem4_ShoesShop]
GO
/****** Object:  Table [dbo].[brands]    Script Date: 3/10/2022 11:22:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[brands](
	[brand_id] [bigint] IDENTITY(1,1) NOT NULL,
	[address] [varchar](250) NULL,
	[description] [nvarchar](500) NOT NULL,
	[email] [varchar](30) NULL,
	[is_delete] [bit] NOT NULL,
	[brand_name] [nvarchar](100) NOT NULL,
	[phone] [varchar](20) NULL,
PRIMARY KEY CLUSTERED 
(
	[brand_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[contacts]    Script Date: 3/10/2022 11:22:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[contacts](
	[contact_id] [bigint] IDENTITY(1,1) NOT NULL,
	[content] [varchar](500) NULL,
	[email] [varchar](20) NULL,
	[name] [nvarchar](100) NOT NULL,
	[phone] [varchar](20) NULL,
PRIMARY KEY CLUSTERED 
(
	[contact_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[customers]    Script Date: 3/10/2022 11:22:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[customers](
	[customer_id] [bigint] IDENTITY(1,1) NOT NULL,
	[address] [varchar](250) NULL,
	[email] [varchar](20) NULL,
	[gender] [bit] NOT NULL,
	[last_access_date] [date] NULL,
	[customer_name] [nvarchar](100) NOT NULL,
	[password] [nvarchar](100) NOT NULL,
	[phone] [varchar](20) NULL,
	[register_date] [date] NULL,
	[status] [varchar](10) NULL,
	[username] [nvarchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[customer_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[employees]    Script Date: 3/10/2022 11:22:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[employees](
	[employee_id] [bigint] IDENTITY(1,1) NOT NULL,
	[address] [varchar](250) NULL,
	[date_of_birth] [date] NULL,
	[email] [varchar](20) NULL,
	[gender] [bit] NOT NULL,
	[identity_card] [varchar](12) NULL,
	[is_delete] [bit] NOT NULL,
	[last_access_date] [date] NULL,
	[fullname] [nvarchar](100) NOT NULL,
	[password] [nvarchar](100) NOT NULL,
	[phone] [varchar](20) NULL,
	[role] [varchar](10) NULL,
	[status] [varchar](10) NULL,
	[username] [nvarchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[employee_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[order_details]    Script Date: 3/10/2022 11:22:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[order_details](
	[order_detail_id] [bigint] IDENTITY(1,1) NOT NULL,
	[quantity] [int] NOT NULL,
	[unit_price] [float] NOT NULL,
	[order_id] [bigint] NULL,
	[shoes_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[order_detail_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[orders]    Script Date: 3/10/2022 11:22:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[orders](
	[order_id] [bigint] IDENTITY(1,1) NOT NULL,
	[grand_total] [float] NOT NULL,
	[order_date] [date] NULL,
	[ship_date] [date] NULL,
	[status] [varchar](15) NULL,
	[customer_id] [bigint] NULL,
	[employee_id] [bigint] NULL,
	[shipment_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[order_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[shipments]    Script Date: 3/10/2022 11:22:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[shipments](
	[shipment_id] [bigint] IDENTITY(1,1) NOT NULL,
	[address_line] [varchar](250) NULL,
	[shipment_name] [nvarchar](100) NOT NULL,
	[phone] [varchar](20) NULL,
	[province] [varchar](250) NULL,
PRIMARY KEY CLUSTERED 
(
	[shipment_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[shoes]    Script Date: 3/10/2022 11:22:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[shoes](
	[shoes_id] [bigint] IDENTITY(1,1) NOT NULL,
	[created_date] [date] NULL,
	[is_delete] [bit] NOT NULL,
	[quantity] [int] NOT NULL,
	[status] [varchar](20) NULL,
	[updated_date] [date] NULL,
	[employee_id] [bigint] NULL,
	[shoes_size_id] [bigint] NULL,
	[shoes_type_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[shoes_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[shoes_sizes]    Script Date: 3/10/2022 11:22:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[shoes_sizes](
	[shoes_size_id] [bigint] IDENTITY(1,1) NOT NULL,
	[centimeter] [float] NOT NULL,
	[size_number] [float] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[shoes_size_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[shoes_types]    Script Date: 3/10/2022 11:22:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[shoes_types](
	[shoes_type_id] [bigint] IDENTITY(1,1) NOT NULL,
	[best_seller] [bit] NOT NULL,
	[description] [nvarchar](500) NOT NULL,
	[gender] [bit] NOT NULL,
	[image] [varchar](200) NULL,
	[is_delete] [bit] NOT NULL,
	[shoes_type_name] [nvarchar](100) NOT NULL,
	[status] [nvarchar](15) NOT NULL,
	[unit_price] [float] NOT NULL,
	[brand_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[shoes_type_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
ALTER TABLE [dbo].[order_details]  WITH CHECK ADD  CONSTRAINT [FKjyu2qbqt8gnvno9oe9j2s2ldk] FOREIGN KEY([order_id])
REFERENCES [dbo].[orders] ([order_id])
GO
ALTER TABLE [dbo].[order_details] CHECK CONSTRAINT [FKjyu2qbqt8gnvno9oe9j2s2ldk]
GO
ALTER TABLE [dbo].[order_details]  WITH CHECK ADD  CONSTRAINT [FKquhprw4bjmk0ivk48qlfa36hk] FOREIGN KEY([shoes_id])
REFERENCES [dbo].[shoes] ([shoes_id])
GO
ALTER TABLE [dbo].[order_details] CHECK CONSTRAINT [FKquhprw4bjmk0ivk48qlfa36hk]
GO
ALTER TABLE [dbo].[orders]  WITH CHECK ADD  CONSTRAINT [FK999el1skih1flvmhtej496ouh] FOREIGN KEY([shipment_id])
REFERENCES [dbo].[shipments] ([shipment_id])
GO
ALTER TABLE [dbo].[orders] CHECK CONSTRAINT [FK999el1skih1flvmhtej496ouh]
GO
ALTER TABLE [dbo].[orders]  WITH CHECK ADD  CONSTRAINT [FKfhl8bv0xn3sj33q2f3scf1bq6] FOREIGN KEY([employee_id])
REFERENCES [dbo].[employees] ([employee_id])
GO
ALTER TABLE [dbo].[orders] CHECK CONSTRAINT [FKfhl8bv0xn3sj33q2f3scf1bq6]
GO
ALTER TABLE [dbo].[orders]  WITH CHECK ADD  CONSTRAINT [FKpxtb8awmi0dk6smoh2vp1litg] FOREIGN KEY([customer_id])
REFERENCES [dbo].[customers] ([customer_id])
GO
ALTER TABLE [dbo].[orders] CHECK CONSTRAINT [FKpxtb8awmi0dk6smoh2vp1litg]
GO
ALTER TABLE [dbo].[shoes]  WITH CHECK ADD  CONSTRAINT [FK6flxqc3r9r37selaxtdj20oie] FOREIGN KEY([shoes_type_id])
REFERENCES [dbo].[shoes_types] ([shoes_type_id])
GO
ALTER TABLE [dbo].[shoes] CHECK CONSTRAINT [FK6flxqc3r9r37selaxtdj20oie]
GO
ALTER TABLE [dbo].[shoes]  WITH CHECK ADD  CONSTRAINT [FK8wk0kx3kv7mw6klc5m96xbn0c] FOREIGN KEY([employee_id])
REFERENCES [dbo].[employees] ([employee_id])
GO
ALTER TABLE [dbo].[shoes] CHECK CONSTRAINT [FK8wk0kx3kv7mw6klc5m96xbn0c]
GO
ALTER TABLE [dbo].[shoes]  WITH CHECK ADD  CONSTRAINT [FKgfngx6b0oiu0bqg9fvw0sc4es] FOREIGN KEY([shoes_size_id])
REFERENCES [dbo].[shoes_sizes] ([shoes_size_id])
GO
ALTER TABLE [dbo].[shoes] CHECK CONSTRAINT [FKgfngx6b0oiu0bqg9fvw0sc4es]
GO
ALTER TABLE [dbo].[shoes_types]  WITH CHECK ADD  CONSTRAINT [FKc67fr28wx1qmtqoy7bm6xpn8u] FOREIGN KEY([brand_id])
REFERENCES [dbo].[brands] ([brand_id])
GO
ALTER TABLE [dbo].[shoes_types] CHECK CONSTRAINT [FKc67fr28wx1qmtqoy7bm6xpn8u]
GO
USE [master]
GO
ALTER DATABASE [ProjectSem4_ShoesShop] SET  READ_WRITE 
GO
