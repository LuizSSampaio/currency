package net.lsamp.currency;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("CURRENCY CONVERTER");

        Scanner sc = new Scanner(System.in);

        System.out.print("Original Currency Code: ");
        String originalCurrencyCode = sc.next().trim().toLowerCase();

        System.out.print("Value: ");
        double originalValue = sc.nextDouble();

        System.out.print("Target Currency Code: ");
        String targetCurrencyCode = sc.next().trim().toLowerCase();

        String apiUrl = String.format(
                "https://cdn.jsdelivr.net/npm/@fawazahmed0/currency-api@latest/v1/currencies/%s.json",
                originalCurrencyCode
        );

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(apiUrl)).build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(responseBody -> {
                    try {
                        ObjectMapper mapper = new ObjectMapper();
                        JsonNode rootNode = mapper.readTree(responseBody);
                        JsonNode currencyNode = rootNode.path(originalCurrencyCode).path(targetCurrencyCode);
                        double targetValue = currencyNode.asDouble() * originalValue;

                        System.out.printf(
                                "%,.2f %s correspond to %,.2f %s%n",
                                originalValue, originalCurrencyCode, targetValue, targetCurrencyCode
                        );
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).join();
    }
}