package com.aventra.service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

// Demo password hashing helper. For production, use BCrypt or Argon2.
public final class PasswordUtil {
    private PasswordUtil(){}
    public static String hash(String value){
        try{
            byte[] bytes=MessageDigest.getInstance("SHA-256").digest(value.getBytes(StandardCharsets.UTF_8));
            return HexFormat.of().formatHex(bytes);
        }catch(NoSuchAlgorithmException e){ throw new IllegalStateException(e); }
    }
    public static boolean matches(String raw,String hashed){return hash(raw).equals(hashed);}
}
