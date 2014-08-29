package com.welovecoding.web.blog.pusher.alias;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class FileName {

  public static final String MODIFIED_FILE = "src/main/resources/github-webhook-6465785245014415509.json";
  public static final Map<String, String> MODIFIED_FILE_HEADERS;

  public static final String MODIFIED_FILES_AND_NEW_FILE = "src/main/resources/github-webhook-1291172619151822652.json";
  public static final Map<String, String> MODIFIED_FILES_AND_NEW_FILE_HEADERS;

  static {
    // MODIFIED_FILE
    Map<String, String> temp = new HashMap<>();

    temp.put("host", "84.190.43.141:8080");
    temp.put("accept", "*/*");
    temp.put("user-agent", "GitHub-Hookshot/e3687ff");
    temp.put("x-github-event", "push");
    temp.put("x-github-delivery", "7d1a7758-2fba-11e4-84cd-fef398359bbc");
    temp.put("content-type", "application/json");
    // temp.put("x-hub-signature", "sha1=39e5e9a53a7395a02c0c93f8952d7886d669119a");
    temp.put("x-hub-signature", "sha1=c5533d38a31ab60a3786cbd0eddd7c540ab4f7eb");
    temp.put("content-length", "4886");

    MODIFIED_FILE_HEADERS = Collections.unmodifiableMap(temp);

    // MODIFIED_FILES_AND_NEW_FILE_HEADERS
    temp = new HashMap<>();

    temp.put("host", "84.190.43.141:8080");
    temp.put("accept", "*/*");
    temp.put("user-agent", "GitHub-Hookshot/e3687ff");
    temp.put("x-github-event", "push");
    temp.put("x-github-delivery", "2eb130b8-2fc2-11e4-8431-faff5043632a");
    temp.put("content-type", "application/json");
    temp.put("x-hub-signature", "sha1=b954cb56b9c67f01777b8d5843dbd999a76b7472");
    temp.put("content-length", "5094");

    MODIFIED_FILES_AND_NEW_FILE_HEADERS = Collections.unmodifiableMap(temp);
  }

  private FileName() {
  }

}
