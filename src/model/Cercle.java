package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Cercle extends FigureGeom {
	
	private int rayon;
	
	public Cercle(PointFigure[] points, Color color, int nbPointSaisie) {
		super(points, color, nbPointSaisie);
	}

	@Override
	public boolean estSurLeContour(Point point) {
		for(PointFigure pointFigure1:getPoints()) {
			for(PointFigure pointFigure2: getPoints()) {
				if(pointFigure1.equals(pointFigure2)) {
					continue;
				}else {
					//calcule la distance entre le pointFigure1 et le pointFigure2
					 double distance1 = calculateDistanceBetweenPoints(pointFigure1.getX(),pointFigure1.getY(), pointFigure2.getX(), pointFigure2.getY());
					 
					 //calcule la distance entre le pointFigure1 et le point du click
					 double distance2 = calculateDistanceBetweenPoints(pointFigure1.getX(),pointFigure1.getY(), point.getX(),point.getY());
					 
					 //calcule la distance entre le pointFigure2 et le point du click
					 double distance3 = calculateDistanceBetweenPoints(pointFigure2.getX(),pointFigure2.getY(), point.getX(),point.getY());
					 
					 if(distance1 == distance2 + distance3) {
						 return true;
					 }
				}
			}
		}
		return false;
	}
	
	private double calculateDistanceBetweenPoints(double x1,double y1,double x2,double y2){
		return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
	}

	@SuppressWarnings("deprecation")
	@Override
	public void dessinerFigure(Graphics g) {
		PointFigure[] points = this.getPoints();
		Point centre = points[0];
		this.rayon = (int)this.calculateDistanceBetweenPoints(centre.getX(), centre.getY(), points[1].getX(), points[1].getY());
		if (this.getPlein()) {
			g.setColor(this.getCouleur());
			g.fillOval(centre.x-rayon, centre.y-rayon, rayon*2, rayon*2);
		}
		g.setColor(this.getCouleurContour());
		g.drawOval(centre.x-rayon, centre.y-rayon, rayon*2, rayon*2);

		setChanged();
		notifyObservers();
		
	}
}

