package com.guestbook.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.guestbook.exception.GuestBookException;
import com.guestbook.model.GuestEntryVO;
/**
 * GuestBook Service Interface
 * @author Anis Deepa
 *
 */
public interface GuestBookService {
	
	public List<GuestEntryVO> fetchAllGuestEntries() throws GuestBookException;
	
	public GuestEntryVO saveGuestEntry(GuestEntryVO guestEntry, MultipartFile file) throws GuestBookException;
	
	public String deleteGuestEntry(List<GuestEntryVO> guestEntryVOList) throws GuestBookException;
	
	public List<GuestEntryVO> saveGuestEntryList(List<GuestEntryVO> guestEntryVOList) throws GuestBookException;

}
