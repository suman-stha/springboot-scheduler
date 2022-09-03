package com.springbootscheduler.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootscheduler.entity.User;

public interface UserDao extends JpaRepository<User, Integer> {

}
