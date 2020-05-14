package com.as.ihmprj.model;

import com.as.ihmprj.view.VueEcranDessin;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Classe abstraite FigureGeom: modele principal 
 * 
 * @author asjoscht
 * @author lsmasmelacastano
 *  
 */

public abstract class FigureGeom{
	/*Attributs*/
	protected int nbPointsFigure;
	protected int nbPointSaisie;
	private PointFigure[] points;
	private Color couleur;
	private boolean selected = false;
	protected boolean plein;
	private final List<VueEcranDessin> observers = new ArrayList<>();

	/*Constructeur de FigureGeom
	 * @param PointFigure[] point : correspondant aux points memoire de la figure
	 * @param Color color
	 * @param int nbPointSaisie
	 * */	
	public FigureGeom(PointFigure[] points, Color color, int nbPointSaisie) {
		this.points = points;
		this.couleur = color;
		this.nbPointSaisie = nbPointSaisie;
		notifyAllObservers();
	}
	
	public abstract boolean estSurLeContour(Point point);
	public abstract double calculateDistanceBetweenPoints(double x1, double y1, double x2, double y2);
	
	
	public void attach(VueEcranDessin observer){
        observers.add(observer);
        notifyAllObservers();
    }
	
	public void notifyAllObservers(){
        for (VueEcranDessin observer : observers) {
            observer.update();
        }
    }

	public PointFigure[] getPoints() {
		return points;
	}
	
	public void setPoint(PointFigure pt, int pos) {
		this.points[pos] = pt;
		notifyAllObservers();
	}

	public void setPoints(PointFigure[] points) {
		this.points = points;
		notifyAllObservers();
	}

	public int getNbPointSaisie() {
		return nbPointSaisie;
	}

	/*Quoiqu'il soit la valeur de la methode isSelected(), celle-ci va retourner la valeur contraire*/
	public void invertSelected(){
		this.selected = !this.selected;
		notifyAllObservers();
	}

	/*getteur de isSelected*/
	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
		notifyAllObservers();
	}

	public void setCouleur(Color newColor){
		this.couleur = newColor;
		notifyAllObservers();
	}

	public Color getCouleur(){
		return this.couleur; 
	}
	
	
	public boolean getPlein() {
		return this.plein;
	}
	
	public void setPlein(boolean p) {
		this.plein=p;
		notifyAllObservers();
	}
	
	public void invertPlein() {
		this.plein=!this.plein;
		notifyAllObservers();
	}
}
