package product.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import product.model.Product;
import product.model.ProductDao;

@Controller
public class ProductInsertController {
	
	final String command = "/insert.prd";
	final String getPage = "ProductInsertForm";
	
	final String gotoPage = "redirect:/list.prd";
	
	
	@Autowired
	ProductDao productDao;
	@Autowired
	ServletContext servletContext;
	@RequestMapping(value = command, method = RequestMethod.GET)
	public String doAction(HttpSession session) {
		
		System.out.println("loginInfo: "+session.getAttribute("loginInfo"));	//1. loginInfo�̸�����  session������ �� ������ �����ͺ��� (ó������ �����Ѱ� ������ null�� ��µ� ��)
		
		if(session.getAttribute("loginInfo") == null) {							//2. null�̶� ���� loginInfo���� ���Ǽ����Ѱ� ���ٴ� ��
			session.setAttribute("destination", "redirect:/insert.prd");		//4. �α��������� �Ѿ������ session�����ϰ� ���ڴ�(�����Ϸ��°� �������� login�ϰ�͵� �����ʵ��� session�����صδ� ��)
			return "redirect:/loginForm.me";									//3. �α����� ���� ���ٸ� �α����Ϸ� ����
		}
		else {																	//5. �α����� �Ǿ��ִٸ�
			return getPage;														//6. ���� ������ �ߴ� form���� ����
		}
	}
	
	@RequestMapping(value = command, method = RequestMethod.POST)
	public String doAction(@Valid Product product,BindingResult result) {
		
		if(result.hasErrors()) {
			System.out.println("Product 유효성 검사 오류");
			return getPage;
		}
		
		MultipartFile multi = product.getUpload();// MultipartFile 객체를 하나 리턴
		//MultipartFile 안에 transferTo 매서드가 있다.
		System.out.println("servletContext.getRealPath('/') " + servletContext.getRealPath("/"));
		//C:\Spring_kmk\.metadata\.plugins\org.eclipse.wst.server.core\tmp1\wtpwebapps\15_MyBatis_Products\
		//최상위 폴더의 위치를 가져와라
		String uploadPath = servletContext.getRealPath("/resources");
		System.out.println("uploadPath" + uploadPath);
		//C:\Spring_kmk\.metadata\.plugins\org.eclipse.wst.server.core\tmp1\wtpwebapps\15_MyBatis_Products\resources
		System.out.println("새로 선택한 화일명 : " + product.getImage());
		
		File file = new File(uploadPath + File.separator + product.getImage());
		
		try {
			multi.transferTo(file); //위치에 jpg가 진짜로 짜라짜라짜짜 올라간다
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int cnt = productDao.insertData(product);
		if(cnt < 0) {
			System.out.println("insert 실패");
			return getPage;
		}
		return gotoPage;
	}

}
