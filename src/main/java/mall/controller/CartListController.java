package mall.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import mall.cart.MyCartList;
import mall.cart.ShoppingInfo;
import product.model.Product;
import product.model.ProductDao;

@Controller
public class CartListController { // CartAddController에서 넘어옴
	final String command = "/list.mall";
	final String getPage = "MallList";
	
	@Autowired
	ProductDao productDao;
	
	
	@RequestMapping(value=command)
	public String doAction(HttpSession session) {
		MyCartList mycart = (MyCartList)session.getAttribute("mycart");
		Map<Integer,Integer> maplists = mycart.getAllOrderLists();
		System.out.println("장바구니 상품 갯수 : " + maplists.size());
		
		Set<Integer> keylist = maplists.keySet();
		System.out.println("keylist : " + keylist);
		List<ShoppingInfo> shoplists = new ArrayList<ShoppingInfo>();
		int totalAmount = 0;
		for(Integer pnum : keylist) {
			Integer oqty = maplists.get(pnum);
			System.out.println(pnum + ":" + oqty);
			
			Product bean = productDao.getDetailView(pnum);
			ShoppingInfo shopInfo = new ShoppingInfo();
			shopInfo.setPnum(pnum);
			shopInfo.setPname(bean.getName());
			shopInfo.setQty(oqty);
			shopInfo.setPrice(bean.getPrice());
			shopInfo.setAmount(bean.getPrice() * oqty);
			totalAmount += shopInfo.getAmount();
			shoplists.add(shopInfo);
		}
		
		
		session.setAttribute("shoplists", shoplists);
		session.setAttribute("totalAmount", totalAmount);
		return getPage; // MallList.jsp(상품번호,상품명,주문수량,단가,금액)
	}
}
