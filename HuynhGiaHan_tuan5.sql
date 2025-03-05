--II) Stored Procedure:
--1)  Viết  một  thủ  tục  tính  tổng  tiền  thu  (TotalDue)  của  mỗi  khách  hàng  trong  một 
--tháng bất kỳ của  một năm bất kỳ (tham số tháng và năm) được nhập từ bàn phím, 
--thông tin gồm: CustomerID, SumOfTotalDue  =Sum(TotalDue)
--select * from [Sales].[Customer]
--select * from [Sales].[SalesOrderHeader]
create proc sp_total @thang int, @nam int
as
	select c.CustomerID, SumOfTotalDue  = Sum(TotalDue), count(oh.SalesOrderID) as TotalOrders  
	from [Sales].[Customer] c join [Sales].[SalesOrderHeader] oh
	on c.CustomerID = oh.CustomerID
	where month(oh.OrderDate) = @thang and year(oh.OrderDate) = @nam
	group by c.CustomerID
	having TotalOrders  
go
exec sp_total @thang = 7, @nam = 2008

--2)  Viết  một  thủ  tục  dùng  để  xem  doanh  thu  từ  đầu  năm  cho  đến  ngày  hiện  tại 
--(SalesYTD)  của một nhân viên bất kỳ, với một tham số đầu vào và một tham số 
--đầu ra. Tham số @SalesPerson nhận giá trị đầu vào theo chỉ định khi gọi thủ tục, 
--tham số @SalesYTD được sử dụng để chứa giá trị trả về của thủ tục. 
--select * from [Sales].[SalesPerson]
create proc doanhthu @SalesYTD money output, @SalesPerson int
as
	select @SalesYTD = @SalesYTD
	from [Sales].[SalesPerson]
	where BusinessEntityID = @SalesPerson
go
declare @DoanhThuNam money
exec doanhthu 277, @DoanhThuNam out
select @DoanhThuNam as [Doanh thu nam]
go
		
--3)  Viết một thủ tục trả về một danh sách ProductID, ListPrice của các sản phẩm 
--có giá bán không vượt quá một giá trị chỉ định (tham số input @MaxPrice). 
--select * from [Production].[Product]
create proc danhsach input @MaxPrice
as
	select ProductID, ListPrice
	from [Production].[Product]
	where ListPrice <= @MaxPrice

--4)  Viết thủ tục tên NewBonus cập nhật lại tiền thưởng (Bonus) cho 1 nhân viên bán 
--hàng (SalesPerson), dựa trên tổng doanh thu của nhân viên  đó. Mức thưởng mới 
--bằng mức thưởng hiện tại cộng thêm 1% tổng doanh thu. Thông tin bao gồm 
--[SalesPersonID], NewBonus (thưởng mới), SumOfSubTotal. Trong đó: 
--SumOfSubTotal =sum(SubTotal) 
--NewBonus = Bonus+ sum(SubTotal)*0.01 


--5)  Viết một thủ tục dùng để xem thông tin của nhóm sản phẩm (ProductCategory) 
--có tổng số lượng (OrderQty) đặt hàng cao nhất trong một năm tùy ý (tham số
--input), thông tin gồm: ProductCategoryID, Name, SumOfQty. Dữ liệu từ bảng 
--ProductCategory, ProductSubCategory, Product và SalesOrderDetail