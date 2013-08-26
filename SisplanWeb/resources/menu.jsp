<html>
<head>
<title>Menu</title>
<script language='JavaScript'>
   bgColorIn='#652B2B';
   bgColorOut='#008000';
  function logOff(){
	  document.frmMenu.action.value='salir';
	  document.frmMenu.submit();
    //alert(document.frmMenu.action.value);
	 }
  function showStatus(estado){
	   window.status=estado;
   }
  function clrStatus(){
	  window.status='MANPOWER - Sistema de Planillas';
  } 

  function Open(opcion,titulo,control){
    var url='open_form.jsp?form='+opcion+'&titulo='+titulo+'&ctrltotal='+control;
    var alto=screen.height-(0.1*screen.height);
    var ancho=screen.width;
    var date=new Date();
    var minutes = date.getMinutes();
		var seconds = date.getSeconds();
    var win='M'+minutes+'S'+seconds;
    window.open(url,win, "height="+alto+",width="+ancho+",left=0,top=0,location=no,menubar=no,resizable=no,scrollbars,status,toolbar=no");
    
  } 
</script>
</head>
<body bgcolor="#669999" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<table width="230" border="0" cellpadding="0" cellspacing="0" bordercolor="#669999">
    <tr>
      <td width="230" valign="top" align="left" bgcolor="#669999">
       <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="230" height="450">
         <param name="movie" value="Tree.swf">
         <param name="quality" value="high">
         <embed src="Tree.swf" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="230" height="450"></embed>
       </object>
      </td>
    </tr>
</table>
 <form  name="frmMenu" action="menuAction.do" method="post">
    <input type="hidden" name="action" value="">
    <input type="hidden" name="contador" value="0">
    
 </form >
</body>
</html>