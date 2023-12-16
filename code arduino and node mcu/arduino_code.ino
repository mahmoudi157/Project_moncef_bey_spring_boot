#include <DHT.h>
#include <TimeLib.h>

// Define the DHT sensor pin and type
#define DHTPIN 2
#define DHTTYPE DHT11
#define LED_RED 4
#define LED_GREN 10

#define LED_1 11
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
  pinMode(LED_GREN, OUTPUT);
  pinMode(LED_1, OUTPUT);
  pinMode(LED_2, OUTPUT);
  pinMode(LED_3, OUTPUT);
  pinMode(LED_4, OUTPUT);

  // Start serial communication
  Serial.begin(9600);

  // Initialize DHT sensor
  dht.begin();
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

   if (hum> 1) {
    digitalWrite(LED_GREN, HIGH); // Turn off the relay
  } else {
    digitalWrite(LED_GREN, LOW); // Turn on the relay
  }

  // Add logic for humidity threshold if needed

  // Get the current time in seconds since midnight
  unsigned long currentTime = now() % 86400;
  Serial.println(currentTime);

  // Implement your automation logic based on time
  if (currentTime ==  18* 3600) { // 18:00 in seconds
    // Do something at 6:00 PM
    digitalWrite(LED_1, HIGH); // Turn on the relay
  }

 if (currentTime == 7 * 3600 + 30 * 60) { // 7:30 in seconds
    // Do something at 7:30 AM
     digitalWrite(LED_1, LOW); // Turn on the relay
  }

  
  if (currentTime >=10 && currentTime < 20) {
  // Do something at 15:51 (between 15:51 and 15:52)
  digitalWrite(LED_1, HIGH); // Turn on the relay
}else{
  
  digitalWrite(LED_1, LOW); }// Turn on the rela

 
}

void loop() {
  etat=1;
  if(etat==1){
  readDHTSensor(); 
  modeAuto();}else{
    
    
    
    }
  
}

