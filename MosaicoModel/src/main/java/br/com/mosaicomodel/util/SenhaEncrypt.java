package br.com.mosaicomodel.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SenhaEncrypt {

	public static void main(String[] args) {
        String password = "123456";
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode(password));
}
}
