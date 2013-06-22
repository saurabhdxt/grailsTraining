modules = {
    
	application {
        resource url:'js/application.js'
    }
	
	jquery {
		resource url:'assets/js/jquery.min.js', disposition: 'head'
	}
	
	
	jqueryUi {
		dependsOn 'jquery'
		resource url:'assets/js/jquery-ui-1.8.18/js/jquery-ui-1.8.18.custom.min.js', disposition: 'head'
		resource url:'assets/js/jquery-ui-1.8.18/css/ui-lightness/jquery-ui-1.8.18.custom.css', disposition: 'head'
	}
	
}