package com.AfangidehAyah;

import com.ayah.daos.EntryDAO;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = EntryControllerTests.class)
public class EntryControllerTests {

    @Mock(name = "EntryDAO")
    EntryDAO entrydao;

    @Test
    public void itexists(){
        assert (!
                entrydao.findById(0).isPresent());


    }


}
