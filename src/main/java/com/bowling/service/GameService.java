package com.bowling.service;

import java.util.List;

import com.bowling.domain.Game;
import com.bowling.service.dto.GameDTO;

public interface GameService {

    List<Game> findAll();
  
    GameDTO getGameDetails(Long id);

}
