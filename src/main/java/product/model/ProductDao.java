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
	
	@Autowired 
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
	
	public int insertData(Product bean) {
	
		int cnt = sqlSessionTemplate.insert(namespace + ".InsertData",bean);
		return cnt;
	}
	
	
	public Product getDetailView(int num) {
		Product bean = sqlSessionTemplate.selectOne(namespace + ".GetDetailView",num);
		return bean;
	}
	
	
	public int updateData(Product bean) {
		int cnt = sqlSessionTemplate.update(namespace + ".UpdateData",bean);
		return cnt;
	}
	
	
	
	public int deleteData(int num) {
		
		int cnt = sqlSessionTemplate.delete(namespace + ".DeleteData",num);
		
		return cnt;
	}
	
	
	
	public void updateStock(Integer pnum,Integer qty) {
		Product bean = new Product();
		bean.setNum(pnum);
		bean.setStock(qty);
		sqlSessionTemplate.update(namespace + ".UpdateStock",bean);
		//업데이트는 뒤에 하나 밖에 넣을 수 없어서, 넘겨줘야 한다면 하나의 묶음으로 보내야 한다.
	}

	
	
	

}
