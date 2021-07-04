package com.bowling.web.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bowling.domain.Game;
import com.bowling.dto.GameDTO;
import com.bowling.service.GameService;

@RestController
@RequestMapping("/api")
public class GameResource {

    private final Logger log = LoggerFactory.getLogger(GameResource.class);

    private final GameService gameService;

    public GameResource(GameService gameService) {
        this.gameService = gameService;
    }
  
    @GetMapping("/games")
    public List<Game> getAllGames() {
        log.debug("REST request to get all Games");
        return gameService.findAll();
    }
    
    @GetMapping("/games/{id}")
    public GameDTO getGame(@PathVariable Long id) {
        log.debug("REST request to get Game : {}", id);
        GameDTO game = gameService.getGameDetails(id);
        return game;
    }
}
