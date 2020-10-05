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
		
		System.out.println("loginInfo: "+session.getAttribute("loginInfo"));	//1. loginInfo�̸�����  session������ �� ������ �����ͺ��� (ó������ �����Ѱ� ������ null�� ��µ� ��)
		
		if(session.getAttribute("loginInfo") == null) {							//2. null�̶� ���� loginInfo���� ���Ǽ����Ѱ� ���ٴ� ��
			session.setAttribute("destination",  "redirect:/insert.prd");		//4. �α��������� �Ѿ������ session�����ϰ� ���ڴ�(�����Ϸ��°� �������� login�ϰ�͵� �����ʵ��� session�����صδ� ��)
			return "redirect:/loginForm.me";									//3. �α����� ���� ���ٸ� �α����Ϸ� ����
		}
		else {																	//5. �α����� �Ǿ��ִٸ�
			return getPage;														//6. ���� ������ �ߴ� form���� ����
		}
	}

}
