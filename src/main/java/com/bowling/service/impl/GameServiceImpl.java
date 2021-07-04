package com.bowling.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bowling.domain.Game;
import com.bowling.repository.GameRepository;
import com.bowling.service.GameService;
import com.bowling.service.dto.GameDTO;

@Service
@Transactional
public class GameServiceImpl implements GameService {

	private final GameRepository gameRepository;

	public GameServiceImpl(GameRepository gameRepository) {
		this.gameRepository = gameRepository;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Game> findAll() {
		return gameRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public GameDTO getGameDetails(Long id) {
//		Integer maxScore = 0;
//		BowlingUser winner = null;
//        BowlingUserDTO userDTO = new BowlingUserDTO();
//        FrameDTO frameDTO = new FrameDTO();
//        Set<Frame> frames;
//
//		Optional<Game> gameDetails = gameRepository.findById(id);
//		GameDTO gameResponse = modelMapper.map(gameDetails, GameDTO.class);
//		Set<BowlingUser> users = gameDetails.get().getBowlingUsers();
//		for (BowlingUser user : users) {
//			if (user.getScore() > maxScore) {
//				winner = user;
//				maxScore = user.getScore();
//			}
//		}
//		
//		if (winner != null) {
//    		userDTO.setName(winner.getName());
//    		userDTO.setId(winner.getId());
//    		userDTO.setScore(winner.getScore());
//    		userDTO.setPaymentType(winner.getPaymentType());
//    		userDTO.setMaxScore(winner.getMaxScore());
//            frames = winner.getFrames();
//            for(Frame frame: frames) {
//            	frameDTO.setId(frame.getId());
//            	frameDTO.setIsSpare(frame.isIsSpare());
//            	frameDTO.setIsStrike(frame.isIsStrike());
//            	frameDTO.setNoOfRolls(frame.getNoOfRolls());
//            	frameDTO.setScore(frame.getScore());
//            }
//            userDTO.setFrame(frameDTO);
//		}
//		gameResponse.setId(gameDetails.get().getId());
//		gameResponse.setAlleyNo(gameDetails.get().getAlleyNo());
//		gameResponse.setNoOfPlayers(gameDetails.get().getNoOfPlayers());
//		gameResponse.setUser(userDTO);	

		return null;
	}
}
