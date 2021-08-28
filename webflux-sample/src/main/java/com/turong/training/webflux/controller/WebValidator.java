package com.turong.training.webflux.controller;

public interface WebValidator<WebRequest> {

    boolean validate(final WebRequest request);

}
