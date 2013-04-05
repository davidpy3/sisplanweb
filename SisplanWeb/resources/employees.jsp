<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <link href="<c:url value='main.css'/>" rel="stylesheet" type="text/css"/>
    <title><fmt:message key="label.employees"/></title>
</head>
<body>
<div class="titleDiv"><fmt:message key="application.title"/></div>
<h1><fmt:message key="label.employees"/></h1>
<c:url var="url" scope="page" value="/employeeSetUp.do">
    <c:param name="dispatch" value="setUpForInsertOrUpdate"/>
</c:url>
<a href="${url}">Add New Employee</a>
<br/><br/>
<table class="borderAll">
    <tr>
        <th><fmt:message key="label.firstName"/></th>
        <th><fmt:message key="label.lastName"/></th>
        <th><fmt:message key="label.age"/></th>
        <th><fmt:message key="label.department"/></th>
        <th>&nbsp;</th>
    </tr>
    <c:forEach var="empMap" items="${employees}" varStatus="status">
        <tr class="${status.index%2==0?'even':'odd'}">
            <td class="nowrap"><c:out value="${empMap.FIRSTNAME}"/></td>
            <td class="nowrap"><c:out value="${empMap.LASTNAME}"/></td>
            <td class="nowrap"><c:out value="${empMap.AGE}"/></td>
            <td class="nowrap"><c:out value="${empMap.DEPTNAME}"/></td>
            <td class="nowrap">
                <c:url var="url" scope="page" value="/employeeSetUp.do">
                    <c:param name="employeeId" value="${empMap.EMPLOYEEID}"/>
                    <c:param name="dispatch" value="setUpForInsertOrUpdate"/>
                </c:url>
                <a href="${url}">Edit</a>
                &nbsp;&nbsp;&nbsp;
                <c:url var="url" scope="page" value="/employeeProcess.do">
                    <c:param name="employeeId" value="${empMap.EMPLOYEEID}"/>
                    <c:param name="dispatch" value="delete"/>
                </c:url>
                <a href="${url}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </table>
</body>
</html>