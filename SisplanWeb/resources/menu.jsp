<%@ page import="com.pe.manpower.sisplan.to.Menu"%>
<%@ page import="java.util.List;"%>
<html>
<head>
        <link rel="stylesheet" href="themes/ui-lightness/jquery.ui.all.css">
	<script src="jquery-1.9.1.js"></script>
	<script src="ui/jquery.ui.core.js"></script>
	<script src="ui/jquery.ui.widget.js"></script>
	<script src="ui/jquery.ui.position.js"></script>
	<script src="ui/jquery.ui.menu.js"></script>
	<link rel="stylesheet" href="demos.css">
	<script>
	$(function() {
		$( "#menu" ).menu();
	});
	</script>
	<style>
	.ui-menu { width: 200px; }
	</style>   
</head>
<body>
    
       <% List<Menu> listMenu=(List<Menu>) request.getSession().getAttribute("listMenu");
               
               %>   

    <ul id="menu">
        <% for(int i=0;i<listMenu.size();i++) {
        Menu menu=(Menu)listMenu.get(i);
      
        if(menu.getTipo().equals("M")){
         %>
        <li><a href="#"><span><%=menu.getTitulo()%></span></a>
          <ul>
        <%  // Hijos del parent 
           for(int j=0;j<listMenu.size();j++) {
             Menu menudet=(Menu) listMenu.get(j);
             if(menudet.getTipo().equals("I")) {
              if(menudet.getParentid().equals(menu.getMenuid())){ %>
               <li><a href="javascript:<%=menudet.getUrl() %>"><span><%=menudet.getTitulo()%></span></a></li> 
              
            <%  }
             }              
           } 
        %>
        </ul>
        </li>
       <%  
        }
        %>
            
        <%}%> 
    </ul>

</body>
</html>