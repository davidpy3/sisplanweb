<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<c:set var="insertUpdateTitle" value="${!empty UsuarioForm.usuario ?'Editar Usuario':'Nuevo Usuario'}"/>
<html>
<head>
    <link href="<c:url value='main.css'/>" rel="stylesheet" type="text/css"/>
    <style>td { white-space:nowrap; }</style>
    <title><c:out value="${insertUpdateTitle}"/></title>
</head>
<body>
<!--div class="titleDiv"><fmt:message key="application.title"/></div-->
<h1><c:out value="${insertUpdateTitle}"/></h1>
<html:form action="/userProcess">
    <table>
         <tr>
            <td class="tdLabel">Usuario:</td>
            <td><html:text property="login" size="30"/>
                 <html:errors property="login"/>
            </td>
        </tr>
         <tr>
            <td class="tdLabel">Staff:</td>
            <td><html:text property="cod_staff" size="30"/>
                 <html:errors property="cod_staff"/>
            </td>
        </tr>
         <tr>
            <td class="tdLabel">Nombres:</td>
            <td><html:text property="nombre" size="50"/>
                 <html:errors property="nombre"/>
            </td>
        </tr>
         <tr>
            <td class="tdLabel">Ap Paterno:</td>
            <td><html:text property="ap_pat" size="50"/>
                 <html:errors property="ap_pat"/>
            </td>
        </tr>
         <tr>
            <td class="tdLabel">Ap Materno:</td>
            <td><html:text property="ap_mat" size="50"/>
                 <html:errors property="ap_mat"/>
            </td>
        </tr>
        <tr>
            <td class="tdLabel">Tipo Documento:</td>
            <td><html:select property="tipo_doc_id">
                  <html:option value="">
                     
                  </html:option>
                  <html:option value="1">
                      DNI
                  </html:option>
                  <html:option value="4">
                      C.Ext
                  </html:option>
                  <html:option value="7">
                      Pasaporte
                  </html:option>    
                </html:select>
                  
                <html:errors property="tipo_doc_id"/></td>
        </tr>
         <tr>
            <td class="tdLabel">Num Doc Id:</td>
            <td><html:text property="num_doc_id" size="15"/>
                 <html:errors property="num_doc_id"/>
            </td>
        </tr>
        <tr>
            <td class="tdLabel">Estado:</td>
            <td><html:select property="activo">
                  <html:option value="S">
                      ACTIVO
                  </html:option>
                  <html:option value="N">
                      INACTIVO
                  </html:option>
                </html:select>
                  
                <html:errors property="activo"/></td>
        </tr>
        <tr>
            <td class="tdLabel">Email:</td>
            <td><html:text property="email" size="50"/>
                 <html:errors property="email"/>
            </td>
        </tr>
        <tr>
            <td class="tdLabel">Rep Legal:</td>
            <td><html:select property="id_repre_legal">
                  <html:option value="S">
                      SI
                  </html:option>
                  <html:option value="N">
                      NO
                  </html:option>
                </html:select>
                <html:errors property="id_repre_legal"/></td>
        </tr>
        <tr>
            <td class="tdLabel">Notif. Venc Contratos:</td>
            <td><html:select property="ind_not_ven_cont">
                  <html:option value="S">
                      SI
                  </html:option>
                  <html:option value="N">
                      NO
                  </html:option>
                </html:select>
                <html:errors property="ind_not_ven_cont"/></td>
        </tr>
        <tr>
            <td class="tdLabel">Ruta Impresion:</td>
            <td><html:text property="ruta_impresion" size="50"/>
                 <html:errors property="ruta_impresion"/>
            </td>
        </tr>
        <tr>
            <td class="tdLabel">Usuario BD:</td>
            <td><html:text property="usuario_db" size="30"/>
                 <html:errors property="usuario_db"/>
            </td>
        </tr>
        <tr>
            <td class="tdLabel">Password BD:</td>
            <td><html:password property="password_db" size="30"/>
                 <html:errors property="password_db"/>
            </td>
        </tr>
        
        <tr>
            <td colspan="2">
                <input type="hidden" name="dispatch" value="insertOrUpdate"/>
                <br/>
                <input type="submit" value="<fmt:message key="button.label.submit"/>" class="butStnd"/>
                &nbsp;&nbsp;&nbsp;
                <input type="submit" value="<fmt:message key="button.label.cancel"/>"  class="butStnd" onclick="document.UsuarioForm.dispatch.value='getAllUsers'"/>
            </td>
        </tr>
    </table>
</html:form>
</body>
</html>