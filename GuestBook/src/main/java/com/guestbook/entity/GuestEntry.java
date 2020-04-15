package com.guestbook.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Data;
/**
 * This is entity for GUEST_ENTRY table
 * @author Anis Deepa
 *
 */
@Data
@Entity
@Table(name = "GUEST_ENTRY", schema = "guestbook")
public class GuestEntry {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Size(max = 20)
	@Column(name="first_name")
	private String firstName;
	
	@Size(max = 20)
	@Column(name="last_name")
	private String lastName;
	
	@Size(max = 50)
	@Column(name="email_addr")
	private String emailAddr;
	
	@Size(max = 20)
	@Column(name="message")
	private String message;
	
	@Column(name="is_approved")
	private Boolean isApproved;
	
	@Column(name="guest_file")
	private byte[] guestFile;

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

	public byte[] getGuestFile() {
		return guestFile;
	}

	public void setGuestFile(byte[] guestFile) {
		this.guestFile = guestFile;
	}
}
