package com.bowling.repository;

import com.bowling.domain.Game;

import java.util.Optional;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Game entity.
 */
@SuppressWarnings("unused")
@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

	
	Optional<Game> findByIdOrderByAlleyNo(Long id);

}
