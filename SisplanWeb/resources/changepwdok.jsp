<%@ page contentType="text/html;charset=iso-8859-1" language="java" %>
<%@ page import="com.pe.manpower.sisplan.to.*"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<html>
<head>
<title><bean:message key="application.title"/></title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">


<SCRIPT LANGUAGE=javascript>
<!--

	function Validar(theForm)
	{
          //var theForm=document.forms[0];
          
		
		if (theForm.password1.value == "")
		{
			alert("Debe ingresar la contraseña");
			theForm.password1.focus();
			return (false);
		}
                if (theForm.password2.value == "")
		{
			alert("Debe confirmar la contraseña");
			theForm.password2.focus();
			return (false);
		}
		if (theForm.password1.value == "" && theForm.password2.value == "")
		{
			alert("Debe confirmar la contraseña");
			theForm.password1.focus();
			return false;
		}	
                
                if (theForm.password1.value != theForm.password2.value)
		{
			alert("Las contraseñas no coinciden");
			theForm.password1.focus();
			return false;
		}
		
         	if (theForm.password1.value != "" && theForm.password2.value != "")
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
		//document.forms[0].login.value=""
		document.forms[0].password1.value=""
                document.forms[0].password2.value=""
		document.forms[0].password1.focus();
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
 if(usuario==null){%>
  <jsp:forward page="login.jsp" /> 
<%}
%> 
<!-- ==================================INICIO DEL CUERPO================================== -->
<center>
<!--form method="post" name="frmlogin" action="/loginUsuario?dispatch=validarUsuario" onSubmit="return Validar(this);"-->
<html:form action="/loginUsuario?dispatch=cambiarPassword" onsubmit="Validar(this);return false;">
<br />
<br>
<br>
<br>
<table valign="middle" border="0" width="506px" cellspacing="2" cellpadding="0" >
   	<tr height=50px valign="middle">
		<td width="100%" colspan=2 align=middle class="TituloAzulClaro">La contraseña del usuario <%=usuario.getLogin() %> se cambió correctamente</td>
	</tr>
	
	
</table>

	
<!--/form-->
</html:form>
</center>
<!-- ===================================FIN DEL CUERPO==================================== -->

</body>
</html>

