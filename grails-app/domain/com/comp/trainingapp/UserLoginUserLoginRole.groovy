package com.comp.trainingapp

import org.apache.commons.lang.builder.HashCodeBuilder

class UserLoginUserLoginRole implements Serializable {

	UserLogin userLogin
	UserLoginRole userLoginRole

	boolean equals(other) {
		if (!(other instanceof UserLoginUserLoginRole)) {
			return false
		}

		other.userLogin?.id == userLogin?.id &&
			other.userLoginRole?.id == userLoginRole?.id
	}

	int hashCode() {
		def builder = new HashCodeBuilder()
		if (userLogin) builder.append(userLogin.id)
		if (userLoginRole) builder.append(userLoginRole.id)
		builder.toHashCode()
	}

	static UserLoginUserLoginRole get(long userLoginId, long userLoginRoleId) {
		find 'from UserLoginUserLoginRole where userLogin.id=:userLoginId and userLoginRole.id=:userLoginRoleId',
			[userLoginId: userLoginId, userLoginRoleId: userLoginRoleId]
	}

	static UserLoginUserLoginRole create(UserLogin userLogin, UserLoginRole userLoginRole, boolean flush = false) {
		new UserLoginUserLoginRole(userLogin: userLogin, userLoginRole: userLoginRole).save(flush: flush, insert: true)
	}

	static boolean remove(UserLogin userLogin, UserLoginRole userLoginRole, boolean flush = false) {
		UserLoginUserLoginRole instance = UserLoginUserLoginRole.findByUserLoginAndUserLoginRole(userLogin, userLoginRole)
		if (!instance) {
			return false
		}

		instance.delete(flush: flush)
		true
	}

	static void removeAll(UserLogin userLogin) {
		executeUpdate 'DELETE FROM UserLoginUserLoginRole WHERE userLogin=:userLogin', [userLogin: userLogin]
	}

	static void removeAll(UserLoginRole userLoginRole) {
		executeUpdate 'DELETE FROM UserLoginUserLoginRole WHERE userLoginRole=:userLoginRole', [userLoginRole: userLoginRole]
	}

	static mapping = {
		id composite: ['userLoginRole', 'userLogin']
		version false
	}
}
