package member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberLoginController {
	
	final String command = "/loginForm.me";
	final String getPage = "MemberLoginForm";
	
	//productInsertController 에서 넘어옴 (상품추가하기 눌렀는데, 로그인 안 되어있어서 온것)
	@RequestMapping(command)
	public String doAction() {
		
		return getPage;
	}
	
	

}
