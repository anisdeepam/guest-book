package com.guestbook.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.guestbook.constants.GuestBookAppConstants;
import com.guestbook.entity.GuestEntry;
import com.guestbook.exception.GuestBookException;
import com.guestbook.model.GuestEntryVO;
import com.guestbook.repository.GuestBookRepository;
import com.guestbook.service.impl.GuestBookServiceImpl;
import com.guestbook.util.GuestBookUtil;

@RunWith(SpringJUnit4ClassRunner.class)
public class GuestBookServiceImplTest {
	
	@InjectMocks
	GuestBookServiceImpl guestBookServiceImpl;
	
	@Mock
	GuestBookRepository guestBookRepository;
	
	@Mock
	GuestBookUtil guestBookUtil;
	
	@Test
	public void test_fetchAllGuestEntries_postive() throws IOException, GuestBookException {
		List<GuestEntry> guestEntryList = new ArrayList<GuestEntry>();
		MockMultipartFile guestFile = new MockMultipartFile("data", "guest.png", "text/plain", "some data".getBytes());
		GuestEntry guestEntry = new GuestEntry();
		guestEntry.setFirstName("Joe");
		guestEntry.setLastName("Johnson");
		guestEntry.setEmailAddr("Joe.Johnson@gmail.com");
		guestEntry.setMessage(null);
		guestEntry.setIsApproved(false);
		guestEntry.setGuestFile(guestFile.getBytes());
		guestEntryList.add(guestEntry);
		
		List<GuestEntryVO> guestEntryResponseVOList = new ArrayList<GuestEntryVO>();
		GuestEntryVO guestEntryVO = new GuestEntryVO();
		guestEntryVO.setFirstName("Joe");
		guestEntryVO.setLastName("Johnson");
		guestEntryVO.setEmailAddr("Joe.Johnson@gmail.com");
		guestEntryVO.setMessage(null);
		guestEntryVO.setIsApproved(false);
		guestEntryVO.setSelected(false);
		guestEntryVO.setGuestFile(guestFile);
		guestEntryResponseVOList.add(guestEntryVO);
		
		when(guestBookRepository.findAll()).thenReturn(guestEntryList);
		when(guestBookUtil.convertGuestEntryEntityToVOList(guestEntryList)).thenReturn(guestEntryResponseVOList);
		
		List<GuestEntryVO> guestEntryResponseList = guestBookServiceImpl.fetchAllGuestEntries();		
		assertEquals(guestEntryResponseList,guestEntryResponseVOList);

	}
	
	@Test
	public void test_fetchAllGuestEntries_negative() throws IOException, GuestBookException {
		List<GuestEntry> guestEntryList = new ArrayList<GuestEntry>();
		MockMultipartFile guestFile = new MockMultipartFile("data", "guest.png", "text/plain", "some data".getBytes());
		GuestEntry guestEntry = new GuestEntry();
		guestEntry.setFirstName("Joe");
		guestEntry.setLastName("Johnson");
		guestEntry.setEmailAddr("Joe.Johnson@gmail.com");
		guestEntry.setMessage(null);
		guestEntry.setIsApproved(false);
		guestEntry.setGuestFile(guestFile.getBytes());
		guestEntryList.add(guestEntry);
		
		List<GuestEntryVO> guestEntryResponseVOList = new ArrayList<GuestEntryVO>();
		GuestEntryVO guestEntryVO = new GuestEntryVO();
		guestEntryVO.setFirstName("Joe");
		guestEntryVO.setLastName("Johnson");
		guestEntryVO.setEmailAddr("Joe.Johnson@gmail.com");
		guestEntryVO.setMessage(null);
		guestEntryVO.setIsApproved(false);
		guestEntryVO.setSelected(false);
		guestEntryVO.setGuestFile(guestFile);
		guestEntryResponseVOList.add(guestEntryVO);
		
		when(guestBookRepository.findAll()).thenReturn(guestEntryList);
		when(guestBookUtil.convertGuestEntryEntityToVOList(guestEntryList)).thenReturn(null);
		
		List<GuestEntryVO> guestEntryResponseList = guestBookServiceImpl.fetchAllGuestEntries();		
		assertNull(guestEntryResponseList);
	}
	
	@Test
	public void test_deleteGuestEntry_postive() throws IOException, GuestBookException {
		MockMultipartFile guestFile = new MockMultipartFile("data", "guest.png", "text/plain", "some data".getBytes());
		List<GuestEntryVO> guestEntryVOList = new ArrayList<GuestEntryVO>();
		GuestEntryVO guestEntryVO = new GuestEntryVO();
		guestEntryVO.setFirstName("Joe");
		guestEntryVO.setLastName("Johnson");
		guestEntryVO.setEmailAddr("Joe.Johnson@gmail.com");
		guestEntryVO.setMessage(null);
		guestEntryVO.setIsApproved(false);
		guestEntryVO.setSelected(false);
		guestEntryVO.setGuestFile(guestFile);
		guestEntryVOList.add(guestEntryVO);
		
		List<GuestEntry> guestEntryList = new ArrayList<GuestEntry>();
		GuestEntry guestEntry = new GuestEntry();
		guestEntry.setFirstName("Joe");
		guestEntry.setLastName("Johnson");
		guestEntry.setEmailAddr("Joe.Johnson@gmail.com");
		guestEntry.setMessage(null);
		guestEntry.setIsApproved(false);
		guestEntry.setGuestFile(guestFile.getBytes());
		
		when(guestBookUtil.convertGuestEntryVOToEntityList(guestEntryVOList)).thenReturn(guestEntryList);
		doNothing().when(guestBookRepository).deleteAll(guestEntryList);
		
		assertEquals(guestBookServiceImpl.deleteGuestEntry(guestEntryVOList),GuestBookAppConstants.SUCCESS);
	}

	@Test
	public void test_deleteGuestEntry_negative() throws IOException, GuestBookException {
		MockMultipartFile guestFile = new MockMultipartFile("data", "guest.png", "text/plain", "some data".getBytes());
		List<GuestEntryVO> guestEntryVOList = new ArrayList<GuestEntryVO>();
		GuestEntryVO guestEntryVO = new GuestEntryVO();
		guestEntryVO.setFirstName("Joe");
		guestEntryVO.setLastName("Johnson");
		guestEntryVO.setEmailAddr("Joe.Johnson@gmail.com");
		guestEntryVO.setMessage(null);
		guestEntryVO.setIsApproved(false);
		guestEntryVO.setSelected(false);
		guestEntryVO.setGuestFile(guestFile);
		guestEntryVOList.add(guestEntryVO);
		
		List<GuestEntry> guestEntryList = new ArrayList<GuestEntry>();
		GuestEntry guestEntry = new GuestEntry();
		guestEntry.setFirstName("Joe");
		guestEntry.setLastName("Johnson");
		guestEntry.setEmailAddr("Joe.Johnson@gmail.com");
		guestEntry.setMessage(null);
		guestEntry.setIsApproved(false);
		guestEntry.setGuestFile(guestFile.getBytes());
		
		when(guestBookUtil.convertGuestEntryVOToEntityList(guestEntryVOList)).thenReturn(null);
		doNothing().when(guestBookRepository).deleteAll(guestEntryList);
		
		assertEquals(guestBookServiceImpl.deleteGuestEntry(guestEntryVOList),GuestBookAppConstants.GUEST_BOOK_EMPTY);	
	}
	
	@Test
	public void test_saveGuestEntryList_postive() throws IOException, GuestBookException {
		
		MockMultipartFile guestFile = new MockMultipartFile("data", "guest.png", "text/plain", "some data".getBytes());
		List<GuestEntryVO> guestEntryVOList = new ArrayList<GuestEntryVO>();
		GuestEntryVO guestEntryVO = new GuestEntryVO();
		guestEntryVO.setFirstName("Joe");
		guestEntryVO.setLastName("Johnson");
		guestEntryVO.setEmailAddr("Joe.Johnson@gmail.com");
		guestEntryVO.setMessage(null);
		guestEntryVO.setIsApproved(false);
		guestEntryVO.setSelected(false);
		guestEntryVO.setGuestFile(guestFile);
		guestEntryVOList.add(guestEntryVO);
		
		List<GuestEntry> guestEntryList = new ArrayList<GuestEntry>();
		GuestEntry guestEntry = new GuestEntry();
		guestEntry.setFirstName("Joe");
		guestEntry.setLastName("Johnson");
		guestEntry.setEmailAddr("Joe.Johnson@gmail.com");
		guestEntry.setMessage(null);
		guestEntry.setIsApproved(false);
		guestEntry.setGuestFile(guestFile.getBytes());
		
		when(guestBookUtil.convertGuestEntryVOToEntityList(guestEntryVOList)).thenReturn(guestEntryList);
		when(guestBookRepository.saveAll(guestEntryList)).thenReturn(guestEntryList);
		when(guestBookUtil.convertGuestEntryEntityToVOList(guestEntryList)).thenReturn(guestEntryVOList);
		
		assertEquals(guestBookServiceImpl.saveGuestEntryList(guestEntryVOList),guestEntryVOList);
		
	}

	@Test
	public void test_saveGuestEntryList_negative() throws IOException, GuestBookException {
		
		MockMultipartFile guestFile = new MockMultipartFile("data", "guest.png", "text/plain", "some data".getBytes());
		List<GuestEntryVO> guestEntryVOList = new ArrayList<GuestEntryVO>();
		GuestEntryVO guestEntryVO = new GuestEntryVO();
		guestEntryVO.setFirstName("Joe");
		guestEntryVO.setLastName("Johnson");
		guestEntryVO.setEmailAddr("Joe.Johnson@gmail.com");
		guestEntryVO.setMessage(null);
		guestEntryVO.setIsApproved(false);
		guestEntryVO.setSelected(false);
		guestEntryVO.setGuestFile(guestFile);
		guestEntryVOList.add(guestEntryVO);
		
		List<GuestEntry> guestEntryList = new ArrayList<GuestEntry>();
		GuestEntry guestEntry = new GuestEntry();
		guestEntry.setFirstName("Joe");
		guestEntry.setLastName("Johnson");
		guestEntry.setEmailAddr("Joe.Johnson@gmail.com");
		guestEntry.setMessage(null);
		guestEntry.setIsApproved(false);
		guestEntry.setGuestFile(guestFile.getBytes());
		
		when(guestBookUtil.convertGuestEntryVOToEntityList(guestEntryVOList)).thenReturn(guestEntryList);
		when(guestBookRepository.saveAll(guestEntryList)).thenReturn(guestEntryList);
		when(guestBookUtil.convertGuestEntryEntityToVOList(guestEntryList)).thenReturn(null);
		
		assertNull(guestBookServiceImpl.saveGuestEntryList(guestEntryVOList));
	}
	
	@Test
	public void test_saveGuestEntry_postive() throws IOException, GuestBookException {
		MockMultipartFile guestFile = new MockMultipartFile("data", "guest.png", "text/plain", "some data".getBytes());
		GuestEntryVO guestEntryRequestVO = new GuestEntryVO();
		guestEntryRequestVO.setFirstName("Joe");
		guestEntryRequestVO.setLastName("Johnson");
		guestEntryRequestVO.setEmailAddr("Joe.Johnson@gmail.com");
		guestEntryRequestVO.setMessage(null);
		guestEntryRequestVO.setSelected(false);
		
		GuestEntry guestEntryResponse = new GuestEntry();
		guestEntryResponse.setId(1);
		guestEntryResponse.setFirstName("Joe");
		guestEntryResponse.setLastName("Johnson");
		guestEntryResponse.setEmailAddr("Joe.Johnson@gmail.com");
		guestEntryResponse.setMessage(null);
		guestEntryResponse.setGuestFile(guestFile.getBytes());
		
		GuestEntryVO guestEntryVO = new GuestEntryVO();
		guestEntryVO.setId(1);
		guestEntryVO.setFirstName("Joe");
		guestEntryVO.setLastName("Johnson");
		guestEntryVO.setEmailAddr("Joe.Johnson@gmail.com");
		guestEntryVO.setMessage(null);
		guestEntryVO.setGuestFile(guestFile);
		
		when(guestBookRepository.save(Mockito.any())).thenReturn(guestEntryResponse);
		when(guestBookUtil.convertGuestEntryEntityToVO(guestEntryResponse)).thenReturn(guestEntryVO);
		assertEquals(guestBookServiceImpl.saveGuestEntry(guestEntryRequestVO, guestFile),guestEntryVO);
	}

	@Test
	public void test_saveGuestEntry_negative() throws IOException, GuestBookException {
		MockMultipartFile guestFile = new MockMultipartFile("data", "guest.png", "text/plain", "some data".getBytes());
		GuestEntryVO guestEntryRequestVO = new GuestEntryVO();
		guestEntryRequestVO.setFirstName("Joe");
		guestEntryRequestVO.setLastName("Johnson");
		guestEntryRequestVO.setEmailAddr("Joe.Johnson@gmail.com");
		guestEntryRequestVO.setMessage(null);
		guestEntryRequestVO.setSelected(false);
		
		GuestEntry guestEntryResponse = new GuestEntry();
		guestEntryResponse.setId(1);
		guestEntryResponse.setFirstName("Joe");
		guestEntryResponse.setLastName("Johnson");
		guestEntryResponse.setEmailAddr("Joe.Johnson@gmail.com");
		guestEntryResponse.setMessage(null);
		guestEntryResponse.setGuestFile(guestFile.getBytes());
		
		GuestEntryVO guestEntryVO = new GuestEntryVO();
		guestEntryVO.setId(1);
		guestEntryVO.setFirstName("Joe");
		guestEntryVO.setLastName("Johnson");
		guestEntryVO.setEmailAddr("Joe.Johnson@gmail.com");
		guestEntryVO.setMessage(null);
		guestEntryVO.setGuestFile(guestFile);
		
		when(guestBookRepository.save(Mockito.any())).thenReturn(guestEntryResponse);
		when(guestBookUtil.convertGuestEntryEntityToVO(guestEntryResponse)).thenReturn(null);
		assertNull(guestBookServiceImpl.saveGuestEntry(guestEntryRequestVO, guestFile));
	}
}
