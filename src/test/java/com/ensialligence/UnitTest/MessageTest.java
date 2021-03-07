package com.ensialligence.UnitTest;


import com.ensialligence.model.Message;
import com.ensialligence.service.MessageService;
import org.junit.Test;

public class MessageTest {

    MessageService msg = new MessageService();

    //************* Tester la method addMsg ************//
    @Test
    public void testAddMsg() {

        Message message = msg.saveMsg(new Message( "Mon msg ","2020-02-02", false, 2, 3));

        System.out.println("Message added : [idMsg=" + message.getMsg() + ", msg=" + message.getMsg() + ", date_envoi=" + message.getDate_envoi() + ", isRead=" + message.isRead()
                + ", idSender=" + message.getIdSender() + ", idReceiver=" + message.getIdReceiver() + "]");
    }
    //**************************************************//

    //************* Tester la method deleteMsg ************//
    @Test
    public void testDeleteMsg() {

        msg.deleteMsg(21);
    }
    //**************************************************//


}
