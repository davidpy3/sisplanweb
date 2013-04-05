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
<h1><fmt:message key="label.menus"/></h1>
<c:url var="url" scope="page" value="/menuSetUp.do">
    <c:param name="dispatch" value="setUpForInsertOrUpdate"/>
</c:url>
<a href="${url}">Nuevo Menu</a>
<br/><br/>
<table class="borderAll">
    <tr>
        <th>MenuId</th>
        <th>Tipo</th>
        <th>Titulo</th>
        <th>PadreId</th>
        <th>PosId</th>
        <th>Estado</th>
        <th>URL</th>
        <th>&nbsp;</th>
    </tr>
    <c:forEach var="mnuMap" items="${menus}" varStatus="status">
        <tr class="${status.index%2==0?'even':'odd'}">
            <td class="nowrap"><c:out value="${mnuMap.MENUID}"/></td>
            <td class="nowrap"><c:out value="${mnuMap.MENUTIPO}"/></td>
            <td class="nowrap"><c:out value="${mnuMap.MENUTITLE}"/></td>
            <td class="nowrap"><c:out value="${mnuMap.PARENTID}"/></td>
            <td class="nowrap"><c:out value="${mnuMap.MENUORDEN}"/></td>
            <td class="nowrap"><c:out value="${mnuMap.ESTADO}"/></td>
            <td class="nowrap"><c:out value="${mnuMap.MENUACTION}"/></td>
            <td class="nowrap">
                <c:url var="url" scope="page" value="/menuSetUp.do">
                    <c:param name="menuid" value="${mnuMap.MENUID}"/>
                    <c:param name="dispatch" value="setUpForInsertOrUpdate"/>
                </c:url>
                <a href="${url}">Editar</a>
                &nbsp;&nbsp;&nbsp;
                <c:url var="url" scope="page" value="/menuProcess.do">
                    <c:param name="menuid" value="${mnuMap.MENUID}"/>
                    <c:param name="dispatch" value="delete"/>
                </c:url>
                <a href="${url}">Eliminar</a>
            </td>
        </tr>
    </c:forEach>
    </table>
</body>
</html>