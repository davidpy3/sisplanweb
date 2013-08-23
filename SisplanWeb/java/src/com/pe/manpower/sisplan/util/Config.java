/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.manpower.sisplan.util;

import java.util.Properties;
import java.io.*;
//import util.*;



public class Config 
{ 
  public static String config_file_name;


  public static String config_file_path;
  public static String url_forms;
  public static String url_webapp;
  public static String app;
  public static int cargasep;
  public static boolean ok=false;
  private String file="config.properties";
  private String mensaje;
  private String form;
  private String titulo;
  private String report;
  private String id_session;
  private String no_cia;
  private String rep_params;
  private String ctrlTotal;
  public Config()
  {
    
  }
  public void setTitulo(String newtitulo){
    titulo=newtitulo;
  }
  public String getTitulo(){
   return titulo;
  }
  public void setRep_params(String newrep_params){
    rep_params=newrep_params;
  }
  public void setReport(String newreport){
     report=newreport;
  }
  public String getMensaje(){
   return mensaje;
  }
  public String getForm(){
    return form;
  }
  public void setNo_cia(String newno_cia){
     no_cia=newno_cia;
  }
  public void setForm(String newForm){
     form=newForm;
  }
  public String getId_session(){
    return id_session;
  }
  public boolean IsOk(){
    return ok;
  }
 /* public String getUrlrep(Cia cia){
    String url_rep="";
    String params="";
    Conecta con=new Conecta();
    if(con.isOkPool()){
      if (this.rep_params!=null){
        params="&"+this.rep_params;
      }
      url_rep=cia.getOas_server_name()+"/reports/rwservlet?destype=cache&desformat="+cia.getTipo_formato_rep()+
              "&server="+cia.getRep_server_name()+"&report="+report+"&userid="+
              con.getUser()+"/"+con.getPasswd()+"@"+con.getDb()+params;
    
    }
    return url_rep;
  }*/
  public String getUrl(){
    String url_addr="";
    String query_only="NO";
    // Si el parametro form tiene extension HTML,JSP,HTM se abre como pagina simple
    //  De lo contrario se retorna la direccion del FORMS SERVER
    if((this.form.toLowerCase().endsWith("html"))||(this.form.toLowerCase().endsWith("htm"))||(this.form.toLowerCase().endsWith("jsp")))
    {
      url_addr=form;
    }else
    { // Sino no tiene control total se llama al form como query_only=YES
      if (ctrlTotal.equals("N")){
         titulo = titulo + " (Sólo Consulta)";
         query_only="YES";
      }
      url_addr=this.url_forms+"&form="+this.form.toLowerCase() +"&pageTitle="+this.titulo+"&otherParams=query_only="+query_only+"+p_idsession="+this.id_session+
             "+p_config_file_path="+this.config_file_path+"+p_config_file_name="+this.config_file_name+
             "+p_cia="+this.no_cia+"+p_url_webapp="+this.url_webapp;     
    }
    
    
    return url_addr;
  }
  
  public void setId_session(String newId){
     id_session=newId;
  }
  public int getCargaSep(){
    return cargasep;
  }
  public boolean loadProperties(){
    boolean result=false;
    Properties prop=new Properties();
    InputStream in=getClass().getResourceAsStream(file);
    try{  prop.load(in);
          this.config_file_name=prop.getProperty("config.file_name");
          this.config_file_path=prop.getProperty("config.file_path");
          this.url_forms=prop.getProperty("config.url_forms");
          this.url_webapp=prop.getProperty("config.url_webapp");
          this.app=prop.getProperty("config.app");
          this.cargasep=Integer.parseInt(prop.getProperty("config.cargasep"));



          result=true;
          this.ok=true;
    }catch(Exception e){mensaje=e.getMessage();System.out.println(e.getStackTrace());}
    return result;
  }

  public String getCtrlTotal()
  {
    return ctrlTotal;
  }

  public void setCtrlTotal(String newCtrlTotal)
  {
    ctrlTotal = newCtrlTotal;
  }























}