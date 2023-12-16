#include <SoftwareSerial.h>
#include <ArduinoJson.h>
#include <DHT.h>
#include <TimeLib.h>

SoftwareSerial Serial1(5, 6);  // RX, TX
#define DHTPIN 2
#define DHTTYPE DHT11
#define LED_RED 4
#define LED_GREEN 11  // Corrected LED naming

#define LED_1 10
#define LED_2 7
#define LED_3 8
#define LED_4 9
#define MIN_TEMP_THRESHOLD 2
#define MAX_HUM_THRESHOLD 60

DHT dht(DHTPIN, DHTTYPE);

double temp = 0;
double hum = 0;
int etat;

void setup() {
  pinMode(LED_RED, OUTPUT);
  pinMode(LED_GREEN, OUTPUT);
  pinMode(LED_1, OUTPUT);
  pinMode(LED_2, OUTPUT);
  pinMode(LED_3, OUTPUT);
  pinMode(LED_4, OUTPUT);

  // Initialize DHT sensor
  dht.begin();
  Serial.begin(9600);
  Serial1.begin(9600);
  delay(2000);
}

void readDHTSensor() {
  unsigned long currentMillis = millis();

  if (currentMillis % 5000 == 0) { // Check every 5 seconds
    temp = dht.readTemperature();
    hum = dht.readHumidity();

    if (isnan(hum) || isnan(temp)) {
      Serial.println("Failed to read from DHT sensor!");
    } else {
      Serial.print("Humidity: ");
      Serial.print(hum);
      Serial.print("%, Temperature: ");
      Serial.print(temp);
      Serial.println("°C");
    }
  }
}

void modeAuto() {
  readDHTSensor();

  // Control the relay based on temperature
  if (temp > MIN_TEMP_THRESHOLD) {
    digitalWrite(LED_RED, LOW); // Turn off the relay
  } else {
    digitalWrite(LED_RED, HIGH); // Turn on the relay
  }

  if (hum > MAX_HUM_THRESHOLD) {
    digitalWrite(LED_GREEN, LOW); // Turn off the relay
  } else {
    digitalWrite(LED_GREEN, HIGH); // Turn on the relay
  }

  unsigned long currentTime = now() % 86400;
  Serial.println(currentTime);

  // Implement your automation logic based on time
  if (currentTime == 18 * 3600) { // 18:00 in seconds
    // Do something at 6:00 PM
    digitalWrite(LED_1, HIGH); // Turn on the relay
  }

  if (currentTime == 7 * 3600 + 30 * 60) { // 7:30 in seconds
    // Do something at 7:30 AM
    digitalWrite(LED_1, LOW); // Turn off the relay
  }

  if (currentTime >= 10 * 3600 && currentTime < 20 * 3600) {
    // Do something between 10:00 AM and 8:00 PM
    digitalWrite(LED_1, HIGH); // Turn on the relay
  } else {
    digitalWrite(LED_1, LOW); // Turn off the relay
  }
}

void readjson() {
  if (Serial1.available()) {
    String jsonString;
    while (Serial1.available()) {
      char c = Serial1.read();
      jsonString += c;
    }

    DynamicJsonDocument doc(200);
    DeserializationError error = deserializeJson(doc, jsonString);
    if (error == DeserializationError::Ok) {
      
      
       
      controleled(doc["lam1"].as<int>(), doc["lam2"].as<int>(), doc["lam3"].as<long>(), doc["lam4"].as<long>());
      Serial.print("mode: ");
      Serial.println(doc["mode"].as<int>());
      Serial.print("lam1: ");
      Serial.println(doc["lam1"].as<int>());
      Serial.print("lam2: ");
      Serial.println(doc["lam2"].as<int>());
      Serial.print("lam3: ");
      Serial.println(doc["lam3"].as<int>());
      Serial.print("lam4: ");
      Serial.println(doc["lam4"].as<int>());
    } else {
      // Handle JSON parsing error
    }
  }
}

void controleled(int led1, int led2, int led3, int led4) {
  digitalWrite(LED_1, led1);
  digitalWrite(LED_2, led2);
  digitalWrite(LED_3, led3);
  digitalWrite(LED_4, led4);
}

void loop() {
  readjson();
etat=0;
  // Consider removing or changing the value based on your logic

  if (etat == 1) {
    readDHTSensor();
    modeAuto();
  } else {
    
  }

  delay(500);
}

