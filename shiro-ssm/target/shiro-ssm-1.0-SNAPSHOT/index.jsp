<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>Title</title>
    <script src="/static/js/jquery-2.1.0.js"></script>
    <script>
        function logout(){
            $.ajax({
                url:"/logout",
                success:function(r){
                    if(r.code===0){
                        location.href="login.jsp";
                    }
                }
            });
        }
    </script>
</head>
<body>

  <shiro:authenticated>
      <!--登录成功-->
      ${sessionScope.username},欢迎您！！&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <a href="javascript:" onclick="logout()">退出</a>
  </shiro:authenticated>
  <br>
  <hr>
  <shiro:hasRole name="管理员">
       <a href="#">系统管理</a>
  </shiro:hasRole>
  <br>

  <shiro:hasPermission name="sys:user:*">
        <a href="#">用户管理</a>
  </shiro:hasPermission>

  <br>
  <!--用户信息-->
  <shiro:principal></shiro:principal>



</body>
</html>
