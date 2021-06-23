package vabiss.task.exceptions;

import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import vabiss.task.model.Response;


@ControllerAdvice
public class Exceptions extends Throwable {

    @ResponseBody
    @ResponseStatus(HttpStatus.ALREADY_REPORTED)
    @ExceptionHandler(AlreadyExistException.class)
    public Response alreadyExistException() {
        return new Response()
                .setCode(HttpStatus.ALREADY_REPORTED.value())
                .setMessage("This data already exist");
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(NotFoundException.class)
    public Response notFoundException(NotFoundException e) {
        return new Response()
                .setCode(HttpStatus.NOT_FOUND.value())
                .setMessage(e.getMessage());

    }

    @ResponseBody
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(TokenNotFoundException.class)
    public Response tokenNotFoundException(NotFoundException e) {
        return new Response()
                .setCode(HttpStatus.UNAUTHORIZED.value())
                .setMessage(e.getMessage());

    }

    @ResponseBody
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(WrongMailFormatException.class)
    public Response wrongMailException(WrongMailFormatException e) {
        return new Response()
                .setCode(HttpStatus.UNAUTHORIZED.value())
                .setMessage(e.getMessage());
    }


    @ResponseBody
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(WrongPasswordException.class)
    public Response wrongPasswordException(WrongPasswordException e) {
        return new Response()
                .setCode(HttpStatus.UNAUTHORIZED.value())
                .setMessage(e.getMessage());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(EmptyException.class)
    public Response emptyException(EmptyException e) {
        return new Response()
                .setCode(HttpStatus.UNPROCESSABLE_ENTITY.value())
                .setMessage(e.getMessage());
    }


    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(InvalidDataAccessResourceUsageException.class)
    public Response invalidDataAccessResourceUsageException(InvalidDataAccessResourceUsageException e) {
        return new Response()
                .setCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .setMessage(e.getMessage());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(JpaSystemException.class)
    public Response jpaSystemException(JpaSystemException e) {
        return new Response()
                .setCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .setMessage(e.getMessage());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Response httpMessageNotReadableException(HttpMessageNotReadableException e) {
        return new Response()
                .setCode(HttpStatus.BAD_REQUEST.value())
                .setMessage(e.getMessage());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Response methodArgumentNotValidException(MethodArgumentNotValidException e) {
        return new Response()
                .setCode(HttpStatus.BAD_REQUEST.value())
                .setMessage(e.getMessage());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Response missingServletRequestParameterException(MissingServletRequestParameterException e) {
        return new Response()
                .setCode(HttpStatus.BAD_REQUEST.value())
                .setMessage(e.getMessage());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public Response methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        return new Response()
                .setCode(HttpStatus.BAD_REQUEST.value())
                .setMessage(e.getMessage());
    }


    @ResponseBody
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Response httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        return new Response()
                .setCode(HttpStatus.METHOD_NOT_ALLOWED.value())
                .setMessage(e.getMessage());
    }
}
