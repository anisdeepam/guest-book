package com.guestbook.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.guestbook.Constants.GuestBookAppConstants;
import com.guestbook.Constants.GuestBookViewConstants;
import com.guestbook.exception.GuestBookException;
/**
 * Exception Handling for GuestBook Controller
 * @author Anis Deepa
 *
 */
@ControllerAdvice
public class GuestBookExceptionHandler {
	
	Logger log = LoggerFactory.getLogger(GuestBookExceptionHandler.class);
	/**
	 * Exception handling for GuestBook custom exception
	 * @param guestBookException
	 * @param model
	 * @return viewName
	 */
	@ExceptionHandler(GuestBookException.class)
	public String handleGuestBookException(GuestBookException guestBookException, Model model){
		log.debug("GuestBookException ="+guestBookException.getCause());
		model.addAttribute(GuestBookAppConstants.GUEST_BOOK_EXCEPTION, guestBookException.getMessage());
	    return GuestBookViewConstants.ERROR_VIEW;
	}
	
	/**
	 * Exception handling for common exception
	 * @param exception
	 * @param model
	 * @return viewName
	 */
	@ExceptionHandler(Exception.class)
	public String handleCommonException(Exception exception, Model model){
		log.debug("CommonException ="+exception.getCause());
		model.addAttribute(GuestBookAppConstants.GUEST_BOOK_EXCEPTION, exception.getMessage());
	    return GuestBookViewConstants.ERROR_VIEW;
	}

}
