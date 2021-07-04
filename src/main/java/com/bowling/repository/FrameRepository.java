package com.bowling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bowling.domain.Frame;


@SuppressWarnings("unused")
@Repository
public interface FrameRepository extends JpaRepository<Frame, Long> {

}
