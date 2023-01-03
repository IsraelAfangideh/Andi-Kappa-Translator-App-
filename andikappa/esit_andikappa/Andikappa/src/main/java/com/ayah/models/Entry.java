package com.ayah.models;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;
import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.stereotype.Component;



@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
	@Component
	@Table(name = "entry")
	public class Entry {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int termid;
		
		@Column(nullable = false)
		@NotNull
		private String englishword;
		
		@Column(nullable = false)
		@NotNull
		private String efikword;

		
		@Column(nullable = false)
		private String example;

		@Column(nullable = false)
		private int weight;

		@ElementCollection
		@Column(nullable = false)
		private List<Integer> authorid;



	}

