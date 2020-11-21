package com.hussain.dbinit;

import java.io.FileInputStream;
import java.io.IOException;
import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Service
public class FirebaseInitialise {

	@PostConstruct
	public void intialiseFirebase() throws IOException {

		FileInputStream serviceAccount = new FileInputStream("./myemployeedata-abd0d-firebase-adminsdk-6pv0m-016a084bac.json");

		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				.setDatabaseUrl("https://myemployeedata-abd0d.firebaseio.com").build();

		FirebaseApp.initializeApp(options);

	}

}
