package com.recipe.recipe.exceptions;

public class NoSuchReviewException extends Exception{
    public NoSuchReviewException(String message) {
        super(message);
    }

    public NoSuchReviewException() {
    }
}
