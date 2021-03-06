package com.myapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myapp.entity.Friend;

@Repository
public interface FriendRepository extends JpaRepository<Friend, Integer> {

}
