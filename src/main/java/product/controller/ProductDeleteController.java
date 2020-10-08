package product.controller;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import product.model.Product;
import product.model.ProductDao;

@Controller
public class ProductDeleteController {

	final String command = "/delete.prd";
	final String gotoPage = "redirect:/list.prd";
	
	@Autowired
	ProductDao productDao;
	@Autowired
	ServletContext servletContext;
	@RequestMapping(command)
	public String doAction(@RequestParam(value="num",required = true) int num) {
		
		
		Product product = productDao.getDetailView(num);
		
		String uploadPath = servletContext.getRealPath("/resources");
		
		//기존 이미지 지우기 시작
		File dleFile = new File(uploadPath + File.separator + product.getImage());
		dleFile.delete();
		//기존 이미지 지우기 끝
		productDao.deleteData(num);
		return gotoPage;
	}
	
}
