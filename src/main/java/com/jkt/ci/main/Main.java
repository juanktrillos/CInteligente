package com.jkt.ci.main;

import com.jkt.ci.main.data.Basura;
import com.jkt.ci.main.data.Presion;
import com.jkt.ci.main.data.Radiacion;
import com.jkt.ci.main.data.Temperatura;
import com.jkt.lib.driven.MongoHandler;
import java.net.UnknownHostException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juan.trillos
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//            UAOIoT device = new UAOIoT();
//        device.setActive(true);
//        dataBase();
/* try {
String park = "Parque Jardin";
Calendar date = new GregorianCalendar();
MongoHandler mongoHandler = new MongoHandler("CInteligente");
mongoHandler.insert(new Temperatura(26, park, date));
mongoHandler.insert(new Presion(0, park, date));
mongoHandler.insert(new Basura(0, park, date));
mongoHandler.insert(new Radiacion(20, park, date));
} catch (UnknownHostException ex) {
Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
}*/
    }

    //<editor-fold defaultstate="collapsed" desc="Show DBs Data">
    private static void dataBase() {
        try {
            MongoHandler mongoHandler = new MongoHandler("CInteligente");
            LinkedList<Temperatura> temperatura = (LinkedList<Temperatura>) mongoHandler.findAll(Temperatura.class);
            LinkedList<Presion> presion = (LinkedList<Presion>) mongoHandler.findAll(Presion.class);
            LinkedList<Basura> basura = (LinkedList<Basura>) mongoHandler.findAll(Basura.class);
            LinkedList<Radiacion> radiacion = (LinkedList<Radiacion>) mongoHandler.findAll(Radiacion.class);

            for (Temperatura temp : temperatura) {
                System.out.print("Temperatura:       ");
                System.out.println(temp.get("dato"));
            }

            for (Radiacion rad : radiacion) {
                System.out.print("Radiacion:       ");
                System.out.println(rad.get("dato"));
            }

            for (Presion pres : presion) {
                System.out.print("Presion:       ");
                System.out.println(pres.get("dato"));
            }

            for (Basura basu : basura) {
                System.out.print("Basura:       ");
                System.out.println(basu.get("dato"));
            }

        } catch (UnknownHostException ex) {
            System.out.println("no se conecto a DB");
        }
    }
//</editor-fold>
}
