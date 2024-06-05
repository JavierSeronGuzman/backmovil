package com.example.backapp;

import com.example.backapp.model.User;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class SomeService {

    @Autowired
    private Firestore db;

    public void testFirebaseConnection() {
        ApiFuture<QuerySnapshot> future = db.collection("users").get();
        List<QueryDocumentSnapshot> documents;
        try {
            documents = future.get().getDocuments();
            for (DocumentSnapshot document : documents) {
                System.out.println(document.getId() + " => " + document.getData());
            }
            System.out.println("Conexión a Firebase exitosa.");
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error al conectar con Firebase: " + e.getMessage());
        }
    }
    public void saveUser(User user) {
        db.collection("users").add(user);
    }
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        try {
            ApiFuture<QuerySnapshot> future = db.collection("users").get();
            List<QueryDocumentSnapshot> documents = future.get().getDocuments();
            for (QueryDocumentSnapshot document : documents) {
                users.add(document.toObject(User.class));
            }
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error al obtener usuarios: " + e.getMessage());
        }
        return users;
    }

}