/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pe.manpower.sisplan.exception;

/**
 *
 * @author externo.gamaro
 */
public class TransactionException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private static String msgError = "La transacción ha fallado";

	public TransactionException(String string) {
		super(msgError + " : " + string);
	}

	public TransactionException() {
		super(msgError);
	}

	public TransactionException(Throwable cause) {
		super(msgError + " : " + cause.getMessage());

	}
	
	public String toString(){
		return getMessage();
	}

}