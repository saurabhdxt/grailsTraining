package com.comp.trainingapp

class TestTimeStampService {

    Boolean saveTimeStampValue( def id = null, String timeStampName, String timeStampProperty ){
		
		TimeStampCheck timeStampCheckInstance = TimeStampCheck.findById(id)
		
		if( timeStampCheckInstance ){
			// Perform Update
		}else{
			//Perform Save
			timeStampCheckInstance  = new TimeStampCheck()
		}
		
		timeStampCheckInstance.timeStampName = timeStampName
		timeStampCheckInstance.timeStampProperty = timeStampProperty
		
		if( timeStampCheckInstance.save( failOnError : true ) ){
			return true
		}else{
			return false
		}
		
	}
}
