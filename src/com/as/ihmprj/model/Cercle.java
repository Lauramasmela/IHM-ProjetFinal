package com.as.ihmprj.model;

import java.awt.Color;
import java.awt.Point;

/**
 * 
 * Classe Cercle: modelise un cercle
 * 
 * @author asjoscht
 * @author lsmasmelacastano
 *  
 */

public class Cercle extends FigureGeom {
	
	private static final int NB_POINT_SAISIE=2;
	private int rayon; 
	
	public Cercle(PointFigure[] points, Color color) {
		super(points, color, NB_POINT_SAISIE);
	}

	@Override
	public boolean estSurLeContour(Point point) {
		if(getPoints()!=null) {
			this.getPoints();
			//calcule la distance entre le this.getPoints()[0] et le this.getPoints()[1]
			double distance1 = calculateDistanceBetweenPoints(this.getPoints()[0].getX(),this.getPoints()[0].getY(), this.getPoints()[1].getX(), this.getPoints()[1].getY());

			//calcule la distance entre le this.getPoints()[0] et le point du click
			double distance2 = calculateDistanceBetweenPoints(this.getPoints()[0].getX(),this.getPoints()[0].getY(), point.getX(),point.getY());

			if((distance1 < (distance2)+10) && (distance1 > (distance2)-10)) {
				return true;
			}
		}
		return false;
	}
	
	public double calculateDistanceBetweenPoints(double x1,double y1,double x2,double y2){
		return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
	}

	public double getRayon() {
		return rayon;
	}

	public void setRayon(int rayon) {
		this.rayon = rayon;
	}
	
}

