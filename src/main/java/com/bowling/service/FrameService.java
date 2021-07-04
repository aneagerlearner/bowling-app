package com.bowling.service;

import java.util.List;
import java.util.Optional;

import com.bowling.domain.Frame;

/**
 * Service Interface for managing {@link Frame}.
 */
public interface FrameService {

    /**
     * Save a frame.
     *
     * @param frame the entity to save.
     * @return the persisted entity.
     */
    Frame save(Frame frame);

    /**
     * Get all the frames.
     *
     * @return the list of entities.
     */
    List<Frame> findAll();


    /**
     * Get the "id" frame.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Frame> findOne(Long id);

    /**
     * Delete the "id" frame.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
