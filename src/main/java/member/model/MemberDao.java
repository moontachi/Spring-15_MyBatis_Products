package member.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

@Component("myMemberDao")
public class MemberDao {
	
	private String namespace = "member.model.Member";
	
	@Autowired 
	SqlSessionTemplate sqlSessionTemplate;
	
	public void insertData(Member member) {
		int cnt = sqlSessionTemplate.insert(namespace + ".InsertData", member);
		System.out.println("cnt: "+cnt);
	}
	
	public int getTotalCount(Map<String, String> map) {
		
		int cnt = sqlSessionTemplate.selectOne(namespace+ ".GetTotalCount",map);
		return cnt;
	}
	
	public List<Member> getDataList(Paging pageInfo,Map<String, String> map) {
		
		List<Member> lists = new ArrayList<Member>();
		
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());	
		lists = sqlSessionTemplate.selectList(namespace+ ".GetDataList",map,rowBounds);
		System.out.println("lists.size(): "+lists.size());
		
		return lists;
		
	}
	
	public int deleteData(String id) {
		
		int cnt = sqlSessionTemplate.delete(namespace+ ".DeleteData",id);
		System.out.println("delete_cnt: " +cnt);
		return cnt;
		
	}

}
