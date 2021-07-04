package com.bowling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bowling.domain.BowlingUser;


@SuppressWarnings("unused")
@Repository
public interface BowlingUserRepository extends JpaRepository<BowlingUser, Long> {

}
