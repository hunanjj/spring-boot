package com.renting.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.renting.pojo.District;
import com.renting.pojo.House;
import com.renting.pojo.HouseType;
import com.renting.pojo.Users;
import com.renting.service.IDisService;
import com.renting.service.IHTService;
import com.renting.service.IHouseService;
import com.renting.service.impl.DisService;
import com.renting.service.impl.HTService;

@Controller
@RequestMapping("/house")
public class HouseController {
	@Autowired
	private IHouseService houseService;
	@Autowired
	private IHTService ht;
	@Autowired
	private IDisService dis;
	
	@RequestMapping("/add")
	public String addHouse(House house,Model model,HttpServletRequest request) {
		System.out.println("发布房屋============"+house.toString());
		Object obj=request.getSession().getAttribute("userinfo");
		Users user=null;
		if(obj != null) {
			user=(Users) obj;
			house.setOwnerid(user.getUid());
		}else {
			return "redirect:/user/login";
		}
		if(!houseService.insertHouse(house)) {
			model.addAttribute("fabuError", "发布失败");
			System.out.println("发布失败！");
			return "forward:/guanli/fabu";
		}
		
		return "forward:/guanli/list";
	}
	
	@RequestMapping("/update")
	public String updateHouse(House house,Integer houseId,
							Model model,HttpServletRequest request) {
		System.out.println("房屋更新提交=======houseId="+houseId);
		house.setHid(houseId);
		if(houseService.updateHouse(house)) {
			System.out.println("修改成功！");
		return "forward:/guanli/list";
		}
		return "forward:/guanli/fabu";
	}
	
	@GetMapping(value="/selectOne/{hid}")
	public String selectOne(@PathVariable Integer hid,Model model) {
		System.out.println("进入/selectOne/{hid}===="+hid);
		Map<String,Object> maps=new HashMap<String, Object>();
		maps.put("hid",hid);
		List<Map<String, Object>> hlist = houseService.selectHouse(maps);
		model.addAttribute("hlist", hlist.get(0));
		return "details";
	}
	
	@RequestMapping("/list")
	public String houseList(@RequestParam(required=false) Integer index,
			/*@RequestParam(required=false)*/ House house,
			@RequestParam(required=false) Integer district_id,
			@RequestParam(required=false) String order,
			@RequestParam(required=false) String opr,
			Model model,HttpServletRequest request) {
		System.out.println("opr======="+opr);
		int page = 1 ;//当前页码	
		
		//定义排序		
		if(order == null) {
			order = "creatDate desc";
		}
		System.out.println("order======="+order);
		
		Map<String,Object> maps=new HashMap<String, Object>();
		
		if(opr.equals("list")) {
			//首先进来把搜索框恢复默认
			maps.put("htitle","");
			maps.put("did", 0);
			maps.put("addressid", 0);
			maps.put("houseTypeId", 0);
			maps.put("area",0);
			maps.put("price", 0);
			
			request.getSession().setAttribute("m", maps);
		}else if(opr.equals("query")) {
			
			//System.out.println("title="+house.getHtitle());
			maps.put("htitle",house.getHtitle());
			
			//System.out.println("did:"+district_id);
			maps.put("did",district_id);
			
			//System.out.println("sid:"+house.getAddressid());
			maps.put("addressid", house.getAddressid());

			System.out.println("tid:"+house.getHouseTypeId());
			maps.put("houseTypeId", house.getHouseTypeId());
			String prices = house.getPrice();
			System.out.println("prices:=================="+prices);
			if(!prices.equals("0")) {
				String price0=prices.substring(0,prices.indexOf("-"));
				System.out.println("price0:"+price0);
				
				String price=prices.substring(prices.indexOf("-")+1);
				System.out.println("price:"+price);
				maps.put("price0", Integer.parseInt(price0));
				maps.put("price", Integer.parseInt(price));
				//model.addAttribute("price", prices);
			}
			
			String ar = house.getArea();
			if(!ar.equals("0")) {
				String area0=ar.substring(0, ar.indexOf("-"));
				String area=ar.substring(ar.indexOf("-")+1);
				maps.put("area0",Integer.parseInt(area0));
				maps.put("area",Integer.parseInt(area) );
				//model.addAttribute("floorage", ar);
			}
			
			request.getSession().setAttribute("m", maps);
		}else if(opr.equals("page") || opr.equals("order") ) {
			//用来上一页，下一页传过来的参数
			if(index !=null ) {			
				page=index;
				if(index==0) {
					page=1;
				}
			}
			System.out.println("page======="+page);
			Object obj = request.getSession().getAttribute("m");
			Map<String,Object> maps1=null;
			
			try {
				maps1=(Map<String, Object>) obj;
			} catch (Exception e) {
				maps1=new HashMap<String, Object>();
			}
			for (String key:maps1.keySet()) {
				System.out.println("key="+key+" and vaule ="+maps1.get(key));
			}
			
			maps.put("htitle",maps1.get("htitle"));
			maps.put("did", maps1.get("did"));
			maps.put("addressid", maps1.get("addressid"));
			maps.put("houseTypeId", maps1.get("houseTypeId"));
			maps.put("price0", maps1.get("price0"));
			maps.put("price", maps1.get("price"));
			maps.put("area0",maps1.get("area0"));
			maps.put("area",maps1.get("area"));
			//maps.put("order",order);
		}
		model.addAttribute("order", order);
		
		Page<Map<String, Object>> pages = PageHelper.startPage(page, 3,order);
			houseService.selectHouse(maps);
		 PageInfo info = new PageInfo(pages,5);
		 
		 int[] num = info.getNavigatepageNums();
		
		model.addAttribute("hlist", pages);
		model.addAttribute("hinfo", info);
		
		List<HouseType> htlist = ht.selectHT();
		model.addAttribute("htlist", htlist);
				
		List<District> dislist = dis.selectDis();
		model.addAttribute("dislist", dislist);
		
		
		return "list";
	}

}
