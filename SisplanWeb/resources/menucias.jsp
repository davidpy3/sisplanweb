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
<div class="Titulo1AzulClaro"><fmt:message key="label.pmenucia"/>&nbsp;&nbsp;</div>
<br/><br/>

<table class="borderAll">
    <tr>
        <th>Empresa Id</th>
        <th>Nombre</th>
        <th>&nbsp;</th>
    </tr>
    <c:forEach var="ciaMap" items="${cias}" varStatus="status">
        <tr class="${status.index%2==0?'even':'odd'}">
            <td class="nowrap"><c:out value="${ciaMap.codigo}"/></td>
            <td class="nowrap"><c:out value="${ciaMap.nombre}"/></td>
            <td class="nowrap">
                <c:url var="url" scope="page" value="/menuProcess.do">
                    <c:param name="no_cia" value="${ciaMap.codigo}"/>
                    <c:param name="dispatch" value="getMenuByCia"/>
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