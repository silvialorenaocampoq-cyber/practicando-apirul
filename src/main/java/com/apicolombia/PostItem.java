package com.apicolombia;

// Modelo simple para representar un post de la API
public class PostItem {

    private int id;
    private int userId;
    private String title;
    private String body;

    public PostItem(int id, int userId, String title, String body) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    public int getId()       { return id; }
    public int getUserId()   { return userId; }
    public String getTitle() { return title; }
    public String getBody()  { return body; }
}
