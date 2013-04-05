// JavaScript Document

/**********************************************
** crea una ventana popup
*************************************************/
var dtCh= "/";
var minYear=1900;
var maxYear=2100;

function getNumFecha(dateString,dateSeperator)
{
//This function return a date object after accepting
//a date string ans dateseparator as arguments
var curValue=dateString;
var sepChar=dateSeperator;
var curPos=0;
var cDate,cMonth,cYear;

//extract day portion
curPos=dateString.indexOf(sepChar);
cDate=dateString.substring(0,curPos);
//extract month portion
endPos=dateString.indexOf(sepChar,curPos+1); 
cMonth=dateString.substring(curPos+1,endPos);
//extract year portion
curPos=endPos;
endPos=curPos+5;
cYear=curValue.substring(curPos+1,endPos);

var fechaNum = parseInt(cYear+cMonth+cDate); 
//Create Date Object
//dtObject=new Date(cYear,cMonth,cDate);
return fechaNum;
}  

function getFechaActual(){
    var dtoday = new Date();
    var dia = dtoday.getDate();
      if (dia<10) dia='0'+dia;
      
    var mes=dtoday.getMonth()+1;
      if (mes<10) mes='0'+mes;
    
    var anio=dtoday.getFullYear();
    var fecha = dia+'/'+mes+'/'+anio;
    
    return fecha;
}

function isInteger(s){
	var i;
    for (i = 0; i < s.length; i++){   
        // Check that current character is number.
        var c = s.charAt(i);
        if (((c < "0") || (c > "9"))) return false;
    }
    // All characters are numbers.
    return true;
}

function stripCharsInBag(s, bag){
	var i;
    var returnString = "";
    // Search through string's characters one by one.
    // If character is not in bag, append to returnString.
    for (i = 0; i < s.length; i++){   
        var c = s.charAt(i);
        if (bag.indexOf(c) == -1) returnString += c;
    }
    return returnString;
}

function daysInFebruary (year){
	// February has 29 days in any year evenly divisible by four,
    // EXCEPT for centurial years which are not also divisible by 400.
    return (((year % 4 == 0) && ( (!(year % 100 == 0)) || (year % 400 == 0))) ? 29 : 28 );
}
function DaysArray(n) {
	for (var i = 1; i <= n; i++) {
		this[i] = 31
		if (i==4 || i==6 || i==9 || i==11) {this[i] = 30}
		if (i==2) {this[i] = 29}
   } 
   return this
}

function isDate(dtStr){
	var daysInMonth = DaysArray(12)
	var pos1=dtStr.indexOf(dtCh)
	var pos2=dtStr.indexOf(dtCh,pos1+1)
	var strDay=dtStr.substring(0,pos1)
	var strMonth=dtStr.substring(pos1+1,pos2)
	var strYear=dtStr.substring(pos2+1)
	strYr=strYear
	if (strDay.charAt(0)=="0" && strDay.length>1) strDay=strDay.substring(1)
	if (strMonth.charAt(0)=="0" && strMonth.length>1) strMonth=strMonth.substring(1)
	for (var i = 1; i <= 3; i++) {
		if (strYr.charAt(0)=="0" && strYr.length>1) strYr=strYr.substring(1)
	}
	month=parseInt(strMonth)
	day=parseInt(strDay)
	year=parseInt(strYr)
	if (pos1==-1 || pos2==-1){
		alert("El formato de fecha debe ser : dd/mm/yyyy")
		return false
	}
	if (strMonth.length<1 || month<1 || month>12){
		alert("Mes invalido")
		return false
	}
	if (strDay.length<1 || day<1 || day>31 || (month==2 && day>daysInFebruary(year)) || day > daysInMonth[month]){
		alert("Dia invalido")
		return false
	}
	if (strYear.length != 4 || year==0 || year<minYear || year>maxYear){
		alert("Ingrese un valor de 4 digitos para el año entre "+minYear+" and "+maxYear)
		return false
	}
	if (dtStr.indexOf(dtCh,pos2+1)!=-1 || isInteger(stripCharsInBag(dtStr, dtCh))==false){
		alert("Fecha invalida")
		return false
	}
return true
}

function textonly(e){

var code;
if (!e) var e = window.event;
if (e.keyCode) code = e.keyCode;
else if (e.which) code = e.which;
var character = String.fromCharCode(code);
//alert('Character was ' + character);
    //alert(code);
    //if (code == 8) return true;
    var AllowRegex  = /^[\ba-zA-Z\s-]$/;
    if (AllowRegex.test(character)) return true;     
    return false; 
}

function numberonly(e){

var code;
if (!e) var e = window.event;
if (e.keyCode) code = e.keyCode;
else if (e.which) code = e.which;
var character = String.fromCharCode(code);
//alert('Character was ' + character);
    //alert(code);
    //if (code == 8) return true;
    
    var AllowRegex  = /^([0-9])*$/;
    if (AllowRegex.test(character)) return true;     
    return false; 
}

function popUp(URL) {
day = new Date();
id = day.getTime();
eval("page" + id + " = window.open(URL, '" + id + "', 'toolbar=0,scrollbars=0,location=0,statusbar=0,menubar=0,resizable=0,width=400,height=480');");
}

function openWindow(url,w,h){
	var win = window.open(url,"newwin","width=" + w + ",height="+ h+ ",status=yes,toolbar=no,menubar=no",true);
	win.focus();
	return win;	
}

/********************************************************************
*Valida el ingreso de caracteres a un control de texto
*
*********************************************************************/
var DEC_PATTERN=/\d{0,}\.?\d{0,2}/;
var SDEC_PATTERN=/\-?\d{0,}\.?\d{0,2}/;
var DBL_PATTERN=/\d{0,}\.?\d{0,}/;
var INT_PATTERN=/\d{0,}/;
var SINT_PATTERN=/\-?\d{0,}/;
var FEC_PATTERN=/\d{0,2}\/?\d{0,2}\/?\d{0,4}/; 
var TEL_PATTERN=/(\d{0,}\-*)*/; 
var ALFA_PATTERN=/[\w\s\.\-]*/; 
var LETTER_PATTERN=/[A-Za-z\s]*/; 


function validKey(format){
	var text = event.srcElement.value + String.fromCharCode(event.keyCode);
	var arr = format.exec(text);
	return (arr!=null && text==arr[0]);
}

/**********************************************
** Valida formularios
*************************************************/
function _findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function validateForm() { //v4.0
  var i,p,q,nm,test,num,min,max,errors='',args=validateForm.arguments;
  for (i=0; i<(args.length-2); i+=3) { test=args[i+2]; val=_findObj(args[i]);
    if (val) { nm=args[i+1]!=''?args[i+1]:val.name; //etiqueta
    if ((val=val.value)!="") {
      if(test.indexOf('isDate')!=-1){
      	if(!isDate(val)) errors+='-'+nm+' debe contener una fecha v�lida con formato (dd/mm/yyyy).\n';
      }else if (test.indexOf('isEmail')!=-1) { p=val.indexOf('@');
        if (p<1 || p==(val.length-1)) errors+='- '+nm+' debe contener una direcci�n de correo.\n';
      } else if (test!='R') { num = parseFloat(val);
        if (isNaN(val)) errors+='- '+nm+' debe contener un n�mero.\n';
        if (test.indexOf('inRange') != -1) { p=test.indexOf(':');
          min=test.substring(8,p); max=test.substring(p+1);
          if (num<min || max<num) errors+='- '+nm+' debe contener un n�mero entre '+min+' y '+max+'.\n';
    } } } else if (test.charAt(0) == 'R') errors += '- '+nm+' es obligatorio.\n'; }
  } if (errors) alert('Han ocurrido los siguientes errores:\n'+errors);
  return (errors == '');
}

/**********************************************
** controla tama�o de un TEXTAREA
*************************************************/
var _EVT_PASTE=1;
var _EVT_KEYPRESS=2;

function checkSize(size){
	var _txa = event.srcElement;
 if(event.type=='keypress'){
	if(_txa.value.length>=size)event.keyCode=0;	
 }else if(event.type=='paste'){
	var ttp = window.clipboardData.getData("Text");
	if(_txa.value.length+ttp.length>size)
		event.returnValue=false; 
 }
}

/**********************************************
** obtiene la pagina de referencia url.
*************************************************/

function openDoc(url){
	window.navigate(getPath(url));
}

/*********************************************
** Resizing logic
**********************************************/
var _resizables = null;
function setResizableElements(){
	_resizables=arguments;
	window.onresize= function(){
		frawidth = window.frameElement.offsetWidth-40;		
		//alert(frawidth);	
		resize(frawidth);
	}
	window.onload=function(){
		frawidth = window.frameElement.offsetWidth-40;		
		//alert(frawidth + ", doleft:"+window.screenLeft+","+window.rightMargin);
		resize(frawidth);
	}		
}
function resize(maxwidth){
	for(i=0;i<_resizables.length;i++){
		var obj = document.getElementById(_resizables[i]);
		//alert("resizing.." + _resizables[i] + " is null " + (obj==null));
		if(obj!=null) {obj.style.width=maxwidth;}
	}
}

/***************************************************************
** Pinta la fila cuando selecciona un checkbox o raddiobutton
****************************************************************/
	function getParentRow(object){
		return getParentElement(object,"TR");
	}
	function getParentElement(object, tag){
		var parentObj=object;
		do{
			parentObj=parentObj.parentElement;	
		}while(parentObj.tagName!=tag);	
		return parentObj;			
	}
	function prueba(src){
		var tr = getParentRow(src);
		if(tr==null) return;
		if(src.checked)
			tr.style.backgroundColor='#B0C4DE';
		else
			tr.style.backgroundColor='white';
	}
	function pintarUnico(name){
		var frm=document.forms[0];
		var chks = frm.elements(name);
		if(chks==null)return;
		if(typeof chks.length=='undefined') return;
		for(i=0;i<chks.length;i++){
			prueba(chks[i]);
			//if(chks[i].checked)return true;
		}
	}

/***************************************************************
** Iluminar la fila conforme se marque con el mouse
****************************************************************/
	function highlightTableRows(tableId) {
          var previousClass = null;
          var table = document.getElementById(tableId);
          if(table !=null){
                 var tbody = table.getElementsByTagName("tbody")[0];
		if (tbody == null) {
			var rows = table.getElementsByTagName("tr");
		} else {
			var rows = tbody.getElementsByTagName("tr");
		}
		// add event handlers so rows light up and are clickable
		for (i=0; i < rows.length; i++) {
			rows[i].onmouseover = function() {
				previousClass=this.className;
				this.className+="over" 
				//alert(this.className)
			};
			rows[i].onmouseout = function() {
				
				///alert(previousClass)
				this.className=previousClass 
			};
			rows[i].onclick = function() {
                          /*var cell = this.getElementsByTagName("td")[0];
                          var link = cell.getElementsByTagName("a")[0];
                          location.href = link.getAttribute("href");*/
                          //this.style.cursor="wait";
                        }
               }
             }
                
 }
 
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
	var numeros = "0123456789"
	var especiales="'#ï¿½()_;:ï¿½[]{}!ï¿½/?ï¿½``ï¿½ï¿½+ï¿½=&%$*"
        var letras = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnÃ‘n??OoPpQqRrSsTtUuVvWwXxYyZz??????????"
        var simbolo = "-Ss/Nn"
        var numerosDni = "0123456789-"

    if (tipo == 'letras'){
       if ( tecla == 32 ) return true;  
       if ( letras.indexOf( key ) != -1 ) return true; 
       return false;
    }

//validación hecha para que en el DNI acepte "-" cuando es un menor de edad
    if (tipo == 'numerosDni'){
        if ( numerosDni.indexOf( key ) != -1   ) return true;
        return false; 
   }
//
   if (tipo == 'enteros'){
        if ( numeros.indexOf( key ) != -1   ) return true;
        return false; 
   }
  
   if (tipo == 'decimales'){
       if ( numeros.indexOf( key ) != -1 ) return true;
       var cadena = textbox.value;
       if ( cadena.indexOf( '.' ) != -1 ) return false; 
       if ( tecla == 46 ) return true;
       return false; 
   }
     if (tipo == 'NoNumeros'){
        if ( tecla == 32 ) return true;  
       if ( numeros.indexOf( key ) != -1 || especiales.indexOf( key ) != -1 ) return false; 
       return true;
    }
	
	 if (tipo == 'especiales'){
        if ( tecla == 32 ) return true;  
       if ( especiales.indexOf( key ) != -1 ) return false; 
       return true;
    }
	
    if (tipo == 'aceptatodo'){
        if ( tecla == 32 ) return true;  
       if ( numeros.indexOf( key ) != -1 || especiales.indexOf( key ) != -1 || letras.indexOf( key ) != -1 ) return true; 
       return true;
    }




	if (tipo == 'todo'){
        if ( tecla == 32 ) return true;  
       if ( numeros.indexOf( key ) != -1 || especiales.indexOf( key ) != -1 || letras.indexOf( key ) != -1 ) return false; 
       return true;
    }
    
    if(tipo == 'NumLetS'){ 	
		if ( numeros.indexOf( key ) != -1 || letras.indexOf( key ) != -1 || simbolo.indexOf( key ) != -1) return true; 
		return false;
	}
	
	if (tipo == 'NumS'){
        if ( numeros.indexOf( key ) != -1 || simbolo.indexOf( key ) != -1 ) return true;
        return false; 
   }
	
	if(tipo == 'LetS'){
		if ( letras.indexOf( key ) != -1 || simbolo.indexOf( key ) != -1  ) return true; 
       	return false;
	}
} 

  
 var primerslap=false; 
var segundoslap=false; 

function formateafecha(fecha) 
{ 
var long = fecha.length; 
var dia; 
var mes; 
var ano; 

if ((long>=2) && (primerslap==false)) { dia=fecha.substr(0,2); 
if ((IsNumeric(dia)==true) && (dia<=31) && (dia!="00")) { fecha=fecha.substr(0,2)+"/"+fecha.substr(3,7); primerslap=true; } 
else { fecha=""; primerslap=false;} 
} 
else 
{ dia=fecha.substr(0,1); 
if (IsNumeric(dia)==false) 
{fecha="";} 
if ((long<=2) && (primerslap=true)) {fecha=fecha.substr(0,1); primerslap=false; } 
} 
if ((long>=5) && (segundoslap==false)) 
{ mes=fecha.substr(3,2); 
if ((IsNumeric(mes)==true) &&(mes<=12) && (mes!="00")) { fecha=fecha.substr(0,5)+"/"+fecha.substr(6,4); segundoslap=true; } 
else { fecha=fecha.substr(0,3);; segundoslap=false;} 
} 
else { if ((long<=5) && (segundoslap=true)) { fecha=fecha.substr(0,4); segundoslap=false; } } 
if (long>=7) 
{ ano=fecha.substr(6,4); 
if (IsNumeric(ano)==false) { fecha=fecha.substr(0,6); } 
else { if (long==10){ if ((ano==0) || (ano<1900) || (ano>2100)) { fecha=fecha.substr(0,6); } } } 
} 

if (long>=10) 
{ 
fecha=fecha.substr(0,10); 
dia=fecha.substr(0,2); 
mes=fecha.substr(3,2); 
ano=fecha.substr(6,4); 
// Año no viciesto y es febrero y el dia es mayor a 28 
if ( (ano%4 != 0) && (mes ==02) && (dia > 28) ) { fecha=fecha.substr(0,2)+"/"; } 
if ( mes == 4 || mes == 6 || mes == 9 || mes == 11 ){ if (dia==31) fecha=fecha.substr(0,2)+"/"; }
} 
return (fecha); 
}    

function IsNumeric(valor) 
{ 
var log=valor.length; var sw="S"; 
for (x=0; x<log; x++) 
{ v1=valor.substr(x,1); 
v2 = parseInt(v1); 
//Compruebo si es un valor numérico 
if (isNaN(v2)) { sw= "N";} 
} 
if (sw=="S") {return true;} else {return false; } 
}

// End -->
