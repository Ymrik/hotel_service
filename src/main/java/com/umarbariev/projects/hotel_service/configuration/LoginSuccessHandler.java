package com.umarbariev.projects.hotel_service.configuration;


import com.umarbariev.projects.hotel_service.entities.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        User user = (User) authentication.getPrincipal();

        String redirectUrl = request.getContextPath();

        if (user.hasRole("ROLE_CLIENT")) redirectUrl = "/";
        if (user.hasRole("ROLE_ADMIN")) redirectUrl = "/";

        response.sendRedirect(redirectUrl);
    }
}
