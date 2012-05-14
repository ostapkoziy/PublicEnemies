package com.epam.publicenemies.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.epam.publicenemies.dto.ProfileDto;
import com.epam.publicenemies.service.IProfileManagerService;

/**
 * Allows to edit user/profile info
 * TODO: need to refactor
 *
 */
@Controller
@RequestMapping(value = "/editProfile")
public class EditProfileFormController {
	
	private Logger log	= Logger.getLogger(EditProfileFormController.class);
	
	@Autowired
	@Qualifier("profileManagerService")
	private IProfileManagerService	profileManagerService;
	

	public void setProfileManagerService(IProfileManagerService profileManagerService) {
		this.profileManagerService = profileManagerService;
	}
	
	/**
	 * Shows form with existing user/profile info
	 */	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showForm(HttpServletRequest request)	{
		ModelAndView mav = new ModelAndView(); 
		log.info("Showing editProfile form");
		ProfileDto pd = profileManagerService.getProfileByUserId((Integer) request.getSession().getAttribute("userId"));
		if (pd != null) {
			log.info("Profile has been fetched successfully");
		} else {
			// TODO: error page ?, unable to find profile for user
		}
		// doesn't matter. sets default profession
		if (pd.getProfession() == null || pd.getProfession() == "") {
			pd.setProfession("unknown"); 
		}
		mav.addObject("profile", pd);
		mav.setViewName("editProfile"); 
		return mav;	
	}
	
	/**
	 * Changes user/profile info
	 * TODO: change getting info from jsp (remove the request way)
	 * 
	 * @param uProfile profile with changed info
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(@ModelAttribute ProfileDto uProfile, HttpServletRequest request, BindingResult result)	{
		log.info("Updating user info with data: nickName = " + request.getParameter("nickName") + 
				"; avatar = " + request.getParameter("avatar") + 
				"; sex = " + request.getParameter("sex") + 
				"; profession = " + request.getParameter("profession") + ";"); 
		profileManagerService.updateProfile(
				(Integer) request.getSession().getAttribute("userId"), 
				request.getParameter("nickName"), 
				request.getParameter("avatar"),
				// TODO: change parsing
				Boolean.parseBoolean(request.getParameter("sex")), 
				request.getParameter("profession")); 
		// Note: exceptions in case empty fields
		// TODO: do changes
		return "redirect:userStartPage.html";		
	} 
}

/* Old code here 
@SuppressWarnings("deprecation")
public class EditProfileFormController extends SimpleFormController {

	private Logger log = Logger.getLogger(EditProfileFormController.class);
	private IProfileManagerService profileManagerService;
	private IStatsManagerService statsManagerService;

	public void setProfileManagerService(
			IProfileManagerService profileManagerService) {
		this.profileManagerService = profileManagerService;
	}
	
	public void setStatsManagerService(
			IStatsManagerService statsManagerService) {
		this.statsManagerService = statsManagerService;
	}

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		HttpSession session = request.getSession();
		UserDto user = (UserDto) session.getAttribute("user");
		
		ProfileDto profile = profileManagerService.saveProfile(((ProfileDto) command), user);
		statsManagerService.saveStats(new StatsDto(), user);
		log.info("NEW PROFILE SAVED: NICKNAME = " + profile.getNickName());
		return new ModelAndView(new RedirectView(getSuccessView()));
	}

	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		return new ProfileDto();
	}

}*/
