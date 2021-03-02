package com.ensialligence.UnitTest;


import com.ensialligence.model.Message;
import com.ensialligence.service.MessageService;
import org.junit.Test;

public class MessageTest {

    MessageService msg = new MessageService();

    //************* Tester la method addMsg ************//
    @Test
    public void testAddMsg() {

        msg.saveMsg(new Message( "Mon msg ","2020-02-02", false, 2, 3));

    }
    //**************************************************//

    //************* Tester la method deleteMsg ************//
    @Test
    public void testDeleteMsg() {

        msg.deleteMsg(21);
    }
    //**************************************************//


}
