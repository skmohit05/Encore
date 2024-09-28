package com.healthcare.encore.commons.rsa;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

/**
 * 
 * @author ckumar
 * No other classes should be calling this and this can only be used a main program to create the key pairs,
 * if there is any need in future to generate them again.
 */
public final class RSAKeyPairGenerator {
   
   /**
    * 
    */
   private static final String ALGORITHM = "RSA";
   
   /**
    * 
    */
   private static final Integer KEY_SIZE = 2048;
   
   /**
    * 
    */
   private final PrivateKey privateKey;
   
   /**
    * 
    */
   private final PublicKey publicKey;
   
   /**
    * 
    * @throws NoSuchAlgorithmException
    */
   private RSAKeyPairGenerator() throws NoSuchAlgorithmException {
      KeyPairGenerator keyGen = KeyPairGenerator.getInstance(RSAKeyPairGenerator.ALGORITHM);
      keyGen.initialize(RSAKeyPairGenerator.KEY_SIZE);
      KeyPair pair = keyGen.generateKeyPair();
      this.privateKey = pair.getPrivate();
      this.publicKey = pair.getPublic();
   }
   
   public static void main(final String[] args) throws NoSuchAlgorithmException {
      RSAKeyPairGenerator keyPairGenerator = new RSAKeyPairGenerator();
      System.out.println(String.format("Private Key : %s", Base64.getEncoder().encodeToString(keyPairGenerator.privateKey.getEncoded())));
      System.out.println(String.format("Public Key : %s", Base64.getEncoder().encodeToString(keyPairGenerator.publicKey.getEncoded())));
   }
}
