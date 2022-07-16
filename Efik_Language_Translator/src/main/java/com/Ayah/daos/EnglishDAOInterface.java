package com.Ayah.daos;

import java.util.ArrayList;

import com.Ayah.models.english;

public interface EnglishDAOInterface {
	
	// english getEnglishWord(String english_word);
	//select by english_word
	//SELECT * FROM english INNER JOIN efik ON english_id_fk = english_id WHERE english_word = 'Abandon';
	 boolean insertEnglishWord(english english);
	
	//boolean deleteEnglishWord ();
	 
	 ArrayList<english> getAllEnglishWords();
	 
	 english getThisEnglishWord(String english_word);

}
