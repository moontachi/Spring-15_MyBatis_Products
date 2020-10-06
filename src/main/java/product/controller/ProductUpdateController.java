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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import product.model.Product;
import product.model.ProductDao;

@Controller
public class ProductUpdateController {
	final String command = "/update.prd";
	final String getPage = "ProductUpdateForm";
	final String gotoPage = "redirect:/list.prd";
	
	@Autowired
	ProductDao productDao;
	@Autowired
	ServletContext servletContext;
	@RequestMapping(value=command,method = RequestMethod.GET)
	public ModelAndView doAction(@RequestParam(value="num",required = true) int num,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		if(session.getAttribute("loginInfo") == null) {
			session.setAttribute("destination", "redirect:/update.prd?num=");
			mav.setViewName("redirect:/loginForm.me");
			return mav;
		}else {
			
			Product product = productDao.getDetailView(num);
			
			mav.addObject("product",product);
			mav.setViewName(getPage);
		
			return mav;
		}
	}
	
	@RequestMapping(value=command,method = RequestMethod.POST)
	public String doAction(@Valid Product product,BindingResult result) {
		
		if(result.hasErrors()) {
			System.out.println("유효성 검사 오류");
			return getPage;
		}
		
		MultipartFile multi = product.getUpload();
		String uploadPath = servletContext.getRealPath("/resources");
		File file = new File(uploadPath + File.separator + product.getImage());
		
		
		//기존 이미지 지우기 시작
		File dleFile = new File(uploadPath + File.separator + product.getUploadOld());
		dleFile.delete();
		//기존 이미지 지우기 끝
		
		int cnt = productDao.updateData(product);
		
		try {
			multi.transferTo(file);
			
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(cnt < 0) {
			System.out.println("update 실패");
			return getPage;
		}
		return gotoPage;
	}
	
	
}
