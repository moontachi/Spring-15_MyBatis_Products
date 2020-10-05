package product.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductInsertController {
	
	final String command = "/insert.prd";
	final String getPage = "ProductInsertForm";
	
	@RequestMapping(command)
	public String doAction(HttpSession session) {
		
		System.out.println("loginInfo: "+session.getAttribute("loginInfo"));	//1. loginInfo이름으로  session설정한 거 있으면 가져와봐라 (처음에는 설정한게 없으니 null이 출력될 것)
		
		if(session.getAttribute("loginInfo") == null) {							//2. null이란 얘기는 loginInfo으로 세션설정한게 없다는 뜻
			session.setAttribute("destination",  "redirect:/insert.prd");		//4. 로그인폼으로 넘어가기전에 session설정하고 가겠다(원래하려는게 뭐였는지 login하고와도 잊지않도록 session설정해두는 것)
			return "redirect:/loginForm.me";									//3. 로그인한 적이 없다면 로그인하러 가라
		}
		else {																	//5. 로그인이 되어있다면
			return getPage;														//6. 원래 가려고 했던 form으로 가라
		}
	}

}
