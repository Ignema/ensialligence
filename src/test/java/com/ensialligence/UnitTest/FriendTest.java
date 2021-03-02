package com.ensialligence.UnitTest;


import com.ensialligence.model.Friend;
import com.ensialligence.service.FriendService;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FriendTest {

    FriendService friend = new FriendService();

    //************* Tester la method addFriend ************//
    @Test
    public void testAddFriend() {

        friend.addFriend(new Friend(1, 3));

    }
    //**************************************************//

    //*********** Tester la method friendsByIdUser*********//
    @Test
    public void testFriendsByIdUser() {
        List<Friend>  Friends = friend.getFriends(1);
        assertEquals(18,Friends.size());
    }
    //**********************************************//

    //************* Tester la method deleteFriend ************//
    @Test
    public void testDeleteFriend() {

        friend.deleteFriend(59);

    }
    //**************************************************//
}
