package com.guestbook.controller;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.support.SessionStatus;

import com.guestbook.constants.GuestBookAppConstants;
import com.guestbook.constants.GuestBookViewConstants;
import com.guestbook.exception.GuestBookException;
import com.guestbook.model.AdminFormVO;
import com.guestbook.model.GuestEntryVO;
import com.guestbook.service.GuestBookService;

@RunWith(SpringJUnit4ClassRunner.class)
public class GuestBookControllerTest {
	
	@InjectMocks
	GuestBookController guestBookController;
	
	@Mock
	GuestBookService guestBookService;
	
	@Mock
	private Model model;
	
	@Test
	public void test_homePage_postive() throws Exception {
		assertEquals(GuestBookViewConstants.HOME_PAGE_VIEW, guestBookController.homePage());
	}
	
	@Test
	public void test_homePage_negative() throws Exception {
		assertNotEquals(GuestBookViewConstants.GUEST_PAGE_VIEW, guestBookController.homePage());
	}
	
	@Test
	public void test_guestPage_positive(){
	     assertEquals(GuestBookViewConstants.GUEST_PAGE_VIEW, guestBookController.guestPage(model));
	}
	
	@Test
	public void test_guestPage_negative(){
	     assertNotEquals(GuestBookViewConstants.HOME_PAGE_VIEW, guestBookController.guestPage(model));
	}
	
	@Test
	public void test_getGuestBookEntries_positive() throws GuestBookException{
		List<GuestEntryVO> entries = new ArrayList<GuestEntryVO>();
		GuestEntryVO guestEntryVO = new GuestEntryVO();
		guestEntryVO.setSelected(true);
		guestEntryVO.setId(1);
		guestEntryVO.setFirstName("Joe");
		guestEntryVO.setLastName("Johnson");
		guestEntryVO.setEmailAddr("Joe.Johnson@gmail.com");
		guestEntryVO.setMessageOption("message");
		guestEntryVO.setMessage("This is a message");
		guestEntryVO.setIsApproved(false);
		guestEntryVO.setGuestFile(null);
		entries.add(guestEntryVO);
		
		when(guestBookService.fetchAllGuestEntries()).thenReturn(entries);
	    assertEquals(GuestBookViewConstants.ADMIN_PAGE_VIEW, guestBookController.getGuestBookEntries(model));
	}
	
	@Test(expected=Exception.class)
	public void test_getGuestBookEntries_negative() throws GuestBookException{
		when(guestBookService.fetchAllGuestEntries()).thenReturn(null);
		assertEquals(GuestBookViewConstants.ADMIN_PAGE_VIEW, guestBookController.getGuestBookEntries(null));
	}
	
	@Test
	public void test_accessDeniedPage_postive() throws Exception {
		assertEquals(GuestBookViewConstants.ACCESS_DENIED_VIEW, guestBookController.accessDeniedPage());
	}
	
	@Test
	public void test_accessDeniedPage_negative() throws Exception {
		assertNotEquals(GuestBookViewConstants.HOME_PAGE_VIEW, guestBookController.accessDeniedPage());
	}
	
	@Test
	public void test_errorPage_postive() throws Exception {
		assertEquals(GuestBookViewConstants.ERROR_VIEW, guestBookController.errorPage());
	}
	
	@Test
	public void test_errorPage_negative() throws Exception {
		assertNotEquals(GuestBookViewConstants.HOME_PAGE_VIEW, guestBookController.errorPage());
	}
	
	@Test
	public void test_saveGuestEntry_postive1() throws Exception {
		MockMultipartFile guestFile = new MockMultipartFile("data", "filename.txt", "text/plain", "some xml".getBytes());
		BindingResult result = mock(BindingResult.class);
		SessionStatus status = mock(SessionStatus.class);
		GuestEntryVO guestEntryVO = new GuestEntryVO();
		guestEntryVO.setSelected(true);
		guestEntryVO.setFirstName("Joe");
		guestEntryVO.setLastName("Johnson");
		guestEntryVO.setEmailAddr("Joe.Johnson@gmail.com");
		guestEntryVO.setMessageOption("file");
		guestEntryVO.setMessage(null);
		guestEntryVO.setIsApproved(false);
		guestEntryVO.setGuestFile(guestFile);
		
		GuestEntryVO guestEntryVOResponse = new GuestEntryVO();
		guestEntryVOResponse.setId(1);
		guestEntryVOResponse.setSelected(true);
		guestEntryVOResponse.setFirstName("Joe");
		guestEntryVOResponse.setLastName("Johnson");
		guestEntryVOResponse.setEmailAddr("Joe.Johnson@gmail.com");
		guestEntryVOResponse.setMessageOption("file");
		guestEntryVOResponse.setMessage(null);
		guestEntryVOResponse.setIsApproved(false);
		guestEntryVOResponse.setGuestFile(guestFile);
		
		when(guestBookService.saveGuestEntry(guestEntryVO, guestFile)).thenReturn(guestEntryVOResponse);
		assertEquals(GuestBookViewConstants.GUEST_PAGE_VIEW, guestBookController.saveGuestEntry(guestFile, guestEntryVO, result, status));
	}
	
	@Test
	public void test_saveGuestEntry_postive2() throws Exception {
		BindingResult result = mock(BindingResult.class);
		SessionStatus status = mock(SessionStatus.class);
		GuestEntryVO guestEntryVO = new GuestEntryVO();
		guestEntryVO.setSelected(true);
		guestEntryVO.setFirstName("Joe");
		guestEntryVO.setLastName("Johnson");
		guestEntryVO.setEmailAddr("Joe.Johnson@gmail.com");
		guestEntryVO.setMessageOption("text");
		guestEntryVO.setMessage("This is awesome");
		guestEntryVO.setIsApproved(false);
		guestEntryVO.setGuestFile(null);
		
		GuestEntryVO guestEntryVOResponse = new GuestEntryVO();
		guestEntryVOResponse.setId(1);
		guestEntryVOResponse.setSelected(true);
		guestEntryVOResponse.setFirstName("Joe");
		guestEntryVOResponse.setLastName("Johnson");
		guestEntryVOResponse.setEmailAddr("Joe.Johnson@gmail.com");
		guestEntryVOResponse.setMessageOption("text");
		guestEntryVOResponse.setMessage("This is awesome");
		guestEntryVOResponse.setIsApproved(false);
		guestEntryVOResponse.setGuestFile(null);
		
		when(guestBookService.saveGuestEntry(guestEntryVO, null)).thenReturn(guestEntryVOResponse);
		assertEquals(GuestBookViewConstants.GUEST_PAGE_VIEW, guestBookController.saveGuestEntry(null, guestEntryVO, result, status));
	}
	
	@Test
	public void test_saveGuestEntry_negative() throws Exception {
		MockMultipartFile guestFile = new MockMultipartFile("data", "filename.txt", "text/plain", "some xml".getBytes());
		BindingResult result = mock(BindingResult.class);
		SessionStatus status = mock(SessionStatus.class);
		GuestEntryVO guestEntryVO = new GuestEntryVO();
		guestEntryVO.setSelected(true);
		guestEntryVO.setFirstName("Joe");
		guestEntryVO.setLastName("Johnson");
		guestEntryVO.setEmailAddr("Joe.Johnson@gmail.com");
		guestEntryVO.setMessageOption("file");
		guestEntryVO.setMessage("This is a file");
		guestEntryVO.setIsApproved(false);
		guestEntryVO.setGuestFile(guestFile);
		
		GuestEntryVO guestEntryVOResponse = new GuestEntryVO();
		guestEntryVO.setId(1);
		guestEntryVO.setSelected(true);
		guestEntryVO.setFirstName("Joe");
		guestEntryVO.setLastName("Johnson");
		guestEntryVO.setEmailAddr("Joe.Johnson@gmail.com");
		guestEntryVO.setMessageOption("file");
		guestEntryVO.setMessage("This is a file");
		guestEntryVO.setIsApproved(false);
		guestEntryVO.setGuestFile(guestFile);
		
		when(guestBookService.saveGuestEntry(guestEntryVO, guestFile)).thenReturn(guestEntryVOResponse);
		assertNotEquals(GuestBookViewConstants.ADMIN_PAGE_VIEW, guestBookController.saveGuestEntry(guestFile, guestEntryVO, result, status));
	}
	
	@Test
	public void test_saveApprovedGuestEntry_positive() throws Exception {
		
		AdminFormVO adminFormVO = new AdminFormVO();
		List<GuestEntryVO> entries = new ArrayList<GuestEntryVO>();
		GuestEntryVO guestEntryVO = new GuestEntryVO();
		guestEntryVO.setSelected(true);
		guestEntryVO.setId(1);
		guestEntryVO.setFirstName("Joe");
		guestEntryVO.setLastName("Johnson");
		guestEntryVO.setEmailAddr("Joe.Johnson@gmail.com");
		guestEntryVO.setMessageOption("message");
		guestEntryVO.setMessage("This is a message");
		guestEntryVO.setIsApproved(false);
		guestEntryVO.setGuestFile(null);
		entries.add(guestEntryVO);
		adminFormVO.setEntries(entries);
		
		List<GuestEntryVO> guestEntryVOResponseList = new ArrayList<GuestEntryVO>();
		GuestEntryVO guestEntryVOResponse = new GuestEntryVO();
		guestEntryVOResponse.setSelected(true);
		guestEntryVOResponse.setId(1);
		guestEntryVOResponse.setFirstName("Joe");
		guestEntryVOResponse.setLastName("Johnson");
		guestEntryVOResponse.setEmailAddr("Joe.Johnson@gmail.com");
		guestEntryVOResponse.setMessageOption("message");
		guestEntryVOResponse.setMessage("This is a message");
		guestEntryVOResponse.setIsApproved(false);
		guestEntryVOResponse.setGuestFile(null);
		guestEntryVOResponseList.add(guestEntryVOResponse);
		
		when(guestBookService.saveGuestEntryList(adminFormVO.getEntries())).thenReturn(guestEntryVOResponseList);
		assertEquals(GuestBookViewConstants.REDIRECT_ADMIN_VIEW, guestBookController.saveApprovedGuestEntry(adminFormVO));
	}
	
	@Test(expected=Exception.class)
	public void test_saveApprovedGuestEntry_negative() throws Exception {
		assertEquals(GuestBookViewConstants.REDIRECT_ADMIN_VIEW, guestBookController.saveApprovedGuestEntry(null));
	}

	@Test
	public void test_deleteGuestEntry_positive() throws Exception {
		AdminFormVO adminFormVO = new AdminFormVO();
		List<GuestEntryVO> entries = new ArrayList<GuestEntryVO>();
		GuestEntryVO guestEntryVO = new GuestEntryVO();
		guestEntryVO.setSelected(true);
		guestEntryVO.setId(1);
		guestEntryVO.setFirstName("Joe");
		guestEntryVO.setLastName("Johnson");
		guestEntryVO.setEmailAddr("Joe.Johnson@gmail.com");
		guestEntryVO.setMessageOption("message");
		guestEntryVO.setMessage("This is a message");
		guestEntryVO.setIsApproved(false);
		guestEntryVO.setGuestFile(null);
		entries.add(guestEntryVO);
		adminFormVO.setEntries(entries);
		
		when(guestBookService.deleteGuestEntry(adminFormVO.getEntries())).thenReturn(GuestBookAppConstants.SUCCESS);
		assertEquals(GuestBookViewConstants.REDIRECT_ADMIN_VIEW, guestBookController.deleteGuestEntry(adminFormVO));
	}
	
	@Test(expected=Exception.class)
	public void test_deleteGuestEntry_negative() throws Exception {
		assertEquals(GuestBookViewConstants.REDIRECT_ADMIN_VIEW, guestBookController.deleteGuestEntry(null));
	}
}
