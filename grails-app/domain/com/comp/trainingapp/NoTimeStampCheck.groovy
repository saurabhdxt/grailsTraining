package com.comp.trainingapp

import java.util.Date;

class NoTimeStampCheck {

	String timeStampName
	String timeStampProperty
	
	Date dateCreated
	Date lastUpdated
	
    static constraints = {
		dateCreated nullable:true 
		lastUpdated nullable:true 
    }
	
	static mapping = {
		
		version false
		autoTimestamp false
		
	}
}
