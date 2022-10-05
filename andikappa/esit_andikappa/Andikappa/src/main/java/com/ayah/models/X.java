package com.ayah.models;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


	@Entity
	@Component
	@Table(name = "x")
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	// @JsonPropertyOrder({ "englishword", "efikword", "wordtype", "context" })
	public class X {
		
		@Id
		@GeneratedValue(strategy =GenerationType.IDENTITY)
		private int xid;
		
		@Column
		private String englishword;
		
		@Column
		private String efikword;
		
		@Column
		private String wordtype;
		
		@Column
		private String context;

		@Column
		private String nse_awongo;

		@Column
		private String definition;

		@ManyToOne
		@JoinColumn(name = "addedbyuser")
		private Users user;

	public X() {
	}

	public X(int xid, String englishword, String efikword, String wordtype, String context, String nse_awongo, String definition, Users user) {
		this.xid = xid;
		this.englishword = englishword;
		this.efikword = efikword;
		this.wordtype = wordtype;
		this.context = context;
		this.nse_awongo = nse_awongo;
		this.definition = definition;
		this.user = user;
	}


	public X(String englishword, String efikword, String wordtype, String context, String nse_awongo, String definition, Users user) {
		this.englishword = englishword;
		this.efikword = efikword;
		this.wordtype = wordtype;
		this.context = context;
		this.nse_awongo = nse_awongo;
		this.definition = definition;
		this.user = user;
	}


	public int getXid() {
		return this.xid;
	}

	public void setXid(int xid) {
		this.xid = xid;
	}

	public String getEnglishword() {
		return this.englishword;
	}

	public void setEnglishword(String englishword) {
		this.englishword = englishword;
	}

	public String getEfikword() {
		return this.efikword;
	}

	public void setEfikword(String efikword) {
		this.efikword = efikword;
	}

	public String getWordtype() {
		return this.wordtype;
	}

	public void setWordtype(String wordtype) {
		this.wordtype = wordtype;
	}

	public String getContext() {
		return this.context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getNse_awongo() {
		return this.nse_awongo;
	}

	public void setNse_awongo(String nse_awongo) {
		this.nse_awongo = nse_awongo;
	}

	public String getDefinition() {
		return this.definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	public Users getUser() {
		return this.user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public X xid(int xid) {
		setXid(xid);
		return this;
	}

	public X englishword(String englishword) {
		setEnglishword(englishword);
		return this;
	}

	public X efikword(String efikword) {
		setEfikword(efikword);
		return this;
	}

	public X wordtype(String wordtype) {
		setWordtype(wordtype);
		return this;
	}

	public X context(String context) {
		setContext(context);
		return this;
	}

	public X nse_awongo(String nse_awongo) {
		setNse_awongo(nse_awongo);
		return this;
	}

	public X definition(String definition) {
		setDefinition(definition);
		return this;
	}

	public X user(Users user) {
		setUser(user);
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof X)) {
			return false;
		}
		X x = (X) o;
		return xid == x.xid && Objects.equals(englishword, x.englishword) && Objects.equals(efikword, x.efikword) && Objects.equals(wordtype, x.wordtype) && Objects.equals(context, x.context) && Objects.equals(nse_awongo, x.nse_awongo) && Objects.equals(definition, x.definition) && Objects.equals(user, x.user);
	}

	@Override
	public int hashCode() {
		return Objects.hash(xid, englishword, efikword, wordtype, context, nse_awongo, definition, user);
	}

	@Override
	public String toString() {
		return "{" +
			" xid='" + getXid() + "'" +
			", englishword='" + getEnglishword() + "'" +
			", efikword='" + getEfikword() + "'" +
			", wordtype='" + getWordtype() + "'" +
			", context='" + getContext() + "'" +
			", nse_awongo='" + getNse_awongo() + "'" +
			", definition='" + getDefinition() + "'" +
			", user='" + getUser() + "'" +
			"}";
	}

		

		
	}

