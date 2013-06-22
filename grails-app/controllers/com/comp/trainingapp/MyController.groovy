package com.comp.trainingapp

class MyController {

	def myService

	def show = {
		def items = myService.fetchItemsFor(params.userId)
		[ itemNames: items.collect { it.companyName } ]
	}

	def getEmployeeList(){
		Company emp =  Company.get(1)
		if(emp){
			emp.companyName = "Mark1"
			if(emp.save()){
				return true
			}else{
				return false
			}
		}else{
			return false
		}

	}

}
