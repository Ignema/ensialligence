package com.ensialligence.UnitTest;


import com.ensialligence.model.Jaime;
import com.ensialligence.service.JaimeService;
import org.junit.Test;

public class JaimeTest {

    JaimeService jaime = new JaimeService();

    //************* Tester la method addJaime ************//
    @Test
    public void testAddJaime() {

        jaime.addJaime(new Jaime(2, 26));

    }
    //**************************************************//

    //************* Tester la method deleteJaime ************//
    @Test
    public void testDeleteJaime() {

        jaime.removeJaime(1);

    }
    //**************************************************//

}
