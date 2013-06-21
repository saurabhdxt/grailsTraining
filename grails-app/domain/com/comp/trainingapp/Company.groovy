package com.comp.trainingapp

class Company {

	String companyName
	String companyProperties
	String field
	List<Department> departmentList
	
	static hasMany = [ departmentList : Department ]
	
    static constraints = {
		
    }
	
}
