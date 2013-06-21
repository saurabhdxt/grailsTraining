package com.comp.trainingapp

class Department {

	String deptName
	String deptProperty

	List<Employee> employeeList 
	
	static belongsTo = [ company : Company ]
	
	static hasMany = [ employeeList : Employee ]
	
    static constraints = {
    }
}
