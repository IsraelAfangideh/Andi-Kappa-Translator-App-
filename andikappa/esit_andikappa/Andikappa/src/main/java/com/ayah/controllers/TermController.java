package com.ayah.controllers;

import java.util.List;
import java.util.Optional;

import com.ayah.models.Term;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayah.daos.TermDAO;


@RestController
@RequestMapping(value = "", produces = "application/json")
@CrossOrigin
public class TermController {

	private TermDAO termdao;

	@Autowired
	public TermController(TermDAO termdao) {
		super();
		this.termdao = termdao;
	}

	//Add New Translation
	@PostMapping(value = "/add")
	public ResponseEntity addterm(@RequestBody Term term) {

		//We use the save method to do inserts


		Term newTerm = termdao.save(term);
		System.out.println(newTerm);
		if (newTerm == null) {
			return ResponseEntity.badRequest().build();
		}

		return ResponseEntity.accepted().body("You've inserted the following Translation: " + newTerm);


	}

	@GetMapping(value = "/fetch/{term}")
	public Optional<List<Term>> fetch(@PathVariable String term) {
		Optional<List<Term>> ListOfTerms;
		ListOfTerms = termdao.findByEfikwordIgnoreCase(term);

//		if (termdao.findByEfikwordIgnoreCase(term).isPresent()){}

//if efik word does not exist
		if (ListOfTerms.get().isEmpty()) {
			ListOfTerms = termdao.findByEnglishwordIgnoreCase(term);

			if (ListOfTerms.get().isEmpty()) {
				ListOfTerms = termdao.findByAyeneIkohEfikKeEsit(term);

				if (ListOfTerms.get().isEmpty()) {
					ListOfTerms = termdao.findByAyeneIkohMbakaraKeEsit(term);

					return ListOfTerms;
				}
				return ListOfTerms;
			}
			return ListOfTerms;
		}
		return ListOfTerms;

	}

	//Get by English Word
	@GetMapping(value = "/getEnglish/{englishword}")
	public ResponseEntity<List<Term>> findbyenglishword(@PathVariable String englishword) {
		Optional<List<Term>> xList = termdao.findByEnglishwordIgnoreCase(englishword);

		if (!xList.get().isEmpty()) {
			List<Term> xl = xList.get();

			return ResponseEntity.ok(xl);
		}

		return ResponseEntity.noContent().build();
	}

	//Get by Efik Word
	@GetMapping(value = "/getEfik/{efikword}")
	public ResponseEntity<List<Term>> findbyefikword(@PathVariable String efikword) {
		Optional<List<Term>> xList = termdao.findByEfikwordIgnoreCase(efikword);

		if (!xList.get().isEmpty()) {
			List<Term> xl = xList.get();

			return ResponseEntity.ok(xl);
		}

		return ResponseEntity.noContent().build();
	}


	//ROUTES FOR CONTAINS QUERIES
	@GetMapping(value = "/ayeneEfik/{efikword}")
	public ResponseEntity<List<Term>> findByAyeneIkohEfikKeEsit(@PathVariable String efikword){
		Optional<List<Term>> xList = termdao.findByAyeneIkohEfikKeEsit(efikword);
		if (!xList.get().isEmpty()) {
			List<Term> xl = xList.get();
			return ResponseEntity.ok(xl);
		}

		return ResponseEntity.noContent().build();
	}

	@GetMapping(value = "/ayeneEnglish/{englishword}")
	public ResponseEntity<List<Term>> findByAyeneIkohMbakaraKeEsit(@PathVariable String englishword){
		Optional<List<Term>> xList = termdao.findByAyeneIkohMbakaraKeEsit(englishword);
		if (!xList.get().isEmpty()) {
			List<Term> xl = xList.get();
			return ResponseEntity.ok(xl);
		}

		return ResponseEntity.noContent().build();
	}

	@GetMapping(value = "/ayeneContext/{context}")
	public ResponseEntity<List<Term>>  findByAyeneContextKeEsit(@PathVariable String context){
		Optional<List<Term>> xList = termdao.findByAyeneContextKeEsit(context);
		if (!xList.get().isEmpty()) {
			List<Term> xl = xList.get();
			return ResponseEntity.ok(xl);
		}

		return ResponseEntity.noContent().build();
	}



}
