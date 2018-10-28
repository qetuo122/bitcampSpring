<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery.min.js"></script>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<style>
	.post {
    padding: 0 1.5% 
}
.comment-form .form-control {
    border: 0px;
    background: #eee;
    min-height: 50px; 
}
.comment-form > .row {
    margin: 0 -1.5%; 
}
.comment-form [class*="col-"] {
        padding: 0 1.5% 
}
.form-group{
	margin-bottom : 30px;
}
.messageTitle {
	margin-bottom : 40px;
}

@media (min-width:992px) { 
    .post {
        width: 50%;
        max-width: 500px;
        margin: 0 auto;
    }
    .comment-form label {
        position: absolute;
        width: 200px;
    }
    .comment-form .name {
        top: -20px;
    }
    .comment-form .email {
        top: -20px;
    }
    .comment-form .message {
        top: -20px;
    }
}


@media (min-width:1200px) { 
    .post {
        max-width: 525px;
    }
}
</style>
</head>
<body>


<div class="post">
 <div class="contact">
   <div class="messageTitle">
      <h2>쪽지보내기</h2>
   </div>
   <form class="comment-form" method = "post">
      <div class="row">
         <div class="col-md-12 form-group">
            <label class="name">보내는 사람</label>
            <input type="text" class="form-control" placeholder="user Id" name = "userId" required/>
         </div>
         <div class="col-md-12 form-group">
            <label class="email">메시지 제목</label>
            <input type="text" class="form-control" placeholder="message Title" name = "messageTitle" required/>
         </div>
         <div class="clearfix"></div>
         <div class="col-md-12 form-group">
            <label class="message">메시지 내용</label>
            <textarea class="form-control" cols="47" rows="7" placeholder="Message" name = "messageCon" required></textarea>
         </div>
         <div class="col-md-12 form-group">
           <input type = "submit" class="btn btn-block btn-lg btn-success" value = "쪽지 보내기">
        </div>        

      </div>
   </form>
  </div>
</div>
</body>
</html>