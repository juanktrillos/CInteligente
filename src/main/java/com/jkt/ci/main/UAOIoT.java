/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jkt.ci.main;

import co.edu.uao.uaoiot.javauaoiotlib.UaoiotCallback;
import co.edu.uao.uaoiot.javauaoiotlib.UaoiotClient;
import com.jkt.ci.main.data.Basura;
import com.jkt.ci.main.data.Presion;
import com.jkt.ci.main.data.Radiacion;
import com.jkt.ci.main.data.Temperatura;
import com.jkt.lib.driven.MongoHandler;
import java.net.UnknownHostException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.paho.client.mqttv3.MqttException;

/**
 *
 * @author juan.trillos
 */
public class UAOIoT {

    private UaoiotClient uaoiot;
    private boolean active;

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public UAOIoT() {
        uaoiot = new UaoiotClient();
        this.active = true;
        try {
//            uaoiot.connect("181.118.150.147", "nombre", "grupo", "password"); //IP EXTERNA UAOIOT
            uaoiot.connect("172.16.3.27", "prueba", "grupo1", "123456"); //IP INTERNA UAOIOT
            //uaoiot.addDevice("remoteDeviceName");
//            listening();
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
                
                if (active) {
                    String park = "Parque Famoso";
                    Calendar date = new GregorianCalendar();
                    try {
                        MongoHandler mongoHandler = new MongoHandler("CInteligente");
                        if (register == 1) {
                            mongoHandler.insert(new Temperatura(value, park, date));
                        }
                        if (register == 2) {
                            mongoHandler.insert(new Presion(value, park, date));
                        }
                        if (register == 3) {
                            mongoHandler.insert(new Basura(value, park, date));
                        }
                        if (register == 4) {
                            mongoHandler.insert(new Radiacion(value, park, date));
                        }
                    } catch (UnknownHostException ex) {
                        Logger.getLogger(UAOIoT.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
