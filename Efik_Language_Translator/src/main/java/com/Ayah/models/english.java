package com.Ayah.models;

import java.util.ArrayList;

public class english {
	
	private int english_id;
	private String english_word;
	private efik efik;
	
	private ArrayList <String> translations;
	
	//no args
	public english() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//both args
	public english(int english_id, String english_word) {
		super();
		this.english_id = english_id;
		this.english_word = english_word;
	}
	
	//args minus id
	public english(String english_word) {
		super();
		this.english_word = english_word;
	}
	
	//toString
	@Override
	public String toString() {
		return "english [english_id=" + english_id + ", english_word=" + english_word + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	//Getters and Setters
	public int getEnglish_id() {
		return english_id;
	}
	public void setEnglish_id(int english_id) {
		this.english_id = english_id;
	}
	public String getEnglish_word() {
		return english_word;
	}
	public void setEnglish_word(String english_word) {
		this.english_word = english_word;
	}

	public english(com.Ayah.models.efik efik) {
		super();
		this.efik = efik;
	}

	public english(int english_id, String english_word, com.Ayah.models.efik efik) {
		super();
		this.english_id = english_id;
		this.english_word = english_word;
		this.efik = efik;
	}

	public efik getEfik() {
		return efik;
	}

	public void setEfik(efik efik) {
		this.efik = efik;
	}

	public ArrayList<String> getTranslations() {
		return translations;
	}

	public void setTranslations(ArrayList<String> translations) {
		this.translations = translations;
	}

	public english(ArrayList<String> translations, int english_id, String english_word) {
		super();
		this.english_id = english_id;
		this.english_word = english_word;
		this.translations = translations;
	}

	
	
	
	
}
