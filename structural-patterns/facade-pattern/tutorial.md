# Facade Pattern

## Http Client
The `HttpClientFacade` class works as a facade for the `java.net` package. The user is only interested in determining the health status of a url. The facade class provides a method called `checkServer`, which does the job. This method abstracts the complexity of using `java.net` package.