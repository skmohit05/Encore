package com.healthcare.encore.webservice.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.GenericFilterBean;

import com.healthcare.encore.security.UserAccount;

/**
 * Performs JWT token validation and adds authentication object to current
 * security context
 *
 * @author ckumar
 *
 */
public class JWTTokenFilter extends GenericFilterBean {

   /**
    *
    */
   private JWTTokenHandler jwtTokenHandler;

   /**
    * {@inheritDoc}
    */
   @Override
   public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain filterChain)
      throws IOException, ServletException {

      if (this.jwtTokenHandler == null) {
         WebApplicationContext webApplicationContext =
                  WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
         this.jwtTokenHandler = webApplicationContext.getBean(JWTTokenHandler.class);
      }

      //Check if Authentication is available in context (from Login using BasicAuth)
      Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
      //If authentication not present, check for token in authorization header
      if (authentication == null) {
         HttpServletRequest httpRequest = (HttpServletRequest) request;
         authentication = this.getAuthentication(httpRequest);
      }

      //Set the authentication object to SecurityContext and proceed with the filter chain
      //If authentication failed, set the error response
      if (authentication != null && !authentication.isAuthenticated()) {
         HttpServletResponse httpResponse = (HttpServletResponse) response;
         httpResponse.sendError(HttpStatus.UNAUTHORIZED.value(), "User not active");
      } else if (authentication != null) {
         SecurityContextHolder.getContext().setAuthentication(authentication);
         filterChain.doFilter(request, response);
      } else {
         HttpServletResponse httpResponse = (HttpServletResponse) response;
         httpResponse.sendError(HttpStatus.UNAUTHORIZED.value(), "Invalid token");
      }
   }

   /**
    * Validate JWT token from header, get the Bearer token from request header and validate JWT
    *
    * @param httpRequest
    * @return Authentication
    */
   private Authentication getAuthentication(final HttpServletRequest httpRequest) {
      Authentication authentication = null;
      String authHeader = httpRequest.getHeader("Authorization");
      if (authHeader != null && authHeader.startsWith("Bearer ")) {
         String token = authHeader.substring(7);
         UserAccount userAccount = this.jwtTokenHandler.parseUserFromAccessToken(token);
         if (userAccount != null) {
            authentication = new UserAccountAuthentication(userAccount);
         }
      }
      return authentication;
   }
}
