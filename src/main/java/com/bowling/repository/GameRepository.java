package com.bowling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bowling.domain.Game;

@SuppressWarnings("unused")
@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

}
