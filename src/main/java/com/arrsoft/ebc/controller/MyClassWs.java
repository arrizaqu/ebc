package com.arrsoft.ebc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.arrsoft.ebc.model.MyClass;
import com.arrsoft.ebc.model.Pembahasan;
import com.arrsoft.ebc.security.ApiKey;
import com.arrsoft.ebc.service.MyClassService;
import com.arrsoft.ebc.service.PembahasanService;

@Controller
@RequestMapping("/class-ws")
public class MyClassWs {
	
	@Autowired
	private MyClassService materiService;
	@Autowired
	private PembahasanService pembahasanService;
	
	//data all session class
	@RequestMapping(value="get", method=RequestMethod.GET)
	@ResponseBody
	public List<MyClass> getMateriPage(@RequestParam(value="page", defaultValue="0") int page){
		int pageSize = 10;
		List<MyClass> listMateri = materiService.getMateriByPage(page, pageSize);
		/*if(listMateri == null){
			MyClass mc = new MyClass();
			listMateri = new ArrayList();
			listMateri.add(mc);
		}*/
		return listMateri;
	}
	
	//data all session class by language
	@RequestMapping(value="get-prog", method=RequestMethod.GET)
	@ResponseBody
	public List<MyClass> getMateriPageByLg(@RequestParam(value="page", defaultValue="0") int page, @RequestParam(value="programming", required=false) String prog){
		int pageSize = 10;
		List<MyClass> listMateri = materiService.getMateriByPageAndLg(page, pageSize, prog);
		/*if(listMateri == null){
			MyClass mc = new MyClass();
			listMateri = new ArrayList();
			listMateri.add(mc);
		}*/
		return listMateri;
	}
	
	@RequestMapping(value = "/save/{key}", method = RequestMethod.POST )
	@ResponseStatus(HttpStatus.OK)
	public void insertMyClass(@PathVariable String key, @RequestBody MyClass materi){
		if(key.equals(ApiKey.MOBILE_KEY)){
			materiService.save(materi);
		} 
	}
	
	@RequestMapping(value="/list-pembahasan", method=RequestMethod.GET)
	@ResponseBody
	public List<Pembahasan> getPembahasanPage(@RequestParam(value="page", defaultValue="0") int page){
		int pageSize = 10;
		List<Pembahasan> listPembahasan = pembahasanService.getPembahasanByPage(page, pageSize);
		
		return listPembahasan;
	}
	
	@RequestMapping(value="/pembahasan", method=RequestMethod.GET)
	@ResponseBody
	public List<Pembahasan> getPembahasanPage(@RequestParam(value="page", defaultValue="0") int page, @RequestParam(value="classid", required=false) String classid){
		int pageSize = 10;
		List<Pembahasan> listPembahasan = pembahasanService.getPembahasanByPageClassId(page, pageSize, classid);
		/*
		if(listPembahasan == null){
			Pembahasan bahasan = new Pembahasan();
			listPembahasan = new ArrayList();
			listPembahasan.add(bahasan);
		}*/
		return listPembahasan;
	}
	
	@RequestMapping(value="/save-pembahasan/{key}/", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void insertPembahasanByClass(@PathVariable String key, @RequestBody Pembahasan pembahasan){
		if(key.equals(ApiKey.MOBILE_KEY)){
			pembahasanService.save(pembahasan);
		} 
	}
}
