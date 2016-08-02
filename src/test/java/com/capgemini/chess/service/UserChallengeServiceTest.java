package com.capgemini.chess.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.chess.ChessApplication;
import com.capgemini.chess.dao.ChallengeDao;
import com.capgemini.chess.dataaccess.enums.ChallengeStatus;

/**
 * Test class for testing {@link UserChallengeService}<br>
 * 
 * Checklist:<br>
 * 1. Test accepting challenge.<br>
 * 2. Test declining challenge.<br>
 * 3. Test creating new challenge.<br>
 * 
 * @author KRPOLTOR
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ChessApplication.class)
public class UserChallengeServiceTest {

	@Autowired
	private UserChallengeService userChallengeService;

	@Autowired
	private ChallengeDao challengeDao;

	/**
	 * Test for invoking accepting a challenge.
	 */
	@Test
	public void shouldAcceptChallenge() {
		// given
		// when
		userChallengeService.acceptChallenge(0);
		// then
		Assert.assertEquals(ChallengeStatus.ACCEPTED, challengeDao.getChallengeById(0).getStatus());
	}

	/**
	 * Test for invoking declining a challenge.
	 */
	@Test
	public void shouldDeclineChallenge() {
		// given
		// when
		userChallengeService.declineChallenge(1);
		// then
		Assert.assertEquals(ChallengeStatus.DECLINED, challengeDao.getChallengeById(1).getStatus());
	}

	/**
	 * Test for invoking creating new challenge.
	 */
	@Test
	public void shouldCreateChallenge() {
		// given
		// when
		userChallengeService.createChallenge(50, 60);
		// then
		Assert.assertEquals(3, challengeDao.getMockingChallengeTableList().size());
		Assert.assertEquals(50, challengeDao.getChallengeById(2).getWhitePlayerId());
		Assert.assertEquals(60, challengeDao.getChallengeById(2).getBlackPlayerId());
	}
}
