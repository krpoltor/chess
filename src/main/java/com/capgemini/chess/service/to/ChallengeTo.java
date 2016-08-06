package com.capgemini.chess.service.to;

import java.util.Date;

import com.capgemini.chess.dataaccess.enums.ChallengeStatus;

public class ChallengeTo {
	private int id;
	private int whitePlayerId;
	private int blackPlayerId;
	private Date startDate;
	private Date endDate;
	private ChallengeStatus status;

	/**
	 * ChallengeTO default constructor.
	 */
	public ChallengeTo() {
	}

	/**
	 * ChallengeTO parameterized constructor.
	 * 
	 * @param id
	 *            - Challenge's ID.
	 * @param whitePlayerId
	 *            - Black set player's ID.
	 * @param blackPlayerId
	 *            - White set player's ID.
	 * @param startDate
	 *            - Date of creating a challenge.
	 * @param endDate
	 *            - Date of expiring a challenge.
	 * @param status
	 *            - Status of a challenge from {@link ChallengeStatus}
	 */
	public ChallengeTo(int id, int whitePlayerId, int blackPlayerId, Date startDate, Date endDate,
			ChallengeStatus status) {
		this.id = id;
		this.whitePlayerId = whitePlayerId;
		this.blackPlayerId = blackPlayerId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
	}

	// CHECKSTYLE:OFF
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getWhitePlayerId() {
		return whitePlayerId;
	}

	public void setWhitePlayerId(int whitePlayerId) {
		this.whitePlayerId = whitePlayerId;
	}

	public int getBlackPlayerId() {
		return blackPlayerId;
	}

	public void setBlackPlayerId(int blackPlayerId) {
		this.blackPlayerId = blackPlayerId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public ChallengeStatus getStatus() {
		return status;
	}

	public void setStatus(ChallengeStatus status) {
		this.status = status;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	// CHECKSTYLE:ON
}