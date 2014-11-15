package jpm.codeforgood.controller;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class WebController {

	final static Logger logger = LoggerFactory.getLogger(WebController.class);

	@RequestMapping(value = "error", method = RequestMethod.GET)
	public String error(HttpServletResponse response) {
		return "error";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("title", "code for good");
		return "index";
	}
}
