/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jkt.ci.main;

import co.edu.uao.uaoiot.javauaoiotlib.UaoiotCallback;
import co.edu.uao.uaoiot.javauaoiotlib.UaoiotClient;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.paho.client.mqttv3.MqttException;

/**
 *
 * @author JuanCamilo
 */
public class UAOIoT {

    UaoiotClient uaoiot;

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public UAOIoT() {
        try {
            uaoiot = new UaoiotClient();
            uaoiot.connect("181.118.150.147", "nombre", "grupo", "password"); //IP EXTERNA UAOIOT
            //uaoiot.connect("172.16.3.27", "nombre", "grupo", "password"); //IP INTERNA UAOIOT
            //uaoiot.addDevice("remoteDeviceName");
            listening();
        } catch (MqttException ex) {
            Logger.getLogger(UAOIoT.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void listening() {

        uaoiot.setUaoiotCallback(new UaoiotCallback() {

            /**
             * METODO que recibe un valor de otro dispositivo UNO A UNO
             *
             * @param register
             * @param value
             */
            @Override
            public void onModifyDataArrive(int register, int value) {
                System.out.println("IdRegistro: " + register);
                System.out.println("Value     : " + value);
            }

            /**
             * METODO que recibe un valor de otro dispositivo UNO A MUCHOS
             *
             * @param deviceName
             * @param register
             * @param value
             */
            @Override
            public void onPublishDataArrive(String deviceName, int register, int value) {
                System.out.println("DeviceName: " + deviceName);
                System.out.println("Registor  : " + register);
                System.out.println("Value     : " + value);
            }
        });
    }
}
