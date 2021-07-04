package com.bowling.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bowling.domain.BowlingUser;
import com.bowling.domain.Game;
import com.bowling.repository.GameRepository;
import com.bowling.service.GameService;
import com.bowling.service.dto.BowlingUserDTO;
import com.bowling.service.dto.GameDTO;

/**
 * Service Implementation for managing {@link Game}.
 */
@Service
@Transactional
public class GameServiceImpl implements GameService {

	private final Logger log = LoggerFactory.getLogger(GameServiceImpl.class);

	private final GameRepository gameRepository;

	@Autowired
	private ModelMapper modelMapper;

	public GameServiceImpl(GameRepository gameRepository) {
		this.gameRepository = gameRepository;
	}

	/**
	 * Save a game.
	 *
	 * @param game the entity to save.
	 * @return the persisted entity.
	 */
	@Override
	public Game save(Game game) {
		log.debug("Request to save Game : {}", game);
		return gameRepository.save(game);
	}

	/**
	 * Get all the games.
	 *
	 * @return the list of entities.
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Game> findAll() {
		log.debug("Request to get all Games");
		return gameRepository.findAll();
	}

	/**
	 * Get one game by id.
	 *
	 * @param id the id of the entity.
	 * @return the entity.
	 */
	@Override
	@Transactional(readOnly = true)
	public GameDTO findOne(Long id) {
		log.debug("Request to get Game : {}", id);
		Optional<Game> gameDetails = gameRepository.findById(id);
		log.info("gameDetails", gameDetails.toString());
		GameDTO gameResponse = modelMapper.map(gameDetails, GameDTO.class);

		Set<BowlingUser> users = gameDetails.get().getBowlingUsers();
		Integer maxScore = 0;
		BowlingUser winner = null;
        BowlingUserDTO userDTO = new BowlingUserDTO();
        //FrameDTO frameDTO = new FrameDTO();


		for (BowlingUser user : users) {
			if (user.getScore() > maxScore) {
				winner = user;
				maxScore = user.getScore();
			}
		}
		
		if (winner != null) {
            System.out.println("Name : " + winner.getName());
            System.out.println("Score : " + winner.getScore());
            System.out.println("ID : " + winner.getId());
    		userDTO.setName(winner.getName());
    		userDTO.setId(winner.getId());
    		userDTO.setScore(winner.getScore());
    		userDTO.setPaymentType(winner.getPaymentType());
    		userDTO.setMaxScore(winner.getMaxScore());
            System.out.println("userDTO" + userDTO.getFrame());
//
//    		frameDTO.setId(userDTO.getFrame().getId());
//    		frameDTO.setIsSpare(userDTO.getFrame().getIsSpare());
//    		frameDTO.setIsStrike(userDTO.getFrame().getIsStrike());
//    		frameDTO.setNoOfRolls(userDTO.getFrame().getNoOfRolls());
//    		userDTO.setFrame(frameDTO);
		}
		gameResponse.setId(gameDetails.get().getId());
		gameResponse.setAlleyNo(gameDetails.get().getAlleyNo());
		gameResponse.setNoOfPlayers(gameDetails.get().getNoOfPlayers());
		gameResponse.setUser(userDTO);	
		return gameResponse;
	}

	/**
	 * Delete the game by id.
	 *
	 * @param id the id of the entity.
	 */
	@Override
	public void delete(Long id) {
		log.debug("Request to delete Game : {}", id);
		gameRepository.deleteById(id);
	}
}
