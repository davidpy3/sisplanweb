<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<c:set var="insertUpdateTitle" value="${!empty employeeForm.employeeId && employeeForm.employeeId != 0 ?'Update Employee':'Add Employee'}"/>
<html>
<head>
    <link href="<c:url value='main.css'/>" rel="stylesheet" type="text/css"/>
    <style>td { white-space:nowrap; }</style>
    <title><c:out value="${insertUpdateTitle}"/></title>
</head>
<body>
<div class="titleDiv"><fmt:message key="application.title"/></div>
<h1><c:out value="${insertUpdateTitle}"/></h1>
<html:form action="/employeeProcess">
    <table>
         <tr>
            <td class="tdLabel"><fmt:message key="label.firstName"/>:</td>
            <td><html:text property="firstName" size="40"/> <html:errors property="firstName"/></td>
        </tr>
        <tr>
            <td class="tdLabel"><fmt:message key="label.lastName"/>:</td>
            <td><html:text property="lastName" size="40"/> <html:errors property="lastName"/></td>
        </tr>
        <tr>
            <td class="tdLabel"><fmt:message key="label.age"/>:</td>
            <td><html:text property="age" size="20"/> <html:errors property="age"/></td>
        </tr>
         <tr>
            <td class="tdLabel"><fmt:message key="label.department"/>:</td>
            <td>
                <html:select property="departmentId">
                    <c:forEach var="dept" items="${departments}">
                        <html:option value="${dept.departmentId}">
                            <c:out value="${dept.name}"/>
                        </html:option>
                    </c:forEach>
                </html:select>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <html:hidden property="employeeId"/>
                <input type="hidden" name="dispatch" value="insertOrUpdate"/>
                <br/>
                <input type="submit" value="<fmt:message key="button.label.submit"/>" class="butStnd"/>
                &nbsp;&nbsp;&nbsp;
                <input type="submit" value="<fmt:message key="button.label.cancel"/>"  class="butStnd" onclick="document.employeeForm.dispatch.value='getEmployees'"/>
            </td>
        </tr>
    </table>
</html:form>
</body>
</html>