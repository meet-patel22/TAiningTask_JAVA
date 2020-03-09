package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.service.AddService;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

@Controller
public class AddController {
	@RequestMapping("/add")
	public ModelAndView add(@RequestParam("number1")int number1, @RequestParam("number2") int number2) {
		AddService service = new AddService();
		
		
		int sum= service.add(number1, number2);
		ModelAndView viewObject=new ModelAndView();
		viewObject.setViewName("display");
		viewObject.addObject("result",sum);
		return viewObject;
	}
}
