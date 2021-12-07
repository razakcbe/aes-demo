package com.razak.decrypt.aesdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;


public class AESEncryptUtil {

    private static final Logger logger = LoggerFactory.getLogger(AESEncryptUtil.class);

    public static String aesDecrypt(String data, String key, String ivKey) {
        try {
            byte[] encrypted1 = Base64.getDecoder().decode(data);

            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");
            IvParameterSpec ivspec = new IvParameterSpec(ivKey.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);

            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original);
            return originalString;
        } catch (Exception e) {
            logger.debug(">> aesDecrypt() Exception occurred while decrypting response body", e );
            return null;
        }
    }
}
