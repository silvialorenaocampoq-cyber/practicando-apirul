package com.apicolombia;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class ApiModelo {

    private final String api_url;

    public ApiModelo(String url) {
        this.api_url = url;
    }

    // Retorna la respuesta cruda como String
    public String hacer_peticion_get() throws IOException, InterruptedException {
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest peticion = HttpRequest.newBuilder()
                .uri(URI.create(this.api_url))
                .header("Accept", "application/json")
                .GET()
                .build();
        HttpResponse<String> respuesta = cliente.send(peticion, HttpResponse.BodyHandlers.ofString());
        return respuesta.body();
    }

    // Parsea el JSON y devuelve lista de posts como objetos simples
    public List<PostItem> obtener_posts() {
        List<PostItem> lista = new ArrayList<>();
        try {
            String body = hacer_peticion_get();
            JSONArray array = new JSONArray(body);
            for (int i = 0; i < array.length(); i++) {
                JSONObject obj = array.getJSONObject(i);
                lista.add(new PostItem(
                        obj.getInt("id"),
                        obj.getInt("userId"),
                        obj.getString("title"),
                        obj.getString("body")
                ));
            }
        } catch (Exception ex) {
            System.out.println("Error al obtener posts: " + ex.getMessage());
        }
        return lista;
    }
}
