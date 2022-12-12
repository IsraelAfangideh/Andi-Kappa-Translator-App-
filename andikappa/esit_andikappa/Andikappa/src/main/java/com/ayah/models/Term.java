package com.ayah.models;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.sun.istack.NotNull;
import org.springframework.stereotype.Component;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


	@Entity
	@Component
	@Table(name = "x")
	public class Term {
		
		@Id
		@GeneratedValue(strategy =GenerationType.IDENTITY)
		private int xid;
		
		@Column
		@NotNull
		private String englishword;
		
		@Column
		@NotNull
		private String efikword;

		
		@Column
		private String context;


		@Column
		private String poster;

	public Term() {
	}

	public Term(int xid, String englishword, String efikword, String context, String definition, String poster) {
		this.xid = xid;
		this.englishword = englishword;
		this.efikword = efikword;

		this.context = context;
		this.poster = poster;
	}


	public Term(String englishword, String efikword, String wordtype, String context, String nse_awongo, String definition, String poster) {
		this.englishword = englishword;
		this.efikword = efikword;
		this.context = context;
		this.poster = poster;
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


	public String getContext() {
		return this.context;
	}

	public void setContext(String context) {
		this.context = context;
	}


	public String getPoster() {
		return this.poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public Term xid(int xid) {
		setXid(xid);
		return this;
	}

	public Term englishword(String englishword) {
		setEnglishword(englishword);
		return this;
	}

	public Term efikword(String efikword) {
		setEfikword(efikword);
		return this;
	}



	public Term context(String context) {
		setContext(context);
		return this;
	}



	public Term user(String user) {
		setPoster(user);
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Term)) {
			return false;
		}
		Term term = (Term) o;
		return xid == term.xid && Objects.equals(englishword, term.englishword) && Objects.equals(efikword, term.efikword) && Objects.equals(context, term.context) && Objects.equals(poster, term.poster);
	}

	@Override
	public int hashCode() {
		return Objects.hash(xid, englishword, efikword, context, poster);
	}

	@Override
	public String toString() {
		return "{" +
			" xid='" + getXid() + "'" +
			", englishword='" + getEnglishword() + "'" +
			", efikword='" + getEfikword() + "'" +
			", context='" + getContext() + "'" +
			", user='" + getPoster() + "'" +
			"}";
	}

		

		
	}

