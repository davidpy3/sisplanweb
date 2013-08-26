<%-- 
    Document   : index.jsp
    Created on : 11/09/2012, 03:23:04 PM
    Author     : G-AMARO
--%>
<%
response.setHeader("Cache-Control","no-cache");
response.setHeader("Pragma","no-cache");
response.setHeader("Location","index.jsp");
response.setDateHeader("Expires",-1);

%>
<%@page import="com.pe.manpower.sisplan.to.Usuario"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><bean:message key="application.title"/></title>
         <script language="javascript" src="js/utils.js"></script>
        <link href="css/espacio.css" type="text/css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/calendar-system.css" type="text/css" rel="stylesheet">
        <script language="javascript" src="${pageContext.request.contextPath}/util/js/calendario.js"></script>
        <script language="javascript" src="${pageContext.request.contextPath}/js/calendar.js"></script>
    </head>
  <script>  
    function Cerrar(){
                         
         document.forms[0].submit();
                
       }
    function openPage(urlDoc, targetFrame){
	if(targetFrame==null)
		targetFrame = "_self";	
	document.open(urlDoc,targetFrame,"",true);
     }
    function loadPage(urlDoc){	
	document.open(urlDoc,"FraMain","",true);
     }   
  </script>              
    <body>
    <% 
 // Validacion de Sesion
 Usuario usuario=(Usuario) session.getAttribute("usr");
 if(usuario==null){
   %>
  <jsp:forward   page="login.jsp" /> 
<%}%>  
<table height="100%" cellspacing="0" cellpadding="0" width="100%" align="center" border=0>
  <tbody>
  <tr height="1">
    <td style="height: 57px;" width="100%" bgcolor="#ffffff">
      <table width="100%" border="0">
        <tbody>
        <tr>
          <td align="left"><img src="imagenes/aLogo.gif" border="0"></td>
          <td align="center" valign="bottom">
              <br>
              <b>Compañia:</b><span class="subtitulog11"> <%=usuario.getCia().getNombre()%></span><br>
              <b>Usuario:</b><span class="subtitulog11"> <%=usuario.getNombre() + " " + usuario.getAp_pat() %></span><br>
              <b>Perfil:</b><span class="subtitulog11"> <%=usuario.getRol().getNombre() %></span>
              
          </td>
          <td align="right">
          <table  cellspacing="0" cellpadding="0"  border=0>
                    <tbody>
                        <tr><td valign="top">
                              <b> <bean:message key="application.title"/></b>  
                                
                            </td></tr>
                        <tr>
                            <td align="right" valign="bottom">
                                <br><br>
                                  <html:form action="/loginUsuario?dispatch=cerrarSesion" >
                                  </html:form>    
                              <img height="10" src="imagenes/flechamenu.gif" width=10> 
                              <strong><a class=lnkcab href="javascript:Cerrar();" >Terminar sesion</a></strong> 
                            </td>
                        </tr>
                    </tbody>
           </table>
          
          </td>
        </tr>
        </tbody>
      </table>
     </td>
  </tr>

               <tr height="100%">
                  <td  ><!--MENU-->
                   <table height="100%" cellspacing="0" cellpadding="0" width="100%" align="center" border=0>
                      <tr height="100%">
                      <td width="20%" ><%@ include file="menu.jsp" %></td>    
                      <td width="80%" >
                       <iframe name="FraMain" src="blank.jsp" frameBorder=yes width="100%" height="100%">
                       </iframe> 
                      </td>
                       </tr>
                   </table>
                  </td>  
                   
               </tr>
              </tbody>
    </table>  
   
    </body>
</html>
