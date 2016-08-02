package com.capgemini.chess.service;

public interface UserChallengeService {

	/**
	 * Change status of given challenge to ACCEPTED.
	 * @param challengeId - Challenge ID.
	 */
	void acceptChallenge(int challengeId);

	/**
	 * Declining a challenge invokes removing it from DB.
	 * @param challengeId - Challenge ID.
	 */
	void declineChallenge(int challengeId);

	/**
	 * Create a new challenge between two players and set it's status to INIT.
	 * @param whitePlayerId - ID of a player playing with white chess-set.
	 * @param blackPlayerId - ID of a player playing with black chess-set.
	 */
	void createChallenge(int whitePlayerId, int blackPlayerId);
	//zwracanie challeneTO ktory zapisuje w bazie danych
	//komentarz do klasy

}
