<html>
<head>
<title>
Cerrando Forma...
</title>
<script language='JavaScript'>

function Close(){
  self.close();
}
</script>
<%
   String form=request.getParameter("form");
   session.removeAttribute(form);
   String  opcion=(String) session.getAttribute(form);
%>
</head>
<body onload="Close()">
</body>
</html>