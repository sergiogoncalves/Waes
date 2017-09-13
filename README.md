## WAES Server Applicant Test Service [![Build Status](https://travis-ci.org/sergiogoncalves/Waes.svg?branch=master)](https://travis-ci.org/sergiogoncalves/Waes)
You can to start application by executing com.wearewaes.WaesApplication, which starts a webserver on port 8080 (http://localhost:8080) and serves SwaggerUI where can inspect and try existing endpoints.

# The assignment
	• Provide 2 http endpoints that accepts JSON base64 encoded binary data on both endpoints
		o <host>/v1/diff/<ID>/left and <host>/v1/diff/<ID>/right
	• The provided data needs to be diff-ed and the results shall be available on a third end point
		o <host>/v1/diff/<ID>
	• The results shall provide the following info in JSON format
		o If equal return that
		o If not of equal size just return that
		o If of same size provide insight in where the diffs are, actual diffs are not needed.
			§ So mainly offsets + length in the data

	• Make assumptions in the implementation explicit, choices are good but need to be communicated

# The architecture 
 The architecture of the web service is built with the following components:
* DataTransferObjects: Objects which are used for outside communication via the API
* Controller: Implements the processing logic of the web service, parsing of parameters and validation of in- and outputs.
* Service: Implements the business logic and handles the access to the DataAccessObjects.
* DataAccessObjects: Interface for the database. Inserts, updates, deletes and reads objects from the database.
* DomainObjects: Functional Objects which might be persisted in the database.
	
The project uses the following technologies:

* Java 8
* Spring MVC with Spring Boot
* Database H2 (In-Memory)
* Maven
* Spring Tool Suite as IDE is preferred but not mandatory. 

# Improvements
* Return more detailed error message to show wich fields of JSON file are differents
* Insert both sides a the same time sending two encoded strings in one endpoint
* Implements the security and determine roles to users
* Provide an endpoint to create a encoded string for users with a few experience


 