package vabiss.task.enums;

public enum EnumExceptionsMessage {

    DATA_ALREADY_EXIST("Data Already Exist"),
    USERNAME_OR_PASSWORD_EMPTY("Username or Password cannot be empty"),
    WRONG_MAIL_FORMAT("mail format is not specified correctly"),
    TOKEN_NOT_FOUND("You must obtain a token to access this page "),
    USER_WRONG_USERNAME_OR_PASSWORD("Username or Password wrong"),
    DATA_NOT_FOUND("Data not found");

    private final String message;

    EnumExceptionsMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
