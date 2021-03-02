package com.ensialligence.dao;

import com.ensialligence.model.Friend;

import java.util.List;

public interface FriendDao {

    Friend addFriend(Friend f);

    void deleteFriend(int idFriend);

    List<Friend> getFriends(int idUser);

}
