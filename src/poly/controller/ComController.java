package poly.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import poly.dto.TestDTO;
import poly.service.IComService;
import poly.util.CmmUtil;

/*
 * Controller �꽑�뼵�빐�빞留� Spring �봽�젅�엫�썙�겕�뿉�꽌 Controller�씤吏� �씤�떇 媛��뒫
 * �옄諛� �꽌釉붾┸ �뿭�븷 �닔�뻾
 * */

@Controller
public class ComController {
	private Logger log = Logger.getLogger(this.getClass());
	
	
	@Resource(name = "ComService")
	private IComService ComService;
	
	
	
	@RequestMapping(value="/Main" )
	public String Main(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model) throws Exception {
		
		log.info(this.getClass().getName() + ".Main start!");
		
			
		
		log.info(this.getClass().getName() + ".Main end!");
		
		return "/Main";
	}
	
	
	@RequestMapping(value="/user/signup")
	public String signUp(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model) throws Exception {
		
		log.info(this.getClass().getName() + ".signup start!");
		
			
		
		log.info(this.getClass().getName() + ".signup end!");
		
		return "/user/signup";
	}
	

	@RequestMapping(value="/user/login", method=RequestMethod.GET)
	public String login(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model) throws Exception {
		
		log.info(this.getClass().getName() + ".insert start!");
		
			
		log.info(this.getClass().getName() + ".insert end!");
		
		return "/user/login";
	}
	
	@RequestMapping(value="/user/userPage", method=RequestMethod.GET)
	public String userPage(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model) throws Exception {
		
		log.info(this.getClass().getName() + ".insert start!");
		
			
		log.info(this.getClass().getName() + ".insert end!");
		
		return "/user/userPage";
	}
	
}	
	