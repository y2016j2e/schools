<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Phân Công</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="clear"></div>
	<div id="content">
		<div id="phancong">
			<div class="container">
				<div class="row">
					<h3 style="text-align: center;">Phân Công Giảng Dạy 2010-2011</h3>
					<div class="phantrang">
						<ul class="pagination">
							<li class="active"><a href="#">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
						</ul>
						<div class="clear"></div>
						<div class="sodong_tai">
							<div class="col-sm-6">
								<div class="dropdown">
									<button class="btn btn-default dropdown-toggle" type="button"
										id="menu1" data-toggle="dropdown">
										Số Dòng<span class="caret"></span>
									</button>
									<ul class="dropdown-menu">
										<li><a href="#">10 dòng</a></li>
										<li><a href="#">15 dòng</a></li>
										<li><a href="#">20 dòng</a></li>
									</ul>
								</div>
							</div>
							<div class="col-sm-6"></div>
						</div>
					</div>
					<table class="table table-bordered table-hover table-condensed">
						<thead>
							<tr class="active">
								<th>STT</th>
								<th>Họ Tên</th>
								<th>Chủ Nhiệm</th>
								<c:forEach items="${monHocs}" var="monHoc">
									<th>${monHoc.tenmonhoc}</th>
								</c:forEach>
								<td>Action</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${giaoViens}" var="giaoVien" varStatus="s">
								<tr>
									<td>${s.count}</td>
									<td>${giaoVien.ten}</td>
									<td><c:forEach items="${giaoVien.khoahoc}" var="khoaHoc">
											<c:if test="${khoaHoc.namhoc.manamhoc==1}">
												${khoaHoc.lop.tenlop}-${khoaHoc.lop.diemtruong.tendiemtruong}
											</c:if>
										</c:forEach></td>
									<c:forEach items="${monHocs}" var="monHoc">
										<td><c:forEach items="${giaoVien.giangday}"
												var="giangDay">
												<c:if test="${giangDay.monhoc.mamonhoc == monHoc.mamonhoc}">
													<c:if test="${giangDay.khoahoc.namhoc.manamhoc==1}">
														${giangDay.khoahoc.lop.tenlop}
													</c:if>
												</c:if>
											</c:forEach></td>
									</c:forEach>
									<td><spring:url
											value="/phancong/${giaoVien.magiaovien}/update" var="edGV"></spring:url>
										<a href="${edGV}" class="btn btn-xs btn-primary"
										title="Phân Công Giáo Viên"> <span class="fa fa-pencil"></span>
									</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>