package com.rt.service;

import org.springframework.http.HttpStatus;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.HttpStatusCodeException;

@Service
public class CheckStatusService {


    @Retryable(retryFor  = HttpStatusCodeException.class, maxAttempts = 3,
            backoff=@Backoff(delay=100),
            notRecoverable = {HttpClientErrorException.class })
    public Example checkStatus() {

        // Insert logic prone to failure and necessitating retries here
        // microservice call to get status.
        // rest template call

        System.out.println("Calling another service to get status!!");
        throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR);

        // return "example";
    }

    @Recover
    public Example handleException(HttpServerErrorException exception) {
         // Implement logic for managing failures after all retries are exhausted
        exception.printStackTrace();
        return new Example("Please try after some time!!");
    }
}
