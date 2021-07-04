package com.bowling.service;

import java.util.List;
import java.util.Optional;

import com.bowling.domain.BowlingUser;

/**
 * Service Interface for managing {@link BowlingUser}.
 */
public interface BowlingUserService {

    /**
     * Save a bowlingUser.
     *
     * @param bowlingUser the entity to save.
     * @return the persisted entity.
     */
    BowlingUser save(BowlingUser bowlingUser);

    /**
     * Get all the bowlingUsers.
     *
     * @return the list of entities.
     */
    List<BowlingUser> findAll();


    /**
     * Get the "id" bowlingUser.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<BowlingUser> findOne(Long id);

    /**
     * Delete the "id" bowlingUser.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
