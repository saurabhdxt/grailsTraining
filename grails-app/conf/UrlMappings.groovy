class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}
		
		
		 "/contrTest" (controller:"contrTest", action: "defaultPageForThisController")
		 
		// "/contrTest/$id" (controller:"contrTest", action: "defaultPageForThisControllerOnlyForId")
		 
		 "/contrTest/$id/$some/$one" (controller:"contrTest", action: "defaultPageForThisController")
		 
		 "/contrTest/$id/$some/$one/$two?/$three?" (controller:"contrTest", action: "defaultPageForThisController")
		 
		 "/contrTest/urlMappingWithStaticVars"{
			controller = 'contrTest'
			action = "urlMappingWithStaticVars"
			id = "Mark" 
			nameUrl = "URLR" 
			secondVar = "Second Variable"
		 }
		 
		
		"/contrTest" (view:"/index")
		"/"(view:"/index")
		
		"500"(view:'/error')
		
		"/product/$id"(controller: "product", parseRequest: true) {
			action = [GET: "show", PUT: "update", DELETE: "delete", POST: "save"]
		}
		
	}
}
