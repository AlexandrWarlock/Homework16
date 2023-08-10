import java.util.regex.Pattern;

public class AuthenticationValidator {
    private static Pattern regex = Pattern.compile("^[A-Za-z0-9_]{0,20}$");
    public static void checkAuthentication(String login,
                                           String password,
                                           String confirmPassword) throws WrongLoginException {
        checkLogin(login);
        checkPassword(password);
        equalsPassword(password, confirmPassword);
    }
    private static void checkLogin(String login)  {
        if (!login.matches(regex.pattern())) {
            try {
                throw new WrongLoginException("Login содержит в себе только латинские буквы," +
                        " цифры и знак подчеркивания" +
                        " и должен быть не более 20 символов");
            } catch (WrongLoginException e) {
                throw new RuntimeException(e);
            }
        }
    }
    private static void checkPassword(String password) {
        if (!password.matches((regex.pattern()))) {
            try {
                throw new WrongPasswordException("password содержит в себе только латинские буквы," +
                        " цифры и знак подчеркивания" +
                        " и должен быть не более 20 символов");
            } catch (WrongPasswordException e) {
                throw new RuntimeException(e);
            }
        }
    }
    private static void equalsPassword(String password, String confirmPassword)
    throws WrongPasswordException {
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают");
        }
    }
}
