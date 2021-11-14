package httpclient;

import java.net.URI;
import java.net.http.*;
import java.util.logging.*;

/**
 * A simplified HTTP client that supports logging.
 */
public class HttpClientFacade {
    private Logger logger = Logger.getAnonymousLogger();

    public HttpClientFacade() {
    }

    public HttpClientFacade(Logger logger) {
        this.logger = logger;
    }

    /**
     * Returns whether a website is up.
     *
     * A website is considered up if a GET request to its uri sends status 200.
     * Any exception caught are logged.
     *
     * @param host String URL of the server.
     */
    public boolean checkServer(String host) {
        try {
            HttpClient client = HttpClient.newBuilder().build();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(host))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            logger.log(Level.INFO, "Status: " + response.statusCode());
            return response.statusCode() == 200;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error: " + e.getMessage());
        }

        return false;
    }
}

