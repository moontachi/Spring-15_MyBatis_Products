package product.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

@Component("myProductDao")
public class ProductDao {
	
	String namespace = "product.model.Product";
	
	@Autowired // 객체를 아래 변수에 넣어라(객체는 root-context.xml에서 만들었다.)
	SqlSessionTemplate sqlSessionTemplate;
	
	
	public int getTotalCount(Map<String, String> map) {
		
		int cnt = sqlSessionTemplate.selectOne(namespace+ ".GetTotalCount",map);
		return cnt;
	}
	
	
	
	public List<Product> getProductList(Paging pageInfo,Map<String, String> map) {
		
		List<Product> lists = new ArrayList<Product>();
		
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());	
		lists = sqlSessionTemplate.selectList(namespace+ ".GetProductList",map,rowBounds);
		System.out.println("lists.size(): "+lists.size());
		
		return lists;
		
	}

	
	
	

}
