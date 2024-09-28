package com.healthcare.encore.webservice.jwt;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Base64;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.healthcare.encore.commons.rsa.RSAUtil;
import com.healthcare.encore.security.SecurityManager;

/**
 * Performs basic auth and adds authentication object to current
 * security context
 *
 * @author ckumar
 *
 */
public class LoginFilter extends AbstractAuthenticationProcessingFilter {

   /**
    *
    */
   private SecurityManager securityManager;

   /**
    *
    */
   public LoginFilter() {
      super(new AntPathRequestMatcher("/api/auth/login"));
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public Authentication attemptAuthentication(final HttpServletRequest request, final HttpServletResponse response)
      throws AuthenticationException, IOException, ServletException { // NOSONAR

      if (this.securityManager == null) {
         WebApplicationContext webApplicationContext =
                  WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
         this.securityManager = webApplicationContext.getBean(SecurityManager.class);
      }

      UserAccountAuthentication authentication = null;
      try {
         String[] credentials = this.getCredentials(request);
         String decryptedPassword = RSAUtil.decrypt(credentials[1]);
         this.securityManager.authenticateUser(credentials[0], decryptedPassword);
         authentication = new UserAccountAuthentication(this.securityManager.getAuthenticatedUser());
         //CHECKSTYLE:OFF
      } catch (CredentialsExpiredException e) { // NOPMD
         // CHECKSTYLE:OFF
         throw new CredentialsExpiredException("Password expired", e);
      } catch (Exception e) { // NOPMD
         // CHECKSTYLE:OFF
         throw new BadCredentialsException("Invalid credentials", e);
      }
      return authentication;
   }

   /**
    * {@inheritDoc}
    */
   @Override
   protected void successfulAuthentication(final HttpServletRequest request, final HttpServletResponse response,
            final FilterChain chain, final Authentication authentication) throws IOException, ServletException {
      //Set authorization to the current security context
      SecurityContextHolder.getContext().setAuthentication(authentication);
      chain.doFilter(request, response);
   }

   /**
    * {@inheritDoc}
    */
   @Override
   protected void unsuccessfulAuthentication(final HttpServletRequest request, final HttpServletResponse response,
            final AuthenticationException failed) throws IOException, ServletException {
      // Update response for Invalid credentials
      HttpServletResponse httpResponse = response;
      httpResponse.sendError(HttpStatus.UNAUTHORIZED.value(), failed.getMessage());
   }

   /**
    * Get credentials from BasicAuth header
    *
    * @param httpRequest
    * @return String array with user name and password
    */
   private String[] getCredentials(final HttpServletRequest httpRequest) {
      String authorization = httpRequest.getHeader("Authorization");
      if (authorization != null && authorization.startsWith("Basic")) {
         // Authorization: Basic base64credentials
         String base64Credentials = authorization.substring("Basic".length()).trim();
         String credentials = new String(Base64.getDecoder().decode(base64Credentials), Charset.forName("UTF-8"));
         // credentials = username:password
         return credentials.split(":", 2);
      }
      return new String[2];
   }
}
