package com.arrsoft.ebc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.arrsoft.ebc.model.Materi;
import com.arrsoft.ebc.security.ApiKey;
import com.arrsoft.ebc.service.MateriService;

@Controller
@RequestMapping("/materi-ws")
public class MateriWS {
	
	@Autowired
	private MateriService materiService;
	
	@RequestMapping(value="get/{page}", method=RequestMethod.GET)
	@ResponseBody
	public List<Materi> getMateriPage(@PathVariable int page){
		int pageSize = 10;
		List<Materi> listMateri = materiService.getMateriByPage(page, pageSize);
		return listMateri;
	}
	
	@RequestMapping(value = "/save/{key}", method = RequestMethod.POST )
	@ResponseStatus(HttpStatus.OK)
	public void insertMateri(@PathVariable String key, @RequestBody Materi materi){
		if(key.equals(ApiKey.MOBILE_KEY)){
			materiService.save(materi);
		} 
	}
}
