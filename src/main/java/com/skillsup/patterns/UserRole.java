package com.skillsup.patterns;

/**
 * UNKNOWN stands for the user which is not known by the system, this kind of user can't access anything in the system
 * COMMON usual user which has access to user related functions
 * ADMIN has unlimited access to application
 */
public enum UserRole {

	UNKNOWN,
	COMMON,
	ADMIN

}
