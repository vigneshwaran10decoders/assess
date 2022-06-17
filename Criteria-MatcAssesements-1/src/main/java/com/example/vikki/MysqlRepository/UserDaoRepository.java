package com.example.vikki.MysqlRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vikki.Model.UserDao;

public interface UserDaoRepository extends JpaRepository <UserDao,Integer> {

	UserDao findByUsername(String username);

}
