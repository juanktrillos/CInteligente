package com.jkt.ci.main;

import com.jkt.ci.main.data.Basura_Inorganica;
import com.jkt.ci.main.data.Basura_Organica;
import com.jkt.ci.main.data.Presion;
import com.jkt.ci.main.data.Radiacion;
import com.jkt.ci.main.data.Temperatura;
import com.jkt.lib.driven.MongoHandler;
import java.net.UnknownHostException;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan Camilo Trillos
 * @author David Perez
 * @author Adrian del Pozo
 * @author David Rojas
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        UAOIoT device = new UAOIoT();

    }

    public void insert() {

        try {
            MongoHandler mongo = new MongoHandler("CInteligente");
            mongo.insert(new Basura_Organica(0, "Parque del Perro", new GregorianCalendar()));
            mongo.insert(new Basura_Inorganica(0, "Parque del Perro", new GregorianCalendar()));
            mongo.insert(new Presion(906, "Parque del Perro", new GregorianCalendar()));
            mongo.insert(new Temperatura(23, "Parque del Perro", new GregorianCalendar()));
            mongo.insert(new Radiacion(2, "Parque del Perro", new GregorianCalendar()));
        } catch (UnknownHostException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
