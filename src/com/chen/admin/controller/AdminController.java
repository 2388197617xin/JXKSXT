package com.chen.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.chen.admin.service.AdminService;
import com.chen.admin.validator.LoginValidator;
import com.chen.domain.DbExamer;
import com.chen.domain.DbPc;
import com.chen.domain.Stxxb;
import com.chen.tools.IPUtil;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.render.CaptchaRender;

public class AdminController extends Controller {

	/**
	 * 默认跳转到登陆页面
	 */
	public void index() {
		render("login.html");
		// render("pageTest.jsp");
	}

	/**
	 * 验证码
	 */
	public void vcode() {
		renderCaptcha();
	}

	/**
	 * 登陆处理
	 * @param
	 */
	public void login() {
		if (getSessionAttr("userName") != null) {
			render("index.jsp");
			return;
		}
		String url = null;
		String userName = getPara("username");
		String password = getPara("pwd");
		String inputRandomCode = getPara("verify");
		boolean passRandomCode = CaptchaRender.validate(this, inputRandomCode);
		if (passRandomCode) {
			// 查询后台管理员信息是否正确
			Boolean islogin = new AdminService().isLogin(userName, password);
			if (islogin) {
				System.out.println("-----" + "登陆成功！");
				setSessionAttr("userName", userName);
				url ="index.jsp";
			}
		} else {
			System.out.println("error.....");
			url = "/Views/Admin/login.html";
		}
		render(url);
	}

	/**
	 * 新增考生信息
	 */
	public void addExamer() {
		String userName = getPara("userName");
		String idCardNum = getPara("idCardNum");
		String sex = getPara("sex");
		String schoolName = getPara("school");
		String base64photo = getPara("base64photo");
		String pcName = getPara("pcName");
		String ip = IPUtil.getRealIpAddr(this.getRequest());
		Boolean saveFlage = new AdminService().savaExamer(userName, idCardNum, sex, schoolName, base64photo, pcName);
		renderText("exam/index");
	}

	public void sendPC() {
		HttpServletRequest request = this.getRequest();
		String ip = IPUtil.getRealIpAddr(request);
		List<DbPc> pcs = new AdminService().sendPC(ip);
		System.out.println(pcs.iterator());
		renderJson(pcs);
	}

	/**
	 * 添加考生信息时候自动分配计算机
	 */
	public void getPC() {
//		 HttpServletRequest request =this.getRequest();
//		 String IP = IPUtil.getRealIpAddr(request);
		List<DbPc> pc = new AdminService().getPCInfo();
		renderJson(pc);
	}

	public void getExamerInfo() {
		String sql = null;
		if (getPara("name") != null) {
			String name = getPara("name");
			sql = "SELECT users.`name`,users.`id_card`,users.`school`,pc.`pcname` FROM db_examer users LEFT OUTER JOIN db_pc pc ON users.`pc_id`=pc.`id` WHERE users.`name` LIKE '%"
					+ name + "%' ;";
		} else {
			sql = "SELECT users.`name`,users.`id_card`,users.`school`,pc.`pcname` FROM db_examer users LEFT OUTER JOIN db_pc pc ON users.`pc_id`=pc.`id`;";
		}
		System.out.println("查询考生信息SQL:" + sql);
		renderJson(DbExamer.dao.find(sql));
	}

}
