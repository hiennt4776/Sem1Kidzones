create database QLSV_Java_4
USE QLSV_Java_4
go

create table LOPSH
(
	ID_LopSH char(10) not null,
	TenLopSH nvarchar(10),
	primary key(ID_LopSH)
)

create table CHUCVU
(
	ID_CV char(6) not null,
	TenCV nvarchar(10)
	primary key(ID_CV),
)
create table NHANVIEN
(
	ID_NV char(10) not null,
	TenNV nvarchar(50),
	NgaysinhNV date,
	GioitinhNV bit,
	CMND char(12),
	DiaChiNV nvarchar(200),
	Luong int,
	ID_CV char(6) not null foreign key references CHUCVU(ID_CV),
	Password char(100),
	primary key(ID_NV)
)

create table SINHVIEN
(
	ID_SV char(10) not null,
	TenSV nvarchar(50),
	NgaysinhSV date,
	GioitinhSV bit,
    CMND char(12),
	DiachiSV nvarchar(50),
	ID_LopSH char(10) not null foreign key references LOPSH(ID_LopSH),
	primary key(ID_SV)
)

create table MONHOC
(
	ID_MH char(6) not null,
	TenMH nvarchar(50),
	primary key(ID_MH)
)

create table LOPHP(
	ID_LOPHP char(10) not null,
	TenLopHP nvarchar(10),
	ID_MH char(6) not null foreign key references MONHOC(ID_MH),
	ID_NV char(10) not null foreign key references NHANVIEN(ID_NV),
	HocPhi int,
	primary key(ID_LOPHP)
	)

create table KETQUA
(
	ID_LOPHP char(10) not null foreign key references LOPHP(ID_LOPHP),
	ID_SV char(10) not null foreign key references SINHVIEN(ID_SV),
	BaiTap real,
	GiuaKy real,
	CuoiKy real,
	TrungBinh real,
	Xeploai char(1),
	ID_NV char(10) foreign key references NHANVIEN(ID_NV),
	ThanhToan bit,
	primary key(ID_LOPHP,ID_SV)
)

select ID_LOPHP from KETQUA where THANHTOAN = 0 and ID_SV='SVID02'; 
select * from SINHVIEN ;
select ID_SV from KETQUA where ID_LOPHP='LHPID01'; 

select ID_SV from SINHVIEN
except
select SINHVIEN.ID_SV from SINHVIEN join KETQUA on SINHVIEN.ID_SV = KETQUA.ID_SV and KETQUA.ID_LOPHP='LHPID01';

update KetQua set BaiTap=5.6, GiuaKy=Null, CuoiKy=3.4, TrungBinh=2, XepLoai='A' where ID_SV='SVID01' and ID_LopHP='LHPID01';
insert into KetQua values('LHPID04','SVID01',null,null,null,null,null,null,null);
delete from KetQua where ID_SV='SVID01' and ID_LopHP='LHPID01';
select ID_LopSH from SINHVIEN where ID_SV='SVID01';

select SINHVIEN.ID_SV from SINHVIEN join KETQUA on SINHVIEN.ID_SV = KETQUA.ID_SV and KETQUA.ID_LOPHP='LHPID01';
select * from LOPHP where ID_MH = 'MHID01';

select KQ.ID_LOPHP, LHP.ID_MH, BaiTap, GiuaKy, CuoiKy, TrungBinh, XepLoai from KETQUA KQ join SINHVIEN SV on KQ.ID_SV = SV.ID_SV join LOPHP LHP on KQ.ID_LOPHP = LHP.ID_LOPHP join MONHOC MH on MH.ID_MH = LHP.ID_MH where KQ.ID_SV = 'SVID000007';

select * from SINHVIEN where TenSV like '%Thành%';

SELECT ROUND(AVG(TrungBinh),3) AS "DTB" FROM KETQUA WHERE ID_SV='SVID000001' and Xeploai != 'F';
SELECT ID_LOPHP, ID_SV, ThanhToan FROM KETQUA where ID_SV = 'SVID000001' and ThanhToan = 0;