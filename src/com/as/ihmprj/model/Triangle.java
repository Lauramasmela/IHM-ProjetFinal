package com.as.ihmprj.model;
import java.awt.*;

/**
 * 
 * Classe Triangle: modelise un triangle
 * 
 * @author asjoscht
 * @author lsmasmelacastano
 *  
 */

public class Triangle extends Polygone {

    private static final int NB_POINTS_SAISIE=3;

    public Triangle(PointFigure[] points, Color color) {
        super(points, color);
    }

    public static int getNbPointsSaisie() {
        return NB_POINTS_SAISIE;
    }
}
