package com.bowling.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bowling.domain.Frame;
import com.bowling.service.FrameService;

/**
 * REST controller for managing {@link com.bowling.domain.Frame}.
 */
@RestController
@RequestMapping("/api")
public class FrameResource {

    private final Logger log = LoggerFactory.getLogger(FrameResource.class);

    private final FrameService frameService;

    public FrameResource(FrameService frameService) {
        this.frameService = frameService;
    }

    /**
     * {@code POST  /frames} : Create a new frame.
     *
     * @param frame the frame to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new frame, or with status {@code 400 (Bad Request)} if the frame has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/frames")
    public ResponseEntity<Frame> createFrame(@RequestBody Frame frame) throws Exception {
        log.debug("REST request to save Frame : {}", frame);
        if (frame.getId() != null) {
            throw new Exception("A new frame cannot already have an ID");
        }
        Frame result = frameService.save(frame);
        return ResponseEntity.created(new URI("/api/frames/" + result.getId()))
            //.headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /frames} : Updates an existing frame.
     *
     * @param frame the frame to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated frame,
     * or with status {@code 400 (Bad Request)} if the frame is not valid,
     * or with status {@code 500 (Internal Server Error)} if the frame couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/frames")
    public ResponseEntity<Frame> updateFrame(@RequestBody Frame frame) throws Exception {
        log.debug("REST request to update Frame : {}", frame);
        if (frame.getId() == null) {
            throw new Exception("Invalid id");
        }
        Frame result = frameService.save(frame);
        return ResponseEntity.ok()
            //.headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, frame.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /frames} : get all the frames.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of frames in body.
     */
    @GetMapping("/frames")
    public List<Frame> getAllFrames() {
        log.debug("REST request to get all Frames");
        return frameService.findAll();
    }

    /**
     * {@code GET  /frames/:id} : get the "id" frame.
     *
     * @param id the id of the frame to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the frame, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/frames/{id}")
    public Optional<Frame> getFrame(@PathVariable Long id) {
        log.debug("REST request to get Frame : {}", id);
        Optional<Frame> frame = frameService.findOne(id);
        return frame;
    }

    /**
     * {@code DELETE  /frames/:id} : delete the "id" frame.
     *
     * @param id the id of the frame to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/frames/{id}")
    public String deleteFrame(@PathVariable Long id) {
        log.debug("REST request to delete Frame : {}", id);
        frameService.delete(id);
        return "Frame delete";
    }
}
