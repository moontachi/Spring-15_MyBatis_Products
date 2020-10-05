package product.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import product.model.ProductDao;
import utility.Paging;
import product.model.Product;

@Controller
public class ProductListController {

	final String command = "/list.prd";
	final String getPage = "ProductList";
	// 	WEB-INF/product/ ProductList.jsp
	
	@Autowired
	ProductDao productdao;
	
	@RequestMapping(command)
	public ModelAndView doAction(
			@RequestParam(value="whatColumn", required = false) String whatColumn,
			@RequestParam(value="keyword", required = false) String keyword,
			@RequestParam(value="pageNumber", required = false) String pageNumber,
			@RequestParam(value="pageSize", required = false) String pageSize,
			HttpServletRequest request
			) {
		
		System.out.println("whatColumn:" +whatColumn); 	
		System.out.println("keyword:" +keyword); 
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("whatColumn",whatColumn); 		
		map.put("keyword", "%"+keyword+"%");
		
		int totalCount = productdao.getTotalCount(map);
		String url = request.getContextPath( ) +command;	//ex/list.prd
		Paging pageInfo = new Paging(pageNumber,pageSize,totalCount,url,whatColumn,keyword);
		
		List<Product> lists = productdao.getProductList(pageInfo,map);
		ModelAndView mav = new ModelAndView();
		mav.addObject("lists", lists);
		mav.addObject("pageInfo", pageInfo);
		mav.addObject("totalCount", totalCount);
		mav.setViewName(getPage);
		return mav;
	}
	
	
}
