package com.comp.trainingapp

class MyService {

	List fetchItemsFor( userId ){
		List<Company> companyList = Company.list()
		return companyList
	}
}
