<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <link href="<c:url value='main.css'/>" rel="stylesheet" type="text/css"/>
    <link href="css/espacio.css" type="text/css" rel="stylesheet">

    <title><fmt:message key="label.menus"/></title>
</head>
<body>
<!--div class="titleDiv"><fmt:message key="application.title"/></div-->
<div class="Titulo1AzulClaro"><fmt:message key="label.roles"/></div>
<c:url var="url" scope="page" value="/rolSetUp.do">
    <c:param name="dispatch" value="setUpForInsertOrUpdate"/>
</c:url>
<br/>
<a href="${url}">Nuevo Rol</a>
<br/><br/>
<table class="borderAll">
    <tr>
        <th>RolId</th>
        <th>Nombre</th>
        <th>&nbsp;</th>
    </tr>
    <c:forEach var="rolMap" items="${roles}" varStatus="status">
        <tr class="${status.index%2==0?'even':'odd'}">
            <td class="nowrap"><c:out value="${rolMap.ID}"/></td>
            <td class="nowrap"><c:out value="${rolMap.NOMBRE}"/></td>
            <td class="nowrap">
                <c:url var="url" scope="page" value="/rolSetUp.do">
                    <c:param name="id" value="${rolMap.ID}"/>
                    <c:param name="dispatch" value="setUpForInsertOrUpdate"/>
                </c:url>
                <a href="${url}">Editar</a>
                &nbsp;&nbsp;&nbsp;
                              
            </td>
        </tr>
    </c:forEach>
    </table>
</body>
</html>