package httpclient;

import java.util.logging.Logger;

public class HttpClientMain {
    /**
     * Prints the status of Google server.
     */
    public static void main(String[] args) {
        Logger logger = Logger.getLogger("HttpClientMain");
        HttpClientFacade client = new HttpClientFacade(logger);

        System.out.println("Loading...");
        boolean up = client.checkServer("https://www.google.com");
        System.out.println("The server is: " + (up ? "up" : "down") + ".");
    }
}
