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
<h1><fmt:message key="label.menurol"/>&nbsp;&nbsp; <c:out value="${rol.nombre}"/> </h1>
<br/><br/>
<table class="borderAll">
    <tr>
        <th>MenuId</th>
        <th>Tipo</th>
        <th>Titulo</th>
        <th>PadreId</th>
        <th>Estado</th>
        <th>Acceso</th>
        <th><img src="imagenes/boton_modificar.gif"></th>
    </tr>
    <c:forEach var="mnuMap" items="${menurol}" varStatus="status">
        <tr class="${status.index%2==0?'even':'odd'}">
            <td class="nowrap"><c:out value="${mnuMap.MENUID}"/></td>
            <td class="nowrap"><c:out value="${mnuMap.MENUTIPO}"/></td>
            <td class="nowrap"><c:out value="${mnuMap.MENUTITLE}"/></td>
            <td class="nowrap"><c:out value="${mnuMap.PARENTID}"/></td>
            <td class="nowrap"><c:out value="${mnuMap.ESTADO}"/></td>
            <td class="nowrap">
                <c:set var="acceso" value="${mnuMap.ACCESO}"/>
                <c:if test="${acceso == 'S'}">
                    <img src="images/ok.jpg" height="20"> 
                </c:if>
                <c:if test="${acceso == 'N'}">
                    <img src="images/lock.jpg" height="20"> 
                </c:if>
            </td>
            <td align="center" class="nowrap">
                <c:if test="${acceso=='S'}">
                  <c:url var="url" scope="page" value="/rolProcess.do">
                  <c:param name="menuid" value="${mnuMap.MENUID}"/>
                  <c:param name="rolid" value="${rol.id}"/>
                  <c:param name="action" value="del"/>
                  <c:param name="dispatch" value="setUpMenuToRol"/>
                </c:url>
                    <a href="${url}"><img src="images/del.jpg" height="20"></a>
                &nbsp;&nbsp;&nbsp;
                </c:if>
                <c:if test="${acceso=='N'}">
                    <c:url var="url" scope="page" value="/rolProcess.do">
                    <c:param name="menuid" value="${mnuMap.MENUID}"/>
                    <c:param name="rolid" value="${rol.id}"/>
                    <c:param name="action" value="add"/>
                    <c:param name="dispatch" value="setUpMenuToRol"/>
                    </c:url>
                    <a href="${url}"><img src="images/add.jpg" height="20"></a>
                </c:if>    
            </td>
        </tr>
    </c:forEach>
    </table>
<br>
<br>
<c:url var="url" scope="page" value="/rolProcess.do">
   <c:param name="dispatch" value="showMenuByRol"/>
 </c:url>
 <a href="${url}">Regresar</a>
</body>
</html>