<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <link href="<c:url value='main.css'/>" rel="stylesheet" type="text/css"/>
    <title><fmt:message key="label.menus"/></title>
</head>
<body>
<!--div class="titleDiv"><fmt:message key="application.title"/></div-->
<h1><fmt:message key="label.pmenurol"/>&nbsp;&nbsp;</h1>
<br/><br/>

<table class="borderAll">
    <tr>
        <th>RolId</th>
        <th>Nombre</th>
        <th>&nbsp;</th>
    </tr>
    <c:forEach var="rolMap" items="${pmenurol}" varStatus="status">
        <tr class="${status.index%2==0?'even':'odd'}">
            <td class="nowrap"><c:out value="${rolMap.ID}"/></td>
            <td class="nowrap"><c:out value="${rolMap.NOMBRE}"/></td>
            <td class="nowrap">
                <c:url var="url" scope="page" value="/rolProcess.do">
                    <c:param name="id" value="${rolMap.ID}"/>
                    <c:param name="dispatch" value="getMenuByRol"/>
                </c:url>
                <a href="${url}">Editar Menu</a>
            </td>
        </tr>
    </c:forEach>
    </table>
<br>
<br>
</body>
</html>