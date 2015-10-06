
package br.com.ngz.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MD5 {

    private MD5() {
    }

    public static String setMD5(String senha) {
        String pass;
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(MD5.class.getName()).log(Level.SEVERE, null, ex);
        }
        BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
        pass = hash.toString(16);
        return pass;

    }
}