package model;

import java.awt.*;
import java.util.Observable;

@SuppressWarnings("deprecation")
public abstract class FigureGeom extends Observable{
	/*Attributs*/
	protected int nbPointsFigure;
	protected int nbPointSaisie;
	private PointFigure[] points;
	private Color color;
	private boolean selected = false;
	protected boolean plein;

	/*Constructeur de FigureGeom
	 * @param PointFigure[] point : correspondant aux points memoire de la figure
	 * @param Color color
	 * @param int nbPointSaisie
	 * */	
	public FigureGeom(PointFigure[] points, Color color, int nbPointSaisie) {
		this.points = points;
		this.color = color;
		this.nbPointSaisie = nbPointSaisie;
	}
	
	public abstract boolean estSurLeContour(Point point);
	public abstract void dessinerFigure(Graphics g);

	public PointFigure[] getPoints() {
		return points;
	}

	public void setPoints(PointFigure[] points) {
		this.points = points;
	}

	public int getNbPointSaisie() {
		return nbPointSaisie;
	}

	/*Quoiqu'il soit la valeur de la methode isSelected(), celle-ci va retourner la valeur contraire*/
	public void invertSelected(){
		this.selected = !this.selected;
	}

	/*geteur de isSelected*/
	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public void setColor(Color newColor){
		this.color = newColor;
	}

	public Color getColor(){
		return this.color;
	}
	
	public boolean getPlein() {
		return this.plein;
	}
	
	public void setPlein(boolean p) {
		this.plein=p;
	}
}
