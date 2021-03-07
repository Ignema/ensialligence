package com.ensialligence.UnitTest;

import com.ensialligence.model.Article;
import com.ensialligence.model.User;
import com.ensialligence.model.UserPlusToken;
import com.ensialligence.service.UserService;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;

public class UserTest {

    UserService userService=new UserService();

    //************* Tester la method addUser ************//
    @Test
    public void testAddUser() {

        userService.addUser(new User(1l, "med", "123","med", "edd", "med@gmail.com", "2010-04-02"));

    }
    //**************************************************//

    //************* Tester la method getListFriends ************//
    @Test
    public void testGetListFriends() {

        ArrayList<User> usersFriends =  userService.listFriends(2L);
        for(User u : usersFriends) {
            System.out.println("usersFriends [id=" + u.getId() + ", FirstName=" + u.getFirstname() + ", LastName=" + u.getLastname() + ", UserName=" + u.getUsername()
                    + ", Password=" + u.getPassword() + ", Mail=" + u.getMail() + ", Date Naissance=" + u.getDate_nais() + "]");

        }
    }
    //**************************************************//

    //************* Tester la method getUser ************//
    @Test
    public void testGetUser() {

        UserPlusToken UserTok=userService.findUser("med", "123");
        System.out.println(UserTok.getUser().getFirstname()+" : token : "+UserTok.getToken());
    }
    //**************************************************//

}
