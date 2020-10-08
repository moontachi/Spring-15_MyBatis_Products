package mall.cart;

import java.util.HashMap;
import java.util.Map;

public class MyCartList {
	// key : 상품번호 , value : 주문수량
	private Map<Integer,Integer> orderlists = null;
	
	public MyCartList() {
		orderlists = new HashMap<Integer,Integer>();
	}
	
	public void addOrder(int pnum,int oqty) {
		
		if(orderlists.containsKey(pnum) == false) {//새상품 이면
			orderlists.put(pnum,oqty);
		}else {//이미 있는 상품이면
			int oldoqty = orderlists.get(pnum);
			orderlists.put(pnum, oldoqty + oqty);
			System.out.println("oldoqty :"+oldoqty);
			System.out.println("oqty :"+oqty);
		}
		
	}
	
	public Map<Integer,Integer> getAllOrderLists() {
		return orderlists;
	}
}
