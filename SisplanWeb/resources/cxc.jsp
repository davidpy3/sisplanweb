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
<div class="Titulo1AzulClaro"><fmt:message key="label.cxc"/></div>
Compañia: <c:out value="${params['Compania']}" />
Fecha: <c:out value="${params['Fecha']}" />
Correntista: <c:out value="${params['Correntista']}" />
<br/><br/>
<c:url var="url" scope="page" value="/mvmntosCrdtoProcess.do">
   <c:param name="dispatch" value="showMvmntoCrdtoParams"/>
 </c:url>
 <a href="${url}">Nueva Consulta</a>
 <br>
    <display:table  name="movcxc" pagesize="10" requestURI=""
                        defaultsort="2" defaultorder="ascending" sort="list" class="consultanormal"  export="true" id="row" >		       	 
             
             <display:column title="Id" property="COD_CORRENTISTA" sortable="false" headerClass="sortable"  />
             <display:column title="Correntista" property="NOMB_CORRENTISTA" sortable="false" headerClass="sortable"  />
             <display:column title="Documento" property="DESCRIP_DOCUM" sortable="false" headerClass="sortable"  />
             <display:column title="Serie" property="NMRO_SRIE" sortable="false" headerClass="sortable"  />
             <display:column title="Numero" property="NUMERO" sortable="false" headerClass="sortable"  />
             <display:column title="TC" property="TC_DOC" sortable="false" headerClass="sortable"  />
             <display:column title="F.Emision" property="FECHA_EMISION" sortable="false" headerClass="sortable"  />
             <display:column title="F.Venc" property="FECHA_VENCIMIENTO" sortable="false" headerClass="sortable"  />
             <display:column title="Moneda" property="MONEDA" sortable="false" headerClass="sortable"  />
             <display:column title="Importe" property="IMPORTE_DOCUMENTO" sortable="false" style="text-align:right;" headerClass="sortable"   />
             <display:column title="Saldo Soles" property="SALDO_SOLES" sortable="false" style="text-align:right;" headerClass="sortable"  />
             <display:column title="Saldo Dolares" property="SALDO_DOLARES" sortable="false" style="text-align:right;" headerClass="sortable"  />
             <display:column title="Total Soles" property="TOTAL_SOLES" sortable="false" style="text-align:right;" headerClass="sortable"  />
             <display:column title="Glosa 1" property="GLOSA1" sortable="false" headerClass="sortable"  />
             <display:column title="Glosa 2" property="GLOSA2" sortable="false" headerClass="sortable"  />
             <display:column title="Glosa 3" property="GLOSA3" sortable="false" headerClass="sortable"  />

              <display:setProperty name="export.excel.filename" value="cxc.xls"/>
              
    </display:table> 
        
  
</body>
</html>