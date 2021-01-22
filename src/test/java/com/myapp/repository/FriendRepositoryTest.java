package com.myapp.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.myapp.entity.Friend;

import junit.framework.Assert;

@RunWith(SpringRunner.class) //junit4
@DataJpaTest
public class FriendRepositoryTest {

	@Autowired
	FriendRepository repository;

	@Test
	public void testSaveFriend() {
		Friend friend = new Friend();
		friend.setName("punya");
		friend.setEmail("punya@gmail.com");
		friend.setPhone("12345");
		repository.save(friend);
		Assert.assertNotNull(friend.getId());
	}
	
	@Test
	public void testSelectFriend() {
		Friend friend = new Friend();
		friend.setName("punya");
		friend.setEmail("punya@gmail.com");
		friend.setPhone("12345");
		repository.save(friend);
		Assert.assertNotNull(friend.getId());
		
		Friend f = repository.findById(friend.getId()).get();
		Assert.assertNotNull(f);
		Assert.assertEquals("punya", f.getName());
		
	}

}
