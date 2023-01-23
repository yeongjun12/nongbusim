<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<style>
	.form-group{
		width: 30%;
	}
	#form-div{
		padding-left:25%;
	}
</style>
<body>
<!-- 메뉴바 -->
<jsp:include page="myPageFarmerCommon.jsp"/>
	<h3>회원정보 수정</h3>
    <form action="updateFarmer.me" id="form-div" method="post">
    <input type="hidden" name="memId" value="${ loginUser.memId }">
    
      <h4>기본정보</h4>
		<div class="form-group">
          <label for="name">* 성명 :</label>
          <input type="text" class="form-control" name="name" value="${ sessionScope.loginUser.name }">
        </div>
        <div class="form-group">
            <label for="pwd">* 비밀번호 :</label>
            <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#updatePwd">비밀번호 변경</button>
        </div>
        <div class="form-group">
            <label for="email">이메일 :</label>
            <input type="email" class="form-control" name="email" value="${ sessionScope.loginUser.email }">
        </div>
        <div class="form-group">
            <label for="nickName">닉네임 :</label>
            <input type="text" class="form-control" name="nickName" value="${ sessionScope.loginUser.nickName }">
        </div>
       <div class="form-group">
          <label for="phone">전화번호  :</label>
          <input type="text" class="form-control" value="${ sessionScope.loginUser.phone }" name="phone">
       </div>
	
      <h4>영농정보</h4>
      <hr>
      <div class="form-group">
        <label for="farmerCode">* 농부코드 :</label>
        <input type="text" class="form-control" value="${ sessionScope.loginUser.farmerCode }" name="farmerCode" readonly>
      </div>
      <div class="form-group">
        <label for="career">* 영농경력  :</label>
        <input type="date" class="form-control" value="${ sessionScope.loginUser.career }" name="career">
      </div>
        <button type="submit" class="btn btn-success">수정하기</button>
        <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteForm">회원탈퇴</button>
      </form>
      
      <!-- 비밀번호 변경 시 보여지는 Modal -->
      <div class="modal fade" id="updatePwd">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">

                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">비밀번호 변경</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>

                <form action="updatePwd.me" method="post">
                    <!-- Modal body -->
                    <div class="modal-body">
                        <div align="center">
                        </div>
                        <br>
                            <label for="userPwd" class="mr-sm-2">현재 비밀번호 : </label>
                            <input type="password" class="form-control mb-2 mr-sm-2" placeholder="비밀번호를 입력하세요" id="memPwd" name="memPwd"> <br>
                            <label for="userPwd" class="mr-sm-2">새 비밀번호 : </label>
                            <input type="password" class="form-control mb-2 mr-sm-2" placeholder="비밀번호는 6~18자리의 영문, 숫자를 혼합해야 합니다." id="updatePwd" name="updatePwd" onchange="check_pwd();"> <br>
                            <label for="userPwd" class="mr-sm-2">새 비밀번호 확인 : </label>
                            <input type="password" class="form-control mb-2 mr-sm-2" placeholder="비밀번호는 6~18자리의 영문, 숫자를 혼합해야 합니다." id="updatePwdChk" name="updatePwdChk" onchange="check_pwd();"> <br>
                            <input type="hidden" name="memNo" value="${ loginUser.memNo }">
                            <div class="mr-sm-2" id="checkPwdResult"></div>
                    </div>
                    <!-- Modal footer -->
                    <div class="modal-footer" align="center">
                        <button type="submit" class="btn btn-danger" onclick="return validate()">변경하기</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
      
      <!-- 회원탈퇴 버튼 클릭 시 보여질 Modal -->
    <div class="modal fade" id="deleteForm">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">

                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">회원탈퇴</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>

                <form action="deleteFarmer.me" method="post">
                    <!-- Modal body -->
                    <div class="modal-body">
                        <div align="center">
			                            탈퇴 후 복구가 불가능합니다. <br>
			                            정말로 탈퇴 하시겠습니까? <br>
                        </div>
                        <br>
                            <label for="userPwd" class="mr-sm-2">Password : </label>
                            <input type="password" class="form-control mb-2 mr-sm-2" placeholder="비밀번호를 입력하세요" id="memPwd" name="memPwd"> <br>
                            <input type="hidden" name="memId" value="${ loginUser.memId }"> <br>
                    </div>
                    <!-- Modal footer -->
                    <div class="modal-footer" align="center">
                        <button type="submit" class="btn btn-danger">탈퇴하기</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>