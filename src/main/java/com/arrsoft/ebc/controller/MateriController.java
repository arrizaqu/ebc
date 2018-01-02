package com.arrsoft.ebc.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RestController;

import com.arrsoft.ebc.model.Materi;
import com.arrsoft.ebc.service.MateriService;
import com.arrsoft.ebc.utils.RzPaginate;

@Controller
@RequestMapping("/materi-api/")
public class MateriController {

	@Autowired
	private MateriService materiService;
	
	@RequestMapping("get/{page}")
	@ResponseBody
	public List<Materi> index(@PathVariable int page){
		RzPaginate<Materi> paginate= new RzPaginate();
		int pageSize = 10;
		List<Materi> listMateri = materiService.getMateriByPage(page, pageSize);
		int totalRows = materiService.getCountMateri();
		return listMateri;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST )
	@ResponseStatus(HttpStatus.CREATED)
	public void insertMateri(@RequestBody Materi materi){
		materiService.save(materi);
	}
}
