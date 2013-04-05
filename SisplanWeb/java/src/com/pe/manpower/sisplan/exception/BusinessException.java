/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pe.manpower.sisplan.exception;

/**
 *
 * @author externo.gamaro
 */
public class BusinessException extends Exception{
  private static final long serialVersionUID = 1L;
	private static String msgError = "La transacción ha fallado";
        private String errorCode;
        
	public BusinessException(String string) {
		super(msgError + " : " + string);
	}

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

	public BusinessException() {
		super(msgError);
	}

	public BusinessException(Throwable cause) {
		super(msgError + " : " + cause.getMessage());

	}
	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public BusinessException(String message, String errorCode) {
		super(message);
		this.errorCode=errorCode;
	}
        
	public String toString(){
		return getMessage();
	}
}
