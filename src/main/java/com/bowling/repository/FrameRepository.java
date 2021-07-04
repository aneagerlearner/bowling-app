package com.bowling.repository;

import com.bowling.domain.Frame;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Frame entity.
 */
@SuppressWarnings("unused")
@Repository
public interface FrameRepository extends JpaRepository<Frame, Long> {

}
