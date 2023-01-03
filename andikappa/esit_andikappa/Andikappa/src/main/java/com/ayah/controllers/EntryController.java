package com.ayah.controllers;

import java.util.List;
import java.util.Optional;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.ayah.daos.AuthorDAO;
import com.ayah.models.Author;
import com.ayah.models.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ayah.daos.EntryDAO;


@RestController
@RequestMapping(value = "", produces = "application/json")
@CrossOrigin
public class EntryController {

	private EntryDAO entryDAO;

	private AuthorDAO authorDAO;

	private AuthorController authorController;

	@Autowired
	public EntryController(EntryDAO entryDAO, AuthorDAO authorDAO, AuthorController authorController) {
		super();
		this.entryDAO = entryDAO;
		this.authorDAO = authorDAO;
		this.authorController = authorController;
	}

	//Add New Translation
	@PostMapping(value = "/add")
	public ResponseEntity addEntry(@RequestBody Entry entry) {

		//We use the save method to do inserts and modifications

		Entry newEntry = entryDAO.save(entry);


		Author EntryAuthor = authorController.getauthorbyid(newEntry.getAuthorid().get(0)).get();
		System.out.println(EntryAuthor);

		EntryAuthor.getEntryids().add(newEntry.getTermid());

		EntryAuthor.setCred(EntryAuthor.getEntryids().size() * 2.7);

		authorDAO.save(EntryAuthor);


		if (newEntry == null) {
			return ResponseEntity.badRequest().build();
		}

		return ResponseEntity.accepted().body("You've inserted the following Translation: " + newEntry);


	}

	@GetMapping(value = "/fetch")
	public List<Entry>getall() {

		return entryDAO.findAll();
	}

	@GetMapping(value = "/fetch/byid/{id}")
	public Optional<Entry>getbyid(@PathVariable Integer id) {

		return entryDAO.findById(id);
	}

	@GetMapping(value = "/fetch/{term}")
	public Optional<List<Entry>> fetch(@PathVariable String term) {
		Optional<List<Entry>> ListOfTerms;
		ListOfTerms = entryDAO.findByEfikwordIgnoreCase(term);

//		if (termdao.findByEfikwordIgnoreCase(term).isPresent()){}

//if efik word does not exist
		if (ListOfTerms.get().isEmpty()) {
			ListOfTerms = entryDAO.findByEnglishwordIgnoreCase(term);

			if (ListOfTerms.get().isEmpty()) {
				ListOfTerms = entryDAO.findByAyeneIkohEfikKeEsit(term);

				if (ListOfTerms.get().isEmpty()) {
					ListOfTerms = entryDAO.findByAyeneIkohMbakaraKeEsit(term);

					return ListOfTerms;
				}
				return ListOfTerms;
			}
			return ListOfTerms;
		}

		return ListOfTerms;

	}

//	@PutMapping(value = "/patch/{id}")
//	public Optional<Entry> modifyentry(@PathVariable int id, @RequestBody Entry entry){
//
//	}

		@GetMapping(value = "/fetch/byauthor/{authorid}")
		Optional<List<Entry>>findByAuthorId(@PathVariable Integer authorid){

		return entryDAO.findByAuthorid(authorid);
		}




}
