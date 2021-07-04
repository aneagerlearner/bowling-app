package com.bowling.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.bowling.domain.BowlingUser;


/**
 * Spring Data  repository for the BowlingUser entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BowlingUserRepository extends JpaRepository<BowlingUser, Long> {

}
