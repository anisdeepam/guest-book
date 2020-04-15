package com.guestbook.model;

import java.io.Serializable;
/**
 * This is POJO for AdminEnryVO
 * @author Anis Deepa
 *
 */
public class AdminEntryVO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String firstName;

	private String lastName;

	private String emailAddr;
	
	private String message;
	
	private String isApproved;
	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmailAddr() {
		return emailAddr;
	}


	public void setEmailAddr(String emailAddr) {
		this.emailAddr = emailAddr;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getIsApproved() {
		return isApproved;
	}


	public void setIsApproved(String isApproved) {
		this.isApproved = isApproved;
	}


	@Override
    public String toString() {
        return "AdminEntryVO [id=" + id + ", firstName=" + firstName
                + ", lastName=" + lastName + ", emailAddr=" + emailAddr + ", message=" + message + ", isApproved=" + isApproved + "]";
    }
}
