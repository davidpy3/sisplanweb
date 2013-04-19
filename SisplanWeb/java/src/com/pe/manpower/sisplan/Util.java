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
 public static String toInitCap(String param) {
		if(param != null && param.length()>0){			
			char[] charArray = param.toCharArray(); // convert into char array
                        char[] newText = new char[charArray.length];
                        boolean isSpace=false;
                        int newIndex=0;
			for(int i=0;i<charArray.length;i++){
                           if((charArray[i]!=' ')&&(charArray[i]!='.')&&(charArray[i]!=';')&&(charArray[i]!='*')&&(charArray[i]!='°')
                                    &&(charArray[i]!='¿')&&(charArray[i]!='?')&&(charArray[i]!='¡')&&(charArray[i]!='!')&&(charArray[i]!=',')&&(charArray[i]!='|')) {
                              if(isSpace||i==0) {
                                newText[newIndex] = Character.toUpperCase(charArray[i]); // set capital letter to first postion
                                isSpace=false;
                                newIndex++;
                              }else{
                                newText[newIndex] = Character.toLowerCase(charArray[i]); // set capital letter to first postion
                                newIndex++;
                              }
                           }else{
                             isSpace=true;
                           }
                           
                        }
                        char[] finalText=new char[newIndex];
                        for(int i=0;i<newIndex;i++){
                          finalText[i] = newText[i]; // set capital letter to first postion
                        }
			return new String(finalText); // return desired output
		}else{
			return "";
		}
	}


public static void main(String[] args){

      System.out.println(Util.toInitCap("el pollo; de *los ¡¡°palotes."));
     
}

}