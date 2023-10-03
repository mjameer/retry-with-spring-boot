# Retry with Spring-boot

## To implement Retry 

Add the following dependency to pom.xml

```
        <dependency>
            <groupId>org.springframework.retry</groupId>
            <artifactId>spring-retry</artifactId>
        </dependency>
```

Add @EnableRetry in the main class

Add Retryable to the service class that needs a retry as follows:

```
@Retryable(value = HttpStatusCodeException.class, maxAttempts = 3, backoff = @Backoff(3000),
 exclude = HttpClientErrorException.class)
```

Add  @Recover to Handle the exception and return the object as per the requirement from here. 

https://medium.com/@mj_ameer/streamlining-code-with-spring-retry-7594c1823fd7

