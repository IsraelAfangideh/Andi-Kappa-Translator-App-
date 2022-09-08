package com.ayah.daos;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.ayah.models.Users;
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

		@ManyToOne
		@JoinColumn(name = "userid")
		private Users user;

		public X() {
			super();
			// TODO Auto-generated constructor stub
		}

		public X(int xid, String englishword, String efikword, String wordtype, String context) {
			super();
			this.xid = xid;
			this.englishword = englishword;
			this.efikword = efikword;
			this.wordtype = wordtype;
			this.context = context;
		}

		public X(String englishword, String efikword, String wordtype, String context) {
			super();
			this.englishword = englishword;
			this.efikword = efikword;
			this.wordtype = wordtype;
			this.context = context;
		}

		@Override
		public String toString() {
			return "X [xid=" + xid + ", englishword=" + englishword + ", efikword=" + efikword + ", wordtype="
					+ wordtype + ", context=" + context + "]";
		}

		public int getXid() {
			return xid;
		}

		public void setXid(int xid) {
			this.xid = xid;
		}

		public String getEnglishword() {
			return englishword;
		}

		public void setEnglishword(String englishword) {
			this.englishword = englishword;
		}

		public String getEfikword() {
			return efikword;
		}

		public void setEfikword(String efikword) {
			this.efikword = efikword;
		}

		public String getWordtype() {
			return wordtype;
		}

		public void setWordtype(String wordtype) {
			this.wordtype = wordtype;
		}

		public String getContext() {
			return context;
		}

		public void setContext(String context) {
			this.context = context;
		}
		

		
	}

