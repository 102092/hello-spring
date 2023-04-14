# Spring WebFlux

## Overview
- It is fully non-blocking, supports Reactive Streams back pressure, and runs on such servers as Netty, Undertow, and Servlet containers
- Why was Spring WebFlux created?
    -  need for a non-blocking web stack to handle concurrency with a small number of threads

### Define “Reactive”
- ...programming models that are built around reacting to change--network components reacting to I/O events, UI controllers reacting to mouse events, and others
- non-blocking is reactive

### Reactive API
- It provides the Mono and Flux API types to work on data sequences of 0..1 (Mono) and 0..N (Flux) ...

### Applicability
![image](https://docs.spring.io/spring-framework/docs/current/reference/html/images/spring-mvc-and-webflux-venn.png)

- In a microservice architecture, you can have a mix of applications with either Spring MVC or Spring WebFlux controllers or with Spring WebFlux functional endpoints
- ...blocking persistence APIs (JPA, JDBC)...
- Spring MVC controllers can call other reactive components too
  - try the reactive `WebClient`

### Servers
- Spring WebFlux is supported on Tomcat, Jetty, Servlet containers
- By default, the starter uses Netty ...
- Spring Boot defaults to Netty, because it is more widely used in the asynchronous, non-blocking space and lets a client and a server share resources

### Performance
- Reactive and non-blocking generally do not make applications run faster.
- The key expected benefit of reactive and non-blocking is the ability to scale with a small, fixed number of threads and less memory.
- however, you need to have some latency (including a mix of slow and unpredictable network I/O)

### Concurrency Model
- Spring MVC (and servlet applications in general), it is assumed that applications can block the current thread
- Spring WebFlux (and non-blocking servers in general), it is assumed that applications do not block

## Reference
- https://docs.spring.io/spring-framework/docs/current/reference/html/web-reactive.html#webflux-new-framework
- https://www.baeldung.com/spring-webflux
- https://reflectoring.io/getting-started-with-spring-webflux/#blocking-request