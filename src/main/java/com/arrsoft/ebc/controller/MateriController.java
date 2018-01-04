package com.arrsoft.ebc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.arrsoft.ebc.model.MyClass;
import com.arrsoft.ebc.security.ApiKey;
import com.arrsoft.ebc.service.MyClassService;
import com.arrsoft.ebc.utils.RzPaginate;

@Controller
@RequestMapping("/materi")
public class MateriController {

	@Autowired
	private MyClassService materiService;
	
	@Autowired
	private ServletContext servletContext;
	
	@RequestMapping("/{page}")
	public String index(@PathVariable int page, Model model){
		RzPaginate<MyClass> paginate= new RzPaginate();
		int pageSize = 10;
		List<MyClass> listMateri = materiService.getMateriByPage(page, pageSize);
		int totalRows = materiService.getCountMateri();
		String url = servletContext.getContextPath()+ "/materi";
		
		paginate.setCurrentPage(page);
		paginate.setBaseUrl(url);
		paginate.setTotalCount(totalRows);
		paginate.setPageSize(pageSize);
		paginate.setDataPopulate(listMateri);
		paginate.setLinkPages();
		
		model.addAttribute("paginate", paginate);
		return "materi";
	}
}
