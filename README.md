# Retry with Spring-boot


Add the following dependency to pom.xml

```
<dependency>
    <groupId>org.springframework.retry</groupId>
    <artifactId>spring-retry</artifactId>
</dependency>
```

Add @EnableRetry in the main class

Add @Retryable to the service class that needs a retry as follows:

```
    @Retryable(retryFor  = HttpStatusCodeException.class, maxAttempts = 3,
            backoff=@Backoff(delay=100),
            notRecoverable = {HttpClientErrorException.class })
```

Add  @Recover to Handle the exception and return the object as per the requirement from here. 

[Blog on Spring Retry](https://medium.com/@mj_ameer/streamlining-code-with-spring-retry-7594c1823fd7)

[Official Spring Retry](https://github.com/spring-projects/spring-retry)
