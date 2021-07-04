package com.bowling.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.tomcat.util.http.HeaderUtil;
import org.apache.tomcat.util.http.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bowling.domain.BowlingUser;
import com.bowling.service.BowlingUserService;

/**
 * REST controller for managing {@link com.bowling.domain.BowlingUser}.
 */
@RestController
@RequestMapping("/api")
public class BowlingUserResource {

    private final Logger log = LoggerFactory.getLogger(BowlingUserResource.class);

    private final BowlingUserService bowlingUserService;

    public BowlingUserResource(BowlingUserService bowlingUserService) {
        this.bowlingUserService = bowlingUserService;
    }

    /**
     * {@code POST  /bowling-users} : Create a new bowlingUser.
     *
     * @param bowlingUser the bowlingUser to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new bowlingUser, or with status {@code 400 (Bad Request)} if the bowlingUser has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/bowling-users")
    public ResponseEntity<BowlingUser> createBowlingUser(@Valid @RequestBody BowlingUser bowlingUser) throws Exception {
        log.debug("REST request to save BowlingUser : {}", bowlingUser);
        if (bowlingUser.getId() != null) {
            throw new Exception("A new bowlingUser cannot already have an ID");
        }
        BowlingUser result = bowlingUserService.save(bowlingUser);
        return ResponseEntity.created(new URI("/api/bowling-users/" + result.getId()))
            //.headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /bowling-users} : Updates an existing bowlingUser.
     *
     * @param bowlingUser the bowlingUser to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated bowlingUser,
     * or with status {@code 400 (Bad Request)} if the bowlingUser is not valid,
     * or with status {@code 500 (Internal Server Error)} if the bowlingUser couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/bowling-users")
    public ResponseEntity<BowlingUser> updateBowlingUser(@Valid @RequestBody BowlingUser bowlingUser) throws Exception {
        log.debug("REST request to update BowlingUser : {}", bowlingUser);
        if (bowlingUser.getId() == null) {
            throw new Exception("Invalid id");
        }
        BowlingUser result = bowlingUserService.save(bowlingUser);
        return ResponseEntity.ok()
            //.headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, bowlingUser.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /bowling-users} : get all the bowlingUsers.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of bowlingUsers in body.
     */
    @GetMapping("/bowling-users")
    public List<BowlingUser> getAllBowlingUsers() {
        log.debug("REST request to get all BowlingUsers");
        return bowlingUserService.findAll();
    }

    /**
     * {@code GET  /bowling-users/:id} : get the "id" bowlingUser.
     *
     * @param id the id of the bowlingUser to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the bowlingUser, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/bowling-users/{id}")
    public Optional<BowlingUser> getBowlingUser(@PathVariable Long id) {
        log.debug("REST request to get BowlingUser : {}", id);
        Optional<BowlingUser> bowlingUser = bowlingUserService.findOne(id);
        return bowlingUser;
    }

    /**
     * {@code DELETE  /bowling-users/:id} : delete the "id" bowlingUser.
     *
     * @param id the id of the bowlingUser to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/bowling-users/{id}")
    public String deleteBowlingUser(@PathVariable Long id) {
        log.debug("REST request to delete BowlingUser : {}", id);
        bowlingUserService.delete(id);
        return "Bowling user deleted";
    }
}
