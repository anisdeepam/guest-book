package com.guestbook.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guestbook.entity.GuestEntry;
import com.guestbook.exception.GuestBookException;
import com.guestbook.model.GuestEntryVO;
import com.guestbook.repository.GuestBookRepository;
import com.guestbook.service.GuestBookService;
import com.guestbook.util.GuestBookUtil;
/**
 * 
 * This class has GuestBook Services which perform database CRUD operations
 * @author Anis Deepa
 *
 */
@Service
public class GuestBookServiceImpl implements GuestBookService{
	
	Logger log = LoggerFactory.getLogger(GuestBookServiceImpl.class);
	
	@Autowired
	private GuestBookRepository guestBookRepository;
	
	@Autowired
	private GuestBookUtil guestBookUtil;
	
	/**
	 * Retrieve method to fetch all guestbook entries
	 * @return GuestEntryVOList
	 * @throws GuestBookException 
	 */
	@Override
	public List<GuestEntryVO> fetchAllGuestEntries() throws GuestBookException {
		log.debug("Method GuestBookServiceImpl.fetchAllGuestEntries");
		List<GuestEntryVO> guestEntryVOList = new ArrayList<GuestEntryVO>();
		try {
			guestEntryVOList = guestBookUtil.convertGuestEntryEntityToVOList(guestBookRepository.findAll());
		} catch (Exception exception) {
			throw new GuestBookException("Error fetching Guest Entries from database", exception);
		}
	    return guestEntryVOList;
	}
	
	/**
	 * This method deletes the guestbook entries
	 * @param guestEntryVOList
	 * @throws GuestBookException 
	 */
	@Override
	public void deleteGuestEntry(List<GuestEntryVO> guestEntryVOList) throws GuestBookException {
		log.debug("Method GuestBookServiceImpl.deleteGuestEntry");
		try {
			guestBookRepository.deleteAll(guestBookUtil.convertGuestEntryVOToEntityList(guestEntryVOList));
		} catch (Exception exception) {
			throw new GuestBookException("Error deleting Guest Entries from database", exception);
		}
	}
	
	/**
	 * This method updates the guestbook entries
	 * @param guestEntryVOList
	 * @throws GuestBookException 
	 */
	@Override
	public void saveGuestEntryList(List<GuestEntryVO> guestEntryVOList) throws GuestBookException {
		log.debug("Method GuestBookServiceImpl.saveGuestEntryList");
		try {
			guestBookRepository.saveAll(guestBookUtil.convertGuestEntryVOToEntityList(guestEntryVOList));
		} catch (Exception exception) {
			throw new GuestBookException("Error updating Guest Entries ", exception);
		}
	}
	
	/**
	 * This method adds new guestbook entry
	 * @param guestEntryVO
	 * @throws GuestBookException 
	 */
	@Override
	public void saveGuestEntry(GuestEntryVO guestEntryVO) throws GuestBookException {
		log.debug("Method GuestBookServiceImpl.saveGuestEntry");
		try {
			GuestEntry guestEntry = new GuestEntry();
			BeanUtils.copyProperties(guestEntryVO, guestEntry); 
			guestEntry.setIsApproved(false);
			guestBookRepository.save(guestEntry);
		} catch (Exception exception) {
			throw new GuestBookException("Error Adding Guest Entry", exception);
		}
	}

}
