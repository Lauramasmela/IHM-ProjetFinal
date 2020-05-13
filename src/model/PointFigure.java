package model;

import java.awt.*;

public class PointFigure extends Point {

	
	private boolean pointSaisie;

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
            PointFigure pf = (PointFigure)obj;
            return (x == pf.x) && (y == pf.y) && (pointSaisie == pf.pointSaisie);
        }
        return super.equals(obj);
    }
}
