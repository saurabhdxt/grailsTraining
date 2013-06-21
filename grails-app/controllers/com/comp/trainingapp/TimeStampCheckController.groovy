package com.comp.trainingapp

import org.springframework.dao.DataIntegrityViolationException

class TimeStampCheckController {

	TestTimeStampService testTimeStampService

    def index() {
        //redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [timeStampCheckInstanceList: TimeStampCheck.list(params), timeStampCheckInstanceTotal: TimeStampCheck.count()]
    }

    def create() {
        [timeStampCheckInstance: new TimeStampCheck(params)]
    }

	def saveTimeStampValues(){
		
		Boolean timeStampInsertedSuccessfully = testTimeStampService.saveTimeStampValue( params.id, params.timeStampName, params.timeStampProperty )
		
		if( timeStampInsertedSuccessfully ){
			flash.message = "Saved Successfully"
		}else{
			flash.message = "Some Issue with the insertion, please try again later" 
		}
		
		def message = flash.message
		 
		return message
		
	}
	
    def save() {
        def timeStampCheckInstance = new TimeStampCheck(params)
        if (!timeStampCheckInstance.save(flush: true)) {
            render(view: "create", model: [timeStampCheckInstance: timeStampCheckInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'timeStampCheck.label', default: 'TimeStampCheck'), timeStampCheckInstance.id])
        redirect(action: "show", id: timeStampCheckInstance.id)
    }

    def show(Long id) {
        def timeStampCheckInstance = TimeStampCheck.get(id)
        if (!timeStampCheckInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'timeStampCheck.label', default: 'TimeStampCheck'), id])
            redirect(action: "list")
            return
        }

        [timeStampCheckInstance: timeStampCheckInstance]
    }

    def edit(Long id) {
        def timeStampCheckInstance = TimeStampCheck.get(id)
        if (!timeStampCheckInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'timeStampCheck.label', default: 'TimeStampCheck'), id])
            redirect(action: "list")
            return
        }

        [timeStampCheckInstance: timeStampCheckInstance]
    }

    def update(Long id, Long version) {
        def timeStampCheckInstance = TimeStampCheck.get(id)
        if (!timeStampCheckInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'timeStampCheck.label', default: 'TimeStampCheck'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (timeStampCheckInstance.version > version) {
                timeStampCheckInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'timeStampCheck.label', default: 'TimeStampCheck')] as Object[],
                          "Another user has updated this TimeStampCheck while you were editing")
                render(view: "edit", model: [timeStampCheckInstance: timeStampCheckInstance])
                return
            }
        }

        timeStampCheckInstance.properties = params

        if (!timeStampCheckInstance.save(flush: true)) {
            render(view: "edit", model: [timeStampCheckInstance: timeStampCheckInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'timeStampCheck.label', default: 'TimeStampCheck'), timeStampCheckInstance.id])
        redirect(action: "show", id: timeStampCheckInstance.id)
    }

    def delete(Long id) {
        def timeStampCheckInstance = TimeStampCheck.get(id)
        if (!timeStampCheckInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'timeStampCheck.label', default: 'TimeStampCheck'), id])
            redirect(action: "list")
            return
        }

        try {
            timeStampCheckInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'timeStampCheck.label', default: 'TimeStampCheck'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'timeStampCheck.label', default: 'TimeStampCheck'), id])
            redirect(action: "show", id: id)
        }
    }
}
