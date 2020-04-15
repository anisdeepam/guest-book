package com.guestbook.model;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;
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
	
	private String messageOption;
	
	private MultipartFile guestFile;

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
	
	public String getMessageOption() {
		return messageOption;
	}

	public void setMessageOption(String messageOption) {
		this.messageOption = messageOption;
	}

	public MultipartFile getGuestFile() {
		return guestFile;
	}

	public void setGuestFile(MultipartFile guestFile) {
		this.guestFile = guestFile;
	}

	@Override
    public String toString() {
        return "GuestEntryVO [selected=" + selected + ",id=" + id + ", firstName=" + firstName
                + ", lastName=" + lastName + ", emailAddr=" + emailAddr + ", message=" + message + ", isApproved=" + isApproved + "]";
    }

}
