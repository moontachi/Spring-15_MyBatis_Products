package member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import member.model.Member;
import member.model.MemberDao;
import utility.Paging;

@Controller
public class MemberListController {

	final String command = "/list.me";
	final String getPage = "MemberList";
	//final String gotoPage = "";
	
	@Autowired
	MemberDao memberDao;
	
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
		
		int totalCount = memberDao.getTotalCount(map);
		String url = request.getContextPath( ) +command;	
		Paging pageInfo = new Paging(pageNumber,pageSize,totalCount,url,whatColumn,keyword);
		
		
		List<Member> lists = memberDao.getDataList(pageInfo,map);
		ModelAndView mav = new ModelAndView();
		mav.addObject("lists", lists);
		mav.addObject("pageInfo", pageInfo);
		mav.addObject("totalCount", totalCount);
		mav.setViewName(getPage);
		return mav;
		
	}
}
