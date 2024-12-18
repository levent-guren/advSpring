package com.advspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrnekController {
	// @RequestMapping(value = "/", method = RequestMethod.GET)
	@GetMapping("/")
	// @ResponseBody
	public String merhaba() {
		System.out.println("Burası çalıştı");
		return "Merhaba";
	}
}
