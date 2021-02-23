package com.ensialligence.dao;

import com.ensialligence.model.Message;

public interface MessageDao {
	
	Message saveMsg(Message m);
	
	void  deleteMsg(int idMsg);

}
