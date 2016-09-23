<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<spring:url value="/resources/css/bootrap.min.csss" var="boottrap" />
<spring:url value="resources/css/lopstyle.css" var="lopStyle" />
<spring:url value="/resources/font-awesome-4.1.0/css/font-awesome.css"
	var="fontStyle" />

<link href="${bootrap}" type="text/css" rel="stylesheet" />
<link href="${lopStyle}" type="text/css" rel="stylesheet" />
<script src="/schools/resources/js/libs/bootstrap.min.js"></script>
<script src="/schools/resources/js/libs/jquery-1.9.1.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Thêm Giáo Viên</title>
</head>

<body>
<jsp:include page="header.jsp"></jsp:include>
	<div id="content">
		<div class="addGiaoVien">
			<h2 style="text-align: center;">Thêm Giáo Viên</h2>
			<div class="container">
				<div class="row">
					<div class="col-md-6 col-md-offset-3 well form-small">
						<form:form	modelAttribute="giaovien" class="form-horizontal" role="form" id="add" action="/giaovien/addGV" accept-charset="UTF-8" method="POST" >


							<div class="form-group">
								<label class="control-label col-sm-4" for="ten">Họ và Tên</label>
								<div class="col-sm-8">
									<form:input class="form-control" placeholder="Họ và tên" type="text"  path="ten" id="ten"/>
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-4" for="ngaysinh">Ngày sinh</label>
								<div class="col-sm-8">
									<form:input class="form-control datepicker" placeholder="Ngày sinh" type="text" path="ngaysinh" id="ngaysinh"/>
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-4" for="diachi">Địa chỉ</label>
								<div class="col-sm-8">
									<form:input class="form-control" placeholder="Địa chỉ" type="text" path="diachi" id="diachi"/>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-4" for="quenquan">Quê quán</label>
								<div class="col-sm-8">
									<form:input class="form-control" placeholder="Địa chỉ" type="text" path="quequan" id="quenquan"/>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-4" for="email">Email</label>
								<div class="col-sm-8">
									<form:input class="form-control" placeholder="Email" type="text" path="email" id="email"/>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-4" for="sdt">Số điện thoại</label>
								<div class="col-sm-8">
									<form:input class="form-control" placeholder="Số điện thoại" type="text" path="sdt" id="sdt"/>
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-4" for="sdt">Năm vào nghề</label>
								<div class="col-sm-8">
									<form:input class="form-control" placeholder="Năm vào nghề" type="sdt" path="namvaonghe" id="sdt"/>
								</div>
							</div>


							<div class="form-group">
								<label class="control-label col-sm-4" for="trinhdo">Trình độ đào tạo</label>
								<div class="col-sm-8">
									<select class="form-control selectpicker bs-select-hidden" patch="trinhdo" id="trinhdo"><option value="">------</option>
										<option value="Cấp tốc">Cấp tốc</option>
										<option value="Sơ cấp">Sơ cấp</option>
										<option value="TH 12+2">TH 12+2</option>
										<option value="TH 9+3">TH 9+3</option>
										<option value="Trung cấp">Trung cấp</option>
										<option value="Cao đẳng">Cao đẳng</option>
										<option value="Đại học">Đại học</option>
										<option value="Thạc sĩ">Thạc sĩ</option>
										<option value="Tiến sĩ">Tiến sĩ</option></select>
								</div>
							</div>






							<hr>
							<div class="row no-margin">
								<div class="pull-left">
									<a class="btn btn-info" href="/shools/giaovien">Hủy</a>
								</div>
								<div class="pull-right">
									<input type="submit" name="commit" value="Tạo mới" class="btn btn-success" id="newGiaoVien"/>
								</div>
							</div>
						</form:form>  </div>
				</div>

				<form id="esc_cancel" action="/shools/giaovien" method="GET">
					<script type="text/javascript">
						$('body').keyup(function(e) {
							if (e.keyCode == 27) {$("#esc_cancel").submit();}
						});
					</script>
				</form>
			</div>


		</div>


	</div>




<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>