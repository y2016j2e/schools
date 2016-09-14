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
		<div id="phancong_update">
			<h2 style="text-align: center;">${giaoVien.ten}-PhânCôngGiảng
				Dạy - ${giaoVien.khoahoc[0].namhoc.thoigian}</h2>
			<div class="container">
				<div class="row">
					<div class="col-sm-12">
						<spring:url value="/phancong/confirmUpdate" var="confirmUpdate"></spring:url>
						<s:form modelAttribute="giaoVien" method="POST" id="form_update"
							class="form-horizontal" action="${confirmUpdate}">
							<s:hidden readonly="true" path="magiaovien" />
							<div class="panel panel-default form_update">
								<div class="panel-heading">
									<div class="form-group">
										<label class="control-label col-sm-3">Chủ Nhiệm</label>
										<div class="col-sm-9">
											<select name="khoahoc[0].makhoahoc"
												class="selectpicker form-control" data-live-search="true"
												title="Mời Bạn Chọn Lớp!">
												<c:forEach items="${khoaHocs}" var="khoaHoc" varStatus="s">
													<c:choose>
														<c:when
															test="${giaoVien.khoahoc[0].makhoahoc==khoaHoc.makhoahoc}">
															<option selected="selected" value="${khoaHoc.makhoahoc}">
																${khoaHoc.lop.tenlop} -
																${khoaHoc.lop.diemtruong.tendiemtruong} - Mã Khóa học:
																${khoaHoc.makhoahoc}</option>
														</c:when>
														<c:otherwise>
															<option value="${khoaHoc.makhoahoc}">
																${khoaHoc.lop.tenlop} -
																${khoaHoc.lop.diemtruong.tendiemtruong} - Mã Khóa học:
																${khoaHoc.makhoahoc}</option>
														</c:otherwise>
													</c:choose>
												</c:forEach>
											</select>
										</div>
									</div>
								</div>
								<div class="panel-body">
									<div class="col-sm-6">
										<span>Lớp</span>
									</div>
									<div class="col-sm-6">
										<span>MônHoc</span>
									</div>
									<div class="clear"></div>
									<div id="phancong-box">
										<c:forEach items="${giaoVien.giangday}" var="giangDay"
											varStatus="s">
											<input type="hidden" name="giangday[${s.index}].magiangday"
												value="${giangDay.magiangday}" class="giangDay${s.index}" />
											<div style="float: left; width: 90%; margin-top: 10px;" class="giangDay${s.index}">
												<div class="col-sm-6">
													<select name="giangday[${s.index}].khoahoc.makhoahoc"
														class="selectpicker form-control khoahoc-selector"
														data-live-search="true" title="Mời Bạn Chọn Lớp!">
														<c:forEach items="${khoaHocs}" var="khoaHoc">
															<c:choose>
																<c:when
																	test="${giangDay.khoahoc.makhoahoc==khoaHoc.makhoahoc}">
																	<option selected="selected"
																		value="${khoaHoc.makhoahoc}">
																		${khoaHoc.lop.tenlop} - Mã Khóa học:
																		${khoaHoc.makhoahoc}</option>
																</c:when>
																<c:otherwise>
																	<option value="${khoaHoc.makhoahoc}">
																		${khoaHoc.lop.tenlop} - Mã Khóa học:
																		${khoaHoc.makhoahoc}</option>
																</c:otherwise>
															</c:choose>
														</c:forEach>
													</select>
												</div>
												<div class="col-sm-6">
													<select name="giangday[${s.index}].monhoc.mamonhoc"
														class="selectpicker form-control" data-live-search="true"
														title="Mời Bạn Chọn Môn Học!">
														<c:forEach items="${monHocs}" var="monHoc">
															<c:choose>
																<c:when
																	test="${giangDay.monhoc.mamonhoc==monHoc.mamonhoc}">
																	<option selected="selected" value="${monHoc.mamonhoc}">${monHoc.tenmonhoc}(
																		ma:${monHoc.mamonhoc})</option>
																</c:when>
																<c:otherwise>
																	<option value="${monHoc.mamonhoc}">${monHoc.tenmonhoc}(ma:${monHoc.mamonhoc})</option>
																</c:otherwise>
															</c:choose>
														</c:forEach>
													</select>
												</div>
											</div>

											<button type="button"
												style="float: right; margin-top: 15px; margin-right: 10px;"
												onclick="xoa(${s.index})"
												class="btn btn-sm btn-danger fa fa-times giangDay${s.index}">
											</button>
											<div class="clear"></div>
										</c:forEach>
									</div>
									<button type="button" onclick="them()"
										style="float: right; margin: 20px; margin-right: 10px"
										class="btn btn-sm btn-success fa fa-plus"></button>
								</div>
								<div class="panel-footer">
									<div class="form-group">
										<div class="col-sm-3">
											<input type="submit" value="Update" class="btn btn-success" />
										</div>
									</div>
								</div>
							</div>
						</s:form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	<script type="text/javascript">
		var gSize = parseInt('${giaoVien.giangday.size()}');
		var danhSachLop = [];
		function them(){
			gSize++;
			
			var str = "";
			str = str+"<div style=\"float: left; width: 90%; margin-top: 10px;\" class=\"giangDay"+gSize+"\">";
			str=str+"<div class=\"col-sm-6\">";
			str=str+"<select id='slectpicker_khoahoc" + gSize +"' name=\"giangday["+gSize+"].khoahoc.makhoahoc\" class=\"selectpicker form-control\" data-live-search=\"true\" title=\"Mời Bạn Chọn Lớp!\">";
			<c:forEach items="${khoaHocs}" var="khoaHoc">
				str += '<option value="${khoaHoc.makhoahoc}">${khoaHoc.lop.tenlop} - Mã Khóa học:${khoaHoc.makhoahoc}</option>';
			</c:forEach>
			str = str+"";
			str = str+"</select></div>";
			str = str+"<div class=\"col-sm-6\">";
			str = str+"<select id='slectpicker_monhoc" + gSize +"' name=\"giangday["+gSize+"].monhoc.mamonhoc\"class=\"selectpicker form-control\" data-live-search=\"true\"title=\"Mời Bạn Chọn Môn Học!\">";
			<c:forEach items="${monHocs}" var="monHoc">
				str += '<option value="${monHoc.mamonhoc}">${monHoc.tenmonhoc}(ma:${monHoc.mamonhoc})</option>';
			</c:forEach>
			str = str+"	</select></div>";
			str=str+"</div>";
			str=str+'<button type="button" style="float: right; margin-top: 15px; margin-right: 10px;" onclick="xoa(${s.index})" class="btn btn-sm btn-danger fa fa-times giangDay${s.index}"></button>';
			$("#phancong-box").append($.parseHTML(str));
			$('#slectpicker_khoahoc'+gSize).selectpicker('refresh');
			$('#slectpicker_khoahoc'+gSize).selectpicker('render');
			
			$('#slectpicker_monhoc'+gSize).selectpicker('refresh');
			$('#slectpicker_monhoc'+gSize).selectpicker('render');
		};
		
		function xoa(index) {
			$(".giangDay"+index).remove();
		}
		function changeGiangDay(ma){
			alert($(".giangDayKhoaHoc"+ma+":selected").val());
		}
		function add() {
			var html = '';
			$('#phancong-box');
			
		};
		
		$(document).ready(function(){
			$('.khoahoc-selector').on('change', function(){
				var self = $(this);
				var selectors = $('#phancong-box select.khoahoc-selector');
				$.each(selectors, function(index, item){
					var selfName = self.prop('name');
					var itemName = $(item).prop('name');
					if(!(selfName == itemName) && $(item).val() == self.val()) {
						console.log('trung');
					}
				});
				console.log($(this).val());
			});
		});
	</script>
</body>
</html>