package com.guestbook.util;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.guestbook.entity.GuestEntry;
import com.guestbook.model.GuestEntryVO;
/**
 * GuestBook Utility
 * @author Anis Deepa
 *
 */
@Component
public class GuestBookUtil {
	
	   Logger log = LoggerFactory.getLogger(GuestBookUtil.class);
	
	  /**
	   * This method converts List of GuestEntry entities to List of GuestEntryVO objects
	   * @param guestEntryList
	   * @return guestEntryVOList
	   */
	  public List<GuestEntryVO> convertGuestEntryEntityToVOList(List<GuestEntry> guestEntryList) {
		  log.debug("Method GuestBookUtil.convertGuestEntryEntityToVOList");
		  List<GuestEntryVO> guestEntryVOList = guestEntryList.stream().map(guestEntry -> {
			GuestEntryVO guestEntryVO = new GuestEntryVO();
			BeanUtils.copyProperties(guestEntry, guestEntryVO);
			guestEntryVO.setSelected(false);
			return guestEntryVO;
		 })
		.collect(Collectors.toList());
		return guestEntryVOList;
	  }
	  /**
	   * This method converts List of GuestEntryVO objects to List of GuestEntryVO entities
	   * @param guestEntryVOList
	   * @return guestEntryList
	   */
	  public List<GuestEntry> convertGuestEntryVOToEntityList(List<GuestEntryVO> guestEntryVOList) {
		  log.debug("Method GuestBookUtil.convertGuestEntryVOToEntityList");
			List<GuestEntry> guestEntryList = guestEntryVOList.stream().filter(guestEntryVO -> guestEntryVO.getSelected()).map(guestEntryVO -> {
				GuestEntry guestEntry = new GuestEntry();
				BeanUtils.copyProperties(guestEntryVO, guestEntry);
				return guestEntry;
			 })
			.collect(Collectors.toList());
			return guestEntryList;
	  }
	  
	  /**
	   * This method converts GuestEntry entity to GuestEntryVO
	   * @param guestEntry
	   * @return guestEntryVO
	   */
	  public GuestEntryVO convertGuestEntryEntityToVO(GuestEntry guestEntry) {
		  	log.debug("Method GuestBookUtil.convertGuestEntryEntityToVO");
		  	GuestEntryVO guestEntryVO = new GuestEntryVO();
		  	BeanUtils.copyProperties(guestEntry, guestEntryVO); 
			return guestEntryVO;
	  }
}
