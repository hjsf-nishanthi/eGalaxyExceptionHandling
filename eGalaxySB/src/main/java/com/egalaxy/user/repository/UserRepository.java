package com.egalaxy.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.egalaxy.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
