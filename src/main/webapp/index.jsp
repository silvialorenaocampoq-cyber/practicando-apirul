<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.apicolombia.PostItem, java.util.List" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Posts - API Colombia</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 30px;
            background-color: #f4f4f4;
        }

        h1 {
            color: #333;
        }

        .contenedor {
            background: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 6px rgba(0,0,0,0.1);
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 15px;
        }

        th {
            background-color: #4a90d9;
            color: white;
            padding: 10px;
            text-align: left;
        }

        td {
            padding: 8px 10px;
            border-bottom: 1px solid #ddd;
            vertical-align: top;
        }

        tr:hover {
            background-color: #f0f7ff;
        }

        .badge {
            display: inline-block;
            background: #4a90d9;
            color: white;
            border-radius: 12px;
            padding: 2px 8px;
            font-size: 12px;
        }
    </style>
</head>
<body>

<div class="contenedor">
    <h1>Posts de jsonplaceholder.typicode.com</h1>
    <p>Total de posts: <strong><%= ((List<PostItem>) request.getAttribute("posts")).size() %></strong></p>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>User ID</th>
                <th>Título</th>
                <th>Contenido</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<PostItem> posts = (List<PostItem>) request.getAttribute("posts");
                for (PostItem post : posts) {
            %>
            <tr>
                <td><span class="badge"><%= post.getId() %></span></td>
                <td><%= post.getUserId() %></td>
                <td><%= post.getTitle() %></td>
                <td><%= post.getBody() %></td>
            </tr>
            <% } %>
        </tbody>
    </table>
</div>

</body>
</html>
