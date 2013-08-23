<%
response.setHeader("Cache-Control","no-cache");
response.setHeader("Pragma","no-cache");
response.setDateHeader("Expires",0);
%>
<%@ page import="com.pe.manpower.sisplan.to.Menu"%>
<%@ page import="java.util.List;"%>
<% List<Menu> listMenu=(List<Menu>) request.getSession().getAttribute("listMenu");
    String xmlString="";     
         
    for(int i=0;i<listMenu.size();i++) {
        Menu menu=(Menu)listMenu.get(i);
      
        if(menu.getTipo().equals("M")&&menu.getParentid()==0){
         
           xmlString=xmlString+"<nodo label=\""+menu.getTitulo()+"\" dirurl=\"#\">";
       
           // Hijos del parent 
           for(int j=0;j<listMenu.size();j++) {
               
             Menu menudet=(Menu) listMenu.get(j);
             
             if(menudet.getTipo().equals("M")&&menudet.getParentid().equals(menu.getMenuid())){
               
               xmlString=xmlString+"<nodo label=\""+menudet.getTitulo()+"\" dirurl=\"#\">";                    
               
               for(int k=0;k<listMenu.size();k++) {
                 Menu menudet2=(Menu) listMenu.get(k);   
                 if(menudet2.getTipo().equals("I")&&menudet2.getParentid().equals(menudet.getMenuid())){
                   if(menudet2.getIndweb().equals("W")){
                     
                       xmlString=xmlString+"<nodo label=\""+menudet2.getTitulo()+"\" dirurl=\"javascript:"+menudet2.getUrl()+"\"></nodo>";        
                   
                   }else{
                   
                       xmlString=xmlString+"<nodo label=\""+menudet2.getTitulo()+"\" dirurl=\"javascript:Open('"+menudet2.getUrl()+"\','"+menudet2.getTitulo()+"\','"+"S"+"\')\"></nodo>";     
                   
                   }
                 }          
               }                          
               xmlString=xmlString+"</nodo>"; 
             }else if(menudet.getTipo().equals("I")&&menudet.getParentid().equals(menu.getMenuid())) {
               
                if(menudet.getTipo().equals("I")) {
                  
                  if(menudet.getIndweb().equals("W")){
                     
                      xmlString=xmlString+"<nodo label=\""+menudet.getTitulo()+"\" dirurl=\"javascript:"+menudet.getUrl()+"\"></nodo>";        
                   
                   }else{
                      
                      xmlString=xmlString+"<nodo label=\""+menudet.getTitulo()+"\" dirurl=\"javascript:Open('"+menudet.getUrl()+"\','"+menudet.getTitulo()+"\','"+"S"+"\')\"></nodo>";   
                   
                   }
                }  
             
             } 
                          
           } 
          xmlString=xmlString+"</nodo>";
  
        }

     }
    out.print(xmlString);
  %>