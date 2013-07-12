/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pe.manpower.sisplan.form;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author externo.gamaro
 */
public class LoginForm extends org.apache.struts.action.ActionForm {
    
   private String login;
   private String password;
   private String password1;
   private String password2;
   private String no_cia;
   private Integer rolid;

    public String getNo_cia() {
        return no_cia;
    }

    public void setNo_cia(String no_cia) {
        this.no_cia = no_cia;
    }

    public Integer getRolid() {
        return rolid;
    }

    public void setRolid(Integer rolid) {
        this.rolid = rolid;
    }

   
    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }
   
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
   
   
}
