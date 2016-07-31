package com.capgemini.chess.service.impl;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dao.ChallengeDao;
import com.capgemini.chess.dataaccess.enums.ChallengeStatus;
import com.capgemini.chess.service.UserChallengeService;
import com.capgemini.chess.service.to.ChallengeTO;

@Service
public class UserChallengeServiceImpl implements UserChallengeService {

	private static int FOURTEEN_DAYS = 14;

	@Autowired
	private ChallengeDao challengeDao;

	@Override
	public final void acceptChallenge(final int challengeId) {
		challengeDao.changeChallengeStatus(challengeId, ChallengeStatus.ACCEPTED);
		// message.show("Opponent accepted.")
		// game.start()
	}

	@Override
	public final void declineChallenge(final int challengeId) {
		// Keep challenge for statistics
		challengeDao.changeChallengeStatus(challengeId, ChallengeStatus.DECLINED);
		// or remove it from DB
		// challengeDao.removeChallengeById(challengeId);
		// message.show("Opponent declined.")
	}

	@Override
	public final void createChallenge(final int whitePlayerId, final int blackPlayerId) {
		// List will not reiterate itself and shift data into empty fields
		// DB engine will do this
		int currentSize = challengeDao.getMockingChallengeTableList().size();
		int id = currentSize++;
		Date startDate = new Date();
		Date endDate = addDaysToGivenDate(startDate, FOURTEEN_DAYS);

		ChallengeTO newChallenge = new ChallengeTO(id, whitePlayerId, blackPlayerId, startDate, endDate,
				ChallengeStatus.WAITING_FOR_REPLY);
		challengeDao.addNewChallenge(newChallenge);
	}

	private Date addDaysToGivenDate(final Date startDate, final int numberOfDaysToAdd) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startDate);
		calendar.add(Calendar.DAY_OF_YEAR, numberOfDaysToAdd);
		Date date = calendar.getTime();
		return date;
	}
}
