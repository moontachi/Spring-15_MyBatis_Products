package product.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import product.model.Product;
import product.model.ProductDao;

@Controller
public class ProductDetailViewController {
	final String command = "/detail.prd";
	final String getPage = "ProuductDetailView";
	
	@Autowired
	ProductDao productDao;
	
	@RequestMapping(command)
	public ModelAndView doAction(@RequestParam(value="num",required = true) int num) {
		
		ModelAndView mav = new ModelAndView();
		Product product = productDao.getDetailView(num);
		
		mav.addObject("product",product);
		mav.setViewName(getPage);
		return mav;
	}
	
}
