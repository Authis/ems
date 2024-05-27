package com.jpmc.ems.common;

import io.atlassian.fugue.Either;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.NOT_FOUND;

public class ResultOrError<R, E> extends ResponseEntity<R> {

    public ResultOrError(Either<E, R> result) {
        super(body(result), status(result));

    }

    private static <E, R> HttpStatus status(Either<E, R> result) {
        return result.fold(
                err -> NOT_FOUND,
                res -> OK);
    }

    private static <E, R> R body(Either<E, R> result) {
        return result.fold(
                err -> (R) err,
                res -> res);
    }

}
