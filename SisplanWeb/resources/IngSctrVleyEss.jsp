<%
response.setHeader("Cache-Control","no-cache");
response.setHeader("Pragma","no-cache");
response.setDateHeader("Expires",-1);
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<div class="Titulo1AzulClaro">REPORTES CONTROLLER - Ingresos, SCTR , VLey y Essalud </div>
Compañia: <c:out value="${params['Compania']}" />
<br>
Año: <c:out value="${params['Ano']}" />
<br/><br/>
<c:url var="url" scope="page" value="/repControllerProcess.do">
   <c:param name="dispatch" value="showParamsIngSctrVleyEss"/>
 </c:url>
 <a href="${url}">Nueva Consulta</a>
 <br>
    <display:table  name="IngSctrVleyEss" pagesize="15" requestURI=""
                        defaultsort="1" defaultorder="ascending" sort="list" class="consultanormal"  export="true" id="row" >		       	 
             
             <display:column title="NO_CIA" property="no_cia" sortable="false" headerClass="sortable"  />
             <display:column title="EMPRESA" property="cia_desc" sortable="false" headerClass="sortable"  />
             <display:column title="Año" property="ano" sortable="false" headerClass="sortable"  />
             <display:column title="Mes" property="mes" sortable="false" headerClass="sortable"  />
             <display:column title="Mes_N" property="mes_desc" sortable="false" headerClass="sortable"  />
             <display:column title="Cod Cliente" property="cod_clie" sortable="false" headerClass="sortable"  />
             <display:column title="Desc Cliente" property="desc_clie" sortable="false" headerClass="sortable"  />
             <display:column title="Tot Ingresos" property="tot_ing" sortable="false" style="text-align:right;" headerClass="sortable"  />
             <display:column title="Tot Provisiones" property="tot_prov" sortable="false" style="text-align:right;" headerClass="sortable"  />
             <display:setProperty name="export.excel.filename" value="IngSctrVleyEss.xls"/>
              
    </display:table> 
        
  
</body>
</html>