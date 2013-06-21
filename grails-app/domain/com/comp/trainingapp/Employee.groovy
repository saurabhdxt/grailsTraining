package com.comp.trainingapp

class Employee {

	String employeeName
	String designation
	
	Date dateCreated
	Date lastUpdated
	
	static belongsTo = Department
	
	static hasMany = [ departmentList : Department ]
	
    static constraints = {
		
    }
}
