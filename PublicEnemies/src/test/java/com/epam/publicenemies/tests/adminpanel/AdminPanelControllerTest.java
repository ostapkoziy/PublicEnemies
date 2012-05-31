/**
 * 
 */
package com.epam.publicenemies.tests.adminpanel;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.epam.publicenemies.web.adminpanel.AdminPanelController;

/**
 * @author I. Kostyrko
 *
 */
public class AdminPanelControllerTest {

	AdminPanelController apc = new AdminPanelController(); 
	/**
	 * Test method for {@link com.epam.publicenemies.web.adminpanel.AdminPanelController#showAdminPage(javax.servlet.http.HttpServletRequest)}.
	 */
	@Test
	public void testShowAdminPage() {
		assertTrue(apc.showAdminPage().equals("redirect:adminPanel/summary.html"));
	}
}
