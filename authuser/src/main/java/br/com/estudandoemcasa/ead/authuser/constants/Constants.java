package br.com.estudandoemcasa.ead.authuser.constants;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class Constants {

    public static String USER_NOT_FOUND =  "User Not Found.";
    public static String USER_UPDATE =  "User Update Success";
    public static String IMG_UPDATE =  "Img Update Success";
    public static String USER_OR_PASSWORD_INCORRECT = "User Not Found or Password Incorrect!";
    public static String PASSWORD_UPDATE = "Password Update Success!";
    public static LocalDateTime LOCAL_DATE_TIME_NOW = LocalDateTime.now(ZoneId.of("UTC"));
}
