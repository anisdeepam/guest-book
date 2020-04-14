package com.guestbook.exception;

/**
 * GuestBook Custom Exception
 * @author Anis Deepa
 *
 */
public class GuestBookException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public GuestBookException(String message, Throwable cause){
		super(message, cause);
	}

}
