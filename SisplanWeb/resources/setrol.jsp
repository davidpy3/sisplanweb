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
<%@page import="com.pe.manpower.sisplan.to.Usuario"%>
<html>
<head>
<title><bean:message key="application.title"/></title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">


<SCRIPT LANGUAGE=javascript>
<!--

	function Validar(theForm)
	{
          //var theForm=document.forms[0];
          
		if (theForm.login.value == "")
		{
			alert("Debe ingresar el usuario");
			theForm.login.focus();
			return (false);
		}
		if (theForm.password.value == "")
		{
			alert("Debe ingresar la contraseña");
			theForm.password.focus();
			return (false);
		}
		if (theForm.login.value == "" && theForm.password.value == "")
		{
			alert("Debe ingresar el usuario y la contraseña");
			theForm.login.focus();
			return false;
		}	

		

		
		if (theForm.login.value != "" && theForm.password.value != "")
		{
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
		document.forms[0].login.value=""
		document.forms[0].password.value=""
		document.forms[0].login.focus();
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
 <% 
 // Validacion de Sesion
 Usuario usuario=(Usuario) session.getAttribute("usr");
 if(usuario==null){
   %>
  <jsp:forward   page="login.jsp" /> 
<%}%> 
<!-- ==================================INICIO DEL CUERPO================================== -->
<center>
<!--form method="post" name="frmlogin" action="/loginUsuario?dispatch=validarUsuario" onSubmit="return Validar(this);"-->
<html:form action="/loginUsuario?dispatch=setRol" method="POST" onsubmit="Validar(this);return false;">
<br>
<br>
<br>
<br>
<br>
<div style="position:relative;width:600px;height:323px;border:2px solid #2D466F;">
<table valign="middle" border="0" width="506px" cellspacing="2" cellpadding="0" class=tabla>
    <tr>
        <td colspan=2  width="206px" height="138px" background="">
	<img src="imagenes/manpower.jpg" border="0">
        </td>
    </tr>
	<tr height=10px valign="middle">
		<td width="100%" colspan=2 align=middle class="TextoAzulTitulo1">Bienvenido <bean:message key="application.title"/></td>
	</tr>
	<tr height=10px>
		<td width="60%" align="center" >
                    
			<table border="0" width="70%" class="tabla">
				<tr valign="middle" height="25px">
                                    <td width="100%" colspan=2 align=middle class="Titulo2AzulClaro">Por favor seleccionar el <b>Perfil</b>:</td>
				</tr>
                                <tr valign="middle" height="25px">
                                    <td width="100%" colspan=2 align=middle class="Titulo2AzulClaro">
                                        <font color="#FF0000" ><html:errors property="login" /></font>
                                        <font color="#FF0000" ><html:errors property="password"/></font>
                                    </td>
				</tr>
				<tr>
                                    <td class="Titulo2BlancoClaro" bgcolor="#2D466F">&nbsp;&nbsp;Perfil</td>
                                    <td class="FondoGris1">
                                         <html:select property="rolid" styleClass="Campo">
                                            <c:forEach var="rol" items="${roles}">
                                                <html:option value="${rol.id}">
                                                <c:out value="${rol.nombre}"/>
                                                </html:option>
                                            </c:forEach>
                                         </html:select>
                                    </td>
				</tr>			
				<tr valign="middle" height="25px">
                                    <td align=center colspan=2><input type="submit" name="btnIngresar" value="Aceptar" class="boton" ></td>
                                    <td></td>
				</tr>
			</table>
                     <script>
                        document.forms[0].login.focus();
                     </script>
		</td>
	</tr>
	<tr height="15px" valign="bottom">
            <td width="100%" colspan=2 align="middle">
                    <!--font size=1>Copyright &#169; 2012. Todos los derechos reservados. Manpower. Lima - Perú</font-->
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

