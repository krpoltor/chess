package com.capgemini.chess.dao.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.capgemini.chess.dao.UserProfileDao;
import com.capgemini.chess.service.to.UserProfileTO;

@Component
public class UserProfileDaoImpl implements UserProfileDao {

	/**
	 * List mocking Database table "USERS".
	 */
	private static List<UserProfileTO> mockingUserProfileTableList = new LinkedList<UserProfileTO>();

	/**
	 * Constructor simulating creation of Database "USERS" table.
	 */
	public UserProfileDaoImpl() {
		createListOfUserProfileTO();
	}

	@Override
	public final void createListOfUserProfileTO() {
		List<UserProfileTO> temporaryList = new LinkedList<UserProfileTO>();
		temporaryList.add(new UserProfileTO(0, "one", "one", "john", "", "", "", ""));
		temporaryList.add(new UserProfileTO(1, "two", "two", "john", "", "", "", ""));
		temporaryList.add(new UserProfileTO(2, "three", "three", "john", "", "", "", ""));
		temporaryList.add(new UserProfileTO(3, "four", "four", "john", "", "", "", ""));
		setMockingUserProfileTableList(temporaryList);
	}

	@Override
	public final void deleteListOfUserProfileTO() {
		mockingUserProfileTableList.clear();
	}

	public List<UserProfileTO> getMockingUserProfileTableList() {
		return mockingUserProfileTableList;
	}

	/**
	 * Setter for list mocking Database table "USERS".
	 * 
	 * @param listAsMockingUserProfileTableList
	 *            - List<UserProfileTO>
	 */
	public static void setMockingUserProfileTableList(final List<UserProfileTO> listAsMockingUserProfileTableList) {
		UserProfileDaoImpl.mockingUserProfileTableList = listAsMockingUserProfileTableList;
	}

	@Override
	public final UserProfileTO getUserProfileById(final int id) {
		return mockingUserProfileTableList.get(id);
	}
}
