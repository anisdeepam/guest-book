package com.guestbook.model;

import java.io.Serializable;
import java.util.List;
/**
 * This is POJO for AdminFormVO
 * @author Anis Deepa
 *
 */
public class AdminFormVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private List<GuestEntryVO> entries;

	public List<GuestEntryVO> getEntries() {
		return entries;
	}

	public void setEntries(List<GuestEntryVO> entries) {
		this.entries = entries;
	}
}
