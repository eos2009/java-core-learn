package com.chenfei.annotation;

/**
 * @author chenfei
 * @description
 * @since 2018/10/29
 */
@SuppressWarnings("uncheck")
public class PasswordUtils {

    private String salt;

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    private void testPrivate(){}

    @UseCase(id = 47, description = "Passwords must contain at least one numeric")
    public static boolean validatePassword(String password) {
        return (password.matches("\\w*\\d\\w*"));
    }

    @UseCase(id = 48)
    public static String encryptPassword(String password) {
        return new StringBuilder(password).reverse().toString();
    }

    @UseCase2("@annotation(useCase)")
    public String test(String password,UseCase useCase) {
        return new StringBuilder(password).reverse().toString();
    }
}
