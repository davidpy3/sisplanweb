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
<div style="position:relative;width:600px;height:300px;border:2px solid #2D466F;">
<table valign="middle" border="0" width="506px" cellspacing="2" cellpadding="0" class=tabla>
   	<tr height=50px valign="middle">
		<td width="100%" colspan=2 align=middle class="TextoAzulTitulo1">Cambiar Contraseña</td>
	</tr>
	<tr height=20px>
		<td width="60%" align="center" >
			<table border="0" width="70%" class="tabla">
				<tr valign="middle" height="25px">
                                    <td width="100%" colspan=2 align=middle class="Titulo2AzulClaro">
                                        <font color="#FF0000" ><html:errors property="login" /></font>
                                        <font color="#FF0000" ><html:errors property="password"/></font>
                                    </td>
				</tr>
				<tr>
				  <td width="50%" class="TituloAzulClaro" >Usuario</td>
				  <td width="50%" class="FondoGris1">
                                     <%=usuario.getLogin() %>
                                     <html:hidden property="login" value="<%=usuario.getLogin() %>"/>
                                  </td>
				</tr>
                               
				<tr>
					<td class="TituloAzulClaro" >Nueva Contraseña</td>
					<td class="FondoGris1">
                                      <html:password property="password1" size="30" styleClass="Campo"  />
                                        </td>
				</tr>	
                                <tr>
					<td class="TituloAzulClaro" >Confirmar Contraseña</td>
					<td class="FondoGris1">
                                      <html:password property="password2" size="30" styleClass="Campo"  />
                                        </td>
				</tr>
				<tr valign="middle" height="25px">
				  <td align=right><input type="submit" name="btnIngresar" value="Cambiar" class="boton" ></td>
					<td><input type="button" name="btnLimpiar" value="Limpiar"  class="boton" onclick="Limpiar()"></td>
				</tr>
			</table>
		</td>
	</tr>
	
</table>
</div>
	
<!--/form-->
</html:form>
</center>
<!-- ===================================FIN DEL CUERPO==================================== -->
<% String strMsg="";
   strMsg=(String) request.getAttribute("msg");
   
   %>
<script language="javascript">
var mensaje = "<%=strMsg%>";

if (mensaje!="null"&&mensaje!=""){
    alert("<%=strMsg%>");
    
}

</script>           

</body>
</html>

