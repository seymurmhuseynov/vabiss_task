package vabiss.task.model;


public class Response {

    private int code;
    private String message;
    private Object response;

    public Response() {
        code = 200;
        message = "success: Done!";
    }

    public Response(int code, String message, Object response) {
        this.code = code;
        this.message = message;
        this.response = response;
    }

    public int getCode() {
        return code;
    }

    public Response setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Response setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getResponse() {
        return response;
    }

    public Response setResponse(Object response) {
        this.response = response;
        return this;
    }
}
