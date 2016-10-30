package com.jkt.ci.main.data;

import com.mongodb.BasicDBObject;
import java.util.HashSet;
import java.util.Set;

/**
 * CLASE Device - hace referencia a los sensores que capturan un dato del entorno
 * 
 * @author olarguz
 * @author juan.trillos
 */
public class Device extends BasicDBObject
{
    public static final String DATO = "dato";

    private boolean partial;
    
    public Device ()
    {
        partial = false;
    }
    
    
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public Device (int dato)
    {
        this.put(Device.DATO, dato);
        
        this.markAsPartialObject();
    }
    
    @Override
    public void markAsPartialObject() {
        Set<String> set = keySet();
        set.remove("_id");
        
        Set<String> setThis = new HashSet<>();
        setThis.add(DATO);
        
        partial =  !set.equals(setThis);
    }
    
    public String getNombre ()
    {
        return this.getString(Device.DATO);
    }
    
    @Override
    public boolean isPartialObject() {
        return partial;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 53 * hash + (this.partial ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Device other = (Device) obj;
        boolean cn = getNombre().equals(other.getNombre());
        return cn;
    }
    
}
