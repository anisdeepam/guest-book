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
	
	public void saveGuestEntry(GuestEntryVO guestEntry, MultipartFile file) throws GuestBookException;
	
	public void deleteGuestEntry(List<GuestEntryVO> guestEntryVOList) throws GuestBookException;
	
	public void saveGuestEntryList(List<GuestEntryVO> guestEntryVOList) throws GuestBookException;

}
