package com.as.ihmprj.controller;

import com.as.ihmprj.exception.FunctionalException;
import com.as.ihmprj.model.*;
import com.as.ihmprj.model.Rectangle;
import java.awt.*;
import java.util.Map;

/**
 * 
 * Classe FigureGeomController: controller qui cree, supprime, duplique, selectionne les figures
 * 
 * @author asjoscht
 * @author lsmasmelacastano
 *  
 */

public class FigureGeomController {

	private static final int DEPLACEMENT= 20;


	//pointClick = coordonnees du point quand on clique
	public void getSelectedByMouseCoordinates(Point pointClick, Map<String,FigureGeom> figureGeoms){
		for(FigureGeom figureGeom:figureGeoms.values()){ 
			if(figureGeom.estSurLeContour(pointClick)){
				figureGeom.setSelected(true);
			}else {
				figureGeom.setSelected(false);
			}
		}
	}

	public Triangle createTriangle(PointFigure[] points, Color color) throws FunctionalException{
		if(points.length == Triangle.getNbPointsSaisie() && points.length==countPointsSaisie(points)){
			return new Triangle(points,color);
		}else{
			throw new FunctionalException("Le nombre de points requis pour contruire un " + Triangle.class.getName() + " est de " + Triangle.getNbPointsSaisie()
			+"\\nTous les points doivent etre point de saisie dans un  "+ Triangle.class.getName() + ".");
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
			throw new FunctionalException("Tous les points doivent etre point de saisie dans un  "+Polygone.class.getName() + ".");
		}

	}

	public Cercle createCercle(PointFigure[] points, Color color) throws FunctionalException {
		if(points.length==countPointsSaisie(points)) {
			return new Cercle(points,color);

		}else {
			throw new FunctionalException("Tous les points doivent etre point de saisie dans un  "+Cercle.class.getName() + ".");
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



	public FigureGeom deleteFigureGeom(FigureGeom f){
		f.setPoints(null);
		return f;
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

	public Cercle deleteCercle(Cercle cercle){
		cercle.setPoints(null);
		return cercle;
	}



	public PointFigure[] getPointsTriangleParDefaut() {
		PointFigure p1 = new PointFigure(20, 20, true);
		PointFigure p2 = new PointFigure(150, 300, true);
		PointFigure p3 = new PointFigure(400, 50, true);
		return  new PointFigure[]{p1, p2, p3};
	}

	public PointFigure[] getPointsPolygoneParDefaut() {
		PointFigure p1 = new PointFigure(40, 40, true);
		PointFigure p2 = new PointFigure(200, 300, true);
		PointFigure p3 = new PointFigure(400, 000, true);
		PointFigure p4 = new PointFigure(500, 100, true);
		PointFigure p5 = new PointFigure(600, 100, true);
		return  new PointFigure[]{p1, p2, p3, p4, p5};
	}

	public PointFigure[] getPointsRectangleParDefaut() {
		PointFigure p1 = new PointFigure(100, 150, true);
		PointFigure p2 = new PointFigure(300, 150, false);
		PointFigure p3 = new PointFigure(300, 200, true);
		PointFigure p4 = new PointFigure(100, 200, false);
		return  new PointFigure[]{p1, p2, p3, p4};
	}

	public PointFigure[] getPointsCercleParDefaut() {
		PointFigure p1 = new PointFigure(200, 200, true);
		PointFigure p2 = new PointFigure(200+200, 200, true);
		return  new PointFigure[]{p1, p2};
	}

	public PointFigure[] dupliquerTriangle(FigureGeom figureGeom) {
		PointFigure[] pfduplic = new PointFigure[3];
		if(figureGeom.getPoints()!=null) {
			int pfx1=(int)figureGeom.getPoints()[0].getX()+DEPLACEMENT;
			int pfx2=(int)figureGeom.getPoints()[1].getX()+DEPLACEMENT;
			int pfx3=(int)figureGeom.getPoints()[2].getX()+DEPLACEMENT;
			int pfy1=(int)figureGeom.getPoints()[0].getY()+DEPLACEMENT;
			int pfy2=(int)figureGeom.getPoints()[1].getY()+DEPLACEMENT;
			int pfy3=(int)figureGeom.getPoints()[2].getY()+DEPLACEMENT;
			PointFigure pf1 = new PointFigure(pfx1, pfy1, true);
			PointFigure pf2 = new PointFigure(pfx2, pfy2, true);
			PointFigure pf3 = new PointFigure(pfx3, pfy3, true);
			pfduplic[0]=pf1;
			pfduplic[1]=pf2;
			pfduplic[2]=pf3;
		}
		return pfduplic;
	}

	public PointFigure[] dupliquerCercle(FigureGeom figureGeom) {
		PointFigure[] pfduplic = new PointFigure[2];
		if(figureGeom.getPoints()!=null) {
			int pfx1=(int)figureGeom.getPoints()[0].getX()+DEPLACEMENT;
			int pfx2=(int)figureGeom.getPoints()[1].getX()+DEPLACEMENT;
			int pfy1=(int)figureGeom.getPoints()[0].getY()+DEPLACEMENT;
			int pfy2=(int)figureGeom.getPoints()[1].getY()+DEPLACEMENT;
			PointFigure pf1 = new PointFigure(pfx1, pfy1, true);
			PointFigure pf2 = new PointFigure(pfx2, pfy2, true);
			pfduplic[0]=pf1;
			pfduplic[1]=pf2;
		}
		return pfduplic;

	}

	public PointFigure[] dupliquerRectangle(FigureGeom figureGeom) {
		PointFigure[] pfduplic = new PointFigure[4];
		if(figureGeom.getPoints()!=null) {
			int pfx1=(int)figureGeom.getPoints()[0].getX()+DEPLACEMENT;
			int pfx2=(int)figureGeom.getPoints()[1].getX()+DEPLACEMENT;
			int pfx3=(int)figureGeom.getPoints()[2].getX()+DEPLACEMENT;
			int pfx4=(int)figureGeom.getPoints()[3].getX()+DEPLACEMENT;
			int pfy1=(int)figureGeom.getPoints()[0].getY()+DEPLACEMENT;
			int pfy2=(int)figureGeom.getPoints()[1].getY()+DEPLACEMENT;
			int pfy3=(int)figureGeom.getPoints()[2].getY()+DEPLACEMENT;
			int pfy4=(int)figureGeom.getPoints()[3].getY()+DEPLACEMENT;
			PointFigure pf1 = new PointFigure(pfx1, pfy1, true);
			PointFigure pf2 = new PointFigure(pfx2, pfy2, false);
			PointFigure pf3 = new PointFigure(pfx3, pfy3, true);
			PointFigure pf4 = new PointFigure(pfx4, pfy4, false);
			pfduplic[0]=pf1;
			pfduplic[1]=pf2;
			pfduplic[2]=pf3;
			pfduplic[3]=pf4;
		}
		return pfduplic;
	}

	public PointFigure[] dupliquerPolygone(FigureGeom figureGeom) {
		PointFigure[] pfduplic = new PointFigure[5];
		if(figureGeom.getPoints()!=null) {
			int pfx1=(int)figureGeom.getPoints()[0].getX()+DEPLACEMENT;
			int pfx2=(int)figureGeom.getPoints()[1].getX()+DEPLACEMENT;
			int pfx3=(int)figureGeom.getPoints()[2].getX()+DEPLACEMENT;
			int pfx4=(int)figureGeom.getPoints()[3].getX()+DEPLACEMENT;
			int pfx5=(int)figureGeom.getPoints()[4].getX()+DEPLACEMENT;
			int pfy1=(int)figureGeom.getPoints()[0].getY()+DEPLACEMENT;
			int pfy2=(int)figureGeom.getPoints()[1].getY()+DEPLACEMENT;
			int pfy3=(int)figureGeom.getPoints()[2].getY()+DEPLACEMENT;
			int pfy4=(int)figureGeom.getPoints()[3].getY()+DEPLACEMENT;
			int pfy5=(int)figureGeom.getPoints()[4].getY()+DEPLACEMENT;
			PointFigure pf1 = new PointFigure(pfx1, pfy1, true);
			PointFigure pf2 = new PointFigure(pfx2, pfy2, true);
			PointFigure pf3 = new PointFigure(pfx3, pfy3, true);
			PointFigure pf4 = new PointFigure(pfx4, pfy4, true);
			PointFigure pf5 = new PointFigure(pfx5, pfy5, true);
			pfduplic[0]=pf1;
			pfduplic[1]=pf2;
			pfduplic[2]=pf3;
			pfduplic[3]=pf4;
			pfduplic[4]=pf5;
		}
		return pfduplic;
	}

}
