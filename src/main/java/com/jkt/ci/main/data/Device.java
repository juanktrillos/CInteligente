package com.jkt.ci.main.data;

import com.mongodb.BasicDBObject;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * CLASE Device - hace referencia a los sensores que capturan un dato del
 * entorno
 *
 * @author olarguz
 * @author juan.trillos
 */
public class Device extends BasicDBObject {

    public static final String SENSOR = "sensor";
    public static final String PARQUE = "parque";
    public static final String DATO = "dato";
    public static final String FECHA = "fecha";

    private boolean partial;

    public Device() {
        partial = false;
    }

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public Device(int dato, String parque, String sensor, Date date) {
        String dateFormate = date.getDay() + "/" + date.getMonth() + "/" + date.getYear();
        this.put(Device.DATO, dato);
        this.put(Device.SENSOR, sensor);
        this.put(Device.PARQUE, parque);
        this.put(Device.FECHA, dateFormate);

        this.markAsPartialObject();
    }

    @Override
    public void markAsPartialObject() {
        Set<String> set = keySet();
        set.remove("_id");

        Set<String> setThis = new HashSet<>();
        setThis.add(SENSOR);
        setThis.add(DATO);
        setThis.add(PARQUE);
        setThis.add(FECHA);

        partial = !set.equals(setThis);
    }

    @Override
    public boolean isPartialObject() {
        return partial;
    }
}
