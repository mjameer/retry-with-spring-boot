# retry-with-spring-boot

Add @EnableRetry in main class

Add Retryable in the service class that needs retry as follows:

```
@Retryable(value = HttpStatusCodeException.class, maxAttempts = 3, backoff = @Backoff(3000),
 exclude = HttpClientErrorException.class)
```

Add  @Recover to Handle the exception and return the object as per the requirment from here. 

