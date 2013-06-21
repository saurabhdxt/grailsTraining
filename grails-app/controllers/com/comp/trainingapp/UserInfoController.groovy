package com.comp.trainingapp

import org.springframework.dao.DataIntegrityViolationException

class UserInfoController {

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	def index() {
		redirect(action: "list", params: params)
	}

	def list(Integer max) {
		params.max = Math.min(max ?: 10, 100)
		[userInfoInstanceList: UserInfo.list(params), userInfoInstanceTotal: UserInfo.count()]
	}

	def create() {
		[userInfoInstance: new UserInfo(params)]
	}

	def save() {
		def userInfoInstance = new UserInfo(params)
		if(userInfoInstance.hasErrors()){
			println("User Instance is having type errors")
		}else{
			if (!userInfoInstance.save(flush: true)) {
				render(view: "create", model: [userInfoInstance: userInfoInstance])
				return
			}

			flash.message = message(code: 'default.created.message', args: [message(code: 'userInfo.label', default: 'UserInfo'), userInfoInstance.id])
			redirect(action: "show", id: userInfoInstance.id)
		}
	}

	def show(Long id) {
		def userInfoInstance = UserInfo.get(id)
		if (!userInfoInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'userInfo.label', default: 'UserInfo'), id])
			redirect(action: "list")
			return
		}

		[userInfoInstance: userInfoInstance]
	}

	def edit(Long id) {
		def userInfoInstance = UserInfo.get(id)
		if (!userInfoInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'userInfo.label', default: 'UserInfo'), id])
			redirect(action: "list")
			return
		}

		[userInfoInstance: userInfoInstance]
	}

	def update(Long id, Long version) {
		def userInfoInstance = UserInfo.get(id)
		if (!userInfoInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'userInfo.label', default: 'UserInfo'), id])
			redirect(action: "list")
			return
		}

		if (version != null) {
			if (userInfoInstance.version > version) {
				userInfoInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
						[message(code: 'userInfo.label', default: 'UserInfo')] as Object[],
						"Another user has updated this UserInfo while you were editing")
				render(view: "edit", model: [userInfoInstance: userInfoInstance])
				return
			}
		}

		userInfoInstance.properties = params

		if (!userInfoInstance.save(flush: true)) {
			render(view: "edit", model: [userInfoInstance: userInfoInstance])
			return
		}

		flash.message = message(code: 'default.updated.message', args: [message(code: 'userInfo.label', default: 'UserInfo'), userInfoInstance.id])
		redirect(action: "show", id: userInfoInstance.id)
	}

	def delete(Long id) {
		def userInfoInstance = UserInfo.get(id)
		if (!userInfoInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'userInfo.label', default: 'UserInfo'), id])
			redirect(action: "list")
			return
		}

		try {
			userInfoInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'userInfo.label', default: 'UserInfo'), id])
			redirect(action: "list")
		}
		catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'userInfo.label', default: 'UserInfo'), id])
			redirect(action: "show", id: id)
		}
	}
}
