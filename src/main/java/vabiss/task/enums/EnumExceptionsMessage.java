package vabiss.task.enums;

public enum EnumExceptionsMessage {

    DATA_ALREADY_EXIST("Data Already Exist"),
    USERNAME_OR_PASSWORD_EMPTY("Username or Password cannot be empty"),
    WRONG_MAIL_FORMAT("mail format is not specified correctly"),
    DATA_NOT_FOUND("Data not found");

    private final String message;

    EnumExceptionsMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
