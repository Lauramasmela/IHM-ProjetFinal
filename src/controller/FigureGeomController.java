package controller;

import exception.FunctionalException;
import model.*;
import model.Rectangle;

import java.awt.*;

public class FigureGeomController {

    //y et x (point) sont les coordonnees de la souris au moment du clic
    public FigureGeom getSelectedByMouseCoordinates(Point pointClick, FigureGeom[] figureGeoms){

        FigureGeom resultat = null;

        for(FigureGeom figureGeom:figureGeoms){
            if(figureGeom.estSurLeContour(pointClick)){
                figureGeom.setSelected(true);
                resultat = figureGeom;
            }else {
                figureGeom.setSelected(false);
            }
        }
        return resultat;
    }

    public Triangle createTriangle(PointFigure[] points, Color color) throws FunctionalException{
        if(points.length == Triangle.getNbPointsSaisie() && points.length==countPointsSaisie(points)){
            return new Triangle(points,color);
        }else{
            throw new FunctionalException("Le nombre de points requis pour contruire un " + Triangle.class.getName() + " est de " + Triangle.getNbPointsSaisie()
            +"\\nTous les points doivent etre point de saisie dans un  "+Polygone.class.getName() + ".");
        }
    }

    public Rectangle createRectangle(PointFigure[] points, Color color) throws FunctionalException {
    	int compteur = countPointsSaisie(points);
        if(points.length == Rectangle.getNbPointsTotal() && Rectangle.getNbPointsSaisie()==compteur){
            return new Rectangle(points,color);
        }else{
            throw new FunctionalException("Le nombre de points requis pour contruire un " 
            		+ Rectangle.class.getName() + " est de " + Rectangle.getNbPointsTotal() + " dont "
            		+ Rectangle.getNbPointsSaisie()+" points de saisie");
        }
    }

    public Polygone createPolygone(PointFigure[] points, Color color) throws FunctionalException{
    	if(points.length==countPointsSaisie(points)) {
    		return new Polygone(points,color);
    		
    	}else {
    		throw new FunctionalException("Tous les points doivent être point de saisie dans un  "+Polygone.class.getName() + ".");
    	}
        
    }

	private int countPointsSaisie(PointFigure[] points) {
		int compteur = 0;
    	for(PointFigure pointFigure: points) {
    		if(pointFigure.isPointSaisie()) {
    			compteur++;
    		}
    	}
		return compteur;
	}
    
    public FigureGeom updateFigureGeom(FigureGeom figureGeom, PointFigure[] pointFigures) {
    	figureGeom.setPoints(pointFigures);
    	return figureGeom;
    }
    

    public Triangle deleteTriangle(Triangle triangle){
        triangle.setPoints(null);
        return triangle;
    }

    public Polygone deletePolygone(Polygone polygone){
        polygone.setPoints(null);
        return polygone;
    }

    public Rectangle deleteRectangle(Rectangle rectangle){
        rectangle.setPoints(null);
        return rectangle;
    }

}
