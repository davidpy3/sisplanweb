/****************************
ENTER => Submit Form
******************************/
        function enter(form_name){
            var tecla;     if(navigator.appName.indexOf("Netscape") != -1)
                tecla= event.which; 
            else tecla= event.keyCode;
                var key = String.fromCharCode(tecla);
            if (tecla== 13){	
                  document.forms[form_name].submit();
            }            	
        }

/****************************
ENTER => Next Element
******************************/
        function isEnter(nextTab){
            if(event.keyCode==13){
                        if(null!=document.all[nextTab])
                                document.all[nextTab].focus();
            }
        }

/****************************
VALIDA BLANCOS
******************************/
        function trim (inputStringTrim){ 
            fixedTrim = ""; 
            lastCh = ""; 
            for (x=0; x < inputStringTrim.length; x++){ 
                ch = inputStringTrim.charAt(x); 
                if ((ch != " ") || (lastCh != " ")){ 
                        fixedTrim += ch;        
                } 
                lastCh = ch; 
            } 
            if (fixedTrim.charAt(fixedTrim.length - 1) == " "){ 
                fixedTrim = fixedTrim.substring(0, fixedTrim.length - 1); 
            } 
            return fixedTrim ;
        } 


/****************************
VALIDA TECLA
******************************/
        function validatecla(tipo,textbox){
   
            var tecla; 
            if(navigator.appName.indexOf("Netscape")!= -1){    		
                tecla= event.keyCode;    
            }
            else {
                tecla= event.keyCode;    
            }

            var key = String.fromCharCode(tecla);

            /*---Mayuscula---*/
            key = key.toUpperCase();

            event.keyCode = key.charCodeAt(0);
            var numeros = "0123456789";
            var especiales="'#�()_;:�[]{}!�/?�``��+�=&%$*";
            var letras = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnÑn??OoPpQqRrSsTtUuVvWwXxYyZz??????????";
             
            if (tipo == 'letras'){
                if ( tecla == 32 ){
                	return true;  
                	}
                if ( letras.indexOf( key ) != -1 ){
        		return true; 
        		}
                return false;
            }

            if (tipo == 'enteros'){
                if ( numeros.indexOf( key ) != -1   ) {
                	return true;
                }
                return false; 
            }
        
           if (tipo == 'decimales'){
               if ( numeros.indexOf( key ) != -1 ){ return true;}
               var cadena = textbox.value;
               if ( cadena.indexOf( '.' ) != -1 ){ return false; }
              if ( tecla == 46 ){ return true;}
               return false; 
           }
            if (tipo == 'NoNumeros'){
                if ( tecla == 32 ) {return true;  }
               if ( numeros.indexOf( key ) != -1 || especiales.indexOf( key ) != -1 ) {return false; }
               return true;
            }

                 if (tipo == 'especiales'){
                if ( tecla == 32 ) {return true;}  
               if ( especiales.indexOf( key ) != -1 ) {return false; }
              return true;
            }

                if (tipo == 'todo'){
                if ( tecla == 32 ) {return true;}  
               if ( numeros.indexOf( key ) != -1 || especiales.indexOf( key ) != -1 || letras.indexOf( key ) != -1 ){ return false;} 
               return true;
            }

        }

        

        /****************************
        VALIDA MAIL
        ******************************/
                function checkMail(input_mail)
                {
                        var x = document.all[input_mail].value;
                        var filter  = "/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/";
                        if (filter.test(x)) return true;
                        else return false;
                }

                
                /****************************
                VALIDA RUC
                ******************************/
        function valruc(valor){
          valor = trim(valor);
      
          if ( esnumero(valor)) {
            if ( valor.length == 8 ){
              suma = 0;
              for (i=0; i<valor.length-1;i++){
                digito = valor.charAt(i) - '0';
                if ( i==0 ){
                	suma += (Number(digito)*2);
                }else{
                	suma += (Number(digito)*Number(valor.length-i));
                }
              }
              resto = suma % 11;
              if ( resto == 1) resto = 11;
              if ( resto + ( valor.charAt( valor.length-1 ) - '0' ) == 11 ){
                return true;
              }
            } else if ( valor.length == 11 ){
              suma = 0;
              x = 6;
              for (i=0; i<valor.length-1;i++){
                if ( i == 4 ) x = 8;
                digito = valor.charAt(i) - '0';
                x--;
                if ( i==0 ) suma += Number(digito*x);
                else suma += Number(digito*x);
              }
              resto = suma % 11;
              resto = 11 - resto;

              if ( resto >= 10) resto = resto - 10;
              if ( resto == valor.charAt( valor.length-1 ) - '0' ){
                return true;
              }      
            }
          }
          return false;
        }


        
        

        /*****************************
        valida fecha
        *********************************/
        function validaFecha2(fecsus,fecini){
           
        		var iDia="";
        		var iMes="";
        		var iAnio="";
        		
        		var fDia="";
        		var fMes="";
        		var fAnio="";
        					
        			iAnio=fecsus.substr(6 , 4); 			
        			iMes=fecsus.substr(3 , 2); 
        			iDia=fecsus.substr(0 , 2); 	
        			
        		
        			
        			fAnio=fecini.substr(6 , 4); 			
        			fMes=fecini.substr(3 , 2); 
        			fDia=fecini.substr(0 , 2); 	
        	
        			
        			if(fAnio>=iAnio){
        				if(fMes>=iMes){
        					if(fDia>=iDia){
        						return true;
        					}else{
        						return false;
        					}
        				}else{
        					return false;
        				}
        			}else{
        				return false;
        			}
        	
        }
        


        function validaFecha3(fecini,fecfin){
           
        		var iDia="";
        		var iMes="";
        		var iAnio="";
        		
        		var fDia="";
        		var fMes="";
        		var fAnio="";
        					
        			iAnio=fecini.substr(6 , 4); 			
        			iMes=fecini.substr(3 , 2); 
        			iDia=fecini.substr(0 , 2); 	
        			
        		
        			
        			fAnio=fecfin.substr(6 , 4); 			
        			fMes=fecfin.substr(3 , 2); 
        			fDia=fecfin.substr(0 , 2); 	
        	
        			
        			if(fAnio>=iAnio){
        				if(fMes>=iMes){
        					if(fDia>iDia){
        						return true;
        					}else{
        						return false;
        					}
        				}else{
        					return false;
        				}
        			}else{
        				return false;
        			}
        	
        }
