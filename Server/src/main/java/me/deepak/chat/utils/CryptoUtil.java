package me.deepak.chat.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author SONY
 */
public class CryptoUtil {

	private static final String URL = System.getProperty("user.home") + File.separator + ".lan_chat";

	private CryptoUtil() {
	}

	public static String encrypt(String userId, String unencryptedString) throws Exception {
		return DatatypeConverter
				.printHexBinary(getCipher(userId, Cipher.ENCRYPT_MODE).doFinal(unencryptedString.getBytes()));
	}

	public static String decrypt(String userId, String encryptedText) throws Exception {
		return new String(
				getCipher(userId, Cipher.DECRYPT_MODE).doFinal(DatatypeConverter.parseHexBinary(encryptedText)));
	}

	private static Cipher getCipher(String userId, int mode) throws Exception {
		ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(URL + File.separator + userId));
		SecretKey secretKey = (SecretKey) inputStream.readObject();
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(mode, secretKey);
		inputStream.close();
		return cipher;
	}

}
