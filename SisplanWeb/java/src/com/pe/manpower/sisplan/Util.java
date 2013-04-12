/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.manpower.sisplan;

/**
 *
 * @author G-AMARO
 */
public class Util {
    
    public static String getMesNombre(Integer mes){
      String descmes="";  
        
        switch(mes){
          case 1: descmes="ENERO";break;
          case 2: descmes="FEBRERO";break;
          case 3: descmes="MARZO";break;
          case 4: descmes="ABRIL";break;
          case 5: descmes="MAYO";break;
          case 6: descmes="JUNIO";break;
          case 7: descmes="JULIO";break;    
          case 8: descmes="AGOSTO";break;    
          case 9: descmes="SEPTIEMBRE";break;    
          case 10: descmes="OCTUBRE";break;    
          case 11: descmes="NOVIEMBRE";break;   
          case 12: descmes="DICIEMBRE";break;       
          default: descmes=""; 
        }
        
        return descmes;
    
    }
}
