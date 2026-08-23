<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.net.http.HttpClient, java.net.http.HttpRequest, java.net.http.HttpResponse" %>
<%@ page import="java.net.URI" %>
<%@ page import="org.json.JSONArray, org.json.JSONObject" %>

<%
    // --- Petición GET a la API (igual que en la terminal) ---
    String url = "https://jsonplaceholder.typicode.com/posts";

    HttpClient cliente = HttpClient.newHttpClient();
    HttpRequest peticion = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .header("Accept", "application/json")
            .GET()
            .build();

    HttpResponse<String> respuesta = cliente.send(peticion, HttpResponse.BodyHandlers.ofString());
    JSONArray posts = new JSONArray(respuesta.body());
%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Posts API</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 30px; background: #f0f2f5; }

        h1 { color: #333; }

        .tabla-container {
            background: white;
            border-radius: 8px;
            padding: 20px;
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
        }

        table { width: 100%; border-collapse: collapse; }

        th { background: #3a7bd5; color: white; padding: 10px; text-align: left; }

        td { padding: 8px 10px; border-bottom: 1px solid #eee; }

        tr:hover td { background: #f5f8ff; }
    </style>
</head>
<body>

    <h1>Posts de jsonplaceholder.typicode.com</h1>
    <p>Total: <strong><%= posts.length() %></strong> posts</p>

    <div class="tabla-container">
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>User ID</th>
                    <th>Título</th>
                </tr>
            </thead>
            <tbody>
                <%
                    // Recorre el JSON igual que info_respuesta() en la terminal
                    for (int i = 0; i < posts.length(); i++) {
                        JSONObject post = posts.getJSONObject(i);
                        int id     = post.getInt("id");
                        int userId = post.getInt("userId");
                        String titulo = post.getString("title");
                %>
                <tr>
                    <td><%= id %></td>
                    <td><%= userId %></td>
                    <td><%= titulo %></td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </div>

</body>
</html>
