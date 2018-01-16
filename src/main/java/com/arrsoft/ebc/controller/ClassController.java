package com.arrsoft.ebc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.arrsoft.ebc.model.MyClass;
import com.arrsoft.ebc.service.MyClassService;
import com.arrsoft.ebc.utils.RzPaginate;

@Controller
@RequestMapping("/myclass")
public class ClassController {

	@Autowired
	MyClassService myClassService;
	@Autowired
	ServletContext servletContext;
	int pageSize = 10;
	
	@ModelAttribute("commandClass")
	public MyClass injectionObjectForm(){
		return new MyClass();
	}
	
	@RequestMapping
	public String index(Model model, @RequestParam(value="page", defaultValue="0") int page){
		
		List<MyClass> listClasses = myClassService.getMateriByPage(page, pageSize);
		List<String> dataLg = new ArrayList();
		dataLg.add("java");
		dataLg.add("android");
		dataLg.add(".NET");
		dataLg.add("PHP");
		dataLg.add("javascript");
		model.addAttribute("lgList", dataLg);
		
		//pagination
		long totalRows = myClassService.getCountMateri();
		RzPaginate<MyClass> paginate= new RzPaginate();
		String url = servletContext.getContextPath()+ "/myclass";
		paginate.setCurrentPage(page);
		paginate.setBaseUrl(url);
		paginate.setTotalCount(totalRows);
		paginate.setPageSize(pageSize);
		paginate.setDataPopulate(listClasses);
		paginate.setLinkPages();
		model.addAttribute("myPagination", paginate);
		
		
		return "myclass";
	}
	
	@RequestMapping(value="/get/{id}", method=RequestMethod.GET)
	@ResponseBody
	public MyClass getClassById(@PathVariable String id){
		MyClass mc = myClassService.getMyClassById(id);
		return mc;
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(@Valid @ModelAttribute("commandClass") MyClass myClass, RedirectAttributes redirectAttributes){
		myClassService.save(myClass);
		
		redirectAttributes.addFlashAttribute("message", "Class Berhasil ditambahkan");
		return "redirect:/myclass";
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable String id){
		MyClass myClass = new MyClass();
		myClass.setId(id);
		myClassService.delete(myClass);
	}
	
	@RequestMapping(value="/updclass", method=RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void updClass(@RequestBody MyClass myClass){
		myClassService.update(myClass);
	}
}
