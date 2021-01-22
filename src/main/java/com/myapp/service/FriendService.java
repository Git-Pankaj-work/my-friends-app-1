package com.myapp.service;

import java.util.List;

import com.myapp.entity.Friend;

public interface FriendService {
	
	public String addFriend(Friend friend);
	public Friend getFriendById(Integer id);
	public List<Friend> getAllFriends();
	public Friend updateFriend(Friend friend);
	public void deleteFriendById(Integer id);

}
