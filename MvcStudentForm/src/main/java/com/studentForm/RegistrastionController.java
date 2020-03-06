package com.studentForm;

import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView; 

@RequestMapping("/registration")  
@Controller  
public class RegistrastionController 
{
    @RequestMapping("/registrationForm")  

	public ModelAndView registrationForm()  
	{  
    	
    	
    	
    	

		ModelAndView mv=new ModelAndView();
	
	
	
		

		
	      //create a reservation object   
	    Registrastion res=new Registrastion();  
	      //provide reservation object to the model   
	    ((Model) mv).addAttribute("registrastion", res);  
		mv.setViewName("registrastionPage");
	    return mv;  
	}  
	@RequestMapping("/submitForm")  
	// @ModelAttribute binds form data to the object  
	public String submitForm(@ModelAttribute("registrastion") Registrastion res)  
	{  
	    return "confirmation";  
	}  
	  
	
	

}
