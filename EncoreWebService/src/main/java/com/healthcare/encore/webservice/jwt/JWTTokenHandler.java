package com.healthcare.encore.webservice.jwt;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.healthcare.encore.security.UserAccount;
import com.healthcare.encore.security.impl.UserAccountDetailService;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * Utility class to convert JWT to UserAccount and UserAccount to JWT
 *
 * @author ckumar
 *
 */
@Component
public class JWTTokenHandler {

   @Value("${jwt.accessSecret:WTFnDBhECs*7GD7@X+8X}")
   private String accessSecret;

   @Value("${jwt.refreshSecret:rG#xBKrQDf&@g2jSr-Av}")
   private String refreshSecret;

   private String secret1;
   private String secret2;

   @Autowired
   private UserAccountDetailService userAccountDetailService;

   @PostConstruct
   public void postInit() {
      //random secret - reset on application restart
      //String randomSecret = RandomStringUtils.randomAscii(12);
      this.secret1 = Base64.getEncoder().encodeToString(this.accessSecret.getBytes(StandardCharsets.UTF_8));
      this.secret2 = Base64.getEncoder().encodeToString(this.refreshSecret.getBytes(StandardCharsets.UTF_8));
   }

   /**
    * Get UserAccount for the JWT token passed. Return null in case of invalid token
    *
    * @param token
    * @return UserAccount
    */
   public UserAccount parseUserFromAccessToken(final String token) {
      String emailId = null;
      try {
         //@formatter:off
         emailId = Jwts.parser().setSigningKey(this.secret1).parseClaimsJws(token).getBody().getSubject();
         //@formatter:on
      } catch (JwtException e) {
      }

      //Load user from account detail server
      UserAccount userAccount = null;
      if (emailId != null) {
         userAccount = (UserAccount) this.userAccountDetailService.loadUserByUsername(emailId);
      }
      return userAccount;
   }

   /**
    * Get UserAccount for the JWT token passed. Return null in case of invalid token
    *
    * @param token
    * @return UserAccount
    */
   public UserAccount parseUserFromRefreshToken(final String token) {
      String emailId = null;
      try {
         //@formatter:off
         emailId = Jwts.parser().setSigningKey(this.secret2).parseClaimsJws(token).getBody().getSubject();
         //@formatter:on
      } catch (JwtException e) {
      }

      //Load user from account detail server
      UserAccount userAccount = null;
      if (emailId != null) {
         userAccount = (UserAccount) this.userAccountDetailService.loadUserByUsername(emailId);
      }
      return userAccount;
   }

   /**
    * Create JWT token for the UserAccount passed
    * @param userAccount
    * @return JWT token
    */
   public String createAccessTokenForUser(final UserAccount userAccount) {
      final long currentTimeInMillis = System.currentTimeMillis();
      //@formatter:off
      return Jwts.builder()
               .setId(UUID.randomUUID().toString())
               .setIssuedAt(new Date(currentTimeInMillis))
               .setExpiration(DateUtils.addMinutes(new Date(currentTimeInMillis), 1440))
               .setSubject(userAccount.getEmailId())
               .setIssuedAt(Date.from(Instant.now()))
               .claim("roles", userAccount.getAuthorities())
               .claim("credentialsNotExpired", userAccount.isCredentialsNonExpired())
               .signWith(SignatureAlgorithm.HS512, this.secret1)
               .compact();
      //@formatter:on
   }

   public String createRefreshTokenForUser(final UserAccount userAccount) {
      final long currentTimeInMillis = System.currentTimeMillis();
      //@formatter:off
      return Jwts.builder()
               .setId(UUID.randomUUID().toString())
               .setIssuedAt(new Date(currentTimeInMillis))
               .setExpiration(DateUtils.addDays(new Date(currentTimeInMillis), 7))
               .setSubject(userAccount.getEmailId())
               .setIssuedAt(Date.from(Instant.now()))
               .claim("roles", userAccount.getAuthorities())
               .claim("credentialsNotExpired", userAccount.isCredentialsNonExpired())
               .signWith(SignatureAlgorithm.HS512, this.secret2)
               .compact();
      //@formatter:on
   }


   public boolean isRefreshTokenActive(final String token) {
      boolean active = false;
      try {
         Date expiration = Jwts.parser().setSigningKey(this.secret2).parseClaimsJws(token).getBody().getExpiration();
         if (expiration != null) {
            return expiration.toInstant().isAfter(Instant.now());
         }
      } catch (JwtException e) {
      }
      return active;
   }
}
