package com.ayah.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ayah.daos.XDAO;
import com.ayah.models.X;



@RestController
@RequestMapping(value = "/ikoh", produces = "application/json")
@CrossOrigin
public class XController {

	private XDAO xd;

	@Autowired
	public XController(XDAO xd) {
		super();
		this.xd = xd;
	}
	
	//Add New Translation
	@PostMapping(value = "/add")
	public ResponseEntity addX(@RequestBody X x) {
		
		//We use the save method to do inserts
	

		X newX = xd.save(x);
		System.out.println(newX);
		if (newX == null) {
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.accepted().body("You've inserted the following Translation: " + newX);
		
		
	}
	

	//Get by English Word
	@GetMapping(value = "/getEnglish/{englishword}")
	public ResponseEntity<List<X>> findbyenglishword(@PathVariable String englishword) {
		Optional<List<X>> xList = xd.findByEnglishwordIgnoreCase(englishword);
		
		if (!xList.get().isEmpty()) {
			List<X> xl = xList.get();
			
			return ResponseEntity.ok(xl);
		}
		
		return ResponseEntity.noContent().build();
	}
	
	//Get by Efik Word
	@GetMapping(value = "/getEfik/{efikword}")
	public ResponseEntity<List<X>> findbyefikword(@PathVariable String efikword) {
		Optional<List<X>> xList = xd.findByEfikwordIgnoreCase(efikword);
		
		if (!xList.get().isEmpty()) {
			List<X> xl = xList.get();
			
			return ResponseEntity.ok(xl);
		}
		
		return ResponseEntity.noContent().build();
	}


	//ROUTES FOR CONTAINS QUERIES
	@GetMapping(value = "/ayeneEfik/{efikword}")
	public ResponseEntity<List<X>> findByAyeneIkohEfikKeEsit(@PathVariable String efikword){
		Optional<List<X>> xList = xd.findByAyeneIkohEfikKeEsit(efikword);
		if (!xList.get().isEmpty()) {
			List<X> xl = xList.get();
			return ResponseEntity.ok(xl);
		}

		return ResponseEntity.noContent().build();
	}

	@GetMapping(value = "/ayeneEnglish/{englishword}")
	public ResponseEntity<List<X>> findByAyeneIkohMbakaraKeEsit(@PathVariable String englishword){
		Optional<List<X>> xList = xd.findByAyeneIkohMbakaraKeEsit(englishword);
		if (!xList.get().isEmpty()) {
			List<X> xl = xList.get();
			return ResponseEntity.ok(xl);
		}

		return ResponseEntity.noContent().build();
	}

	@GetMapping(value = "/ayeneContext/{context}")
	public ResponseEntity<List<X>>  findByAyeneContextKeEsit(@PathVariable String context){
		Optional<List<X>> xList = xd.findByAyeneContextKeEsit(context);
		if (!xList.get().isEmpty()) {
			List<X> xl = xList.get();
			return ResponseEntity.ok(xl);
		}

		return ResponseEntity.noContent().build();
	}
		
}
