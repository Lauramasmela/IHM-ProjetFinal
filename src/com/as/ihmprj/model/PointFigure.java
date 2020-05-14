package com.as.ihmprj.model;

import java.awt.*;

/**
 * 
 * Classe PointFigure: modelise les points de saisie vs points de memorisation
 * 
 * @author asjoscht
 * @author lsmasmelacastano
 *  
 */

@SuppressWarnings("serial")
public class PointFigure extends Point {

	
	private boolean pointSaisie;
	private int taille=5;

    public PointFigure(int x, int y, boolean pointSaisie) {
        super(x, y);
        this.pointSaisie = pointSaisie;
    }

    public boolean isPointSaisie() { 
        return pointSaisie;
    }

    public void setPointSaisie(boolean pointSaisie) {
        this.pointSaisie = pointSaisie;
    }

    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PointFigure) {
        	boolean ok=false;
            PointFigure pf = (PointFigure)obj;
			if(x>pf.x-taille && x<pf.x+taille && y>pf.y-taille && y<pf.y+taille && (pointSaisie == pf.pointSaisie)){
				ok=true;
			}
            return ok;
        }
        return super.equals(obj);
    }
}
