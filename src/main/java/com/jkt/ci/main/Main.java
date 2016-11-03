package com.jkt.ci.main;

//import com.oag.servicio.mongolib.driven.MongoHandler;
//import com.jkt.ci.main.data.Device;
import com.jkt.ci.main.data.Basura;
import com.jkt.ci.main.data.Presion;
import com.jkt.ci.main.data.Radiacion;
import com.jkt.ci.main.data.Temperatura;
import com.jkt.lib.driven.MongoHandler;
import java.net.UnknownHostException;
import java.util.LinkedList;

/**
 *
 * @author olarguz
 * @author juan.trillos
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//        UAOIoT device = new UAOIoT();

//        device.setActive(true);
        
//        dataBase();
    }

    //<editor-fold defaultstate="collapsed" desc="EJEMPLOS DE MANEJO DE MONGODB">
//        mongoHandler.insert( new Articulo("Bus", "MC-R45GF-AS45HN", 2001));
//        mongoHandler.insert( new Persona("Jessica Robayo", 19, "Ing. Mecatronica", "2130520"));
//        mongoHandler.insert( new Persona("Daniel Zamora", 19, "Ing. Multimedia", "2130400"));
//        mongoHandler.insert( new Personaje("A4","Avatar2","Stand",new Vector(-1.5,10,0), new Vector(1, 0, 0)));
//        mongoHandler.insert( new Pregunta("Facil","Cuantos  ......."));
//        CriterioActualizacion criterioActualizacion = new CriterioActualizacion();
//        criterioActualizacion.setCriterio(Persona.IDENTIFICACION, "888181818");
//        criterioActualizacion.setNuevoValor(Persona.EDAD, 44);
//        mongoHandler.update( Persona.class, criterioActualizacion);
//        BufferedImage img = new BufferedImage(300, 50, BufferedImage.TYPE_INT_ARGB);
//        Imagen imagenA = new Imagen("cuadro.png", "PNG", img);
//        mongoHandler.insert( imagenA);
//        LinkedList<Persona> personas = (LinkedList<Persona>) mongoHandler.findAll(Persona.class);
//        LinkedList<Articulo> articulos = (LinkedList<Articulo>) mongoHandler.findAll(Articulo.class);
//        LinkedList<Personaje> personajes =(LinkedList<Personaje>) mongoHandler.findAll(Personaje.class);
//        LinkedList<Imagen> imagenes = (LinkedList<Imagen>) mongoHandler.findAll(Imagen.class);
//
//        personas.stream().forEach((persona) ->
//        {
//            System.out.println(persona.toString());
//        });
//        articulos.stream().forEach((articulo) ->
//        {
//            System.out.println(articulo.toString());
//        });
//        personajes.stream().forEach((personaje) ->
//        {
//            System.out.println(personaje.toString());
//        });
//        imagenes.stream().forEach((imagen) ->
//        {
//            BufferedImage bi = imagen.getImage();
//            System.out.println(imagen.getNombre() + " " + imagen.getTipo() + " " + bi.getWidth() + "x" + bi.getHeight() + "px");
//        });
//        System.out.println("---- Busqueda por nombre ----");
//        LinkedList<Persona> personasNombre =(LinkedList<Persona>) mongoHandler.find(Persona.class, "nombre", "Jessica Robayo");//"nombre", "Olmedo");
//        personasNombre.stream().forEach((persona) ->
//        {
//            System.out.println(persona.toString());
//        });
//        System.out.println("---- Busqueda por id ----");
//        LinkedList<Persona> personasId =(LinkedList<Persona>) mongoHandler.find(Persona.class, "_id", "51ffff86e05b4f6e2807474f");//"nombre", "Olmedo");
//        personasId.stream().forEach((persona) ->
//        {
//            System.out.println(persona.toString());
//        });
//        System.out.println("---- Busqueda por rango de edad ----");
//        LinkedList<Persona> personasConSeleccion =(LinkedList<Persona>) mongoHandler.find(Persona.class, "edad", 10, 20);
//        personasConSeleccion.stream().forEach((persona) ->
//        {
//            System.out.println(persona.toString());
//        });
//</editor-fold>
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
}
