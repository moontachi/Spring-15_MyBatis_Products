package orderdetail.model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("myOrderDetailDao")
public class OrderDetailDao {
	
	private final String namespace = "orderdetail.model.OrderDetail";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public void insertData(OrderDetail odBean) {
		sqlSessionTemplate.insert(namespace + ".InsertData",odBean);
	}
	
}
