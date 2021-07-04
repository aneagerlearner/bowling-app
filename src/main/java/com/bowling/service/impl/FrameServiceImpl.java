package com.bowling.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bowling.domain.Frame;
import com.bowling.repository.FrameRepository;
import com.bowling.service.FrameService;

/**
 * Service Implementation for managing {@link Frame}.
 */
@Service
@Transactional
public class FrameServiceImpl implements FrameService {

    private final Logger log = LoggerFactory.getLogger(FrameServiceImpl.class);

    private final FrameRepository frameRepository;

    public FrameServiceImpl(FrameRepository frameRepository) {
        this.frameRepository = frameRepository;
    }

    /**
     * Save a frame.
     *
     * @param frame the entity to save.
     * @return the persisted entity.
     */
    @Override
    public Frame save(Frame frame) {
        log.debug("Request to save Frame : {}", frame);
        return frameRepository.save(frame);
    }

    /**
     * Get all the frames.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<Frame> findAll() {
        log.debug("Request to get all Frames");
        return frameRepository.findAll();
    }


    /**
     * Get one frame by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Frame> findOne(Long id) {
        log.debug("Request to get Frame : {}", id);
        return frameRepository.findById(id);
    }

    /**
     * Delete the frame by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Frame : {}", id);
        frameRepository.deleteById(id);
    }
}
