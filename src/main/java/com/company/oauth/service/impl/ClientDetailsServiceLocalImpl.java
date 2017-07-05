package com.company.oauth.service.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

import com.company.oauth.model.Client;

@Service("clientDetailsSvc")
public class ClientDetailsServiceLocalImpl implements ClientDetailsService{

private static final Logger logger = Logger.getLogger(UserDetailsServiceLocalImpl.class.getName());
	
	private static Map<String, ClientDetails> clientMap;
	
	static {
		clientMap = new HashMap<String, ClientDetails>();

		Set<String> scope = new HashSet<String>();
		scope.add("resource-server-read");
		scope.add("resource-server-write");
		
		Set<String> authzGrantTypes = new HashSet<String>();
		authzGrantTypes.add("client_credentials");
		
		Client client1 = new Client();
		client1.setClientId("client1");
		client1.setClientSecret("password1");
		client1.setScope(scope);
		client1.setAuthorizedGrantTypes(authzGrantTypes);
		clientMap.put(client1.getClientId(), client1);
		logger.log(Level.INFO, "Client 1 : " + client1);

		Client client2 = new Client();
		client2.setClientId("client2");
		client2.setClientSecret("password2");
		client2.setScope(scope);
		client2.setAuthorizedGrantTypes(authzGrantTypes);
		clientMap.put(client2.getClientId(), client2);
		logger.log(Level.INFO, "Client 2 : " + client2);

	}
	@Override
	public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
		ClientDetails client = clientMap.get(clientId);
		if(clientId == null) {
			throw new ClientRegistrationException("Client '" + clientId + "' not registered");
		}
		return client;
	}

}
