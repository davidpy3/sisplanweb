<%
response.setHeader("Cache-Control","no-cache");
response.setHeader("Pragma","no-cache");
response.setDateHeader("Expires",-1);
%>
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
    <script language="javascript" src="js/calendar-es.js"></script>
<script language="javascript" src="js/calendar-setup.js"></script>
<script language="javascript" src="js/utils.js"></script>
<script language="javascript" src="js/tw-sack.js"></script> 
<script language="javascript" src="util/js/calendario.js"></script> 
    <title><fmt:message key="label.employees"/></title>
</head>
<body>
<br>
<div class="Titulo1AzulClaro">GESTION DE USUARIOS</div>
<br>

<html:form action="/userProcess">
    <table>
         <tr>
            <td class="tdLabel">Usuario:</td>
            <td><html:text property="usuario" size="30"/>
            </td>
        </tr>
        <tr>
            <td class="tdLabel">Nombre:</td>
            <td><html:text property="nombre" size="50"/>
            </td>
        </tr>
        <tr>
            <td class="tdLabel">Ap Paterno:</td>
            <td><html:text property="ape_pat" size="50"/>
            </td>
        </tr>
        <tr>
            <td class="tdLabel">Ap Materno:</td>
            <td><html:text property="ape_mat" size="50"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="hidden" name="dispatch" value="getUsers"/>
                <br/>
                <input type="submit" value="<fmt:message key="button.label.search"/>" class="butStnd"/>
                &nbsp;&nbsp;&nbsp;
                
            </td>
        </tr>
    </table>
</html:form>

<c:url var="url" scope="page" value="/userSetUp.do">
   <c:param name="dispatch" value="setUpForInsertOrUpdate"/>
 </c:url>
 <a href="${url}">Nuevo Usuario</a>
 <br>
    <display:table  name="users" pagesize="12" requestURI=""
                        defaultsort="3" defaultorder="ascending" sort="list" class="consultanormal"  export="true" id="row" >		       	 
             
             <display:column title="Login" property="login" sortable="false" headerClass="sortable"  />
             <display:column title="Nombres" property="nombre" sortable="false" headerClass="sortable"  />
             <display:column title="Ap Pat" property="ap_pat" sortable="false" headerClass="sortable"  />
             <display:column title="Ap Mat" property="ap_mat" sortable="false" headerClass="sortable"  />
             <display:column title="Tip Doc" property="tipo_doc_id" sortable="false" headerClass="sortable"  />
             <display:column title="Num Doc" property="num_doc_id" sortable="false" headerClass="sortable"  />
             <display:column title="Email" property="email" sortable="false" headerClass="sortable"  />
             <display:column title="Estado" property="estado" sortable="false" headerClass="sortable"  />
             <display:column title="Rep Legal" property="id_repre_legal" sortable="false" style="text-align:right;" headerClass="sortable"  />
             <display:column title="STAFF" property="cod_staff" sortable="false" style="text-align:right;" headerClass="sortable"  />
             <display:setProperty name="export.excel.filename" value="Usuarios.xls"/>
              
    </display:table> 
        
  
</body>
</html>
