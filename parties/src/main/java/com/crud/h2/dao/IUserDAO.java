package com.crud.h2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.crud.h2.dto.User;


public interface IUserDAO extends JpaRepository<User, Long>{

}
