package org.example;

import com.google.auth.oauth2.GoogleCredentials;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws IOException {
    System.out.println(getAccessToken());
  }

  private static final String MESSAGING_SCOPE = "https://www.googleapis.com/auth/firebase.messaging";
  private static final String[] SCOPES = {MESSAGING_SCOPE};

  private static String getAccessToken() throws IOException {
    GoogleCredentials googleCredentials = GoogleCredentials
        .fromStream(Files.newInputStream(Paths.get("put your android.json path here !")))
        .createScoped(Arrays.asList(SCOPES));
    googleCredentials.refresh();
    return googleCredentials.getAccessToken().getTokenValue();
  }
}