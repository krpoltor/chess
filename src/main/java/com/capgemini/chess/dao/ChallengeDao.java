package com.capgemini.chess.dao;

import java.util.List;

import com.capgemini.chess.dataaccess.enums.ChallengeStatus;
import com.capgemini.chess.service.to.ChallengeTo;

public interface ChallengeDao {

	/**
	 * Generate list simulating DB.
	 */
	void createListOfChallengeTO();

	/**
	 * Delete overdue challenges.
	 */
	void deleteOverdueChallengesFromListOfChallengeTO();

	/**
	 * Print all data from the list.
	 */
	void readListOfChallengeTO();

	/**
	 * Clear list.
	 */
	void deleteListOfChallengeTO();

	/**
	 * Getter for a challenge.
	 * 
	 * @param challengeId
	 *            - Challenge ID.
	 * @return ChallengeTO containing challenge with given ID.
	 */
	ChallengeTo getChallengeById(int challengeId);

	/**
	 * Add new ChallengeTO to the list.
	 * 
	 * @param newChallenge
	 *            - ChallengeTO
	 */
	void addNewChallenge(ChallengeTo newChallenge);

	/**
	 * Add new ChallengeTO to the list by given ID.
	 * 
	 * @param challengeId
	 *            - Challenge ID.
	 * @param newChallenge
	 *            - ChallengeTO containing challenge.
	 */
	void addChallengeById(int challengeId, ChallengeTo newChallenge);

	/**
	 * Change challenge status.
	 * 
	 * @param challengeId
	 *            - Challenge ID
	 * @param status
	 *            - Challenge status from {@link ChallengeStatus}
	 */
	void changeChallengeStatus(int challengeId, ChallengeStatus status);

	/**
	 * Remove challenge from the list by given ID.
	 * 
	 * @param challengeId
	 *            - Challenge ID.
	 */
	void deleteChallengeById(int challengeId);

	/**
	 * Getter for List simulating DB.
	 * 
	 * @return List<ChallengeTO>
	 */
	List<ChallengeTo> getMockingChallengeTableList();

	/**
	 * Setter for List simulating DB.
	 * 
	 * @param inputlist
	 *            - List<ChallengeTO>
	 */
	void setMockingChallengeTableList(List<ChallengeTo> inputlist);

}
