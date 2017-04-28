package xtu.library.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xtu.library.entity.Administrator;
import xtu.library.entity.Reader;
import xtu.library.service.admin.IAdminService;
import xtu.library.service.reader.IReaderService;
import xtu.library.web.util.MD5Util;

@Controller
@RequestMapping("/login")
public class LoginController {

	// 注入readerService
	@Autowired
	private IReaderService readerService;
	// 注入adminService
	@Autowired
	private IAdminService adminService;

	@RequestMapping("/toLogin")
	public String toLogin() {
		return "login";
	}

	/*
	 * 对普通用户或者管理员的登陆进行校验
	 */
	@ResponseBody
	@RequestMapping("/checkLogin")
	public Map<String, Object> checkLogin(String loginname, String password, Integer role, HttpSession session) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		// 检查登陆的状态
		int flag = 0;
		//将role存入session中
		session.setAttribute("role", role);
		// 判断是普通用户还是管理员登陆,0是普通用户，1是管理员
		if (role != null && loginname != null && password != null) {// 对role进行非空检测
			password = MD5Util.MD5Encrypt(password);
			System.out.println(password);
			if (role == 0) {
				List<Reader> readerList = readerService.findByName(loginname);
				if (readerList != null) {
					for (Reader reader : readerList) {
						if (password.equals(reader.getrPwd())) {
							flag = 1;
							session.setAttribute("reader", reader);
							resultMap.put("result", flag);
							return resultMap;
						} else {
							flag = 2;
						}
					}
				} else {
					flag = 3;
				}
			} else {
				List<Administrator> adminList = adminService.findByName(loginname);
				if (adminList != null) {
					for (Administrator admin : adminList) {
						if (password.equals(admin.getaPwd())) {
							flag = 1;
							session.setAttribute("admin", admin);
							resultMap.put("result", flag);
							return resultMap;
						} else {
							flag = 2;
						}
					}
				} else {
					flag = 3;
				}
			}
		}
		resultMap.put("result", flag);
		return resultMap;
	}

	/**
	 * 校验完成后跳转到读者或者是管理员的首页面
	 * @param role
	 * @return
	 */
	@RequestMapping("/toWelcome")
	public String toWelcome(Integer role,HttpSession session) {
		//如果没有从上一级传过来，就从session中拿role；
		role = (Integer) session.getAttribute("role");
		if (role != null) {
			if (role == 0) {
				return "reader/readerIndex";
			} else {
				return "admin/adminIndex";
			}
		} else {
			// 异常处理界面
			return "commom/error";
		}
	}
	
	/**
	 * 登出操作
	 * @return
	 */
	@RequestMapping("/logOut")
	public String logOut(){
		return "login";
	}
	
	@RequestMapping("/notComplete")
	public String notComplete(){
		return "common/notComplete";
	}

}
