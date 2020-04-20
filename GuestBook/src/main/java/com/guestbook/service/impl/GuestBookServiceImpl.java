package com.guestbook.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.guestbook.constants.GuestBookAppConstants;
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
			List<GuestEntry> guestEntryList = guestBookRepository.findAll();
			if (Optional.ofNullable(guestEntryList).isPresent()) {
				guestEntryVOList = guestBookUtil.convertGuestEntryEntityToVOList(guestEntryList);
			}
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
	public String deleteGuestEntry(List<GuestEntryVO> guestEntryVOList) throws GuestBookException {
		log.debug("Method GuestBookServiceImpl.deleteGuestEntry");
		String response = GuestBookAppConstants.GUEST_BOOK_EMPTY;
		try {
			List<GuestEntry> guestEntryList = guestBookUtil.convertGuestEntryVOToEntityList(guestEntryVOList);
			if (Optional.ofNullable(guestEntryList).isPresent()) {
				guestBookRepository.deleteAll(guestEntryList);
				response = GuestBookAppConstants.SUCCESS;
			}
		} catch (Exception exception) {
			throw new GuestBookException("Error deleting Guest Entries from database", exception);
		}
		return response;
	}
	
	/**
	 * This method updates the guestbook entries
	 * @param guestEntryVOList
	 * @throws GuestBookException 
	 */
	@Override
	public List<GuestEntryVO> saveGuestEntryList(List<GuestEntryVO> guestEntryVOList) throws GuestBookException {
		log.debug("Method GuestBookServiceImpl.saveGuestEntryList");
		List<GuestEntry> guestEntryResponseList = new ArrayList<GuestEntry>();
		try {
			List<GuestEntry> guestEntryList = guestBookUtil.convertGuestEntryVOToEntityList(guestEntryVOList);
			if (Optional.ofNullable(guestEntryList).isPresent()) {
				guestEntryResponseList = guestBookRepository.saveAll(guestEntryList);
			}
		} catch (Exception exception) {
			throw new GuestBookException("Error updating Guest Entries ", exception);
		}
		return guestBookUtil.convertGuestEntryEntityToVOList(guestEntryResponseList);
	}
	
	/**
	 * This method adds new guestbook entry
	 * @param guestEntryVO
	 * @param guestFile
	 * @throws GuestBookException 
	 */
	@Override
	public GuestEntryVO saveGuestEntry(GuestEntryVO guestEntryVO, MultipartFile guestFile) throws GuestBookException {
		log.debug("Method GuestBookServiceImpl.saveGuestEntry");
		GuestEntry guestEntryResponse = new GuestEntry();
		try {
			GuestEntry guestEntry = new GuestEntry();
			BeanUtils.copyProperties(guestEntryVO, guestEntry); 
			guestEntry.setIsApproved(false);
			guestEntry.setGuestFile(guestFile.getBytes());
			guestEntryResponse = guestBookRepository.save(guestEntry);
		} catch (Exception exception) {
			throw new GuestBookException("Error Adding Guest Entry", exception);
		}
		return guestBookUtil.convertGuestEntryEntityToVO(guestEntryResponse);
	}

}
