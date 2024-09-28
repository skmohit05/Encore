package com.healthcare.encore.webservice.config;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

/**
 * 
 * @author ckumar
 *
 */
public class CaseInsensitiveRequestParamFilter extends GenericFilterBean {

   /**
    * {@inheritDoc}
    */
   @Override
   public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain filterChain)
      throws IOException, ServletException {
      filterChain.doFilter(new CaseInsensitiveRequestWrapper(request), response);
   }

   /**
    *
    * @author ckumar
    *
    */
   private static class CaseInsensitiveRequestWrapper extends HttpServletRequestWrapper {
      /**
       *
       */
      private final Map<String, String> caseSensitiveParamNames = new HashMap<>();

      /**
       * Loop request parameters and populate map with lower case parameter name as key, to the
       * actual parameter name as value
       *
       * @param request
       */
      public CaseInsensitiveRequestWrapper(final ServletRequest request) {
         super((HttpServletRequest) request);
         Enumeration<String> names = super.getParameterNames();
         while (names.hasMoreElements()) {
            String name = names.nextElement();
            this.caseSensitiveParamNames.put(StringUtils.lowerCase(name), name);
         }
      }

      /**
       * Lookup map for case sensitive parameter name using lower case paramName
       * Use the case sensitive parameter name to perform the lookup from request object
       *
       * @return String[]
       */
      public String[] getParameterValues(final String paramName) {
         String caseSensitiveParamName = this.caseSensitiveParamNames.get(StringUtils.lowerCase(paramName));
         if (caseSensitiveParamName != null) {
            return super.getParameterValues(caseSensitiveParamName);
         }
         return new String[] {};
      }
   }
}
