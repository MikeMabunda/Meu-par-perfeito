package com.meupar.perfeito.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class CriptografiaAES {

    public static String criptografar(String mensagem, String chave) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(chave.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] criptografado = cipher.doFinal(mensagem.getBytes());
        return Base64.getEncoder().encodeToString(criptografado);
    }

    public static String descriptografar(String mensagemCriptografada, String chave) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(chave.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decodificado = Base64.getDecoder().decode(mensagemCriptografada);
        byte[] descriptografado = cipher.doFinal(decodificado);
        return new String(descriptografado);
    }
}
