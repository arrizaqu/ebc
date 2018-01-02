package com.arrsoft.ebc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arrsoft.ebc.model.Materi;

@RestController
@RequestMapping("/msapi/")
public class MateriController {

	@RequestMapping("/materi/{id}")
	public List<Materi> index(){
		List<Materi> mList = new ArrayList();
		return mList;
	}
}
