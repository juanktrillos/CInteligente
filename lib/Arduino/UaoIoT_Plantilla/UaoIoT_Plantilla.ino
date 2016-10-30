#include <UAOIOTClient.h>

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  while (!Serial);
  beginUAOIOT("181.118.150.147", "nombre", "grupo", "password"); //IP EXTERNA UAOIOT
  //beginUAOIOT("172.16.3.27", "nombre", "grupo", "password"); //IP INTERNA UAOIOT
  connectToBroker();
  //addDevice("remoteDeviceName");
}

void loop() {
  // put your main code here, to run repeatedly:
  int data = analogRead(A0);
  checkConn();
  publishData(1, data);
  Serial.print("Enviando datos ....... "); Serial.println(datos);
  delay(1000);

  //publishData(registro, valor);//METODO PARA PUBLICAR DATO EN UAOIOT
  //modifyData("remoteDeviceName", registro, valor);//METODO PARA ENVIAR DATO A UN DISPOSITIVO
}

void onPublishDataArrave(String remoteDeviceName, int idRegister, int value) {
  Serial.print("Datos Recibidos: "); Serial.println(value);
}

void onModifyDataArrave(int idRegister, int value) {

}
