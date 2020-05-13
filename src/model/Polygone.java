package model;
import java.awt.*;

public class Polygone extends FigureGeom {

	public Polygone(PointFigure[] points, Color color){
		super(points,color,points.length);
		nbPointsFigure = points.length;
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

	@Override
	public void dessinerFigure(Graphics g) {
		
		PointFigure[] points = this.getPoints();
		int[] pointX = new int[points.length];
		int[] pointY = new int[points.length];
		for (int i = 0; i < points.length; i++){
			pointX[i] = points[i].x;
			pointY[i] = points[i].y;
		}

		if (this.getPlein()){
			g.setColor(this.getCouleur());
			g.fillPolygon(pointX, pointY, points.length);
		}
		
		g.setColor(this.getCouleurContour());
		if (points.length > 2)
			g.drawPolygon(pointX, pointY, points.length);
		else
			g.drawPolyline(pointX, pointY, points.length);
		

		setChanged();
		notifyObservers();
		
	}
}
