package com.guestbook.model;

import java.io.Serializable;
/**
 * This is POJO for GuestEntryVO
 * @author Anis Deepa
 *
 */
public class GuestEntryVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Boolean selected;
	
	private Integer id;

	private String firstName;

	private String lastName;

	private String emailAddr;
	
	private String message;
	
	private Boolean isApproved;
	
	public Boolean getSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}

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
	
    public Boolean getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(Boolean isApproved) {
		this.isApproved = isApproved;
	}

	@Override
    public String toString() {
        return "GuestEntryVO [id=" + id + ", firstName=" + firstName
                + ", lastName=" + lastName + ", emailAddr=" + emailAddr + "]";
    }

}
