package member.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import member.model.Member;
import member.model.MemberDao;

@Controller
public class MemberRegisterController {

	final String command = "/registerForm.me";
	final String getPage = "MemberRegisterForm";
	final String gotoPage = "redirect:/list.me";
	
	@Autowired
	MemberDao memberDao;
	
	//MemberLoginForm.jsp 에서 요청함 (로그인화면에서 '회원가입' 클릭해서 넘어옴)
	@RequestMapping(value=command, method=RequestMethod.GET)
	public String doAction() {
		
		return getPage;
		
	}
	
	//MemberRegisterForm.jsp 에서 요청함 (회원가입화면에서 '추가하기' 클릭해서 넘어옴)
	@RequestMapping(value=command, method=RequestMethod.POST)	
	public ModelAndView doAction(@Valid Member member, BindingResult result) {	//커맨드객체(유효성검사하면서 한묶음의 bean으로 묶을것이다)
		
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			System.out.println("유효성 검사 오류입니다.");
			mav.setViewName(getPage);
			return mav;
		}
		
		memberDao.insertData(member);
		mav.setViewName(gotoPage);
		return mav;
		
	}
	
	
}
