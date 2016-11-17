/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jkt.ci.main.data;

import com.mongodb.BasicDBObject;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Juan Camilo Trillos
 * @author David Perez
 * @author Adrian del Pozo
 * @author David Rojas
 */
public class Temperatura extends BasicDBObject {

    public static final String PARQUE = "parque";
    public static final String DATO = "dato";
    public static final String FECHA = "fecha";

    private boolean partial;

    public Temperatura() {
        partial = false;
    }

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public Temperatura(int dato, String parque, Calendar date) {
        String dateFormate = date.get(Calendar.DAY_OF_MONTH) + "/" + (1 + date.get(Calendar.MONTH)) + "/" + date.get(Calendar.YEAR);
        this.put(Temperatura.DATO, dato);
        this.put(Temperatura.PARQUE, parque);
        this.put(Temperatura.FECHA, dateFormate);

        this.markAsPartialObject();
    }

    @Override
    public void markAsPartialObject() {
        Set<String> set = keySet();
        set.remove("_id");

        Set<String> setThis = new HashSet<>();
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
