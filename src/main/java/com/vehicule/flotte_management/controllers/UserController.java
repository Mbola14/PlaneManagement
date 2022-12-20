package com.vehicule.flotte_management.controllers;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vehicule.flotte_management.exceptions.AuthenticationException;
import com.vehicule.flotte_management.model.AuthModel;
import com.vehicule.flotte_management.model.User;
import com.vehicule.flotte_management.service.KeyService;
import com.vehicule.flotte_management.service.UsersService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@CrossOrigin("http://localhost:1602")
public class UserController {
	@Autowired
	KeyService keyService;

	@Autowired
	UsersService usersService;

    @PostMapping("user")
	public AuthModel login(@RequestBody User auth) {
		AuthModel authModel = new AuthModel();
		User authenticated_User = null;
		try {
			authenticated_User = usersService.authenticate(auth);
		} catch (AuthenticationException e) {
			authModel.setErrorMessage(e.getMessage());
			return authModel;
		}
		String token = getJWTToken(auth.getUsername());
		authModel.setUserId(authenticated_User.getIdUser());
		authModel.setAccessToken(token);

		return authModel;
	}

	private String getJWTToken(String username) {
		String secretKey = keyService.fetchKey().getSecretKey();
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}
}
