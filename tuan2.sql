--1)  Liệt kê danh sách các hóa đơn (SalesOrderID) lập trong tháng  6  năm 2008  có 
--tổng tiền > 70000, thông tin gồm SalesOrderID, Orderdate,  SubTotal,  trong đó 
----SubTotal  =SUM(OrderQty*UnitPrice).
select s.SalesOrderID, OrderDate, SubTotal  = SUM(OrderQty*UnitPrice)
from [Sales].[SalesOrderDetail] s join [Sales].[SalesOrderHeader] h 
on s.SalesOrderID = h.SalesOrderID 
where year(OrderDate) = 2008 and month(OrderDate) = 6 and SubTotal > 70000
group by  s.SalesOrderID, OrderDate

--2)  Đếm tổng số khách hàng và tổng tiền của những khách hàng thuộc các quốc gia 
--có  mã  vùng  là  US  (lấy  thông  tin  từ  các  bảng  Sales.SalesTerritory, 
--Sales.Customer,  Sales.SalesOrderHeader,  Sales.SalesOrderDetail).  Thông  tin 
--bao  gồm  TerritoryID,  tổng  số  khách  hàng  (CountOfCust),  tổng  tiền 
--(SubTotal) với  SubTotal = SUM(OrderQty*UnitPrice)
select t.TerritoryID, sum(c.CustomerID) as CountOfCust, SubTotal = SUM(OrderQty*UnitPrice)
from [Sales].[SalesOrderDetail] s join [Sales].[SalesOrderHeader] h 
on s.SalesOrderID = h.SalesOrderID 
join [Sales].[Customer] c on h.CustomerID = c.CustomerID
join [Sales].[SalesTerritory] t on t.TerritoryID = c.TerritoryID 
group by  t.TerritoryID

--3)  Tính  tổng  trị  giá  của  những  hóa  đơn  với  Mã  theo  dõi  giao  hàng
--(CarrierTrackingNumber)  có  3  ký  tự  đầu  là  4BD,  thông  tin  bao  gồm 
--SalesOrderID, CarrierTrackingNumber,  SubTotal=SUM(OrderQty*UnitPrice)
select SalesOrderID, CarrierTrackingNumber,  SubTotal = SUM(OrderQty*UnitPrice)
from [Sales].[SalesOrderDetail] 
where CarrierTrackingNumber like '%4BD%'
group by SalesOrderID, CarrierTrackingNumber

--4)  Liệt  kê  các  sản  phẩm  (Product)  có  đơn  giá  (UnitPrice)<25  và  số  lượng  bán 
--trung bình >5, thông tin gồm ProductID, Name,  AverageOfQty.
select p.ProductID, p.Name,  AverageOfQty = avg(od.UnitPrice)
from [Production].[Product] p join [Sales].[SalesOrderDetail] od
on p.ProductID = od.ProductID
where od.UnitPrice < 25  
group by p.ProductID, p.Name
having avg(od.UnitPrice) > 5

--5)  Liệt kê các công việc (JobTitle) có tổng số nhân viên >20 người, thông tin gồm 
--JobTitle,  CountOfPerson=Count(*)
select JobTitle,  CountOfPerson=Count(*)
from [HumanResources].[Employee] e join [Person].[Person] p
on e.BusinessEntityID = p.BusinessEntityID
group by JobTitle
having Count(*) > 20

--6)  Tính tổng số lượng và tổng trị giá của các sản phẩm do các nhà cung cấp có tên 
--kết  thúc  bằng  ‘Bicycles’  và  tổng  trị  giá  >  800000,  thông  tin  gồm 
--BusinessEntityID, Vendor_Name, ProductID, SumOfQty,  SubTotal
--(sử dụng các bảng [Purchasing].[Vendor] , [Purchasing].[PurchaseOrderHeader] và 
--[Purchasing].[PurchaseOrderDetail])
select v.BusinessEntityID, v.Name, pv.ProductID, SumOfQty = sum(pod.OrderQty),  SubTotal = SUM(OrderQty*UnitPrice)
from [Purchasing].[PurchaseOrderHeader] poh join [Purchasing].[PurchaseOrderDetail] pod
on poh.PurchaseOrderID = pod.PurchaseOrderID 
join [Purchasing].[ProductVendor] pv on pod.ProductID = pv.ProductID
join [Purchasing].[Vendor] v on pv.BusinessEntityID = v.BusinessEntityID
where Name like '%Bicycles%'
group by v.BusinessEntityID, v.Name, pv.ProductID
having SUM(OrderQty*UnitPrice) > 80000

--7)  Liệt kê các sản phẩm có trên 500 đơn đặt hàng trong quí 1 năm 2008 và có tổng 
--trị giá >10000, thông tin gồm ProductID, Product_Name, CountOfOrderID và 
--SubTotal
select *
from [Production].[Product]
select p.ProductID, Name, CountOfOrderID = Count(*), SubTotal = SUM(OrderQty*UnitPrice)
from [Production].[Product] p join [Sales].[SalesOrderDetail] d
on p.ProductID = d.ProductID 
join [Sales].[SalesOrderHeader] h on d.SalesOrderID = h.SalesPersonID
where h.OrderDate between '2008-01-01' and '2008-03-31' 
group by p.ProductID, Name
having Count(*) > 500 and SUM(OrderQty*UnitPrice) > 10000

--8)  Liệt kê danh sách các khách hàng có trên 25 hóa đơn đặt hàng từ năm 2007 đến 
--2008, thông tin gồm mã khách (PersonID) , họ tên (FirstName +'   '+ LastName 
--as FullName), Số hóa đơn  (CountOfOrders).


--9)  Liệt kê những sản phẩm có tên bắt đầu với ‘Bike’ và ‘Sport’ có tổng số lượng 
--bán  trong  mỗi  năm  trên  500  sản  phẩm,  thông  tin  gồm  ProductID,  Name, 
--CountOfOrderQty,  Year.  (Dữ  liệu  lấy  từ  các  bảng  Sales.SalesOrderHeader, 
--Sales.SalesOrderDetail  và Production.Product)

--10)  Liệt kê những phòng ban có lương (Rate: lương theo giờ) trung bình >30, thông 
--tin  gồm  Mã  phòng  ban  (DepartmentID),  tên  phòng  ban  (Name),  Lương  trung
--bình (AvgofRate).  Dữ  liệu  từ  các  bảng
--[HumanResources].[Department], 
--[HumanResources].[EmployeeDepartmentHistory], 
--[HumanResources].[EmployeePayHistory].
select d.DepartmentID, d.Name, avg(rate) as AvgofRate
from [HumanResources].[Department] d join [HumanResources].[EmployeeDepartmentHistory] h 
on d.DepartmentID = h.DepartmentID join [HumanResources].[EmployeePayHistory] p
on p.BusinessEntityID = h.BusinessEntityID
group by d.DepartmentID, d.Name