package com.comp.trainingapp

import grails.validation.Validateable;
import javax.servlet.http.HttpServletResponse

// ApplicationHolder Deprecated
//import org.codehaus.groovy.grails.commons.ApplicationHolder;

class ContrTestController {

	ContrTestService contrTestService
	SecondContrService secondContrService

	def index(){
		
		render "This is Index page"
	}
	
	def testcontrAction(){
		println("Hello World")
		render "This is my first controller"
	}

	def testconPart2(){
		render "This is my second controller action"
	}

	def userNamePassCheck(){

		def returnedValue = contrTestService.performCheckOnUserNameAndPassword("mack", "marc")
		if(returnedValue){
			render "User is same as password"
		}else{
			render "You can go ahead"
		}
	}


	def changePassword(){
		
		session['checkScope'] = "grails Training"

		String returnedValue = "This is the returned Value11"
		// Request Scope : returnedValue
		[ returnedValue : returnedValue, checkScope : session['checkScope'] ]
	}



	def checkSessionAccess(){

	}
	

	def performPasswordChange(PasswordChangeCommand command){

		Map comMessages = [:]

		if(command.validate()){

			comMessages.putAt("msg1", "Command validated")
			comMessages.putAt("msg2", "Now you can proceed")

			flash.message = comMessages

		}else{

			def errorsOnTheCommandObject = command.errors.allErrors.collect{error->
				error.field
			}.join(",")

			comMessages.putAt("msg1", "Command validation failed")
			comMessages.putAt("msg2", "Please fix the errors before going any further")

			flash.message = comMessages


		}
		redirect (action: "changePassword")

	}


	def defaultPageForThisController(){
		
		render "Default Page Renderer: ${params.id}"
		
		println("id=${params.id}")
		println("some=${params.some}")
		println("one=${params.one}")
		
	}

	def defaultPageForThisControllerOnlyForId(){
		render "Default Page Renderer Only for ID: ${params.id}"
	}
	
	def responseObjectCheck(){
		
		// Setting servelet context
		servletContext.variableName = "variable value"
		
		// Checking response object class
		println(response.getClass())
		// OutPut: // Class org.codehaus.groovy.grails.web.sitemesh.GrailsContentBufferingResponse
		
		// Setting a response code with the response
		response.status = HttpServletResponse.SC_BAD_GATEWAY
		
		// Accessing i18 messages properties
		def msg = message(code: "passwordChangeCommand.newPasswordMismatch")
		def newDefaultmsg = message(code: "default.newPasswordMismatch", args:['julian','mark'])
		
		println("msg=${msg}")
		println("newDefaultmsg=${newDefaultmsg}")
		
	}
	
	def urlMappingWithStaticVars(){
		println("id=${params.id}")
		println("nameUrl=${params.nameUrl}")
		println("secondVar=${params.secondVar}")
	}
	
	def checkOnInternalization(){
		def msg = message(code: "contrCont.usernameMismatch", args:["marck", "julian"])
		response.status = HttpServletResponse.SC_BAD_GATEWAY
		
		//user name mismatched fr marck and julian
		 [ msg : msg ]
	}
}

@Validateable
class PasswordChangeCommand {

	ContrTestService contrTestService

	String username
	String actualPassword
	String newPassword
	String repNewPassword

	static constraints = {

		newPassword(nullable: false, blank: false)
		repNewPassword(nullable: false, blank: false, validator: {String repNewPassword, obj ->

			String newPassword = obj.properties['newPassword']
			
			/*
			 * If you are injecting a service into a command object for validation,
			 * you will have to reference the service via the command object.
			 * */
			
			if( obj.contrTestService.checkOnThePasswordEquality( newPassword, repNewPassword ) ){
				def msg = message(code: "passwordChangeCommand.newPasswordMismatch")
				return msg
			}else{
				return false
			}
			return true

		})
	}
}

class UserInfoCommand{
	String username

	static constraints = {
		//username nullable:false
		importFrom UserInfo, include: [/.*name/]



	}
}
