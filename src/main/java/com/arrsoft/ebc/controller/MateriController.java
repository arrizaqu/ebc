package com.arrsoft.ebc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/msapi/")
public class MateriController {

	@RequestMapping("/materi/{id}")
	public String index(){
		return "hello world!!";
	}
}
