package com.arrsoft.ebc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

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

import com.arrsoft.ebc.model.MyClass;
import com.arrsoft.ebc.model.Pembahasan;
import com.arrsoft.ebc.service.MyClassService;
import com.arrsoft.ebc.service.PembahasanService;
import com.arrsoft.ebc.utils.RzPaginate;

@Controller
@RequestMapping("/pembahasan")
public class PembahasanController {

	private int pageSize = 10;
	@Autowired
	PembahasanService pembahasanService;
	
	@Autowired
	MyClassService myClassService;
	
	@Autowired
	ServletContext servletContext;
	
	@ModelAttribute("commandPembahasan")
	public Pembahasan getInstancePembahasan(){
		return new Pembahasan();
	}
	
	@RequestMapping(value="/get", method=RequestMethod.GET)
	@ResponseBody
	public Pembahasan get(@RequestParam(value="id", defaultValue = "0") String id){
		Pembahasan pembahasan = pembahasanService.getPembahasanById(id);
		return pembahasan;
	}
	
	@RequestMapping
	public String index(Model model, @RequestParam(value="page", defaultValue="0") int page){
		List<MyClass> myclass = myClassService.getAll();
		
		List<String> dataLg = new ArrayList();
		dataLg.add("java");
		dataLg.add("android");
		dataLg.add(".NET");
		dataLg.add("PHP");
		dataLg.add("javascript");
		model.addAttribute("lgList", dataLg);
		model.addAttribute("listClass", myclass);
		model.addAttribute("");
		
		//pagination
		List<Pembahasan> listPembahasan = pembahasanService.getPembahasanByPage(page, pageSize);
		long totalRows = myClassService.getCountMateri();
		RzPaginate<Pembahasan> paginate= new RzPaginate();
		String url = servletContext.getContextPath()+ "/pembahasan";
		paginate.setCurrentPage(page);
		paginate.setBaseUrl(url);
		paginate.setTotalCount(totalRows);
		paginate.setPageSize(pageSize);
		paginate.setDataPopulate(listPembahasan);
		paginate.setLinkPages();
		model.addAttribute("myPagination", paginate);
		
		return "pembahasan";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String savePembahasan(@ModelAttribute("commandPembahasan") Pembahasan pembahasan, Model model){
		pembahasanService.save(pembahasan);
		return "redirect:/pembahasan";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void updatePembahasan(@RequestBody Pembahasan pembahasan){
		pembahasanService.save(pembahasan);
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public String delete(@PathVariable String id){
		Pembahasan pembahasan = new Pembahasan();
		pembahasan.setId(id);
		pembahasanService.delete(pembahasan);
		return "redirect:/pembahasan";
	}
}
