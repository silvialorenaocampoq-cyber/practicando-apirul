package javaapicolombia2;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class apimodelo {

    private final String api_url;
    public HttpResponse<String> respuesta_api;

    public apimodelo(String dato_url) {
        this.api_url = dato_url;
        this.respuesta_api = null;
    }

    public void hacer_peticion_get() {
        try {
            HttpClient cliente = HttpClient.newHttpClient();
            HttpRequest peticion = HttpRequest.newBuilder()
                    .uri(URI.create(this.api_url))
                    .header("Accept", "application/json") // Corrección: de "text/plain" a "application/json"
                    .GET()
                    .build();
            this.respuesta_api = cliente.send(peticion, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException ex) {
            System.out.println("Error en la petición GET: " + ex.getMessage());
        }
    }

    public void hacer_peticion_post() {
        String texto_json = """
                            {"cedula": "127044901", "nombre": "nelson"}""";
        try {
            HttpClient cliente = HttpClient.newHttpClient();
            HttpRequest peticion = HttpRequest.newBuilder()
                    .uri(URI.create(this.api_url))
                    .header("Content-Type", "application/json") // Corrección: de "application/jason" a "application/json"
                    .POST(HttpRequest.BodyPublishers.ofString(texto_json))
                    .build();
            this.respuesta_api = cliente.send(peticion, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException ex) {
            System.out.println("Error en la petición POST: " + ex.getMessage());
        }
    }

    public void imprimir_info() {
        if (this.respuesta_api != null) {
            System.out.println("Código de estado HTTP: " + this.respuesta_api.statusCode());
            System.out.println("Cuerpo de la respuesta: " + this.respuesta_api.body());
        } else {
            System.out.println("No hay respuesta para mostrar (la petición falló o no se ejecutó).");
        }
    }

    public void info_respuesta() {
        if (this.respuesta_api == null || this.respuesta_api.body() == null) {
            System.out.println("No se encontraron datos para procesar.");
            return;
        }

        try {
            JSONArray array_json = new JSONArray(this.respuesta_api.body());
            for (int i = 0; i < array_json.length(); i++) {
                JSONObject obj_info = array_json.getJSONObject(i);
                int id = obj_info.getInt("id");
                String titulo = obj_info.getString("title");

                System.out.println("ID: " + id + " - Título: " + titulo);
            }
        } catch (JSONException ex) {
            System.out.println("Error al procesar el JSON: " + ex.getMessage());
        }
    }
}