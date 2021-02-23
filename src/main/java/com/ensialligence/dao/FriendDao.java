package com.ensialligence.dao;

import java.util.List;

import com.ensialligence.model.Friend;

public interface FriendDao {

	Friend addFriend(Friend f);
	
	void deleteFriend(int idFriend);
	
	List<Friend> getFriends(int idUser);

}
