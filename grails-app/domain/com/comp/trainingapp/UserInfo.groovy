package com.comp.trainingapp

class UserInfo {

	String login
	String password
	String email
	Integer age

	static constraints = {
		login size: 5..15, blank: false, unique: true
		password size: 5..15, blank: false
		email email: true, blank: false
		age min: 18

	}
}
