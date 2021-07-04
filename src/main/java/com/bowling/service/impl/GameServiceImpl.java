package com.bowling.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bowling.domain.Game;
import com.bowling.dto.GameDTO;
import com.bowling.mapper.GameMapper;
import com.bowling.repository.GameRepository;
import com.bowling.service.GameService;

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
		Optional<Game> gameDetails = gameRepository.findById(id);
		GameDTO gameResponse = GameMapper.map(gameDetails.get());
		return gameResponse;
	}
}
