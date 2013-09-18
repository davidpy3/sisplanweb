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
    <title>Usuarios Intranet</title>
 <script language="JavaScript">    
     function Pick(CodStaff,ApePat,ApeMat,Nombres,Email,TipDoc,NumDoc){
       
       window.opener.document.forms[0].cod_staff.value=CodStaff;
       window.opener.document.forms[0].nombre.value=Nombres;
       window.opener.document.forms[0].nombre.readOnly="true";
       window.opener.document.forms[0].ap_pat.value=ApePat;
       window.opener.document.forms[0].ap_pat.readOnly="true";
       window.opener.document.forms[0].ap_mat.value=ApeMat;
       window.opener.document.forms[0].ap_mat.readOnly="true";
       window.opener.document.forms[0].email.value=Email;
       window.opener.document.forms[0].email.readOnly="true";
       window.opener.document.forms[0].tipo_doc_id.value=TipDoc;
       window.opener.document.forms[0].tipo_doc_id.readOnly="true";
       window.opener.document.forms[0].num_doc_id.value=NumDoc;
       window.opener.document.forms[0].num_doc_id.readOnly="true";
       window.close();
         
     }
 </script>   
</head>
<body>
<form action="userSetUp.do">
    <input type="hidden" name="dispatch" value="showUsersIntranet">
    <table>
     <tr><td>Ap Paterno</td><td><input type="text" name="ap_paterno" value="" size="40"></td></tr>
     <tr><td>Ap Materno</td><td><input type="text" name="ap_materno" value="" size="40"></td></tr>
     <tr><td>Nombres</td><td><input type="text" name="nombres" value="" size="40"></td></tr>
     <tr><td colspan="2"><input type="submit" value="Buscar"></td></tr>
     </table>
</form>    
<display:table  name="usersIntra" pagesize="12" requestURI=""
                        defaultsort="1" defaultorder="ascending" sort="list" class="consultanormal"  export="true" id="row" >		       	 
             
             <display:column title="Ap. Paterno" property="APELLIDOPAT" sortable="false" headerClass="sortable"  />
             <display:column title="Ap. Materno" property="APELLIDOMAT" sortable="false" headerClass="sortable"  />
             <display:column title="Nombres" property="NOMBRES" sortable="false" headerClass="sortable"  />
             <display:column title="Cod Staff"  sortable="false" headerClass="sortable">
               <a href="javascript:Pick(${row.USUARIO},'${row.APELLIDOPAT}','${row.APELLIDOMAT}','${row.NOMBRES}','${row.EMAIL}',${row.TIPDOCIDENT},${row.CODDOCIDENT});return true;">${row.USUARIO}</a>
             </display:column>  
             <display:column title="Email" property="EMAIL" sortable="false" headerClass="sortable"  />
             <display:column title="Tipo Doc" property="TIPDOCIDENT" sortable="false" headerClass="sortable"  />
             <display:column title="Num Doc" property="CODDOCIDENT" sortable="false" headerClass="sortable"  />
                        
             <display:setProperty name="export.excel.filename" value="UsuariosIntranet.xls"/>
              
    </display:table> 
               
</body>
</html>