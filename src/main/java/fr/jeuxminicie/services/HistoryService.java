package fr.jeuxminicie.services;

import java.util.List;

import fr.jeuxminicie.dtos.HistoryDto;

public interface HistoryService extends GenericService<HistoryDto> {

	HistoryDto createNew(HistoryDto historyDto) throws Exception;
	
	List<HistoryDto> getAllByUserId(long userId) throws Exception;
}
