package com.healthcare.encore.commons.rsa;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.healthcare.encore.commons.CommonsException;

/**
 *
 * @author ckumar
 *
 */
public final class RSAUtil {

   /**
    * 
    */
   private static final String DEFAULT_CHARSET = "UTF-8";

   /**
    *
    */
   private static final String ALGORITHM = "RSA";

   /**
    *
    */
   private static final String BASE_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA60pz"
            + "EmfFVgYPRLN7Hi7Bdwdg2mR+h+6jV4HYQGLxj/UIOqX2ffXr4paUjaj5fIu5WxG/pGHND7f/2FIIXUGveWq"
            + "lfvXYK3xmDPnh/5+o2UhDvgC750aeeHEp04bN9yZ2ztg7HzsadmFziE/CUr6+D7IZ3vqz077eTGvqZ+eCUC"
            + "aAo0IHGsyC4Bte7+LXNw7XBhkFpzAyJSxcC6Wf7x4eIFYUKeNQXLI9qFkacXP7LwjHLpUmD1rIK223mWyMt"
            + "y7/dm+HfRWmAThxK+twfqza9LvVCrvri1KYiwJTaN+copFG5P15EjjepIhXtLjGl0D8EkQ6om2CWs2gmwgw"
            + "yJGlhwIDAQAB";

   /**
    * 
    */
   private static final String BASE_PRIVATE_KEY = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoI"
            + "BAQDrSnMSZ8VWBg9Es3seLsF3B2DaZH6H7qNXgdhAYvGP9Qg6pfZ99evilpSNqPl8i7lbEb+kYc0Pt//YUg"
            + "hdQa95aqV+9dgrfGYM+eH/n6jZSEO+ALvnRp54cSnThs33JnbO2DsfOxp2YXOIT8JSvr4Pshne+rPTvt5Ma"
            + "+pn54JQJoCjQgcazILgG17v4tc3DtcGGQWnMDIlLFwLpZ/vHh4gVhQp41Bcsj2oWRpxc/svCMculSYPWsgr"
            + "bbeZbIy3Lv92b4d9FaYBOHEr63B+rNr0u9UKu+uLUpiLAlNo35yikUbk/XkSON6kiFe0uMaXQPwSRDqibYJ"
            + "azaCbCDDIkaWHAgMBAAECggEAJLwi6yS4co3PpHJBLp0uJ19Hh9FYz/A6IFdtY+AOxuMCveVbbp8OjPnlh5"
            + "hyGzfVYJqMySVb1rBriWKFW8n9k39LB19quJ9bb3s0Bazvt7zIlsmWjK1B4JwKY7QQRB4FPpYT5PRdVU4xs"
            + "36AYFrXYav0zhNmMBEEs/nFRyOl/M05cZ/oUQcuGu4ODrebATEd2an4JJJ0NhgouQmicCxSeUfTa7sLqyDg"
            + "JiL84hSvpA/MCUfzMksByUwgNIbKHMqdIMCiBHAWeTgd81Ul+vuDxK4t93Wh6VAXYdg7GbfbY7thclzolB8"
            + "P6cFoSlc4WDWXsWJu63aTeMHS2k2g2bCIgQKBgQD6UF0VNYQIcK/K/bh/Ti+i0RCyXyYElmSL0TcHKCAGlW"
            + "7GjvXCVatdaL4VqQc2P+PX4356CmAzk4yNpvf6Vvmdvd+PSX7En9PBm3R5WlOhxNeW/HS5BwwkWRbB5xe3t"
            + "4O7wGDpMjwjHhaCUSCfCjigA09KNplOOM5r/0NGOFn8zwKBgQDworkP5Uuz08ttmMEEn+lvlYMtFolB9cBv"
            + "7E/iyjnfW88qsGIPkwXLDn0erSoS+fd/LcQYcrWf5P3y40TEucKk46brEIJkQACg3dkCWPPGfhqeY9rg4Rk"
            + "AQYrE5fw1F1F3lYp5boHvi52d2hljaXTYyAxZjlGHNuF99m2RtgMpyQKBgQCXT3z1FSR69aNOUZD1Y43oHf"
            + "i52kpg+4hL/GwHJ3o0gKA15rUohCDSlj5RWZvCb1yLZDlQDHWat9Z+yi+cZHb/o4dAVm0K7pJStmXx9WgYo"
            + "aSw4GqublQopLHdBJSRuZ0oIWJzlKpFkCqLG/9cJBGWqGmFsvt5DV26atN/3xCGgQKBgQDr682enQLsaqCO"
            + "ce4DV7io8p/qC6dEaOljkf78baHxr3Rb+RQbCtzqKOlYsxOGCVaydK9F/Oi+u+aSRGl+qlUADkXvPn9oRCu"
            + "ZjAefupA+MhJs6Z+FTIuTaa7gvk7XymXP5WgfB84SigJc6aBsi87IXtFk2BhshczsDzd7XUSaqQKBgQCmf5"
            + "RZKEn4+AkqszdqUyIcZL8pKqKsgfRUZdF1NhxpJuZm9EJKjEhn1eNRENISEo85jwTvlR/o6GKqI1DCw7vWa"
            + "g5Qv4YPESylPWsDkNYv+yP6TpE6Bbtsz2c+u2T0mPaTUcg/w+dpEpKKhoMD5g4DaVIZC0Tz9XNItCi6LXMSFA==";

   /**
    *
    */
   private RSAUtil() {

   }

   private static PublicKey getPublicKey(final String base64PublicKey) {
      PublicKey publicKey = null;
      try {
         X509EncodedKeySpec keySpec =
                  new X509EncodedKeySpec(Base64.getDecoder().decode(base64PublicKey.getBytes(DEFAULT_CHARSET)));
         KeyFactory keyFactory = KeyFactory.getInstance("RSA");
         publicKey = keyFactory.generatePublic(keySpec);
      } catch (NoSuchAlgorithmException | InvalidKeySpecException | UnsupportedEncodingException e) {
         throw new CommonsException(e);
      }
      return publicKey;
   }

   /**
    *
    * @param base64PrivateKey
    * @return
    * @throws UnsupportedEncodingException
    */
   private static PrivateKey getPrivateKey(final String base64PrivateKey) throws UnsupportedEncodingException {
      PrivateKey privateKey = null;
      PKCS8EncodedKeySpec keySpec =
               new PKCS8EncodedKeySpec(Base64.getDecoder().decode(base64PrivateKey.getBytes(DEFAULT_CHARSET)));
      KeyFactory keyFactory = null;
      try {
         keyFactory = KeyFactory.getInstance(RSAUtil.ALGORITHM);
      } catch (NoSuchAlgorithmException e) {
         throw new CommonsException(e);
      }
      try {
         privateKey = keyFactory.generatePrivate(keySpec);
      } catch (InvalidKeySpecException e) {
         throw new CommonsException(e);
      }
      return privateKey;
   }

   /**
    * 
    * @param data
    * @param publicKey
    * @return
    * @throws BadPaddingException
    */
   public static String encrypt(final String data) {
      try {
         Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
         cipher.init(Cipher.ENCRYPT_MODE, getPublicKey(BASE_PUBLIC_KEY));
         byte[] encrypted = cipher.doFinal(data.getBytes(DEFAULT_CHARSET));
         byte[] encoded = Base64.getEncoder().encode(encrypted);
         return new String(encoded, DEFAULT_CHARSET);
      } catch (IllegalBlockSizeException | InvalidKeyException | NoSuchPaddingException | NoSuchAlgorithmException
               | UnsupportedEncodingException | BadPaddingException e) {
         throw new CommonsException(e);
      }
   }

   /**
    *
    * @param data
    * @param privateKey
    * @return
    */
   private static String decrypt(final byte[] data, final PrivateKey privateKey) {
      try {
         Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
         cipher.init(Cipher.DECRYPT_MODE, privateKey);
         return new String(cipher.doFinal(data), DEFAULT_CHARSET);
      } catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException | IllegalBlockSizeException
               | UnsupportedEncodingException | BadPaddingException e) {
         throw new CommonsException(e);
      }
   }

   /**
    *
    * @param data
    * @return
    * @throws UnsupportedEncodingException
    */
   public static String decrypt(final String data) {
      String decryptedString = null;
      try {
         decryptedString = decrypt(Base64.getDecoder().decode(data.getBytes(DEFAULT_CHARSET)), getPrivateKey(BASE_PRIVATE_KEY));
      } catch (UnsupportedEncodingException e) {
         throw new CommonsException(e);
      }
      return decryptedString;
   }
}
