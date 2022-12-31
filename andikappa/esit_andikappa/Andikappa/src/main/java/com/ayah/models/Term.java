package com.ayah.models;
import java.util.Objects;

import javax.persistence.*;

import com.sun.istack.NotNull;
import org.springframework.stereotype.Component;


@Entity
	@Component
	@Table(name = "term")
	public class Term {
		
		@Id
		@GeneratedValue(strategy =GenerationType.IDENTITY)
		private int termid;
		
		@Column
		@NotNull
		private String englishword;
		
		@Column
		@NotNull
		private String efikword;

		
		@Column
		private String example;

		@Column
		private int weight;

		@JoinColumn(name = "author")
		@ManyToOne(fetch = FetchType.LAZY)
		private User author;

	public Term() {
	}

		@Override
		public String toString() {
			return "Term{" +
					"termid=" + termid +
					", englishword='" + englishword + '\'' +
					", efikword='" + efikword + '\'' +
					", example='" + example + '\'' +
					", weight=" + weight +
					", author=" + author +
					'}';
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (!(o instanceof Term)) return false;
			Term term = (Term) o;
			return getTermid() == term.getTermid() && getWeight() == term.getWeight() && Objects.equals(getEnglishword(), term.getEnglishword()) && Objects.equals(getEfikword(), term.getEfikword()) && Objects.equals(getExample(), term.getExample()) && Objects.equals(getAuthor(), term.getAuthor());
		}

		@Override
		public int hashCode() {
			return Objects.hash(getTermid(), getEnglishword(), getEfikword(), getExample(), getWeight(), getAuthor());
		}

		public int getTermid() {
			return termid;
		}

		public void setTermid(int termid) {
			this.termid = termid;
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

		public String getExample() {
			return example;
		}

		public void setExample(String example) {
			this.example = example;
		}

		public int getWeight() {
			return weight;
		}

		public void setWeight(int weight) {
			this.weight = weight;
		}

		public User getAuthor() {
			return author;
		}

		public void setAuthor(User author) {
			this.author = author;
		}

		public Term(String englishword, String efikword, String example, int weight, User author) {
			this.englishword = englishword;
			this.efikword = efikword;
			this.example = example;
			this.weight = weight;
			this.author = author;
		}

		public Term(int termid, String englishword, String efikword, String example, int weight, User author) {
			this.termid = termid;
			this.englishword = englishword;
			this.efikword = efikword;
			this.example = example;
			this.weight = weight;
			this.author = author;
		}
	}

