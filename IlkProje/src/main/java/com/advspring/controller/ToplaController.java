package com.advspring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.advspring.dto.Sayilar;
import com.advspring.dto.SonucDTO;

@RestController
public class ToplaController {
	@GetMapping("/topla")
	public String topla(int sayi1) {
		System.out.println(sayi1);
		return "Sonuc: " + sayi1;
	}

	@PostMapping(value = "/topla2")
	public ResponseEntity<SonucDTO> topla2(@RequestBody Sayilar sayilar) {
		System.out.println(sayilar.getSayi1());
		System.out.println(sayilar.getSayi2());
		SonucDTO sonucDTO = new SonucDTO();
		sonucDTO.setSonuc(sayilar.getSayi1() + sayilar.getSayi2());
		return ResponseEntity.status(HttpStatus.CONFLICT).body(sonucDTO);
	}
}
