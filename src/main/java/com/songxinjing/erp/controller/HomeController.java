package com.songxinjing.erp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.songxinjing.erp.controller.base.BaseController;
import com.songxinjing.erp.domain.Store;
import com.songxinjing.erp.service.StoreService;

/**
 * 主页控制类
 * 
 * @author songxinjing
 * 
 */
@Controller
public class HomeController extends BaseController {

	private static Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	StoreService storeService;

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String home(Model model, HttpServletRequest request) {
		logger.info("进入主页面");
		String hql = "from Store";
		List<Store> stores = storeService.findPage(hql, 0, 5);
		model.addAttribute("stores", stores);
		return "index";
	}

	@RequestMapping(value = "system/error", method = RequestMethod.GET)
	public String error() {
		logger.info("进入报错页面");
		return "system/error";
	}

	@RequestMapping(value = "system/404", method = RequestMethod.GET)
	public String notFound() {
		logger.info("进入404页面");
		return "system/404";
	}

}
