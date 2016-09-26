<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">

    <title>Thêm Giáo Viên</title>

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div id="content">
    <div class="editGiaoVien">
        <h2 style="text-align: center;">Cập Nhật Thông Tin Giáo Viên </h2>

        <div class="container">
            <div class="row">
                <div class="col-md-6 col-md-offset-3 well form-small">

                    <form:form modelAttribute="giaovien" class="form-horizontal" role="form" id="updateGV"
                               action="/schools/giaovien/update" accept-charset="UTF-8" method="POST">


                    <div class="form-group">
                        <label class="control-label col-sm-4" for="tengv">Họ và tên</label>

                        <div class="col-sm-8">
                            <form:input class="form-control" placeholder="Họ tên" type="text" value="${giaovien.ten}"
                                        path="ten" id="tengv"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-4" for="ngaysinh">Ngày sinh</label>

                        <div class="col-sm-8">
                            <form:input class="form-control datepicker" placeholder="Ngày sinh"
                                        value="${giaoVien.ngaysinh}" type="text" path="ngaysinh" id="ngaysinh"/>
                        </div>
                    </div>


                    <div class="form-group">
                        <label class="control-label col-sm-4" for="diachi">Địa chỉ</label>

                        <div class="col-sm-8">
                            <form:input class="form-control" placeholder="Địa chỉ" type="text"
                                        value="${giaoVien.diachi}" path="diachi" id="diachi"/>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="quequan">Quê quán</label>

                            <div class="col-sm-8">
                                <form:input class="form-control" placeholder="Địa chỉ" type="text"
                                            value="${giaoVien.quequan}" path="quequan" id="quequan"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="sdt">Số điện thoại</label>

                            <div class="col-sm-8">
                                <form:input class="form-control" placeholder="Số điện thoại" type="text"
                                            value="${giaoVien.sdt}" path="sdt" id="sdt"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="email">Email</label>

                            <div class="col-sm-8">
                                <form:input class="form-control" placeholder="Email" type="text"
                                            value="${giaoVien.email}" path="email" id="email"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="namvaonghe">Năm vào nghề</label>

                            <div class="col-sm-8">
                                <form:input class="form-control" placeholder="Năm vào nghề" type="number" value="${giaoVien.namvaonghe}"
                                      path="namvaonghe" id="namvaonghe"/>
                            </div>
                        </div>


                        <div class="form-group">
                            <label class="control-label col-sm-4" for="trinhdo">Trình độ đào tạo</label>

                            <div class="col-sm-8" id="select_degree">
                                <form:select class="form-control selectpicker bs-select-hidden" path="${giaoVien.namvaonghe}"
                                        id="trinhdo">
                                    <option value="">------</option>
                                    <option value="Cấp tốc">Cấp tốc</option>
                                    <option value="Sơ cấp">Sơ cấp</option>
                                    <option value="TH 12+2">TH 12+2</option>
                                    <option value="TH 9+3">TH 9+3</option>
                                    <option value="Trung cấp">Trung cấp</option>
                                    <option selected="selected" value="Cao đẳng">Cao đẳng</option>
                                    <option value="Đại học">Đại học</option>
                                    <option value="Thạc sĩ">Thạc sĩ</option>
                                    <option value="Tiến sĩ">Tiến sĩ</option>
                                    <option value="Tiến sĩ KH">Tiến sĩ KH</option>
                                </form:select>

                                <div class="btn-group bootstrap-select form-control">
                                    <button type="button" class="btn dropdown-toggle btn-default" data-toggle="dropdown"
                                            data-id="teacher_degree" title="Cao đẳng"><span
                                            class="filter-option pull-left">Cao đẳng</span>&nbsp;<span
                                            class="caret"></span></button>
                                    <div class="dropdown-menu open">
                                        <ul class="dropdown-menu inner" role="menu">
                                            <li data-original-index="0"><a tabindex="0" class="" style=""
                                                                           data-tokens="null"><span
                                                    class="text">------</span><span
                                                    class="glyphicon glyphicon-ok check-mark"></span></a></li>
                                            <li data-original-index="1"><a tabindex="0" class="" style=""
                                                                           data-tokens="null"><span
                                                    class="text">Cấp tốc</span><span
                                                    class="glyphicon glyphicon-ok check-mark"></span></a></li>
                                            <li data-original-index="2"><a tabindex="0" class="" style=""
                                                                           data-tokens="null"><span
                                                    class="text">Sơ cấp</span><span
                                                    class="glyphicon glyphicon-ok check-mark"></span></a></li>
                                            <li data-original-index="3"><a tabindex="0" class="" style=""
                                                                           data-tokens="null"><span
                                                    class="text">TH 12+2</span><span
                                                    class="glyphicon glyphicon-ok check-mark"></span></a></li>
                                            <li data-original-index="4"><a tabindex="0" class="" style=""
                                                                           data-tokens="null"><span
                                                    class="text">TH 9+3</span><span
                                                    class="glyphicon glyphicon-ok check-mark"></span></a></li>
                                            <li data-original-index="5"><a tabindex="0" class="" style=""
                                                                           data-tokens="null"><span class="text">Trung cấp</span><span
                                                    class="glyphicon glyphicon-ok check-mark"></span></a></li>
                                            <li data-original-index="6" class="selected"><a tabindex="0" class=""
                                                                                            style="" data-tokens="null"><span
                                                    class="text">Cao đẳng</span><span
                                                    class="glyphicon glyphicon-ok check-mark"></span></a></li>
                                            <li data-original-index="7"><a tabindex="0" class="" style=""
                                                                           data-tokens="null"><span
                                                    class="text">Đại học</span><span
                                                    class="glyphicon glyphicon-ok check-mark"></span></a></li>
                                            <li data-original-index="8"><a tabindex="0" class="" style=""
                                                                           data-tokens="null"><span
                                                    class="text">Thạc sĩ</span><span
                                                    class="glyphicon glyphicon-ok check-mark"></span></a></li>
                                            <li data-original-index="9"><a tabindex="0" class="" style=""
                                                                           data-tokens="null"><span
                                                    class="text">Tiến sĩ</span><span
                                                    class="glyphicon glyphicon-ok check-mark"></span></a></li>
                                            <li data-original-index="10"><a tabindex="0" class="" style=""
                                                                            data-tokens="null"><span class="text">Tiến sĩ KH</span><span
                                                    class="glyphicon glyphicon-ok check-mark"></span></a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <hr>
                        <div class="row no-margin">
                            <div class="pull-left">
                                <a class="btn btn-info	item btn-lg" href="../giaovien">Hủy</a>
                            </div>
                            <div class="pull-right">
                              <button type="button"  class="btn btn-success btn-block btn-md "  onclick="document.getElementById('updateGV').submit();">Cập nhật</button>
                            </div>
                        </div>
                        </form:form>  </div>
                </div>

                <form id="esc_cancel" action="../giaovien" method="GET">
                    <script type="text/javascript">
                        $('body').keyup(function (e) {
                            if (e.keyCode == 27) {
                                $("#esc_cancel").submit();
                            }
                        });
                    </script>
                </form>
            </div>


        </div>


    </div>


    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>