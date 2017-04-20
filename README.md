This module provides web services/APIs using Cloud Endpoint

## Running the Application

Run the application with 

`mvn appengine:devserver`, 

and ensure it's running by visiting your local server's api explorer's address (by
default localhost:8080/_ah/api/explorer.)

## Building Client Library

Get the client library with

`mvn appengine:endpoints_get_client_lib`

It will generate a client library jar file under the
`target/endpoints-client-libs/<api-name>/target` directory of your project, as well as 
install the artifact into your local maven repository.

