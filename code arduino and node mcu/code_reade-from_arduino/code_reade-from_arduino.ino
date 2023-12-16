#include <ESP8266WiFi.h>
#include <ESP8266HTTPClient.h>
#include <WiFiClientSecure.h>
#include "ArduinoJson.h"

const char* ssid = "EL BEHYA SPACE FOR MOBILE";
const char* password = "98765432";
String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI2NTU3YjRkYTk5YzU1MzVmYTcwYzc2MzciLCJpc3MiOiJNeUFwcCIsImV4cCI6MjAwMDg0MjYzMiwiaWF0IjoxNzAwODQyNjMyfQ.TYPCU9ClyS-eqAlEGwkvNVeuMkOmEjgFsRBl4nIfOxy0vilR014ot1mptUPj4CNQIJ1bxuDaMB1xXL68L3XrNA";
String serverName = "https://smart-home-53xp.onrender.com/api/";
DynamicJsonDocument doc(200);
unsigned long lastTime = 0;
unsigned long timerDelay = 5000;
String payload;
String previousPayload;  // Variable to store the previous payload

void setup() {
  Serial.begin(9600);
  WiFi.begin(ssid, password);
  Serial.println("Connecting");
  Serial1.begin(9600);

  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }

  Serial.println("");
  Serial.print("Connected to WiFi network with IP Address: ");
  Serial.println(WiFi.localIP());

  Serial.println("Timer set to 5 seconds (timerDelay variable), it will take 5 seconds before publishing the first reading.");
}

void parseJsonArray(const String& jsonString, int arrayValues[]) {
  DynamicJsonDocument jsonDoc(1024);
  deserializeJson(jsonDoc, jsonString);

  JsonArray jsonArray = jsonDoc.as<JsonArray>();

  for (int i = 0; i < jsonArray.size(); i++) {
    arrayValues[i] = jsonArray[i]["etat"];
  }
}

void checkAndSendVariables() {
  if (payload != previousPayload) {
    // If the payload has changed, send the variables to the Arduino
    int arrayValues[4];
    parseJsonArray(payload, arrayValues);
    createjson(arrayValues[0], arrayValues[1], arrayValues[2], arrayValues[3]);
    Serial.println("change");
    previousPayload = payload;
  }
}

String sendRequestGet(String path) {
  if ((millis() - lastTime) > timerDelay) {
    if (WiFi.status() == WL_CONNECTED) {
      WiFiClientSecure client;
      HTTPClient http;

      String serverPath = serverName + path;

      http.begin(client, serverPath.c_str());
      http.addHeader("Content-Type", "text/plain");
      http.addHeader("Authorization", token);

      client.setInsecure();
      http.setTimeout(15000);

      Serial.println("Before HTTP request");
      int httpResponseCode = http.GET();
      Serial.println("After HTTP request");

      if (httpResponseCode > 0) {
        Serial.print("HTTP Response code: ");
        Serial.println(httpResponseCode);
        payload = http.getString();
        Serial.println("Response payload:");

        // Check and send variables if there's a change
        checkAndSendVariables();
      } else {
        Serial.print("Error code: ");
        Serial.println(httpResponseCode);
        Serial.println(http.errorToString(httpResponseCode).c_str());
      }

      http.end();
    } else {
      Serial.println("WiFi Disconnected");
    }

    lastTime = millis();
  }

  return payload;
}

void createjson(int v1, int v2, int v3, int v4) {
  doc["mode"] = "1";
  doc["lam1"] = v1;
  doc["lam2"] = v2;
  doc["lam3"] = v3;
  doc["lam4"] = v4;

  // Serialize JSON document to a string
  String jsonString;
  serializeJson(doc, jsonString);

  // Print the JSON string to Serial
  Serial.println(jsonString);
}

void createjsonmode(String ss) {
  doc["mode"] = "2";
  doc["lam1"] = ss;
  

  // Serialize JSON document to a string
  String jsonString;
  serializeJson(doc, jsonString);

  // Print the JSON string to Serial
  Serial.println(jsonString);
}

void loop() {
 
  
String  ss = sendRequestGet("data/lamp");
  
  int arrayValues[4];
  parseJsonArray(ss, arrayValues);
  createjson( arrayValues[0], arrayValues[1], arrayValues[2], arrayValues[3]);

  // Delay before sending the next JSON data
  delay(1000);
  String  mm = sendRequestGet("data/mode/");
  createjsonmode(mm);
  delay(1000);

}

