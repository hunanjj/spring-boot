package com.renting.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.renting.pojo.District;
import com.renting.pojo.HouseType;
import com.renting.pojo.Users;
import com.renting.service.IDisService;
import com.renting.service.IHTService;
import com.renting.service.IHouseService;
import com.renting.service.impl.DisService;
import com.renting.service.impl.HTService;

@Controller
@RequestMapping("/guanli")
public class GuanliController {
	

	@Autowired
	private IHouseService houseService;
	@Autowired
	private IDisService disService ;
	@Autowired
	private IHTService hTService ;
	
	@RequestMapping("/list")
	public String houseList(@RequestParam(required=false) Integer index,Model model,HttpServletRequest request) {
		System.out.println("进入GuanliController ===list");
		System.out.println("进入GuanliController ===index="+index);
		int page=1;
		if(index !=null ) {			
			page=index;
			if(index==0) {
				page=1;
			}
		}
		Object obj=request.getSession().getAttribute("userinfo");
		 Users user=null;
		 if(obj != null) {
			user=(Users) obj;
			
		System.out.println("用户姓名："+user.getUname());
		
		Map<String,Object> maps=new HashMap<String, Object>();
		maps.put("ownerid", user.getUid());
		model.addAttribute("uid", user.getUid());
		int pagesize=3;//每页显示条数
		model.addAttribute("page", page);
		Page<Object> pages = PageHelper.startPage(page, pagesize,"creatDate desc");
		List<Map<String, Object>> hlist = houseService.selectHouse(maps);
		model.addAttribute("sumPage", pages.getPages());//总页数
		System.out.println("总页数 ：========="+pages.getPages());
		model.addAttribute("hlist", hlist);
			return "guanli";
		}else {
			return "redirect:/user/login";	
		}

	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam(required=false) Integer hid,Model model) {
		System.out.println("进入/guanli/delete==========hid="+hid);
		if(!houseService.deleteHouseOne(hid)) {
			model.addAttribute("deleterror", "删除失败！");
		}
		
		return "redirect:/guanli/list";
	}
	
	@RequestMapping("/update")
	public String update(Integer hid,Model model) {
		System.out.println("进入/guanli/update==========hid="+hid);
		
		Map<String, Object> maps= new HashMap<String, Object>();
		maps.put("hid", hid);
		List<Map<String, Object>> holist=houseService.selectHouse(maps);
		System.out.println(holist.get(0).toString());
		model.addAttribute("holist", holist.get(0));
		
		List<HouseType> htlist = hTService.selectHT();
		model.addAttribute("htlist", htlist);

		List<District> dislist = disService.selectDis();
		model.addAttribute("dislist", dislist);
		return "fabu";
	}
	
	/**
	 * 退出 
	 */
	@RequestMapping("/exit")
	public String exit(HttpServletRequest request) {
		System.out.println("退出登录 =============");
		 request.getSession().setAttribute("userinfo", null);
		return "login";
	}
	
	@RequestMapping("/fabu")
	public String fabu(@RequestParam(required=false) Integer userid,Model model) {
		System.out.println("进入发布页面===============userid="+userid);
		if(userid != null) {
		List<HouseType> htlist = hTService.selectHT();
		model.addAttribute("htlist", htlist);

		List<District> dislist = disService.selectDis();
		model.addAttribute("dislist", dislist);
		return "fabu";
		}else {
		model.addAttribute("logonError", "您还没登录呢，请先登录再发布");
		return "login";
		}
	}

}
