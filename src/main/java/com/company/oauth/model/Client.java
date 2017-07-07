package com.company.oauth.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Component;

@Component
public class Client extends BaseClientDetails /*implements ClientDetails*/{
	
	static final long serialVersionUID = 1L;
	
	private String clientId;
	
	private String clientSecret;
	
	Set<String> scope;

	Set<String> authorizedGrantTypes;
	
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public void setScope(Set<String> scope) {
		this.scope = scope;
	}

	public void setAuthorizedGrantTypes(Set<String> authorizedGrantTypes) {
		this.authorizedGrantTypes = authorizedGrantTypes;
	}

	@Override
    public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Client {")
			.append("name=").append(clientId)
			.append(", scope='").append(scope.toArray())
                .append("'}");
		return sb.toString();
    }

//	@Override
//	public Integer getAccessTokenValiditySeconds() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Map<String, Object> getAdditionalInformation() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public Set<String> getAuthorizedGrantTypes() {
		return authorizedGrantTypes;
	}

	@Override
	public String getClientId() {
		return clientId;
	}

	@Override
	public String getClientSecret() {
		return clientSecret;
	}

//	@Override
//	public Integer getRefreshTokenValiditySeconds() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Set<String> getRegisteredRedirectUri() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Set<String> getResourceIds() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public Set<String> getScope() {
		return scope;
	}

//	@Override
//	public boolean isAutoApprove(String arg0) {
//		// TODO Auto-generated method stub
//		return false;
//	}

	@Override
	public boolean isScoped() {
		return true;
	}

	@Override
	public boolean isSecretRequired() {
		return true;
	}

//	@Override
//	public Collection<GrantedAuthority> getAuthorities() {
//		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//		return authorities;
//	}

}
