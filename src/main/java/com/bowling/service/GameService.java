package com.bowling.service;

import java.util.List;

import com.bowling.domain.Game;
import com.bowling.service.dto.GameDTO;

/**
 * Service Interface for managing {@link Game}.
 */
public interface GameService {

    /**
     * Save a game.
     *
     * @param game the entity to save.
     * @return the persisted entity.
     */
    Game save(Game game);

    /**
     * Get all the games.
     *
     * @return the list of entities.
     */
    List<Game> findAll();


    /**
     * Get the "id" game.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    GameDTO findOne(Long id);

    /**
     * Delete the "id" game.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
