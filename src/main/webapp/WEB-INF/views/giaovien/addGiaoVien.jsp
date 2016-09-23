<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<spring:url value="/resources/css/bootrap.min.csss" var="boottrap" />
<spring:url value="resources/css/lopstyle.css" var="lopStyle" />
<spring:url value="/resources/font-awesome-4.1.0/css/font-awesome.css"
	var="fontStyle" />

<link href="${bootrap}" type="text/css" rel="stylesheet" />
<link href="${lopStyle}" type="text/css" rel="stylesheet" />
<link href="${fontStyle}" type="text/css" rel="stylesheet" />
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
						<form class="form-horizontal" role="form" id="add" action="/giaovien/addGV" accept-charset="UTF-8" method="POST">


							<div class="form-group">
								<label class="control-label col-sm-4" for="tenGiaoVien">Họ và tên</label>
								<div class="col-sm-8">
									<input class="form-control" placeholder="Họ và tên" type="text"  path="tenGiaovien" id="tenGiaoVien">
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-4" for="teacher_dob">Ngày sinh</label>
								<div class="col-sm-8">
									<input class="form-control datepicker" placeholder="Ngày sinh" type="text" name="teacher[dob]" id="teacher_dob">
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-4" for="teacher_address">Địa chỉ</label>
								<div class="col-sm-8">
									<input class="form-control" placeholder="Địa chỉ" type="text" name="teacher[address]" id="teacher_address">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-4" for="teacher_phone">Số điện thoại</label>
								<div class="col-sm-8">
									<input class="form-control" placeholder="Số điện thoại" type="text" name="teacher[phone]" id="teacher_phone">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-4" for="teacher_email">Email</label>
								<div class="col-sm-8">
									<input class="form-control" placeholder="Email" type="text" name="teacher[email]" id="teacher_email">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-4" for="teacher_career_year">Năm vào nghề</label>
								<div class="col-sm-8">
									<input class="form-control" placeholder="Năm vào nghề" type="number" name="teacher[career_year]" id="teacher_career_year">
								</div>
							</div>


							<div class="form-group">
								<label class="control-label col-sm-4" for="teacher_degree">Trình độ đào tạo</label>
								<div class="col-sm-8">
									<select class="form-control selectpicker bs-select-hidden" name="teacher[degree]" id="teacher_degree"><option value="">------</option>
										<option value="Cấp tốc">Cấp tốc</option>
										<option value="Sơ cấp">Sơ cấp</option>
										<option value="TH 12+2">TH 12+2</option>
										<option value="TH 9+3">TH 9+3</option>
										<option value="Trung cấp">Trung cấp</option>
										<option value="Cao đẳng">Cao đẳng</option>
										<option value="Đại học">Đại học</option>
										<option value="Thạc sĩ">Thạc sĩ</option>
										<option value="Tiến sĩ">Tiến sĩ</option>
										<option value="Tiến sĩ KH">Tiến sĩ KH</option></select><div class="btn-group bootstrap-select form-control"><button type="button" class="btn dropdown-toggle btn-default" data-toggle="dropdown" data-id="teacher_degree" title="------"><span class="filter-option pull-left">------</span>&nbsp;<span class="caret"></span></button><div class="dropdown-menu open"><ul class="dropdown-menu inner" role="menu"><li data-original-index="0" class="selected"><a tabindex="0" class="" style="" data-tokens="null"><span class="text">------</span><span class="glyphicon glyphicon-ok check-mark"></span></a></li><li data-original-index="1"><a tabindex="0" class="" style="" data-tokens="null"><span class="text">Cấp tốc</span><span class="glyphicon glyphicon-ok check-mark"></span></a></li><li data-original-index="2"><a tabindex="0" class="" style="" data-tokens="null"><span class="text">Sơ cấp</span><span class="glyphicon glyphicon-ok check-mark"></span></a></li><li data-original-index="3"><a tabindex="0" class="" style="" data-tokens="null"><span class="text">TH 12+2</span><span class="glyphicon glyphicon-ok check-mark"></span></a></li><li data-original-index="4"><a tabindex="0" class="" style="" data-tokens="null"><span class="text">TH 9+3</span><span class="glyphicon glyphicon-ok check-mark"></span></a></li><li data-original-index="5"><a tabindex="0" class="" style="" data-tokens="null"><span class="text">Trung cấp</span><span class="glyphicon glyphicon-ok check-mark"></span></a></li><li data-original-index="6"><a tabindex="0" class="" style="" data-tokens="null"><span class="text">Cao đẳng</span><span class="glyphicon glyphicon-ok check-mark"></span></a></li><li data-original-index="7"><a tabindex="0" class="" style="" data-tokens="null"><span class="text">Đại học</span><span class="glyphicon glyphicon-ok check-mark"></span></a></li><li data-original-index="8"><a tabindex="0" class="" style="" data-tokens="null"><span class="text">Thạc sĩ</span><span class="glyphicon glyphicon-ok check-mark"></span></a></li><li data-original-index="9"><a tabindex="0" class="" style="" data-tokens="null"><span class="text">Tiến sĩ</span><span class="glyphicon glyphicon-ok check-mark"></span></a></li><li data-original-index="10"><a tabindex="0" class="" style="" data-tokens="null"><span class="text">Tiến sĩ KH</span><span class="glyphicon glyphicon-ok check-mark"></span></a></li></ul></div></div>
								</div>
							</div>






							<hr>
							<div class="row no-margin">
								<div class="pull-left">
									<a class="btn btn-info" href="http://truongnha.com/school_manager/teachers">Hủy</a>
								</div>
								<div class="pull-right">
									<input type="submit" name="commit" value="Tạo mới" class="btn btn-success" id="create_teacher">
								</div>
							</div>
						</form>  </div>
				</div>

				<form id="esc_cancel" action="http://truongnha.com/school_manager/teachers" method="GET">
					<script type="text/javascript">
						$('body').keyup(function(e) {
							if (e.keyCode == 27) {$("#esc_cancel").submit();}
						});
					</script>

			</div>


		</div>


	</div>




<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>