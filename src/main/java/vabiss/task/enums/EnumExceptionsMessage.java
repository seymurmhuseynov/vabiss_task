package vabiss.task.enums;

public enum EnumExceptionsMessage {

    DATA_NOT_FOUND("Data not found");

    private final String message;

    EnumExceptionsMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
