/**
 *
 */
package com.healthcare.encore.webservice.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.filter.GenericFilterBean;

/**
 *
 * @author ckumar
 *
 */
public class SimpleCORSFilter extends GenericFilterBean {
   /**
    * {@inheritDoc}
    */
   @Override
   public void doFilter(final ServletRequest req, final ServletResponse res, final FilterChain chain)
      throws IOException, ServletException {
      HttpServletResponse response = (HttpServletResponse) res;
      HttpServletRequest request = (HttpServletRequest) req;
      String origin = StringUtils.trimToEmpty(request.getHeader(HttpHeaders.ORIGIN)).replaceAll(StringUtils.CR, "")
               .replaceAll(StringUtils.LF, "");
      response.setHeader("Access-Control-Allow-Origin", origin);
      response.setHeader("Access-Control-Allow-Credentials", "true");
      response.setHeader("Access-Control-Allow-Methods", "PATCH, POST, PUT, GET, OPTIONS, DELETE, HEAD");
      response.setHeader("Access-Control-Max-Age", "86400");
      response.setHeader("Access-Control-Allow-Headers", "Content-Type, x-requested-with, X-Custom-Header, authorization");
      //Proceed with filter chain for any other method other than OPTIONS
      if (!HttpMethod.OPTIONS.matches(request.getMethod())) {
         chain.doFilter(request, response); //Chain of actions calling
      }
   }
}