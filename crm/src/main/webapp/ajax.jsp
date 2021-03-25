<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + 	request.getServerPort() + request.getContextPath() + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
</head>
<script>
    $.ajax({
        url:"",
        data:{

        },
        type:"",
        dataType:"json",
        success:function(data){

        }
    })

    String createTime = DateTimeUtil.getSysTime();
    String createBy = ((User)request.getSession().getAttribute("user")).getName();
</script>
<body>

</body>
</html>
