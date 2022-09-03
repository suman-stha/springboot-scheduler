package com.springbootscheduler.service;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.springbootscheduler.dao.UserDao;
import com.springbootscheduler.entity.User;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    Logger log = LoggerFactory.getLogger(UserService.class);

    // schedule a job to add object in DB(Every 5 sec)

    @Scheduled(fixedRate = 5000)
    public void add2DBJob() {
        User user = new User();
        user.setName("User " + new Random().nextInt(1255));
        userDao.save(user);
        System.out.println("Add service call in  " + new Date().toString());
    }

    @Scheduled(cron = "0/15 * * * * *")
    public void fetchDBJob() {
        List<User> users = userDao.findAll();
        System.out.println("Fetch service cal in " + new Date().toString());
        System.out.println("No of record fetched: " + users.size());
        log.info("users : {}", users);

    }
}
