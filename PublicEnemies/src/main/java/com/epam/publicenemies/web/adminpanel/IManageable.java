package com.epam.publicenemies.web.adminpanel;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

/**
 * Defines the methods common to all manageable classes
 *  
 * @author I. Kostyrko
 * 
 * TODO: doEdit, doDelete, doAdd
 *
 */
public interface IManageable {
	
	public ModelAndView addNewOne();
	
	public ModelAndView editOne(Integer id);
	
	public ModelAndView detailInfo(Integer id); 
	
	public ModelAndView deleteOne(Integer id); 
}
