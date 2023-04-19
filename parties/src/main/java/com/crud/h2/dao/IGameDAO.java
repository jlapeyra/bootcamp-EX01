package com.crud.h2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.crud.h2.dto.Game;


public interface IGameDAO extends JpaRepository<Game, Long>{

}
