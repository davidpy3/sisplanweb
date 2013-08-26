<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<html>
<head>
    <link href="css/espacio.css" type="text/css" rel="stylesheet">
    <link href="css/calendar-system.css" type="text/css" rel="stylesheet">
    <link href="css/displaytag.css" type="text/css" rel="stylesheet">
    
    <title><fmt:message key="label.menus"/></title>
</head>
<body>

<div class="Titulo1AzulClaro"><fmt:message key="label.menus"/></div>
<br>
<html:form action="/menuProcess">
    <table>
         <tr>
            <td class="tdLabel">Titulo:</td>
            <td><html:text property="titulo" size="40"/>
            </td>
        </tr>
        <tr>
            <td class="tdLabel">Contenedor:</td>
            <td>
                <html:select property="parentid">
                    <html:option value="">
                    </html:option>
                    <c:forEach var="menu" items="${parents}">
                        <html:option value="${menu.menuid}">
                            <c:out value="${menu.titulo}"/>
                        </html:option>
                    </c:forEach>
                </html:select>
            </td>
        </tr>
        <tr>
            <td class="tdLabel">Formato Salida:</td>
            <td>
            
            <html:radio property="indweb" value="F"/> Forms
            <html:radio property="indweb" value="W"/> Web
   	    
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="hidden" name="dispatch" value="getMenus"/>
                <br/>
                <input type="submit" value="<fmt:message key="button.label.search"/>" class="butStnd"/>
                &nbsp;&nbsp;&nbsp;
                
            </td>
        </tr>
    </table>
</html:form>
<c:url var="url" scope="page" value="/menuSetUp.do">
    <c:param name="dispatch" value="setUpForInsertOrUpdate"/>
</c:url>
<a href="${url}">Nuevo Menu</a>
<br>
 <display:table  name="menus" pagesize="12" requestURI=""
                        defaultsort="3" defaultorder="ascending" sort="list" class="consultanormal"  export="true" id="row" >		       	 
             
    <display:column title="MenuId" property="menuid" sortable="true" headerClass="sortable"  />
    <display:column title="Tipo" property="tipo" sortable="false" headerClass="sortable"  />
    <display:column title="Titulo" property="titulo" sortable="true" headerClass="sortable"  />
    <display:column title="PadreId" property="parentid" sortable="false" headerClass="sortable"  />
    <display:column title="PosId" property="posid" sortable="true" headerClass="sortable"  />
    <display:column title="Estado" property="estado" sortable="false" headerClass="sortable"  />
    <display:column title="URL" property="url" sortable="false" headerClass="sortable"  />
    <display:column title="&nbsp;"  sortable="false" media="html" headerClass="sortable">
      <c:url var="url" scope="page" value="/menuSetUp.do">
           <c:param name="menuid" value="${row.menuid}"/>
           <c:param name="dispatch" value="setUpForInsertOrUpdate"/>
      </c:url>
      <a href="${url}">Editar</a>
      &nbsp;&nbsp;&nbsp;
      <c:url var="url" scope="page" value="/menuProcess.do">
        <c:param name="menuid" value="${row.menuid}"/>
        <c:param name="dispatch" value="delete"/>
      </c:url>
      <a href="${url}">Eliminar</a>  
    </display:column>>
    <display:setProperty name="export.excel.filename" value="Menus.xls"/>
              
</display:table> 


</body>
</html>