package com.webshop.project;

import org.springframework.security.crypto.password.StandardPasswordEncoder;

/**
 * Created by stanislav on 25.10.17.
 */
public class EncryptPassword {
    public static void main(String[] args) {
        StandardPasswordEncoder passwordEncoder = new StandardPasswordEncoder("d15m12y1995");
        System.out.println(passwordEncoder.encode("stas1995"));
    }
}
