package com.distributed.hoteljpa.util;

import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

/**
 * This app will generate a salted, SHA-512 hashed password based on the 
 * username and password field values in the users table in the db. Use this 
 * to initially seed your database with the hashed passwords. 
 * 
 * NOTE: this IS NOT a web app -- run it as a standalone app.
 * 
 * @author jlombardo
 */
public class ShaHashGeneratorApp {

    private static final ShaPasswordEncoder pe = new ShaPasswordEncoder();
    private static final String salt = ">$#X0x13abcSDF";
    /**
     * @param args the command line arguments - not used.
     */
    public static void main(String[] args) {
        // replace these with your own...
        
        String salt = "nwdavis88@gmail.com"; // username field in db
        String password = "nd593#NM"; // password field in db
        System.out.println(password + ": " + sha512(password,salt));
        
        salt = "sally@isp.com"; // username field in db
        password = "password2"; // password field in db
        System.out.println(password + ": " + sha512(password,salt));
        
        salt = "tom@isp.com"; // username field in db
        password = "password3"; // password field in db
        System.out.println(password + ": " + sha512(password,salt));
    }

    public static String sha512(String pwd, String salt) {
            pe.setIterations(1024);
            String hash = pe.encodePassword(pwd, salt);

            return hash;
    }
}
