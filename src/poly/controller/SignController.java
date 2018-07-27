package poly.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import poly.service.IComService;
import poly.util.CmmUtil;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

@Controller
public class SignController {
	private Logger log = Logger.getLogger(this.getClass());

	/*
	 * @Resource(name = "ComService") private IComService ComService;
	 */

	@RequestMapping(value = "/request")
	public String Request(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {

		log.info(this.getClass().getName() + ".request start!");

		log.info(this.getClass().getName() + ".request end!");

		return "/request";
	}

	@RequestMapping(value = "/response")
	public String Response(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {

		log.info(this.getClass().getName() + ".response start!");

		String res = request.getParameter("output-3");

		System.out.println(res);

		model.addAttribute("res", res);

		log.info(this.getClass().getName() + ".response end!");

		return "/response";
	}

	@RequestMapping(value = "/submit")
	public String submit(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {

		log.info(this.getClass().getName() + ".submit start!");

		String sign = request.getParameter("sign");
		String result = request.getParameter("result");

		System.out.println("sign : " + sign.length());
		System.out.println("result : " + result.length());

		String signPath = "";
		String resultPath = "";
		String path = request.getSession().getServletContext().getRealPath("/");//프로젝트 경로

		signPath = path + "\\signImg\\"; //저장할 폴더 경로
		resultPath = path + "\\resultImg\\";//저장할 폴더 경로
		
		File fileSign = new File(signPath);
		File resultSign = new File(resultPath);
		
		if(!fileSign.exists())//signImg폴더 없다면 만들기
		  {
		   fileSign.mkdirs();
		  }
		
		if(!resultSign.exists())//resultImg폴더 없다면 만들기
		  {
			resultSign.mkdirs();
		  }
		
		log.info("path :" + path);

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String currentTiem = dateFormat.format(date).replaceAll("/", "");
		currentTiem = currentTiem.replaceAll(":", "");
		currentTiem = currentTiem.replaceAll("\\p{Z}", "");
		log.info("time :" + currentTiem);

		try {
			String data = sign.split(",")[1];
			byte[] imageBytes = DatatypeConverter.parseBase64Binary(data);
			BufferedImage bufImg = ImageIO.read(new ByteArrayInputStream(imageBytes));

			String fileName = currentTiem + "Sign.jpg";
			File file = new File(signPath + fileName);
			ImageIO.write(bufImg, "jpg", file);

		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			String data = result.split(",")[1];
			byte[] imageBytes = DatatypeConverter.parseBase64Binary(data);
			BufferedImage bufImg = ImageIO.read(new ByteArrayInputStream(imageBytes));

			String fileName = currentTiem + "result.jpg";
			File file = new File(resultPath + fileName);
			ImageIO.write(bufImg, "jpg", file);

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("msg","저장 완료!");
		model.addAttribute("url","/request.do");
		
		log.info(this.getClass().getName() + ".submit end!");

		return "/redirect";
	}

}
