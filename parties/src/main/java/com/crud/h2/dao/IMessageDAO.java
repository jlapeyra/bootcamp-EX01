package com.crud.h2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.crud.h2.dto.Message;


public interface IMessageDAO extends JpaRepository<Message, Long>{

}
