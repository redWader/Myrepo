package Handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class GetInfo implements HttpHandler {

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {


        handleResponse(httpExchange);
    }

    private String handleGetRequest(HttpExchange httpExchange) {
        return httpExchange.
                getRequestURI()
                .toString()
                .split("\\?")[1]
                .split("=")[1];
    }

    private void handleResponse(HttpExchange httpExchange)  throws  IOException {
        OutputStream outputStream = httpExchange.getResponseBody();
        StringBuilder htmlBuilder = new StringBuilder();

        // encode HTML content
        String htmlResponse = "qwerty";

        // this line is a must
        httpExchange.sendResponseHeaders(200, htmlResponse.length());

        outputStream.write(htmlResponse.getBytes());
        outputStream.flush();
        outputStream.close();
    }
}