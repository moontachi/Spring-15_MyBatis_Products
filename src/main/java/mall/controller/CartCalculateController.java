package mall.controller;

import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import mall.cart.MyCartList;
import member.model.Member;
import member.model.MemberDao;
import order.model.OrderDao;
import orderdetail.model.OrderDetail;
import orderdetail.model.OrderDetailDao;
import product.model.ProductDao;

@Controller
public class CartCalculateController { //MallList.jsp 에서  결재하기 요청 받고 넘어옴

	final String command = "/calculate.mall";
	final String gotoPage = "redirect:/list.prd";
	
	@Autowired
	MemberDao memberDao;
	@Autowired
	ProductDao productDao;
	@Autowired
	OrderDao orderDao;
	@Autowired
	OrderDetailDao orderDetailDao;
	
	
	
	@RequestMapping(value=command)
	public String doAction(HttpSession session) {
		
		MyCartList mycart = (MyCartList)session.getAttribute("mycart");
		Map<Integer,Integer> maplists =  mycart.getAllOrderLists();//장바구니에 담긴 정보가 다 여기에 있다.
		//maplists 장바구니
		Set<Integer> keylist = maplists.keySet();//상품의 번호만 가져와보자. 장바구니에 있는 상품의 번호 가져오기
		
		//oid,mid,orderdate -> order 테이블에 주입 작업을 해야함.
		Member member = (Member)session.getAttribute("loginInfo");
		
		//orders테이블에 멤버 id 넣기
		orderDao.insertData(member.getId());
		
		//가장 큰 oid값 가져오기
		int maxOid = orderDao.getMaxOid();
		
		
		//주문상품에서 수량을 빼주는 작업
		for(Integer pnum : keylist) {
			Integer qty = maplists.get(pnum);//장바구니에서 pnum 상품의 재고수량 가져와~~
			
			productDao.updateStock(pnum,qty);
			
			OrderDetail odBean = new OrderDetail();
			odBean.setOid(maxOid);
			odBean.setPnum(pnum);
			odBean.setQty(qty);
			
			
			orderDetailDao.insertData(odBean);
		}
		
		memberDao.updatePoint(member.getId(),100);
		session.removeAttribute("mycart");
		return gotoPage;
	}
}
