package com.capgemini.chess.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.chess.dataaccess.entities.ChallengeEntity;
import com.capgemini.chess.service.to.ChallengeTO;

public class ChallengeMapper {
	
	public static ChallengeTO map(ChallengeEntity challengeEntity) {
		if (challengeEntity != null) {
			ChallengeTO challengeTO = new ChallengeTO();
			challengeTO.setId(challengeEntity.getId());
			challengeTO.setWhitePlayerId(challengeEntity.getWhitePlayerId());
			challengeTO.setBlackPlayerId(challengeEntity.getBlackPlayerId());
			challengeTO.setStartDate(challengeEntity.getStartDate());
			challengeTO.setEndDate(challengeEntity.getEndDate());
			challengeTO.setStatus(challengeEntity.getStatus());
			return challengeTO;
		}
		return null;
	}

	public static ChallengeEntity map(ChallengeTO challengeTO) {
		if (challengeTO != null) {
			ChallengeEntity challengeEntity = new ChallengeEntity();
			challengeEntity.setId(challengeTO.getId());
			challengeEntity.setWhitePlayerId(challengeTO.getWhitePlayerId());
			challengeEntity.setBlackPlayerId(challengeTO.getBlackPlayerId());
			challengeEntity.setStartDate(challengeTO.getStartDate());
			challengeEntity.setEndDate(challengeTO.getEndDate());
			challengeEntity.setStatus(challengeTO.getStatus());
			return challengeEntity;
		}
		return null;
	}
	
	public static ChallengeEntity update(ChallengeEntity challengeEntity, ChallengeTO challengeTO) {
		if (challengeTO != null && challengeEntity != null) {
			challengeEntity.setId(challengeTO.getId());
			challengeEntity.setWhitePlayerId(challengeTO.getWhitePlayerId());
			challengeEntity.setBlackPlayerId(challengeTO.getBlackPlayerId());
			challengeEntity.setStartDate(challengeTO.getStartDate());
			challengeEntity.setEndDate(challengeTO.getEndDate());
			challengeEntity.setStatus(challengeTO.getStatus());
		}
		return challengeEntity;
	}
	
	public static List<ChallengeTO> map2TOs(List<ChallengeEntity> challengeEntities) {
		return challengeEntities.stream().map(ChallengeMapper::map).collect(Collectors.toList());
	}

	public static List<ChallengeEntity> map2Entities(List<ChallengeTO> challengeTOs) {
		return challengeTOs.stream().map(ChallengeMapper::map).collect(Collectors.toList());
	}
}
