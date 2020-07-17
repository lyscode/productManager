<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
<%--跳转到登录页面--%>
<jsp:forward page="${pageContext.request.contextPath}/pages/login.jsp"/>
</body>
</html>
