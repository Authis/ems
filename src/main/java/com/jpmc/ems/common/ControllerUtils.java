package com.jpmc.ems.common;

import io.atlassian.fugue.Either;

public class ControllerUtils {

    public static <R, E> ResultOrError<R, E> fold(Either<E, R> result) {
        return new ResultOrError<>(result);
    }


}
