package com.comp.trainingapp

class CompanyDetailController {

	def saveCompanyDetail(){
		
		Department dept = new Department()
		
		dept.deptName = "Account"
		dept.deptProperty = "Managing money"
		
		dept.save()
		
		Company companyInstance = new Company()
		
		companyInstance.companyName = "Xerox"
		companyInstance.companyProperties = "Software"
		companyInstance.field = "Technology"
		
		companyInstance.department = dept
		
		if( companyInstance.save( failOnError : true ) ){
			println("Company instance saved successfully")
		}else{
			println("Something went wrong")
		}
	}
	
	def saveDeptAsChildInCompany(){
		
		Department dept = new Department()
		
		dept.deptName = "Account1"
		dept.deptProperty = "Managing money1"
		
		
		Department dept2 = new Department()
		
		dept2.deptName = "Account2"
		dept2.deptProperty = "Managing money2"
		
		Company companyInstance = new Company()
		
		companyInstance.companyName = "Xerox"
		companyInstance.companyProperties = "Software"
		companyInstance.field = "Technology"
		
		//dept.company = companyInstance
		//dept2.company = companyInstance
		
		companyInstance.departmentList
		
		companyInstance.addToDepartmentList(dept)
		companyInstance.addToDepartmentList(dept2)
		
		
		if(companyInstance.save(failOnError:true, flush:true)){
			println("Company instance saved successfully")
		}else{
			println("Something went wrong")
		}
	}
	
	def saveEmployeesToDepartment(){
		
		Department department1 = Department.get(1)
		Department department2 = Department.get(2)
		
		
		println("departmentInstance=${department1}")
		
		Employee emp1 = new Employee()
		emp1.employeeName = "Mark"
		emp1.designation = "CEO"
		
		Employee emp2 = new Employee()
		emp2.employeeName = "Julian"
		emp2.designation = "MD"
		
		
		department1.addToEmployeeList(emp1)
		
		department1.addToEmployeeList(emp2)
		
		department2.addToEmployeeList(emp1)
		department2.addToEmployeeList(emp2)
		
		if( department1.save(failOnError:true, flush:true) ){
			println("Department 1 saved ")
		}
		
		if( department2.save(failOnError:true, flush:true) ){
			println("Department 2 saved ")
		}
	}
	
	def retrivalCheck(){
		//Department dept = Department.get(1)
		//List<Department> departmentList = Department.getAll()
		
		//List<Department> departmentList1 = Department.list()
		
		
		Department newDept = Department.findByDeptName('Account2')
		
		println("newDept=${newDept}")
		println("newDept.departmentProperty = ${newDept.deptProperty}")
		
		Department newDeptProperty = Department.findByDeptProperty('Managing money2')
		
		println("newDeptProperty=${newDeptProperty}")
		
		List<Department> newDeptPropertyByTwoPrperties = Department.findAllByDeptNameIlike('account%')
		
		println("newDeptPropertyByTwoPrperties=${newDeptPropertyByTwoPrperties}")
		
		
		
	}
  
	def criteriaQueryDemo(){
		
		def departments = Department.createCriteria().list{
			eq('deptName', 'Account2')
		}
		
		def departmentsList = Department.createCriteria().list{
			and{
				eq('deptName', 'Account2')
				company{
					eq('companyName','Comp1')
				}
				
			}
			order "deptName","desc"
			firstResult(10)
			maxResults(20)
		}
		
		println("departments=${departments}")
	}
	
	def checkOnWhereQuery(){
		
		def department = Department.where {
			deptName=='Account2'
		}.find()
		println("department=${department}")
		
		Department.findByDeptName('Account2')
		
		def deptNameVar = 'Account2'
		
		def query = Department.where {
			deptName == deptNameVar
		}
		
		println query.find()
	}
	
}




