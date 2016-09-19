<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<spring:url value="resources/css/bootstrap.min.css" var="bootstrap" />
<spring:url value="resources/css/lopstyle.css" var="lopStyle" />
<spring:url value="resources/font-awesome-4.1.0/css/font-awesome.css"
	var="fontStyle" />

<link href="${bootstrap}" type="text/css" rel="stylesheet" />
<link href="${lopStyle}" type="text/css" rel="stylesheet" />
<link href="${fontStyle}" type="text/css" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Cosovatchat</title>

<script src="resources/js/libs/jquery-1.9.1.js"></script>
<script src="resources/js/libs/bootstrap.min.js"></script>
</head>
<body>
	<div class="wapper">
		<!-- header -->
		<div id="header">
			<div class="left">
				<a href="#" class="box1"> <i class="fa fa-3x fa-home"></i>
				</a>
				<div class="box2">
					<h3>Tiểu Học Imic</h3>
				</div>
				<div class="box3 dropdown-toggle dropdown" data-toggle="dropdown">
					Năm học 2016 - 2017 <span class="caret"></span>
				</div>
				<ul class="dropdown-menu position">
					<li><a href="#">Năm học 2016 - 2017</a></li>
					<li class="divider"></li>
					<li><a href="#">Danh sách năm học</a></li>
				</ul>
			</div>

			<div class="right dropdown">
				<div class="box1 dropdown-toggle" data-toggle="dropdown">
					<i class="fa fa-user"></i> username <span class="caret"></span>
				</div>
				<ul class="dropdown-menu"
					style="top: 65px; right: 0px; left: inherit;">
					<li><a href="#"><i class="fa fa-cog"></i> Thông tin tài
							khoản</a></li>
					<li class="divider"></li>
					<li><a href="#"><i class="fa fa-sign-out"></i> Đăng xuất</a></li>
				</ul>
			</div>

			<div class="under"></div>
		</div>

		<div class="content">
			<div class="main">
				<%-- <table class="table table-striped table-bordered" aria-describedby="dataTables-exemple_info">
			<c:forEach var="diemtruong" items="${listdt}" varStatus="indexes">
			<tr>
				<th class="center">${diemtruong.tendiemtruong}</th>
				<th class="center">${diemtruong.madiemtruong } </th>
				<th class="center">${diemtruong.email } </th>
			</tr>
			</c:forEach>
		
		</table> --%>
				<ul class="tab">
					<li><a href="#" class="tablinks"
						onclick="openCity(event, 'London')">London</a></li>
					<li><a href="#" class="tablinks"
						onclick="openCity(event, 'Paris')">Paris</a></li>
					<li><a href="#" class="tablinks"
						onclick="openCity(event, 'Tokyo')">Tokyo</a></li>
				</ul>

				<div id="London" class="tabcontent">
					<h3>London</h3>
					<p>London is the capital city of England.</p>
				</div>

				<div id="Paris" class="tabcontent">
					<h3>Paris</h3>
					<p>Paris is the capital of France.</p>
				</div>

				<div id="Tokyo" class="tabcontent">
					<h3>Tokyo</h3>
					<p>Tokyo is the capital of Japan.</p>
				</div>
			</div>
			<%-- <form:form action="cosovatchat" id="xem"  method="GET">
				<div class="center">

					<form:select class="form-control" path="diemtruong">
						<form:options items="${listdt}" />
					</form:select>
					<div class="select">
					<form:select class="form-control" path="namhoc">
						<form:options items="${listnh}" />
					</form:select>
					</div>

				</div>
				<div class="but center"><button type="button" class="btn btn-success" onclick="document.getElementById('xem').submit();"><i class="fa fa-pencil"> Xem Danh Sách</i></input></div>
			</form:form> --%>
		</div>
	</div>
	<script>
	function openCity(evt, cityName) {
	    // Declare all variables
	    var i, tabcontent, tablinks;

	    // Get all elements with class="tabcontent" and hide them
	    tabcontent = document.getElementsByClassName("tabcontent");
	    for (i = 0; i < tabcontent.length; i++) {
	        tabcontent[i].style.display = "none";
	    }

	    // Get all elements with class="tablinks" and remove the class "active"
	    tablinks = document.getElementsByClassName("tablinks");
	    for (i = 0; i < tablinks.length; i++) {
	        tablinks[i].className = tablinks[i].className.replace(" active", "");
	    }

	    // Show the current tab, and add an "active" class to the link that opened the tab
	    document.getElementById(cityName).style.display = "block";
	    evt.currentTarget.className += " active";
	}
	</script>
</body>
</html>