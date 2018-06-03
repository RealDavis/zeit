package br.com.jestoque.security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import br.com.zeit.exceptions.EncriptionException;

public class Encript {

	public String encriptPassword(String senha) throws EncriptionException {
		String senhaEncriptada = "";
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte messageDigest[] = md.digest(senha.getBytes("UTF-8"));
			
			StringBuilder hexString = new StringBuilder();
			for (byte b : messageDigest) {
			  hexString.append(String.format("%02X", 0xFF & b));
			}
			senhaEncriptada = hexString.toString();
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			throw new EncriptionException("Erro interno da aplicação");
		}
		
		return senhaEncriptada;
	}
	
}
