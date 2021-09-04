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
    
     public static CSG extrude(){
        
      // return Extrude.points(Vector3d.Z_ONE, new Vector3d[]{  Vector3d.xyz(  0.5, 0,0), Vector3d.xyz( 1, 1,0), Vector3d.xyz( 0.5,.5,0) , Vector3d.xyz(0.3,.3,0)});
        
       Polygon p1=Polygon.fromPoints(toCCW((Arrays.asList(new Vector3d[]{  Vector3d.xyz(  0.5, 0,0), Vector3d.xyz( 1, 1,0), Vector3d.xyz( 0.5,.5,0) , Vector3d.xyz(0.3,.3,0)}))));
      
       Polygon p2=Polygon.fromPoints(toCCW((Arrays.asList(new Vector3d[]{  Vector3d.xyz(  0.1, 0,3), Vector3d.xyz( .7, .7,3),Vector3d.xyz( 1, 1,2)  , Vector3d.xyz(0.3,.3,2)}))));
      
       return Extrude.combine(p1,p2 );

    }
    

    public static void main(String... args) {
        try {
            CSG cube = new Cube(2).toCSG();
            CSG sphere = new Sphere(1.25).toCSG();
            cube=cube.difference(sphere);
            cube.toObj().toFiles(Paths.get("SampleTG.obj"));
            
            //Extrude Example
             CSG extrude=extrude();
            extrude.toObj().toFiles(Paths.get("SampleExtrudeTG.obj"));
            
        } catch (IOException ex) {
            Logger.getLogger(Simple3D.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
