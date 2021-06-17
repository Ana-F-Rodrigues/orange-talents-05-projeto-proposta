package br.com.zuporange05.orangetalents05projetoproposta.validacoes;

import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;

public class Criptografia {
	
	private static String password = "orangetalents";
    private static String salt = "6F72616E676574616C656E7473";

    private static TextEncryptor textEncryptor = Encryptors.queryableText(password, salt);

    public static String encrypt(String string) {
        return textEncryptor.encrypt(string);
    }

    public static String decrypt(String string) {
        return textEncryptor.decrypt(string);
    }

}
