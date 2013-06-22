package com.comp.trainingapp

import grails.converters.JSON

class CheckRestController {

    def checkRest() {
		
		if( request.method == "GET" ){
			println( "GET REQUEST RECEIVED" )
			List<Company> companyList = Company.list()
			render companyList as JSON
		}else if( request.method == "POST" ){
			println( "POST REQUEST RECEIVED" )
			List<Employee> employeeList = Employee.list()
			render employeeList as JSON
		}
		
	}
}
