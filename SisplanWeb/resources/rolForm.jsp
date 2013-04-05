<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<c:set var="insertUpdateTitle" value="${!empty RolForm.id && RolForm.id != 0 ?'Editar Rol':'Nuevo Rol'}"/>
<html>
<head>
    <link href="<c:url value='main.css'/>" rel="stylesheet" type="text/css"/>
    <style>td { white-space:nowrap; }</style>
    <title><c:out value="${insertUpdateTitle}"/></title>
</head>
<body>
<!--div class="titleDiv"><fmt:message key="application.title"/></div-->
<h1><c:out value="${insertUpdateTitle}"/></h1>
<html:form action="/rolProcess">
    <table>
         <tr>
            <td class="tdLabel">Nombre:</td>
            <td><html:text property="nombre" size="40" style="text-transform: uppercase" />
                 <html:errors property="nombre"/>
            </td>
        </tr>
        
        <tr>
            <td colspan="2">
                <html:hidden property="id"/>
                <input type="hidden" name="dispatch" value="insertOrUpdate"/>
                <br/>
                <input type="submit" value="<fmt:message key="button.label.submit"/>" class="butStnd"/>
                &nbsp;&nbsp;&nbsp;
                <input type="submit" value="<fmt:message key="button.label.cancel"/>"  class="butStnd" onclick="document.RolForm.dispatch.value='getRoles'"/>
            </td>
        </tr>
    </table>
</html:form>
</body>
</html>