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
<div class="Titulo1AzulClaro">REPORTES CONTROLLER - Kardex de Trabajadores por Centro de Costo </div>
Compañia: <c:out value="${params['Compania']}" />
<br>
Año: <c:out value="${params['Ano']}" />
<br>
Mes: <c:out value="${params['Mes']}" />
<br/><br/>
<c:url var="url" scope="page" value="/repControllerProcess.do">
   <c:param name="dispatch" value="showParamsKardexTrabCCosto"/>
 </c:url>
 <a href="${url}">Nueva Consulta</a>
 <br>
    <display:table  name="KardexTrabCCosto" pagesize="15" requestURI=""
                        defaultsort="1" defaultorder="ascending" sort="list" class="consultanormal"  export="true" id="row" >		       	 
                          
             <display:column title="Cod CCosto" property="cod_ccosto" sortable="false" headerClass="sortable"  />
             <display:column title="CCosto" property="desc_ccosto" sortable="false" headerClass="sortable"  />
             <display:column title="Cod Cliente" property="cod_clie" sortable="false" headerClass="sortable"  />
             <display:column title="Desc Cliente" property="desc_clie" sortable="false" headerClass="sortable"  />
             <display:column title="Saldo Incial" property="saldo_inicial" sortable="false" style="text-align:right;" headerClass="sortable"  />
             <display:column title="Ingresos" property="ingresos" sortable="false" style="text-align:right;" headerClass="sortable"  />
             <display:column title="Ceses" property="ceses" sortable="false" style="text-align:right;" headerClass="sortable"  />
             <display:setProperty name="export.excel.filename" value="Kardex${params['CiaAbrev']}${params['Ano']}${params['Mes']}.xls"/>
              
    </display:table> 
        
  
</body>
</html>