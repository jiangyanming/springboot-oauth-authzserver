# Springboots Oauth Authorization Server



## Purpose

This is a stand alone Springboots application to simulate a Aauth2 Authorization Server.


## Use case

This example is based on grant type 'client_credentials'.
Clients of a company's API suite will have to register and will be maintained in a repository (say, RDBMS). They will be provided with a clientId and a clientSecret.
In order to use a protected API endpoint (Resource Server), the client should first make a call to the authz endpoint (/oauth/token) with the credentials.
The server will be able to issue a token to registered clients.
The client can use the token to call the API endpoint.
The application simulating the Resource Server will have to configure the an appropriate endpoint (/oauth/user) of this Authorization Server to be able to realize this integration.


## Start the application
mvn spring-boot:run

This starts the application on port 8081 with a context path of /auth
It provides a dummy implementation of client repository which is pre-populated with 2 clientId-clientSecret pairs.
client1, password1
client2, password2
