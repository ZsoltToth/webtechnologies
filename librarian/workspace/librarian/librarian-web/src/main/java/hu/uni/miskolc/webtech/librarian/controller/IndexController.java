package hu.uni.miskolc.webtech.librarian.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class IndexController {
	
	@RequestMapping(value={"", "/", "/home", "/index"})
	public ModelAndView homePage(){
		ModelAndView result = new ModelAndView("index");
		return result;
	}

	@RequestMapping("/hello")
	public @ResponseBody String sayHello(){
		return "Hello World";
	}

}
