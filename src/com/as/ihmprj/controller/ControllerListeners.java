package com.as.ihmprj.controller;

import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Map;
import java.util.UUID;
import javax.swing.JMenuItem;
import com.as.ihmprj.exception.FunctionalException;
import com.as.ihmprj.model.Cercle;
import com.as.ihmprj.model.FigureGeom;
import com.as.ihmprj.model.PointFigure;
import com.as.ihmprj.model.Polygone;
import com.as.ihmprj.model.Rectangle;
import com.as.ihmprj.model.Triangle;
import com.as.ihmprj.view.VueEcranDessin;


/**
 * 
 * Classe ControllerListener: modelise le controller des boutons et de la souris / interaction entre utilisateur et affichage
 * 
 * @author asjoscht
 * @author lsmasmelacastano
 *  
 */

public class ControllerListeners implements MouseListener, MouseMotionListener, ActionListener  {
	
	private Map<String,FigureGeom> figures;
	FigureGeomController figureGeomController = new FigureGeomController();
	private int x, y, xprec, yprec; 
	private  PointFigure pclic;
	private  PointFigure pdrag;
	VueEcranDessin vue;

	public ControllerListeners(Map<String,FigureGeom> lf,VueEcranDessin v) {
		this.figures= lf;
		vue=v;
		v.addMouseListener(this);
		v.addMouseMotionListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof Button) {
			String label = ((Button) e.getSource()).getLabel();
			switch(label){
				case "Triangle": try {
					Triangle triangle = figureGeomController.createTriangle(figureGeomController.getPointsTriangleParDefaut(), Color.green);
					figures.put(UUID.randomUUID().toString(),triangle);
					triangle.attach(vue);
				} catch (FunctionalException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}break;
				case "Polygone": try {
					Polygone polygone = figureGeomController.createPolygone(figureGeomController.getPointsPolygoneParDefaut(), Color.red);
					figures.put(UUID.randomUUID().toString(),polygone);
					polygone.attach(vue);
				} catch (FunctionalException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}break;
				case "Rectangle": try {
					Rectangle rectangle = figureGeomController.createRectangle(figureGeomController.getPointsRectangleParDefaut(), Color.blue);
					figures.put(UUID.randomUUID().toString(),rectangle);
					rectangle.attach(vue);
				} catch (FunctionalException e1) {
					e1.printStackTrace();
				}break;
				case "Cercle": try {
					Cercle cercle = figureGeomController.createCercle(figureGeomController.getPointsCercleParDefaut(), Color.blue);
					figures.put(UUID.randomUUID().toString(),cercle);
					cercle.attach(vue);
				} catch (FunctionalException e1) {
					e1.printStackTrace();
				}break;
				case "Dupliquer": try {
					FigureGeom pduplic = null;
					for(FigureGeom figureGeom: figures.values()) {
						if(figureGeom.isSelected()) {
							if(figureGeom instanceof Triangle) {
								PointFigure pfduplic[] = figureGeomController.dupliquerTriangle(figureGeom);
								 pduplic = figureGeomController.createTriangle(pfduplic, figureGeom.getCouleur());
							}
							else if(figureGeom instanceof Cercle) {
								PointFigure pfduplic[] = figureGeomController.dupliquerCercle(figureGeom);
								 pduplic = figureGeomController.createCercle(pfduplic, figureGeom.getCouleur());
							}
							else if(figureGeom instanceof Rectangle) {
								PointFigure pfduplic[] = figureGeomController.dupliquerRectangle(figureGeom);
								 pduplic = figureGeomController.createRectangle(pfduplic, figureGeom.getCouleur());
							}
							else if(figureGeom instanceof Polygone) {
								PointFigure pfduplic[] = figureGeomController.dupliquerPolygone(figureGeom);
								 pduplic = figureGeomController.createPolygone(pfduplic, figureGeom.getCouleur());	
							}
						}
						else {
							break;
						}
					}
					if(pduplic!=null) {
						figures.put(UUID.randomUUID().toString(),pduplic);
						pduplic.attach(vue);
								
					}
					vue.update();
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}break;
				case "Remplir": try {
					for(FigureGeom figureGeom: figures.values()) {
						if(figureGeom.isSelected()) {
							figureGeom.invertPlein();
						}
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}break;
				case "Supprimer": try {
					for(FigureGeom figureGeom: figures.values()) {
						if(figureGeom.isSelected()) {
							figureGeom=figureGeomController.deleteFigureGeom(figureGeom);
							vue.update();
						}
					}
				}catch (Exception e1) {
					e1.printStackTrace();
				}break;
				default:break;
			}
		}
		if(e.getSource() instanceof JMenuItem) {
			@SuppressWarnings("deprecation")
			String labelCouleurs = ((JMenuItem) e.getSource()).getLabel();
			switch(labelCouleurs){
				case "rouge": try {
					for(FigureGeom figureGeom: figures.values()) {
						if(figureGeom.isSelected()) {
							figureGeom.setCouleur(Color .red);
						}
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}break;
				case "bleu": try {
					for(FigureGeom figureGeom: figures.values()) {
						if(figureGeom.isSelected()) {
							figureGeom.setCouleur(Color .blue);
						}
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}break;
				case "noir": try {
					for(FigureGeom figureGeom: figures.values()) {
						if(figureGeom.isSelected()) {
							figureGeom.setCouleur(Color .black);
						}
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}break;
				case "vert": try {
					for(FigureGeom figureGeom: figures.values()) {
						if(figureGeom.isSelected()) {
							figureGeom.setCouleur(Color .green);
						}
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}break;
				case "jaune": try {
					for(FigureGeom figureGeom: figures.values()) {
						if(figureGeom.isSelected()) {
							figureGeom.setCouleur(Color .yellow);
						}
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}break;
				default:break;
			}
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		Point clic = new Point(e.getX(), e.getY());
		figureGeomController.getSelectedByMouseCoordinates(clic, figures);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		xprec = e.getX();
    	yprec = e.getY();
    	pclic = new PointFigure(xprec,yprec,true);
    	vue.requestFocus();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Graphics g = vue.getGraphics();
    	x = e.getX();
        y = e.getY();
      	pdrag= new PointFigure(x,y,true);
      	
        for(FigureGeom figureGeom: figures.values()) {
    		PointFigure pprec[] = figureGeom.getPoints();
        	if(figureGeom.getPoints()!=null) {
	        	for(int i=0; i<pprec.length; i++) {
		        	if(pprec[i].equals(pclic)) {
		        		figureGeom.isSelected();
		        		double diffX = pclic.getX() - pdrag.getX();	
	        			double diffY = pclic.getY() - pdrag.getY();
		        		if(figureGeom instanceof Rectangle) {
		        			g.setColor(figureGeom.getCouleur());	 
		        			
		        			if(i==0) {
		        				double x3=figureGeom.getPoints()[3].getX()-(diffX);
		        				double y3=figureGeom.getPoints()[3].getY()-(diffY);
		        				PointFigure temp3 = new PointFigure((int)x3,(int)y3, true);
		        				figureGeom.setPoint(temp3, 3);
		        			}
		        			if(i==2) {
		        				double x=figureGeom.getPoints()[3].getX()-(diffX);
		        				double y=figureGeom.getPoints()[3].getY()-(diffY);
		        				PointFigure temp = new PointFigure((int)x,(int)y, false);
		        				figureGeom.setPoint(temp, 3);
		        			}
		        			figureGeom.setPoint(pdrag, i);
		        		}
		        		else if(figureGeom instanceof Cercle) {
		        			if(i==0) {
		        				double x3=figureGeom.getPoints()[1].getX()-(diffX);
		        				double y3=figureGeom.getPoints()[1].getY()-(diffY);
		        				PointFigure temp3 = new PointFigure((int)x3,(int)y3, true);
		        				figureGeom.setPoint(temp3, 1);
		        			}
		        			if(i==1) {
		        				figureGeom.setPoint(pdrag, 1);
		        				//((Cercle)figureGeom).setRayon((int)figureGeom.calculateDistanceBetweenPoints(figureGeom.getPoints()[0].getX(),figureGeom.getPoints()[0].getY(),pdrag.getX(), pdrag.getY()));
		        			}
		        			figureGeom.setPoint(pdrag, i);
		        		}
		        		else {
		        			g.setColor(figureGeom.getCouleur());
			        		figureGeom.setPoint(pdrag, i);	
		        		}			
		        	}
				}
        	}
        }
        vue.update();
	}

	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mouseDragged(MouseEvent e) {}
	@Override
	public void mouseMoved(MouseEvent e) {}

}
