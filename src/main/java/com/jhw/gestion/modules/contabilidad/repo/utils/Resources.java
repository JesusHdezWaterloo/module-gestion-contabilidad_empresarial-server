/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.contabilidad.repo.utils;

import com.jhw.mysql.services.MySQLHandler;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class Resources {

    public static EntityManagerFactory EMF;

    public static void initEMF() {
        try {
            EMF = Persistence.createEntityManagerFactory("ContabilidadPU", MySQLHandler.propertiesMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}