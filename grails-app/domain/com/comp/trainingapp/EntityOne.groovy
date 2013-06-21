package com.comp.trainingapp

class EntityOne {
	
	String entityOneName
	String entityOneDepartment

    static constraints = {
    }
	
	static mapping = {
		tablePerHierarchy false
	 }
}
