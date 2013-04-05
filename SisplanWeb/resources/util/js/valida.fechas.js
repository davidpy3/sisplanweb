/****************************
VALIDA FECHA INICIO Y FIN
******************************/
        function soloFecha(valor,keyCode,decimal){
            if(decimal == null) decimal = false;
                switch(keyCode){
                    case 8: break;
                    default:
                        var caracter = String.fromCharCode(keyCode);
                        var numeros  = "/1234567890";
                        var indice = numeros.indexOf(caracter);
                        if(indice == -1){
                                return false;
                        } else {
                                indice = valor.indexOf('/');
                                var indice2= valor.lastIndexOf('/')
                                if((caracter == '/' && !decimal) || (caracter == '/' && decimal && indice != indice2)){
                                        return false;
                                } else {
                                        return true;
                                }
                        }
                }
        }




/****************************
VALIDA FECHA INICIO Y FIN
******************************/
/*
  Retorna
   -1: en caso de errores de formatos
    1: en caso de que fecha1 sea mayor a la fecha2
    2: en caso de que fecha1 sea menor a la fecha2
    0: en caso de que fecha1 sea igual a la fecha2
*/
        function comparafecha(fecha1, fecha2){
         
          dia = fecha1.substring(0,2) //dia
          mes = fecha1.substring(3,5) //mes
          anho = fecha1.substring(6,10) //anho
          fecha1x = anho + mes + dia
          dia = fecha2.substring(0,2) //dia
          mes = fecha2.substring(3,5) //mes
          anho = fecha2.substring(6,10) //anho
          fecha2x = anho + mes + dia
          if ( fecha1x > fecha2x ){
            return 1
          } else if ( fecha1x < fecha2x ){
            return 2
          } else {
            return 0
          }
        }




/****************************
DIFERENCIAS DE DIAS
******************************/
        function diferenciaDias(fini,ffin){
                var dias = 0;
                if(checkdate(fini) && checkdate(ffin)){
                        var x = str2dt(fini);
                        var y = str2dt(ffin);
                        var mili = (y.getTime() - x.getTime());
                        dias = parseInt(mili / (1000*60*60*24));
                }

                return dias;
        }

/****************************
INCREMENTA DIAS
******************************/
        function incrementafecha(fecha,dias){
                var nueva = "";
                if(!checkdate(fecha)){
                        return nueva;
                }

                if(eval(dias) == 0){
                        return nueva;
                } else {
                        fecha = str2dt(fecha);
                        var mili = fecha.getTime();
                        dias = eval(dias * (1000*60*60*24));
                        var nueva = new Date();
                        nueva.setTime(mili + dias);
                        nueva=dt2dtstr(nueva);
                        return nueva;
                }
        }



/****************************
FECHA EN RANGO
******************************/
        function fechaenrango(fecha,fechamin,fechamax){
                var rpta = false;
                if((typeof(fechamin) == "object") && (typeof(fechamax) == "object")){
                        if((fecha >= fechamin) && (fecha <= fechamax)) {
                                rpta = true;
                        }
                }
                return rpta;
        }



/****************************
MES EN LETRAS
******************************/
/*
  Retorna el mes en Letras
  Donde mes es el numero del mes en el rango 1 hasta al 12
        may 1 o 0 para MAYUSCULAS o minusculas
        cap 1 o 0 para poner en mayusculas la primera letra o no
*/
        function mesenletras(mes, may, cap){
                var imes = parseInt(mes, 10);
                var tmes = "-";
                if ( imes == 1 ){
                        tmes = "enero";
                } else if ( imes == 2 ){
                        tmes = "febrero";
                } else if ( imes == 3 ){
                        tmes = "marzo";
                } else if ( imes == 4 ){
                        tmes = "abril";
                } else if ( imes == 5 ){
                        tmes = "mayo";
                } else if ( imes == 6 ){
                tmes = "junio";
                } else if ( imes == 7 ){
                tmes = "julio";
                } else if ( imes == 8 ){
                tmes = "agosto";
                } else if ( imes == 9 ){
                tmes = "setiembre";
                } else if ( imes == 10 ){
                tmes = "octubre";
                } else if ( imes == 11 ){
                tmes = "noviembre";
                } else if ( imes == 12 ){
                tmes = "diciembre";
                }

                if ( may == 1){
                tmes = tmes.toUpperCase();
                }

                if ( cap == 1){
                tmes = tmes.substring(0,1).toUpperCase() + tmes.substring(1, tmes.length);
                }

                return tmes;
        }