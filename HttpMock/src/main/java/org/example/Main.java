package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import Handlers.GetInfo;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {
    public static Logger LOGGER = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 8001),0);

        server.createContext("/test", new GetInfo());

        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);

        server.setExecutor(threadPoolExecutor);
        server.start();
        LOGGER.info("Сервер запущен на 8001 порту");


    }
}