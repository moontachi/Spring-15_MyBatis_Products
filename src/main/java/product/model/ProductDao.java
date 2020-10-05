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
	
	@Autowired // ��ü�� �Ʒ� ������ �־��(��ü�� root-context.xml���� �������.)
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
