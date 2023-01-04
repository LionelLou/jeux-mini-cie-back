package fr.jeuxminicie.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import fr.jeuxminicie.dtos.ScoreDto;
import fr.jeuxminicie.entities.Score;
import fr.jeuxminicie.repositories.MappingRepository;

@Mapper( componentModel="spring", uses = { MappingRepository.class })

public interface ScoreMapper {

	@Mapping(source="user.id", target="userId")
	@Mapping(source="game.id", target="gameId")
	ScoreDto scoreToScoreDto(Score score);
	
	@Mapping(source="userId", target="user")
	@Mapping(source="gameId", target="game")
	Score scoreDtoToScore(ScoreDto scoreDto);

}
