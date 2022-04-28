package com.company;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        //serializeSimple();
        deserializeSimple();


    }

    static void serializeSimple(){
        Simple person = new Simple("Tucker",17,true);
        Gson gson = new Gson();
        String json = gson.toJson(person);
        try {
            FileWriter writer = new FileWriter("data.json");
            gson.toJson(person,writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static void deserializeSimple(){
        String person2Json = "{\"name\": \"Tucker\", \"age\": 17, \"isDeveloper\": true}";
        JsonParser parser = new JsonParser();
        JsonElement test = parser.parse(person2Json);
        System.out.println(test.isJsonObject());
        Gson gson = new Gson();
        Simple person2 = gson.fromJson(person2Json,Simple.class);
        System.out.println(person2.getClass().getSimpleName());

    }

}

class ToDo{
    private String body;
    private boolean done;
    private int id;
    private int priority;
    private String title;

    public ToDo(String body, boolean done, int id, int priority, String title) {
        this.body = body;
        this.done = done;
        this.id = id;
        this.priority = priority;
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "body='" + body + '\'' +
                ", done=" + done +
                ", id=" + id +
                ", priority=" + priority +
                ", title='" + title + '\'' +
                '}';
    }
}