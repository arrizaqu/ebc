package com.bankmega.traning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value={"/","/dashboard"})
public class Main {
	
	@RequestMapping
	public String index(){
		return "dashboard";
	}
}
