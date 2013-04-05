/* Simple AJAX Code-Kit (SACK) v1.6.1 */
/* �2005 Gregory Wild-Smith */
/* www.twilightuniverse.com */
/* Software licenced under a modified X11 licence,
   see documentation or authors website for more details */

function sack(file) {
	this.xmlhttp = null;

	this.resetData = function() {
		this.method = "POST";
  		this.queryStringSeparator = "?";
		this.argumentSeparator = "&";
		this.URLString = "";
		this.encodeURIString = true;
  		this.execute = false;
  		this.element = null;
		this.elementObj = null;
		this.requestFile = file;
		this.vars = new Object();
		this.responseStatus = new Array(2);
  	};

	this.resetFunctions = function() {
  		this.onLoading = function() { };
  		this.onLoaded = function() { };
  		this.onInteractive = function() { };
  		this.onCompletion = function() { };
  		this.onError = function() { };
		this.onFail = function() { };
	};

	this.reset = function() {
		this.resetFunctions();
		this.resetData();
	};

	this.createAJAX = function() {
		try {
			this.xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e1) {
			try {
				this.xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e2) {
				this.xmlhttp = null;
			}
		}

		if (! this.xmlhttp) {
			if (typeof XMLHttpRequest != "undefined") {
				this.xmlhttp = new XMLHttpRequest();
			} else {
				this.failed = true;
			}
		}
	};

	this.setVar = function(name, value){
		this.vars[name] = Array(value, false);
	};

	this.encVar = function(name, value, returnvars) {
		if (true == returnvars) {
			return Array(encodeURIComponent(name), encodeURIComponent(value));
		} else {
			this.vars[encodeURIComponent(name)] = Array(encodeURIComponent(value), true);
		}
	}

	this.processURLString = function(string, encode) {
		encoded = encodeURIComponent(this.argumentSeparator);
		regexp = new RegExp(this.argumentSeparator + "|" + encoded);
		varArray = string.split(regexp);
		for (i = 0; i < varArray.length; i++){
			urlVars = varArray[i].split("=");
			if (true == encode){
				this.encVar(urlVars[0], urlVars[1]);
			} else {
				this.setVar(urlVars[0], urlVars[1]);
			}
		}
	}

	this.createURLString = function(urlstring) {
		if (this.encodeURIString && this.URLString.length) {
			this.processURLString(this.URLString, true);
		}

		if (urlstring) {
			if (this.URLString.length) {
				this.URLString += this.argumentSeparator + urlstring;
			} else {
				this.URLString = urlstring;
			}
		}

		// prevents caching of URLString
		this.setVar("rndval", new Date().getTime());

		urlstringtemp = new Array();
		for (key in this.vars) {
			if (false == this.vars[key][1] && true == this.encodeURIString) {
				encoded = this.encVar(key, this.vars[key][0], true);
				delete this.vars[key];
				this.vars[encoded[0]] = Array(encoded[1], true);
				key = encoded[0];
			}

			urlstringtemp[urlstringtemp.length] = key + "=" + this.vars[key][0];
		}
		if (urlstring){
			this.URLString += this.argumentSeparator + urlstringtemp.join(this.argumentSeparator);
		} else {
			this.URLString += urlstringtemp.join(this.argumentSeparator);
		}
	}

	this.runResponse = function() {
		eval(this.response);
	}

	this.runAJAX = function(urlstring) {
		if (this.failed) {
			this.onFail();
		} else {
			this.createURLString(urlstring);
			if (this.element) {
				this.elementObj = document.getElementById(this.element);
			}
			if (this.xmlhttp) {
				var self = this;
				if (this.method == "GET") {
					totalurlstring = this.requestFile + this.queryStringSeparator + this.URLString;
					this.xmlhttp.open(this.method, totalurlstring, true);
				} else {
					this.xmlhttp.open(this.method, this.requestFile, true);
					try {
						this.xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded")
					} catch (e) { }
				}

				this.xmlhttp.onreadystatechange = function() {
					switch (self.xmlhttp.readyState) {
						case 1:
							self.onLoading();
							break;
						case 2:
							self.onLoaded();
							break;
						case 3:
							self.onInteractive();
							break;
						case 4:
							self.response = self.xmlhttp.responseText;
							self.responseXML = self.xmlhttp.responseXML;
							self.responseStatus[0] = self.xmlhttp.status;
							self.responseStatus[1] = self.xmlhttp.statusText;

							if (self.execute) {
								self.runResponse();
							}

							if (self.elementObj) {
								elemNodeName = self.elementObj.nodeName;
								elemNodeName.toLowerCase();
								if (elemNodeName == "input"
								|| elemNodeName == "select"
								|| elemNodeName == "option"
								|| elemNodeName == "textarea") {
									self.elementObj.value = self.response;
								} else {
									self.elementObj.innerHTML = self.response;
								}
							}
							if (self.responseStatus[0] == "200") {
								self.onCompletion();
							} else {
								self.onError();
							}

							self.URLString = "";
							break;
					}
				};

				this.xmlhttp.send(this.URLString);
			}
		}
	};

	this.reset();
	this.createAJAX();
}


/* A partir de esta linea empiezo */
/* a crear mis propios metodos creando para ello */
/* un objeto de la clase sack*/

function removeOptions(lista){
	if(lista!=null){
		while(lista.options.length){
			lista.remove(lista.options.length-1);
		}
	}
}

var ajax = new sack();


function comboSeccion(obj){	
      if(obj.options[obj.selectedIndex].value != ""){
          ajax.setVar("cod", obj.options[obj.selectedIndex].value);
          ajax.requestFile = "comboseccion.htm";
          ajax.method = "POST";
          ajax.onCompletion = comboSeccionCom;
          ajax.runAJAX();
      }
}

function comboSeccionCom(){
      var lista = document.getElementById('cbSeccion'); 
      removeOptions(lista);
      var tmp = ajax.response;//.split(",");
      tmp = tmp.split(",");
      lista.options[0] = new Option("-Seleccionar-", "");
      for(var i=1;i<tmp.length;i++){
              var temp = tmp[i].split("=");
              lista.options[i] = new Option(temp[1], temp[0]);
      }
}

function comboProcedimiento(obj){	
      if(obj.options[obj.selectedIndex].value != ""){
          ajax.setVar("cod", obj.options[obj.selectedIndex].value);
          ajax.requestFile = "comboProcedimiento.htm";
          ajax.method = "POST";
          ajax.onCompletion = comboProcedimientoCom;
          ajax.runAJAX();
      }
}

function comboProcedimientoCom(){
      var lista = document.getElementById('cbProcedimiento'); 
      removeOptions(lista);
      var tmp = ajax.response;//.split(",");
      tmp = tmp.split(",");
      lista.options[0] = new Option("-Seleccionar-", "");
      for(var i=1;i<tmp.length;i++){
              var temp = tmp[i].split("=");
              lista.options[i] = new Option(temp[1], temp[0]);
      }
}



function comboGiro(obj){	
      if(obj.options[obj.selectedIndex].value != ""){
          ajax.setVar("cod", obj.options[obj.selectedIndex].value);
          ajax.requestFile = "comboGiro.htm";
          //en plananualcontroller
          ajax.method = "POST";
          ajax.onCompletion = comboGiroCom;
          ajax.runAJAX();
      }
}

function comboGiroCom(){
      var lista = document.getElementById('cbGiro'); 
      removeOptions(lista);
      var tmp = ajax.response;//.split(",");
      tmp = tmp.split(",");
      lista.options[0] = new Option("-Seleccionar-", "");
      for(var i=1;i<tmp.length;i++){
              var temp = tmp[i].split("=");
              lista.options[i] = new Option(temp[1], temp[0]);
      }
}
function comboInspectores(tipofuncion,giro,empresa,tpInspeccion){
      if(tipofuncion.options[tipofuncion.selectedIndex].value != ""){
          ajax.setVar("codtf", tipofuncion.options[tipofuncion.selectedIndex].value);
          ajax.setVar("codgiro", giro.options[giro.selectedIndex].value);
          ajax.setVar("codempresa", empresa.options[empresa.selectedIndex].value);
          var tpinspc = tpInspeccion.options[tpInspeccion.selectedIndex].value;
          if(tpinspc==1){
              ajax.setVar("codTipoInspec", 1);
          }else{
              ajax.setVar("codTipoInspec", 2);
          }
          ajax.requestFile = "comboInspectores.htm";
          ajax.method = "POST";
          ajax.onCompletion = comboInspectoresCom;
          ajax.runAJAX();
      }
}

function comboInspectores2(tipofuncion,giro,empresa,tpInspeccion){
      if(tipofuncion != ""){
          ajax.setVar("codtf", tipofuncion);
          ajax.setVar("codgiro", giro);
          ajax.setVar("codempresa", empresa);
          var tpinspc = tpInspeccion;
          if(tpinspc==1){
              ajax.setVar("codTipoInspec", 1);
          }else{
              ajax.setVar("codTipoInspec", 2);
          }
          ajax.requestFile = "comboInspectores.htm";
          ajax.method = "POST";
          ajax.onCompletion = comboInspectoresCom;
          ajax.runAJAX();
      }
}

function comboInspectoresCom(){
      var lista = document.getElementById('cbInspector'); 
      removeOptions(lista);
      var tmp = ajax.response;
      tmp = tmp.split(";");
      lista.options[0] = new Option("-Seleccionar-", "");
      for(var i=1;i<tmp.length;i++){
              var temp = tmp[i].split("=");
              lista.options[i] = new Option(temp[1], temp[0]);
      }
}