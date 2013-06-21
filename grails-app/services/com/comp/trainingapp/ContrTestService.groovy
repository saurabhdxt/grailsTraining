package com.comp.trainingapp

class ContrTestService {

	Boolean performCheckOnUserNameAndPassword(userName, password){
		if(password == userName){
			return true
		}else return false
	}

	Boolean checkOnThePasswordEquality( newPassword, repNewPassword ){

		if( !(newPassword == repNewPassword) ) {
			return false
		} else {
			return true
		}
	}

}
