package com.depa.user.model.user.impl;

import com.depa.user.dto.UserPrincipal;
import com.depa.user.model.user.User;

public class UserFactory {

	public static User create(UserPrincipal userPrincipal, String registrationId) {
		User user;

		switch (registrationId) {
			case "facebook":
				user = FacebookUserAdapter.create(userPrincipal.getEmail());
				break;
			case "google":
				user = GoogleUserAdapter.create(userPrincipal.getEmail());
				break;
			default:
				user = UserImpl.create(userPrincipal.getEmail());
		}

		setProviderId(userPrincipal, user);
		setUsername(userPrincipal, user);
		setName(userPrincipal, user);
		setEmail(userPrincipal, user);
		setPassword(userPrincipal, user);
		return user;
	}

	private static void setProviderId(UserPrincipal userPrincipal, User user) {
		if (userPrincipal.getId() != null) {
			user.setProviderId(userPrincipal.getId());
		}
	}

	private static void setUsername(UserPrincipal userPrincipal, User user) {
		if (userPrincipal.getEmail() != null) {
			user.setUsername(userPrincipal.getEmail());
		}
	}

	private static void setEmail(UserPrincipal userPrincipal, User user) {
		if (userPrincipal.getEmail() != null) {
			user.setEmail(userPrincipal.getEmail());
		}
	}

	private static void setPassword(UserPrincipal userPrincipal, User user) {
		if (userPrincipal.getPassword() != null) {
			user.setPassword(userPrincipal.getPassword());
		}
	}

	private static void setName(UserPrincipal userPrincipal, User user) {
		String name = userPrincipal.getAttribute("name");
		if (name != null) {
			user.setName(name);
		} else {
			user.setName(userPrincipal.getName());
		}
	}
}
