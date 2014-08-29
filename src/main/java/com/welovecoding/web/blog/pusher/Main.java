package com.welovecoding.web.blog.pusher;

import com.welovecoding.web.blog.pusher.alias.FileName;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

public class Main {

  private static final Logger LOG = Logger.getLogger(Main.class.getName());
  private static final String TARGET_URL = "http://localhost:8080/wlc-blog/webhook/trigger";

  public static void main(String[] args) {

    String payload = getPayload();
    JSONObject jsonObject = new JSONObject(payload);
    try {
      sendPayload(jsonObject);
    } catch (IOException ex) {
      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    }

  }

  private static void sendPayload(JSONObject jsonObject) throws IOException {
    URL url = new URL(TARGET_URL);
    URLConnection connection = url.openConnection();

    connection.setDoOutput(true);

    for (String key : FileName.MODIFIED_FILE_HEADERS.keySet()) {
      connection.setRequestProperty(key, FileName.MODIFIED_FILE_HEADERS.get(key));
    }

    connection.setConnectTimeout(5000);
    connection.setReadTimeout(5000);

    OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
    out.write(jsonObject.toString());
    out.close();

    BufferedReader in = new BufferedReader(new InputStreamReader(
            connection.getInputStream()));

    while (in.readLine() != null) {
    }
    System.out.println("\nREST Service Invoked Successfully..");
    in.close();
  }

  private static String getPayload() {
    StringBuilder sb = new StringBuilder();
    String line = "";

    File file = new File(FileName.MODIFIED_FILE);

    try (
            InputStream stream = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {
      while ((line = reader.readLine()) != null) {
        sb.append(line);
        sb.append(System.getProperty("line.separator", "\r\n"));
      }
    } catch (FileNotFoundException fileException) {
      LOG.log(Level.WARNING, "File cannot be found at: {0}", file.getAbsolutePath());
    } catch (IOException readException) {
      LOG.log(Level.SEVERE, "Error reading file: {0}", readException.getLocalizedMessage());
    }

    return sb.toString();
  }
}
