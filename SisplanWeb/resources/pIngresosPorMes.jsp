<%
response.setHeader("Cache-Control","no-cache");
response.setHeader("Pragma","no-cache");
response.setDateHeader("Expires",-1);
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--c:redirect url="/mvmntosCrdtoProcess.do?dispatch=getMvmntoCrdtoByDate&no_cia=01&fecha=04/09/2012&idCliente="/-->
<%@ page contentType="text/html;charset=iso-8859-1" language="java" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<html>
<head>
<link href="css/espacio.css" type="text/css" rel="stylesheet">
<link href="css/calendar-system.css" type="text/css" rel="stylesheet">
<script language="javascript" src="js/calendar.js"></script>
<script language="javascript" src="js/calendar-es.js"></script>
<script language="javascript" src="js/js.Farmacia.Function.js"  type="text/javascript"></script>
<script language="javascript" src="js/calendar-setup.js"></script>
<script language="javascript" src="js/utils.js"></script>
<script language="javascript" src="js/tw-sack.js"></script> 
<script language="javascript" src="util/js/calendario.js"></script> 

<title><bean:message key="application.title"/></title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">


<SCRIPT LANGUAGE=javascript>
<!--

	function Validar(theForm)
	{
          //var theForm=document.forms[0];
                  
		if (theForm.no_cia.value == "")
		{
			alert("Debe ingresar la compañia");
			theForm.no_cia.focus();
			return (false);
		}
			
		
		if (theForm.no_cia.value != "" )
		{       
                         theForm.btnIngresar.className="butondis";
                         theForm.btnIngresar.value="Procesando...";
                         theForm.btnIngresar.disabled=true;
          
			theForm.submit();
		}

	}
	
    function Login()
	{
	   location.href="index.html";	   
	}

	function Enfocar()
	{

		calform.txtLogin.focus()
	}
	
	function Limpiar()
	{
		document.forms[0].no_cia.value=""
		//document.forms[0].fecha.value=""
                document.forms[0].ano.value=""
		document.forms[0].no_cia.focus();
	}

<% String msg=request.getParameter("msgerr");
   if(msg!=null){
     if(!msg.equals("")) {
     %>
      alert("<%=msg%>");
      <%   
     }
   }
%>
//-->
</SCRIPT>

<link href="styles/sgmstyles.css" type="text/css" rel="stylesheet"/>
<link href="css/espacio.css" rel="stylesheet" type="text/css">
</HEAD>
<BODY topmargin="0px" bgproperties="fixed">

<!-- ==================================INICIO DEL CUERPO================================== -->
<center>
<!--form method="post" name="frmlogin" action="/loginUsuario?dispatch=validarUsuario" onSubmit="return Validar(this);"-->
<html:form action="/repControllerProcess.do?dispatch=getIngresosPorMes" onsubmit="Validar(this);return false;">
<br />
<div style="position:relative;width:600px;height:400px;border:0px solid #2D466F;">
<table valign="middle" border="0" width="506px" cellspacing="2" cellpadding="0" class=tabla>
    <tr>
    
    </tr>
	<tr height=10px valign="middle">
		<td width="100%" colspan=2 align=middle class="TextoAzulTitulo1">Ingresos por Mes</td>
	</tr>
	<tr height=10px>
		<td width="60%" align="center" >
                    
			<table border="0" width="70%" class="tabla">
				<tr valign="middle" height="25px">
                                    <td width="100%" colspan=2 align=middle class="Titulo2AzulClaro"></td>
				</tr>
                               	<tr>
                                    <td width="50%" class="Titulo2BlancoClaro" bgcolor="#2D466F">&nbsp;&nbsp;Compañía&nbsp;<font color="red">*</font></td>
                                    <td width="50%" class="FondoGris1">
                                         <html:select property="no_cia" styleClass="Campo">
                                             <c:forEach var="cia" items="${cias}">
                                                <html:option value="${cia.codigo}">
                                                <c:out value="${cia.nombre}"/>
                                                </html:option>
                                            </c:forEach>
                                         </html:select>
                                    </td>
				</tr>
						
                                <tr>
                                    <td class="Titulo2BlancoClaro" bgcolor="#2D466F">&nbsp;&nbsp;Año</td>
                                    <td class="FondoGris1">
                                         <html:select property="ano" styleClass="Campo">
                                            <c:forEach var="year" items="${years}">
                                                <html:option value="${year}">
                                                <c:out value="${year}"/>
                                                </html:option>
                                            </c:forEach>
                                         </html:select>
                                    </td>
				</tr>
                                
				<tr valign="middle" height="25px">
                                    <td align=right></td>
                                    <td>
                                        <input type="submit" name="btnIngresar" value="Consultar" class="boton" >
                                        <input type="button" name="btnLimpiar" value="Limpiar"  class="boton" onclick="Limpiar()">
                                    </td>
				</tr>
                                <tr valign="middle" height="25px">
                                    <td align=left colspan="2">&nbsp;<font color="red">*</font> Parámetros Obligatorios</td>
                                    
				</tr>
			</table>
                     <script>
                        document.forms[0].no_cia.focus();
                     </script>
		</td>
	</tr>
	
</table>
</div>
	
<!--/form-->
</html:form>
</center>
<!-- ===================================FIN DEL CUERPO==================================== -->


</body>
</html>

