package com.audit.app.customer;

import org.springframework.stereotype.Controller;

@Controller
public class StartPage
{
	public String index() {
		return "index";
	}
}
