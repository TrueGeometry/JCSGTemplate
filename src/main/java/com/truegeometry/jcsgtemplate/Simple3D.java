/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.truegeometry.jcsgtemplate;

import eu.mihosoft.jcsg.CSG;
import eu.mihosoft.jcsg.Cube;
import eu.mihosoft.jcsg.Sphere;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * http://www.truegeometry.com
 * @author ryzen
 */
public class Simple3D {

    public static void main(String... args) {
        try {
            CSG cube = new Cube(2).toCSG();
            CSG sphere = new Sphere(1.25).toCSG();
            cube.difference(sphere);
            cube.toObj().toFiles(Paths.get("SampleTG.obj"));
        } catch (IOException ex) {
            Logger.getLogger(Simple3D.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
