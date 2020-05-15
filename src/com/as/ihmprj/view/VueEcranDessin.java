package com.as.ihmprj.view;

import com.as.ihmprj.controller.FigureGeomController;
import com.as.ihmprj.model.*;
import com.as.ihmprj.model.Rectangle;
import javax.swing.*;
import java.awt.*;
import java.util.Map;

/**
 * 
 * Classe VueEcranDessin: la vue responsable de l'affichage des differentes figures
 * 
 * @author asjoscht
 * @author lsmasmelacastano
 *  
 */

@SuppressWarnings("serial")
public class VueEcranDessin extends JPanel {

	public static final int LARGEUR = 900;
	public static final int HAUTEUR = 550;
	public static final int LARGEUR_BOUTONS = 100;
	public static final int HAUTEUR_BOUTONS = LARGEUR_BOUTONS/2;
	public static final int TAILLE_CARRES = 10;


	private Map<String,FigureGeom> figures;
	FigureGeomController figureGeomController = new FigureGeomController();

	public VueEcranDessin(Map<String,FigureGeom> lf) {
		this.figures= lf;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(FigureGeom figureGeom: figures.values()) {
			((Graphics2D)g).setStroke(new BasicStroke(3));
			g.setColor(figureGeom.getCouleur());
			if(!(figureGeom==null) && figureGeom.getPoints()!=null) {
				//pour tous les polygones
				if(!(figureGeom instanceof Cercle)) {
					int compteur = 0;
					int[] x = new int[figureGeom.getPoints().length];
					int[] y = new int[figureGeom.getPoints().length];
					for(PointFigure pf: figureGeom.getPoints()) {
						x[compteur]=pf.x;
						y[compteur]=pf.y;
						compteur++;
					}
					Polygon p = new Polygon(x, y, x.length);
					g.drawPolygon(p);
					if(figureGeom.getPlein()) {
						g.fillPolygon(p);
					}

					//pour rectangles, points carres coin sup gauche et coin inf droit
					if(figureGeom instanceof Rectangle) {
						g.setColor(Color.black);
						g.drawRect((int)figureGeom.getPoints()[0].getX()-TAILLE_CARRES/2, (int)figureGeom.getPoints()[0].getY()-TAILLE_CARRES/2, TAILLE_CARRES, TAILLE_CARRES);
						g.drawRect((int)figureGeom.getPoints()[2].getX()-TAILLE_CARRES/2, (int)figureGeom.getPoints()[2].getY()-TAILLE_CARRES/2, TAILLE_CARRES, TAILLE_CARRES);
					}
					//pour polygones et triangles, points carres partout
					else {
						for(PointFigure pf: figureGeom.getPoints()) { 
							g.setColor(Color.black);
							g.drawRect((int)pf.x-5, (int)pf.y-TAILLE_CARRES/2, TAILLE_CARRES, TAILLE_CARRES);
						}
					}
				}
				//pour les cercles
				else {
					Cercle cercle = (Cercle)figureGeom;
					int rayon = (int)cercle.calculateDistanceBetweenPoints(cercle.getPoints()[0].getX(),cercle.getPoints()[0].getY(), 
							cercle.getPoints()[1].getX(), cercle.getPoints()[1].getY());
					PointFigure centre = new PointFigure((int)cercle.getPoints()[0].getX(),  (int)cercle.getPoints()[0].getY(), false);
					g.drawOval((int)cercle.getPoints()[0].getX()-rayon,(int)cercle.getPoints()[0].getY()-rayon, rayon*2, rayon*2);

					if(figureGeom.getPlein()) {
						g.fillOval((int)cercle.getPoints()[0].getX()-rayon,(int)cercle.getPoints()[0].getY()-rayon, rayon*2, rayon*2);
					}

					//points carres au centre et a droite du cercle
					g.setColor(Color.black);
					g.drawRect((int)centre.getX()-5,  (int)centre.getY()-TAILLE_CARRES/2, TAILLE_CARRES, TAILLE_CARRES);
					g.drawRect((int)centre.getX()+rayon-5,  (int)centre.getY()-TAILLE_CARRES/2, TAILLE_CARRES, TAILLE_CARRES);
				}
			}
		}
	}

	public void update() {
		repaint();
	}
}

