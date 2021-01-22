package com.myapp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.entity.Friend;
import com.myapp.repository.FriendRepository;

@Service
public class FriendServiceImpl implements FriendService {

	private static final Logger log = LoggerFactory.getLogger(FriendServiceImpl.class);

	@Autowired
	private FriendRepository friendRepository;

	@Override
	public String addFriend(Friend friend) {
		log.info("Inside FriendServiceImpl.addFriend method");
		log.debug("Input data:{}", friend);
		Friend f = friendRepository.save(friend);
		log.debug("Response data:{}", friend);
		return "friend with name :" + f.getName() + " hasa been saved successfully with id =" + f.getId();
	}

	@Override
	public Friend getFriendById(Integer id) {
		return friendRepository.findById(id).get();
	}

	@Override
	public List<Friend> getAllFriends() {
		return friendRepository.findAll();
	}

	@Override
	public Friend updateFriend(Friend friend) {
		return friendRepository.save(friend);
	}

	@Override
	public void deleteFriendById(Integer id) {
		Friend myFriend = friendRepository.findById(id).get();
		friendRepository.delete(myFriend);
	}
}
