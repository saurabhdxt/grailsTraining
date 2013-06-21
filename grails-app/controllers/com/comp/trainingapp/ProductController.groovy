package com.comp.trainingapp

import groovyx.net.http.*
import static groovyx.net.http.ContentType.JSON

class ProductController {

    def index() {
		def http = new HTTPBuilder("http://localhost:8080/amazon")
		
		http.request(Method.GET, JSON) { 
				url.path = '/book/list' 
				response.success = { resp, json -> 
					for (book in json.books){ 
						println book.title 
						}
					} 
				}
		
	}
}
