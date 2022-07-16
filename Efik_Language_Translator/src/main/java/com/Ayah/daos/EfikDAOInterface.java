package com.Ayah.daos;

import java.util.ArrayList;

import com.Ayah.models.efik;
import com.Ayah.models.english;

public interface EfikDAOInterface {
	
	//boolean insertNewEfikWord ();
	//byEnglish_id_fk
	//Would be better to insert by english_word
	
	void deleteEfikWord (int id);
	
	 efik getEfikWordById(int efik_id);
	//SELECT * FROM english INNER JOIN efik ON english_id_fk = english_id WHERE efik_word = 'yak';
	 boolean updateEfikForeignKey (String efik_word, int english_id_fk);
	 
	 boolean insertEfikWord(efik efik);
}
