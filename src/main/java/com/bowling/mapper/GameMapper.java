package com.bowling.mapper;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.bowling.domain.BowlingUser;
import com.bowling.domain.Frame;
import com.bowling.domain.Game;
import com.bowling.dto.BowlingUserDTO;
import com.bowling.dto.FrameDTO;
import com.bowling.dto.GameDTO;

public class GameMapper {

	public static GameDTO map(Game game) {
		List<BowlingUserDTO> sortedUser = game.getBowlingUsers().stream()
				.sorted(Comparator.comparingInt(BowlingUser::getScore).reversed())
				.map(GameMapper::mapUserDto)
				.collect(Collectors.toList());
		
		return GameDTO.builder()
				.withId(game.getId())
				.withAlleyNo(game.getAlleyNo())
				.withNoOfPlayers(game.getNoOfPlayers())
				.withUsers(sortedUser)
				.build();
	}
	
	private static BowlingUserDTO mapUserDto(BowlingUser user) {
		
		return BowlingUserDTO.builder()
				.withId(user.getId())
				.withName(user.getName())
				.withScore(user.getScore())
				.withPaymentType(user.getPaymentType())
				.withMaxScore(user.getMaxScore())
				.withFrames(user.getFrames().stream()
						.map(GameMapper :: mapFrameDto)
						.collect(Collectors.toList()))
				.build();
		
	}
	
	private static FrameDTO mapFrameDto(Frame frame) {
		
		return FrameDTO.builder()
				.withId(frame.getId())
				.withIsSpare(frame.isIsSpare())
				.withIsStrike(frame.isIsStrike())
				.withNoOfRolls(frame.getNoOfRolls())
				.withScore(frame.getScore())
				.build();
		
	}
}
