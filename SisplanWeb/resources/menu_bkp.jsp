<%@ page import="com.pe.manpower.sisplan.to.Menu"%>
<%@ page import="java.util.List;"%>
<html>
<head>
     <title>Style 14 (Steel Blue) - Menu by Apycom.com</title>
    <link type="text/css" href="menu.css" rel="stylesheet" />
    <script type="text/javascript" src="jquery.js"></script>
    <script type="text/javascript" src="menu.js"></script>
<style type="text/css">
div#copyright { display: none; }
</style>    
</head>
<body>
    
       <% List<Menu> listMenu=(List<Menu>) request.getSession().getAttribute("listMenu");
               
               %>   
<div id="menu">
    <ul class="menu">
        <% for(int i=0;i<listMenu.size();i++) {
        Menu menu=(Menu)listMenu.get(i);
      
        if(menu.getTipo().equals("M")){
         %>
        <li><a href="#" class="parent"><span><%=menu.getTitulo()%></span></a>
          <div><ul>
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
        </ul></div>
        </li>
       <%  
        }
        %>
            
        <%}%> 
    </ul>
</div>
<div id="copyright">Copyright &copy; 2012 <a href="http://apycom.com/">Apycom jQuery Menus</a></div>
</body>
</html>