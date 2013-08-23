<%@ page contentType="text/html;charset=iso-8859-1" import="com.pe.manpower.sisplan.util.*"%>
<%@page import="com.pe.manpower.sisplan.to.Usuario"%>
<%
response.setHeader("Cache-Control","no-cache");
response.setHeader("Pragma","no-cache");
response.setDateHeader("Expires",0);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">



<title>
SISPLAN WEB
</title>
<script>
var num=6;
function Cerrar(){
  num=num - 1;
  if (num==0) {
   self.close();
  }
  document.getElementById("reloj").innerHTML = '<h4>Cerrando en... '+num+'</h4>';
  setTimeout("Cerrar()",1000);
}
</script>
</head>
<% 
   Usuario user= (Usuario) session.getAttribute("usr");
   String  form= request.getParameter("form");
   String  titulo=request.getParameter("titulo");
   String  ctrlTotal=request.getParameter("ctrltotal");
   String  url="";
   String  opcion=(String) session.getAttribute(form);
   Config  con=new Config();
  
   if(!(user==null)){
    // Pasamos parametros al form 
    con.setForm(form);
    con.setTitulo(titulo);
    con.setCtrlTotal(ctrlTotal);
    con.setId_session(session.getId());
    con.setNo_cia(String.format("%2s",user.getCia().getCodigo()).replace(' ','0'));
    url=con.getUrl();
    //
    if (opcion==null) {
      session.setAttribute(form,form);
      response.sendRedirect(response.encodeRedirectURL(url));
      //out.println(url);
      
    }else{
      out.println("<body onload='Cerrar()'>");
      out.println("<center><h4>Esta opción yá se encuentra cargada para esta sesión. <a href='javascript:window.close();'>Cerrar</a></h4></center>");
      out.println("<div id='reloj' align='center'></div>");
    }
   %> 
    <!--jsp:forward page="http://172.16.1.20:7778/forms90/f90servlet?config=sisplan&form=<%=form%>"/--> 
      
   <%}else{%>
   <h4>No esta iniciada la session. <a href="javascript:window.close();">Cerrar</a></h4>
<%}%>

</body>
</html>
