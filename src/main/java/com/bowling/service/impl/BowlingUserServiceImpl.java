package com.bowling.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bowling.domain.BowlingUser;
import com.bowling.repository.BowlingUserRepository;
import com.bowling.service.BowlingUserService;

/**
 * Service Implementation for managing {@link BowlingUser}.
 */
@Service
@Transactional
public class BowlingUserServiceImpl implements BowlingUserService {

    private final Logger log = LoggerFactory.getLogger(BowlingUserServiceImpl.class);

    private final BowlingUserRepository bowlingUserRepository;

    public BowlingUserServiceImpl(BowlingUserRepository bowlingUserRepository) {
        this.bowlingUserRepository = bowlingUserRepository;
    }

    /**
     * Save a bowlingUser.
     *
     * @param bowlingUser the entity to save.
     * @return the persisted entity.
     */
    @Override
    public BowlingUser save(BowlingUser bowlingUser) {
        log.debug("Request to save BowlingUser : {}", bowlingUser);
        return bowlingUserRepository.save(bowlingUser);
    }

    /**
     * Get all the bowlingUsers.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<BowlingUser> findAll() {
        log.debug("Request to get all BowlingUsers");
        return bowlingUserRepository.findAll();
    }


    /**
     * Get one bowlingUser by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<BowlingUser> findOne(Long id) {
        log.debug("Request to get BowlingUser : {}", id);
        return bowlingUserRepository.findById(id);
    }

    /**
     * Delete the bowlingUser by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete BowlingUser : {}", id);
        bowlingUserRepository.deleteById(id);
    }
}
