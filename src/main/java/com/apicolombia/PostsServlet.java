package com.apicolombia;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @WebServlet define la URL que activa este servlet
// Al entrar a /posts, este servlet se ejecuta
@WebServlet("/posts")
public class PostsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Llamar a la API
        ApiModelo modelo = new ApiModelo("https://jsonplaceholder.typicode.com/posts");
        List<PostItem> posts = modelo.obtener_posts();

        // 2. Pasar los datos a la vista JSP como atributo del request
        request.setAttribute("posts", posts);

        // 3. Redirigir al JSP (la vista)
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
