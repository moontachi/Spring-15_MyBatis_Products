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
	
	//MemberLoginForm.jsp ���� ��û�� (�α���ȭ�鿡�� 'ȸ������' Ŭ���ؼ� �Ѿ��)
	@RequestMapping(value=command, method=RequestMethod.GET)
	public String doAction() {
		
		return getPage;
		
	}
	
	//MemberRegisterForm.jsp ���� ��û�� (ȸ������ȭ�鿡�� '�߰��ϱ�' Ŭ���ؼ� �Ѿ��)
	@RequestMapping(value=command, method=RequestMethod.POST)	
	public ModelAndView doAction(@Valid Member member, BindingResult result) {	//Ŀ�ǵ尴ü(��ȿ���˻��ϸ鼭 �ѹ����� bean���� �������̴�)
		
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			System.out.println("��ȿ�� �˻� �����Դϴ�.");
			mav.setViewName(getPage);
			return mav;
		}
		
		memberDao.insertData(member);
		mav.setViewName(gotoPage);
		return mav;
		
	}
	
	
}
