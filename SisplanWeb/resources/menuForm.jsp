<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<c:set var="insertUpdateTitle" value="${!empty MenuForm.menuid && MenuForm.menuid != 0 ?'Editar Menu':'Nuevo Menu'}"/>
<html>
<head>
    <link href="<c:url value='main.css'/>" rel="stylesheet" type="text/css"/>
    <style>td { white-space:nowrap; }</style>
    <title><c:out value="${insertUpdateTitle}"/></title>
</head>
<body>
<!--div class="titleDiv"><fmt:message key="application.title"/></div-->
<h1><c:out value="${insertUpdateTitle}"/></h1>
<html:form action="/menuProcess">
    <table>
         <tr>
            <td class="tdLabel">Titulo:</td>
            <td><html:text property="titulo" size="40"/>
                 <html:errors property="titulo"/>
            </td>
        </tr>
        <tr>
            <td class="tdLabel">Tipo:</td>
            <td><html:select property="tipo">
                  <html:option value="M">
                      SUBMENU
                  </html:option>
                  <html:option value="I">
                      ITEM
                  </html:option>
                </html:select>
                  
                <html:errors property="tipo"/></td>
        </tr>
        <tr>
            <td class="tdLabel">Estado:</td>
            <td><html:select property="estado">
                  <html:option value="S">
                      ACTIVO
                  </html:option>
                  <html:option value="N">
                      INACTIVO
                  </html:option>
                </html:select>
                  
                <html:errors property="estado"/></td>
        </tr>
        <tr>
            <td class="tdLabel">Posición:</td>
            <td><html:text property="posid" size="20"/> <html:errors property="posid"/></td>
        </tr>
         <tr>
            <td class="tdLabel">Contenedor:</td>
            <td>
                <html:select property="parentid">
                    <c:forEach var="menu" items="${parents}">
                        <html:option value="${menu.menuid}">
                            <c:out value="${menu.titulo}"/>
                        </html:option>
                    </c:forEach>
                </html:select>
            </td>
        </tr>
        <tr>
            <td class="tdLabel">URL:</td>
            <td><html:text property="url" size="40"/> <html:errors property="url"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <html:hidden property="menuid"/>
                <input type="hidden" name="dispatch" value="insertOrUpdate"/>
                <br/>
                <input type="submit" value="<fmt:message key="button.label.submit"/>" class="butStnd"/>
                &nbsp;&nbsp;&nbsp;
                <input type="submit" value="<fmt:message key="button.label.cancel"/>"  class="butStnd" onclick="document.MenuForm.dispatch.value='getMenus'"/>
            </td>
        </tr>
    </table>
</html:form>
</body>
</html>