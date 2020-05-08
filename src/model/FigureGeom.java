package model;

import java.awt.Color;
import java.awt.Point;
import java.util.Observable;

@SuppressWarnings("deprecation")
public abstract class FigureGeom extends Observable {
	
	private Point[] tabPoints;
	private int nbPoints;
	private Color couleur;
	private boolean selectionne;
	public static final int MAXPOINTS=4;
	
	public FigureGeom() {
		this.couleur = null;
		this.selectionne = true;
		this.tabPoints = new Point[MAXPOINTS];
	}
	
	//dessiner (normalement dans paintComponent) la forme de fgure adequate
	public abstract void dessinerFigure();	
	public abstract void SelectionnerFigure();
	public abstract void changerCouleur();
	public abstract void translaterFigure();
	public abstract void modifierForme();
	
	public Point[] getTabPoints() {
		return tabPoints;
	}
	public void setTabPoints(Point[] tabPoint) {
		this.tabPoints = tabPoint;
		setChanged();
		notifyObservers();
	}
	public int getNbPoints() {
		return nbPoints;
	}
	public void setNbPoints(int nbPoints) {
		this.nbPoints = nbPoints;
	}
	public Color getCouleur() {
		return couleur;
	}
	public void setCouleur(Color couleur) {
		this.couleur = couleur;
		setChanged();
		notifyObservers();
	}
	public boolean isSelectionne() {
		return selectionne;
	}
	public void setSelectionne(boolean selectionne) {
		this.selectionne = selectionne;
		setChanged();
		notifyObservers();
	};
	
}
