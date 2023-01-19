<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>농부심</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<link  href="https://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.4/fotorama.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.4/fotorama.js"></script>
<style>
    .outer{
        /* background-color: rgb(234, 241, 234); */
        font-family: 'Pretendard-Regular';
        padding: 80px 150px;
    }
    .top-area, .botton-area, .fammer-area{
        background-color: white;
        padding: 50px 100px;
        border-radius: 20px;
        box-shadow: 0 2px 10px 0 rgba(0, 0, 0, 0.1);
        margin-bottom: 100px;
    }
    .top-area>div, .botton-area>div, .fammer-area>div{
        display: inline-block;
    }
    #info-img{
        width: 30%;
        height: 100px;
        /* background-color: aqua; */
    }
    #program-area{
        width: 50%;
        /* background-color: aqua; */
        float: right;
    }
    /* #clear{
        width: 5%;
    } */
    #info-img img{
        width: 100%;
    }
    #board-area{
        width: 50%;
    }
    #market-area{
        width: 50%;
        float: right;
    }
    #dairy-area{
        width: 50%;
    }
    #account-area{
        width: 50%;
        float: right;
    }
    
</style>
</head>
<body>
	<jsp:include page="WEB-INF/views/common/menubar.jsp" />

    <div class="outer" align="center">

        <c:if test="${loginUser.memStatus == 'F'}">
            <div class="fammer-area">
                <div id="dairy-area">
                    <h3>영농일지</h3><br>
                </div>
    
                <div id="account-area">
                    <h3>가계부</h3><br>
                </div>
            </div>
        </c:if>

        <div class="top-area">
            <div id="info-img">
                <h3>농업정보</h3><br>
                <div class="fotorama">
                    <img src="resources/images/농사정보1.jfif">
                    <img src="resources/images/농사정보1.jfif">
                    <img src="resources/images/농사정보1.jfif">
                </div>
            </div>

            <div id="program-area">
                <h3>프로그램</h3><br>

            </div>

        </div>

        <div class="botton-area">
            <div id="board-area">
                <h3>농사 게시글</h3><br>
            </div>

            <div id="market-area">
                <h3>판매글</h3><br>
            </div>
        </div>


    </div>

	
</body>
</html>