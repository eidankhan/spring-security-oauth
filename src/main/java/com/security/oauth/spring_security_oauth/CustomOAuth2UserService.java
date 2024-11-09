package com.security.oauth.spring_security_oauth;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    // Patterns for identifying roles based on email prefix
    private static final Pattern MANAGER_EMAIL_PATTERN = Pattern.compile("^.*\\.manager@gmail\\.com$");
    private static final Pattern EMPLOYEE_EMAIL_PATTERN = Pattern.compile("^.*\\.employee@gmail\\.com$");

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) {
        OAuth2User user = super.loadUser(userRequest);
        String email = user.getAttribute("email");

        // Define authorities based on email prefix
        Set<GrantedAuthority> authorities = new HashSet<>();

        if (MANAGER_EMAIL_PATTERN.matcher(email).matches()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_MANAGER"));
        } else if (EMPLOYEE_EMAIL_PATTERN.matcher(email).matches()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_EMPLOYEE"));
        } else {
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }

        // Return the user with the assigned role
        return new DefaultOAuth2User(authorities, user.getAttributes(), "email");
    }
}
