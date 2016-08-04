package com.capgemini.chess.dao.impl;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.stereotype.Component;

import com.capgemini.chess.dao.ChallengeDao;
import com.capgemini.chess.dataaccess.enums.ChallengeStatus;
import com.capgemini.chess.service.to.ChallengeTo;

@Component
public class ChallengeDaoImpl implements ChallengeDao {

	/**
	 * List of ChallengeTO mocking Database.
	 */
	private static List<ChallengeTo> mockingChallengeTableList = new LinkedList<ChallengeTo>();
	
	/**
	 * Two second in miliseconds.
	 */
	private static int TWO_SECONDS = 20000;
	/**
	 * Three seconds in miliseconds.
	 */
	private static int THREE_SECONDS = 30000;

	/**
	 * Constructor simulating creation of database table "CHALLENGES".
	 */
	public ChallengeDaoImpl() {
		createListOfChallengeTO();
	}

	@Override
	public final void createListOfChallengeTO() {
		List<ChallengeTo> temporaryList = new LinkedList<ChallengeTo>();
		Date startDate = new Date();
		Date endDate = new Date(startDate.getTime() + TWO_SECONDS);
		temporaryList.add(new ChallengeTo(0, 1, 2, startDate, endDate, ChallengeStatus.WAITING_FOR_REPLY));
		endDate = new Date(startDate.getTime() + THREE_SECONDS);
		temporaryList.add(new ChallengeTo(1, 1, 2, startDate, endDate, ChallengeStatus.WAITING_FOR_REPLY));
		setMockingChallengeTableList(temporaryList);
	}

	@Override
	public final void deleteOverdueChallengesFromListOfChallengeTO() {
		List<ChallengeTo> temporaryList = getMockingChallengeTableList();
		ListIterator<ChallengeTo> iter = temporaryList.listIterator();
		Date currentTime = new Date();
		while (iter.hasNext()) {
			if (iter.next().getEndDate().getTime() < currentTime.getTime()) {
				iter.remove();
			}
		}
		setMockingChallengeTableList(temporaryList);
	}

	@Override
	public final void readListOfChallengeTO() {
		List<ChallengeTo> list = getMockingChallengeTableList();
		System.out.println("List contains: ");
		for (ChallengeTo challengeTO : list) {
			System.out.println("Challenge ID: " + challengeTO.getId());
			System.out.println("Start date: " + challengeTO.getStartDate());
			System.out.println("End date: " + challengeTO.getEndDate());
		}
	}

	@Override
	public final void deleteListOfChallengeTO() {
		List<ChallengeTo> temporaryList = getMockingChallengeTableList();
		temporaryList.clear();
		setMockingChallengeTableList(temporaryList);
	}

	public final List<ChallengeTo> getMockingChallengeTableList() {
		return mockingChallengeTableList;
	}

	public void setMockingChallengeTableList(final List<ChallengeTo> inputlist) {
		ChallengeDaoImpl.mockingChallengeTableList = inputlist;
	}

	@Override
	public final ChallengeTo getChallengeById(final int challengeId) {
		return mockingChallengeTableList.get(challengeId);
	}

	@Override
	public final void addNewChallenge(final ChallengeTo newChallenge) {
		mockingChallengeTableList.add(newChallenge);
	}

	@Override
	public final void changeChallengeStatus(final int challengeId, final ChallengeStatus status) {
		ChallengeTo challenge = mockingChallengeTableList.get(challengeId);
		deleteChallengeById(challengeId);
		challenge.setStatus(status);
		addChallengeById(challengeId, challenge);
	}

	@Override
	public final void addChallengeById(final int challengeId, final ChallengeTo challenge) {
		mockingChallengeTableList.add(challengeId, challenge);
	}

	@Override
	public final void deleteChallengeById(final int challengeId) {
		mockingChallengeTableList.remove(challengeId);
	}

}
