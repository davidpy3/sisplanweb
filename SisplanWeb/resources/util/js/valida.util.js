/****************************
CONVERTIR A MAYUSCULA
******************************/
        function convertirMayusculas(){
                var caracter = String.fromCharCode(event.keyCode);
                caracter = caracter.toUpperCase();
                event.keyCode = caracter.charCodeAt(0);
                return true;	
        }


/****************************
STRING TOKENIZER
******************************/
        function StringTokenizer(cad, delim){
          var cads = new Array();
          var n = cad.length;
          var j = 0;
          var ic = 0;
          for (i=0;i<n;i++){
            if ( cad.charAt(i)==delim ){
              cads[j] = cad.substring(ic, i);
              ic = i+1;
              j++;
            }
          }
          cads[j] = cad.substring(ic, n);
          return cads;
        }




/****************************
CORTA CADENA
******************************/
        function corta(campo, longitud, cars) {
          if (campo.value.length>longitud)
           campo.value=campo.value.substring(0,longitud);
          cuenta(campo, cars);
        }



/****************************
RELLENA CADENA
******************************/
        function rellena(dato, caracter, tamanho, posicion){
          dato_trim = trim(dato);
          len = dato_trim.length;
          dato_fill = "";
          for (var i=0;i<tamanho-len;i++){
            dato_fill = dato_fill + caracter;
          }

          if(posicion == "R"){
            dato_fill = dato_trim + dato_fill;
          }else{
            dato_fill = dato_fill + dato_trim;
          }

          return dato_fill;
        }


/****************************
ES NULO
******************************/
        function esnulo(campo){
                return (campo == null||campo=="");
        }


/****************************
ES NUMERO
******************************/
        function esnumero(campo){
                return (!(isNaN( campo )));
        }


/****************************
CONVERTIR MAYUSCULA
******************************/
        function convertirMayuscula(campo){
          return campo.toUpperCase();
        }


/****************************
CONVERTIR MINUSCULA
******************************/
        function convertirMinuscula(campo){
          return campo.toLowerCase();
        }


/****************************
ES LONGITUD
******************************/
        function eslongitud(campo, tamno){
          if ( campo.length == tamno ){
            return true;
          } else {
            return false;
          }
        }


/****************************
ESTA ENTRE
******************************/
        function estaEntre(campo, inicio, fin){
          if ( campo != null ){
            if ( campo.length >= inicio && campo.length <= fin ){
              return true;
            } else {
              return false;
            }
          } else {
            return false;
          }
        }


/****************************
MAXIMISAR PANTALLA
******************************/
        function maximize(){
          if (window.screen) {
            var aw = screen.availWidth;
            var ah = screen.availHeight;
            window.moveTo(0, 0);
            window.resizeTo(aw, ah);
          }
        }

/****************************
MAXIMISAR PANTALLA PARENT
******************************/
        function maximizeParent(){
          if (parent.window.screen) {
            var aw = screen.availWidth;
            var ah = screen.availHeight;
            parent.window.moveTo(0, 0);
            parent.window.resizeTo(aw, ah);
          }
        }


/****************************
TAMANO LARGO DE LA PANTALLA
******************************/
        function heightScreen(){
                return window.screen.height;
        }

/****************************
TAMANO ANCHO DE LA PANTALLA
******************************/
        function widthScreen(){
                return window.screen.width;
        }
        
/****************************
ENTER
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
function trim ( inputStringTrim ){ 
        fixedTrim = ""; 
        lastCh = " "; 
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


