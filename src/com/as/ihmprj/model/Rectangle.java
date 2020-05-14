package com.as.ihmprj.model;
import java.awt.*;

/**
 * 
 * Classe Rectangle: modelise un rectangle
 * 
 * @author asjoscht
 * @author lsmasmelacastano
 *  
 */

public class Rectangle extends Polygone {

	private static final int NB_POINTS_SAISIE=2;
	private static final int NB_POINTS_TOTAL=4;

	public Rectangle(PointFigure[] points, Color color) {
        super(points, color);
    }

	public static int getNbPointsSaisie() {
		return NB_POINTS_SAISIE;
	}
	
	public static int getNbPointsTotal() {
		return NB_POINTS_TOTAL;
	}
	
}
