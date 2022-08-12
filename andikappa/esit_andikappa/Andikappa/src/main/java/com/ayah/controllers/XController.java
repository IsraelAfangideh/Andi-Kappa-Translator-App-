package com.ayah.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayah.daos.XDAO;
import com.ayah.models.X;



@RestController
@RequestMapping(value = "/ikoh")
@CrossOrigin
public class XController {

	private XDAO xd;

	@Autowired
	public XController(XDAO xd) {
		super();
		this.xd = xd;
	}
	
	//Add New Translation
	@PostMapping
	public ResponseEntity addX(@RequestBody X x) {
		
		//We use the save method to do inserts
		
		X newX = xd.save(x);
		
		if (newX == null) {
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.accepted().body("You've inserted the following Translation: " + newX);
		
		
	}
	
	//Get by Efik Word
	@GetMapping(value = "/Efik")
	public ResponseEntity<List<X>> findByEfikWord(@RequestBody String efikword) {
		Optional<List<X>> xList = xd.findByEfikword(efikword);
		
		if (!xList.get().isEmpty()) {
			List<X> xl = xList.get();
			
			return ResponseEntity.ok(xl);
		}
		
		return ResponseEntity.noContent().build();
	}
//	
//	//Get by English Word
//	@GetMapping(value = "/getEnglish/{englishword}")
//	public ResponseEntity<List<X>> findbyenglishword(@PathVariable String englishword) {
//		Optional<List<X>> xList = xd.findbyenglishword(englishword);
//		
//		if (!xList.get().isEmpty()) {
//			List<X> xl = xList.get();
//			
//			return ResponseEntity.ok(xl);
//		}
//		
//		return ResponseEntity.noContent().build();
//	}
//	
//	//Get by ID
//	@GetMapping(value = "/getbyID/{xid}")
//	public ResponseEntity<List<X>> findByTranslationId(@PathVariable Integer xid) {
//		Optional<List<X>> xList = xd.findByTranslationId(xid);
//		
//		if (!xList.get().isEmpty()) {
//			List<X> xl = xList.get();
//			
//			return ResponseEntity.ok(xl);
//		}
//		
//		return ResponseEntity.noContent().build();
//	}
//	
		
}
