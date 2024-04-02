package org.launchcode.rootstar;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.launchcode.rootstar.controllers.AuthenticationController;
import org.launchcode.rootstar.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;
import java.util.List;
import java.util.Arrays;

public class AuthenticationFilter implements HandlerInterceptor {

    @Autowired
    AuthenticationController authenticationController;

    /* whitelist pages anyone can access */

    private static final List <String> whitelist = Arrays.asList("/register","/login", "/css",
            "/garden", "/plants", "/seeds", "/soil", "/journal","/weather","/search");

    private static  boolean isWhitelisted (String path) {
        for (String pathRoot: whitelist) {
            if (path.equals("/") || path.startsWith(pathRoot)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws IOException {
        // Don't require sign-in for whitelisted pages
        if (isWhitelisted(request.getRequestURI())) {
            return true;
        }

        HttpSession session = request.getSession();
        User user = authenticationController.getUserFromSession(session);

        // The user is logged in
        if (user != null) {
            return true;
        }

        // The user is NOT logged in
        response.sendRedirect("/login");
        return false;
        }
    }

