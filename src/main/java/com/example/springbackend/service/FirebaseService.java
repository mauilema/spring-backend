package com.example.springbackend.service;

import com.example.springbackend.model.FirebaseUser;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;

@Service
public class FirebaseService {

    public FirebaseApp initializeFirebase() throws IOException {

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource resource = resolver.getResource("classpath:backend-winter23-firebase.json");

        FileInputStream serviceAccount = new FileInputStream(resource.getFile());

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://backend-winter23.firebaseio.com")
                .build();

        return FirebaseApp.initializeApp(options);
    }

    public FirebaseUser authenticate(String idToken) throws IOException, FirebaseAuthException {

        String uid = FirebaseAuth.getInstance(initializeFirebase()).verifyIdToken(idToken).getUid();
        String name = FirebaseAuth.getInstance(initializeFirebase()).verifyIdToken(idToken).getName();
        String email = FirebaseAuth.getInstance(initializeFirebase()).verifyIdToken(idToken).getEmail();

        return new FirebaseUser(uid, name, email);
    }

}

