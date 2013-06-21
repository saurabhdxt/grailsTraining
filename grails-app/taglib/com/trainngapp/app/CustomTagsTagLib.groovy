package com.trainngapp.app

class CustomTagsTagLib {

	static namespace = "trainingApptags"
	
	def customTag = {attrs->
		out << "this is rendered through custom tag: ${attrs.customVar}"
	}
	
	def showCompanyDetailsTag = {attrs->
		
		out << "Companny Name: XYS"
		out << "Companny Place: JUT"
		
	}
	
}
