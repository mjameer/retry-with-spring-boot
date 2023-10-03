# retry-with-spring-boot

Add @EnableRetry in the main class

Add Retryable to the service class that needs a retry as follows:

```
@Retryable(value = HttpStatusCodeException.class, maxAttempts = 3, backoff = @Backoff(3000),
 exclude = HttpClientErrorException.class)
```

Add  @Recover to Handle the exception and return the object as per the requirement from here. 

