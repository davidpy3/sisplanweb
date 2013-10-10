<%@page import="com.pe.manpower.sisplan.to.Usuario"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<html>
<head>
    <link href="<c:url value='main.css'/>" rel="stylesheet" type="text/css"/>
     <link href="css/espacio.css" type="text/css" rel="stylesheet">
    <title><fmt:message key="label.menus"/></title>
</head>
<body>
<!--div class="titleDiv"><fmt:message key="application.title"/></div-->
<div class="Titulo1AzulClaro"><fmt:message key="label.usuariorol"/>&nbsp;&nbsp; <c:out value="${rol.nombre}"/> </div>
<br/><br/>
<html:form action="/rolProcess">
Usuarios Disponibles: &nbsp;
<select name="usuario">
<%  List lista=(List) request.getAttribute("usuariosnorol");
    if(lista!=null){
       for(int i=0;i<lista.size();i++){
         Usuario usuario=(Usuario)lista.get(i);
         %>
         <option value="<%=usuario.getLogin()%>"><%=usuario.getAp_pat()+" "+usuario.getAp_mat()+" "+usuario.getNombre()%></option>
      <%
       }
    
    }
%>
</select>
<br>
<br>
<html:hidden property="dispatch" value="setUpUserToRol"/>
<html:hidden property="rolid" value="${rol.id}"/>
<html:hidden property="action" value="add"/>
<input type="submit" value="Agregar al Rol"  class="butStnd" />
 &nbsp;&nbsp;&nbsp;
<input type="submit" value="Regresar"  class="butStnd" onclick="document.forms[0].dispatch.value='showUsersByRol'"/>
</html:form>
<table class="borderAll">
    <tr>
        <th>Usuario</th>
        <th>Nombre</th>
        <th>Usuario Crea</th>
        <th>Fecha Crea</th>
        <th><img src="imagenes/boton_modificar.gif"></th>
    </tr>
    <c:forEach var="mnuMap" items="${usuariorol}" varStatus="status">
        <tr class="${status.index%2==0?'even':'odd'}">
            <td class="nowrap"><c:out value="${mnuMap.USUARIO}"/></td>
            <td class="nowrap"><c:out value="${mnuMap.NOMBRE}"/></td>
            <td class="nowrap"><c:out value="${mnuMap.USUARIO_CREA}"/></td>
            <td class="nowrap"><c:out value="${mnuMap.FEC_CREA}"/></td>
            <td align="center" class="nowrap">
                <c:url var="url" scope="page" value="/rolProcess.do">
                  <c:param name="usuario" value="${mnuMap.USUARIO}"/>
                  <c:param name="rolid" value="${rol.id}"/>
                  <c:param name="action" value="del"/>
                  <c:param name="dispatch" value="setUpUserToRol"/>
                </c:url>
                    <a href="${url}"><img src="images/del.jpg" height="20"></a>
                &nbsp;&nbsp;&nbsp;
            </td>
        </tr>
    </c:forEach>
    </table>
<br>
<br>
</body>
</html>