package com.guestbook.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import com.guestbook.constants.GuestBookAppConstants;
import com.guestbook.constants.GuestBookURIConstants;
import com.guestbook.constants.GuestBookViewConstants;
import com.guestbook.exception.GuestBookException;
import com.guestbook.model.AdminFormVO;
import com.guestbook.model.GuestEntryVO;
import com.guestbook.service.GuestBookService;

/**
 * This is Controller for GuestBook application 
 * @author Anis Deepa
 * 
 */
@Controller
public class GuestBookController {
	
	Logger log = LoggerFactory.getLogger(GuestBookController.class);
	
	@Autowired
	GuestBookService guestBookService;
	
	/**
	 * This method renders the application home page 
	 * @return viewName
	 */
	@GetMapping(GuestBookURIConstants.HOME_URI)
    public String homePage() {
		log.debug("Method GuestBookController.saveApprovedGuestEntry");
        return GuestBookViewConstants.HOME_PAGE_VIEW;
	}
	
	/**
	 * This method renders the guest page and sets the guestEntry model
	 * @param model
	 * @return viewName
	 */
	@GetMapping(GuestBookURIConstants.GUEST_URI)
	    public String guestPage(Model model) {
		log.debug("Method GuestBookController.guestPage");
		GuestEntryVO guestEntryVO = new GuestEntryVO();
		model.addAttribute(GuestBookAppConstants.GUEST_ENTRY,guestEntryVO);
	    return GuestBookViewConstants.GUEST_PAGE_VIEW;
	}
	
	/**
	 * This method renders the admin page after fetching all the guest entries
	 * @param model
	 * @return viewName
	 * @throws GuestBookException 
	 */
	@GetMapping(GuestBookURIConstants.ADMIN_URI)
	public String getGuestBookEntries(Model model) throws GuestBookException {
		log.debug("Method GuestBookController.getGuestBookEntries");
		AdminFormVO adminForm = new AdminFormVO();
		List<GuestEntryVO> entries = guestBookService.fetchAllGuestEntries();
		adminForm.setEntries(entries);
		model.addAttribute(GuestBookAppConstants.ADMIN_FORM, adminForm);
		return GuestBookViewConstants.ADMIN_PAGE_VIEW;
	}
	
	/**
	 * This method renders the access denied page when access 
	 * is restricted for the logged in user
	 * @return viewName
	 */
	@GetMapping(GuestBookURIConstants.ACCESS_DENIED_URI)
	    public String accessDeniedPage() {
		log.debug("Method GuestBookController.accessDeniedPage");
	    return GuestBookViewConstants.ACCESS_DENIED_VIEW;
	}
	
	/**
	 * This method renders the error page
	 * @return viewName
	 */
	@GetMapping(GuestBookURIConstants.ERROR_URI)
    public String errorPage() {
		log.debug("Method GuestBookController.errorPage");
        return GuestBookViewConstants.ERROR_VIEW;
	}
	
	/**
	 * This method adds the new guest entry by guest user
	 * and renders the guest page
	 * @param guestFile
	 * @param guestEntryVO
	 * @param result
	 * @param status
	 * @return viewName
	 * @throws GuestBookException 
	 */
	@PostMapping(GuestBookURIConstants.GUEST_ADD_URI)
    public String saveGuestEntry(@RequestParam(GuestBookAppConstants.GUEST_FILE) MultipartFile guestFile, @ModelAttribute(GuestBookAppConstants.GUEST_ENTRY) GuestEntryVO guestEntryVO,
    		BindingResult result, SessionStatus status) throws GuestBookException {
		log.debug("Method GuestBookController.saveGuestEntry");
		guestBookService.saveGuestEntry(guestEntryVO, guestFile);
		return GuestBookViewConstants.GUEST_PAGE_VIEW;
	}
	
	/**
	 * This method updates the guest entries updated by admin user 
	 * @param adminFormVO
	 * @return viewName
	 * @throws GuestBookException 
	 */
	@PostMapping(GuestBookURIConstants.ADMIN_SAVE_URI)
	public String saveApprovedGuestEntry(@ModelAttribute(GuestBookAppConstants.ADMIN_FORM) AdminFormVO adminFormVO) throws GuestBookException {
		log.debug("Method GuestBookController.saveApprovedGuestEntry");
		guestBookService.saveGuestEntryList(adminFormVO.getEntries());
		return GuestBookViewConstants.REDIRECT_ADMIN_VIEW;
	}
	
	/**
	 * This method delete the guest entries deleted by admin user
	 * @param adminFormVO
	 * @return viewName
	 * @throws GuestBookException 
	 */
	@PostMapping(GuestBookURIConstants.ADMIN_DELETE_URI)
	public String deleteGuestEntry(@ModelAttribute(GuestBookAppConstants.ADMIN_FORM) AdminFormVO adminFormVO) throws GuestBookException {
		log.debug("Method GuestBookController.deleteGuestEntry");
		guestBookService.deleteGuestEntry(adminFormVO.getEntries());
		return GuestBookViewConstants.REDIRECT_ADMIN_VIEW;
	}
}
