package com.capgemini.chess.rest;

import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;
import com.capgemini.chess.service.UserChallengeService;
import com.capgemini.chess.service.to.ChallengeTo;


@Controller
@ResponseBody
public class ChallengeRestService {
	
	private static Logger LOGGER = Logger.getLogger(ChallengeRestService.class.getName());
	
	@Autowired
	UserChallengeService userChallengeService;
	
	/**
	 * Find all challenges.
	 * 
	 * @return
	 */ 
	@RequestMapping(value = "/rest/challenges", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ChallengeTo>> getchallenge() {
		List<ChallengeTo> allChallenges = userChallengeService.findAllChallenges();
		if (allChallenges.isEmpty()) {
			return new ResponseEntity<List<ChallengeTo>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<ChallengeTo>>(allChallenges, HttpStatus.OK);
	}

	/**
	 * Get challenge by ID.
	 * 
	 * @param id
	 *            - challenge ID.
	 * @return
	 */
	@RequestMapping(value = "/rest/challenges/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ChallengeTo> getchallenge(@PathVariable("id") int id) {
		ChallengeTo challenge = userChallengeService.findChallengeById(id);
		if (challenge.equals(null)) {
			LOGGER.info("Challenge with id " + id + " not found");
			return new ResponseEntity<ChallengeTo>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ChallengeTo>(challenge, HttpStatus.OK);
	}

	/**
	 * Add new challenge to Database.
	 * 
	 * @param challenge
	 *            - challenge to add.
	 * @param ucBuilder
	 * @return
	 */
	@RequestMapping(value = "/rest/challenges", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> addchallenge(@RequestBody ChallengeTo challenge, UriComponentsBuilder ucBuilder) {

		LOGGER.info("Creating challenge: " + challenge.toString());
		userChallengeService.saveChallenge(challenge);
		LOGGER.info("Challenge created");

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/rest/challenges/{id}").buildAndExpand(challenge.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	/**
	 * Update challenge from Database.
	 * 
	 * @param id
	 *            - ID of challenge to update.
	 * @param challenge
	 * @return
	 */
	@RequestMapping(value = "/rest/challenges/{id}", method = RequestMethod.PUT)
	public ResponseEntity<ChallengeTo> updatechallenge(@PathVariable("id") int id, @RequestBody ChallengeTo challenge) {
		ChallengeTo currentChallenge = userChallengeService.findChallengeById(id);

		if (currentChallenge.equals(null)) {
			LOGGER.info("Challenge with id " + id + " not found");
			return new ResponseEntity<ChallengeTo>(HttpStatus.NOT_FOUND);
		}

		currentChallenge.setWhitePlayerId(challenge.getWhitePlayerId());
		currentChallenge.setBlackPlayerId(challenge.getBlackPlayerId());
		currentChallenge.setStatus(challenge.getStatus());
		currentChallenge.setStartDate(challenge.getStartDate());
		currentChallenge.setEndDate(challenge.getEndDate());

		userChallengeService.saveChallenge(currentChallenge);
		return new ResponseEntity<ChallengeTo>(currentChallenge, HttpStatus.OK);
	}

	/**
	 * Delete challenge.
	 * 
	 * @param id
	 *            - ID of challenge to delete.
	 * @return
	 */
	@RequestMapping(value = "/rest/challenges/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<ChallengeTo> deletechallenge(@PathVariable("id") int id) {
		LOGGER.info("Fetching & Deleting User with id " + id);
		ChallengeTo challenge = userChallengeService.findChallengeById(id);
		if (challenge.equals(null)) {
			LOGGER.info("Unable to delete. challenge with id " + id + " not found");
			return new ResponseEntity<ChallengeTo>(HttpStatus.NOT_FOUND);
		}

		userChallengeService.deleteChallenge(id);
		return new ResponseEntity<ChallengeTo>(HttpStatus.NO_CONTENT);
	}
}
