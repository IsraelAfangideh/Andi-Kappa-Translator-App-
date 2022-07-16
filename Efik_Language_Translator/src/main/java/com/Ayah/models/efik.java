package com.Ayah.models;

public class efik {
	
	private int efik_id;
	private String efik_word;
	private int english_id_fk;
	
	//no args
	public efik() {
		super();
		// TODO Auto-generated constructor stub
	}
	//all args
	public efik(int efik_id, String efik_word, int english_id_fk) {
		super();
		this.efik_id = efik_id;
		this.efik_word = efik_word;
		this.english_id_fk = english_id_fk;
	}
	
	//all args minus id
	public efik(String efik_word, int english_id_fk) {
		super();
		this.efik_word = efik_word;
		this.english_id_fk = english_id_fk;
	}
	//toString
	@Override
	public String toString() {
		return "efik [efik_id=" + efik_id + ", efik_word=" + efik_word + ", english_id_fk=" + english_id_fk
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	//Getters and Setters
	public int getEfik_id() {
		return efik_id;
	}
	public void setEfik_id(int efik_id) {
		this.efik_id = efik_id;
	}
	public String getEfik_word() {
		return efik_word;
	}
	public void setEfik_word(String efik_word) {
		this.efik_word = efik_word;
	}
	public int getEnglish_id_fk() {
		return english_id_fk;
	}
	public void setEnglish_id_fk(int english_id_fk) {
		this.english_id_fk = english_id_fk;
	}

}

