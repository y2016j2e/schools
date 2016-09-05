<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<spring:url value="resources/css/bootstrap.min.css" var="bootstrap" />
<spring:url value="resources/css/lopstyle.css" var="lopStyle" />
<spring:url value="resources/font-awesome-4.1.0/css/font-awesome.css" var="fontStyle" />

<link href="${bootstrap}" type="text/css" rel="stylesheet" />
<link href="${lopStyle}" type="text/css" rel="stylesheet" />
<link href="${fontStyle}" type="text/css" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Lop</title>

<script src="resources/js/libs/jquery-1.9.1.js"></script>
<script src="resources/js/libs/bootstrap.min.js"></script>
</head>
<body>
<div class="wapper">
<!-- header -->
<div id="header">
	<div class="left">
    	<a href="#" class="box1" >
        	<i class="fa fa-3x fa-home"></i>
        </a>
        <div class="box2">
        	<h3>Tiểu Học Imic</h3>
        </div>
        <div class="box3 dropdown-toggle dropdown" data-toggle="dropdown">Năm học 2016 - 2017 <span class="caret"></span></div>
        <ul class="dropdown-menu position">
        	<li><a href="#">Năm học 2016 - 2017</a></li>
            <li class="divider"></li>
            <li><a href="#">Danh sách năm học</a></li>
        </ul> 
    </div>
    
    <div class="right dropdown">
    	<div class="box1 dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> username <span class="caret"></span></div>
        <ul class="dropdown-menu" style="top:65px; right:0px; left:inherit;">
        	<li><a href="#"><i class="fa fa-cog"></i> Thông tin tài khoản</a></li>
            <li class="divider"></li>
            <li><a href="#"><i class="fa fa-sign-out"></i> Đăng xuất</a></li>
        </ul> 
    </div>
    
    <div class="under"></div>
</div>

<!-- end header -->
<!-- content -->
<div id="content">
	<div class="box1">
    	<div class="text">Danh Sách Lớp Học</div>
    </div>
    <form>
    <div class="box2">
    	<div class="text">Điểm Trường : </div>
        <div class="select">
        	<select class="form-control">
            	<option>Trung Tâm</option>
                <option>Cầu Giấy</option>
                <option>Hai bà Trưng</option>
                <option>Đống Đa</option>
            </select>
        </div>
        
        <div class="text">Năm học : </div>
        <div class="select">
        	<select class="form-control">
            	<option>2016 - 2017</option>
                <option>2015 - 2016</option>
                <option>2014 - 2015</option>
                <option>2013 - 2014</option>
            </select>
        </div>
        
        <div class="text">Học Kỳ :</div>
        <div class="select">
        	<select class="form-control">
            	<option>Học Kỳ I</option>
                <option>Học Kỳ II</option>
                <option>Học Kỳ Hè</option>
            </select>
        </div>
    </div>
    
    <div class="but center"><a href="#"><button type="button" class="btn btn-success"><i class="fa fa-pencil"> Xem Danh Sách</i></button></a></div>
    </form>
    
    <div class="box3">
    <form>
    	<div class="left">
        	<ul class="pagination pagination-sm fl-l cl">
            	<li><a href="http://localhost:8081/schools/lop?row=${nrow}">«</a></li>
				<c:forEach begin="1" end="${lastpage}" var="i">
					<c:choose>
					<c:when test="${act eq i}">
						<li class="active"><a href="#">${i}</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="http://localhost:8081/schools/lop?page=${i}&row=${nrow}">${i}</a></li>
					</c:otherwise>
					</c:choose>
				</c:forEach>
                <li><a href="http://localhost:8081/schools/lop?page=${lastpage}&row=${nrow}">»</a></li>
            </ul>
     </form>  
		<form style="float:left;" id="row" action="lop">
            <div class="text">Số Dòng :</div>
            <select class="form-control fl-l autoWidth" id="srow" name="row">
            	<option value="5" >5 dòng</option>
                <option value="10">10 dòng</option>
                <option value="20">20 dòng</option></a>
            </select>
        </div>
    	</form>
    	<script>
    	document.getElementById("srow").onchange = function() {
    document.getElementById("row").submit();
};
</script>
        <div class="right">
        	<a href="#"><button type="button" class="btn btn-outline btn-success fl-r marginR"> <i class="fa fa-upload"></i> Tải lên</button></a>
            <a href="#"><button type="button" class="btn  btn-success btn-outline fl-r marginR"> <i class="fa fa-download"></i> Tải Xuống File Excel</button></a>
            <a href="#"><button type="button" class="btn btn-outline btn-success fl-r marginR"><i class="fa fa-file-pdf-o" ></i> Tải Xuống File PDF</button></a>
        </div>
    </div>
    
    <div class="box4 marginT">
    	<table class="table table-striped table-bordered" aria-describedby="dataTables-example_info">
        <tr>
        	<th class="center">STT</th>
            <th class="center">Lớp</th>
            <th class="center">Điểm Trường</th>
            <th class="center">Chủ Nhiệm</th>
            <th class="center">Sĩ Số</th>
            <th class="center">Số Tiết học / Tuần</th>
            <th><a href="#"><button type="button" class="btn btn-success cir"><i class="fa fa-plus"></i></button></a></th>
        </tr>
        
        <c:forEach var="lop" items="${lis}" varStatus="indexes">
        <tr>
        	<td class="center">${lop.makhoahoc}</td>
            <td class="center">${lop.lop.tenlop}</td>
            <td class="center">${lop.lop.diemtruong.tendiemtruong}</td>
            <td class="center">${lop.chunhiem.ten}</td>
            <td class="center">0</td>
            <td class="center">${lop.lop.sotiethoc}</td>
            <td class="center"><a href="#"><button type="button" class="btn btn-info cir"><i class="fa fa-pencil"></i></button></a> <button type="button" class="btn btn-danger btn-del cir" onclick="fun('${lop.makhoahoc}','${lop.lop.tenlop}')"><i class="fa fa-trash-o"></i></button></td>
        </tr>
        </c:forEach>
        </table>
    </div>
  
</div>

<!-- end content -->




</div>
<div class="deleteClass"></div>
<form>
<div class="deleteBox delete">
	<div class="quest delete"><b id="del"></b></div>
    <hr class="divider delete" style="margin-top:10px;" />
    <div class="deleteBut delete">
    	<a href="" id="aaa"><button type="button" class="btn btn-info" onclick="delLop()"><i class="fa fa-trash-o"> Xóa</i></button></a>
        <button type="button" class="btn btn-default btn-can"><i class="fa fa-ban"> Hủy</i></button>
    </div>
</div>
</form>
<!-- <script src="resources/js/libs/jquery-1.9.1.js"></script> -->
<!-- <script src="resources/js/libs/bootstrap.min.js"></script> -->
<script>
$(document).ready(function(){
    $(".btn-del").click(function(){
        $(".deleteClass").fadeToggle("slow");
		$(".delete").fadeToggle("1000");
    });
});

$(document).ready(function(){
    $(".btn-can").click(function(){
        $(".deleteClass").fadeToggle("slow");
		$(".delete").fadeToggle("1000");
    });
});

var maso;
var link;
function fun(id,lop){
	var x = "Bạn có chắc chắn muốn xóa lớp " +lop+ " ?"
	document.getElementById("del").innerHTML = x;
	maso = id;
	var l = "http://localhost:8081/schools/lop/delete/"+id;
	link = l;
}		

function delLop(){
	document.getElementById("aaa").setAttribute("href",link);
}

</script>
</body>
</html>