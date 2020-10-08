package mall.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import member.model.Member;
import order.model.Order;
import product.model.CompositeDao;

@Controller
public class OrderMallController {

	final String command = "/order.mall";
	final String getPage = "ShopList";
	
	@Autowired
	CompositeDao compositeDao;
	
	
	@RequestMapping(value=command)
	public String doAction(HttpSession session,Model model) {
		Member loginInfo = (Member)session.getAttribute("loginInfo");
		if(loginInfo == null) {
			session.setAttribute("destination", "redirect:/order.mall");
			//로그인 하면 destination 으로 가야 할 곳을 설정 한다.
			return "redirect:/loginForm.me";
		}else {
			List<Order> lists = compositeDao.orderMall(loginInfo.getId());
			
			model.addAttribute("lists",lists);
			
		}
		return getPage;
	}
}
