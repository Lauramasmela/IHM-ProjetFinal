package view;

import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import model.FigureGeom;

@SuppressWarnings("deprecation")
public class VueEcranDessin extends JPanel implements Observer {
	private static final long serialVersionUID = 1L;
	
	public FigureGeom figure;

	@Override
	public void update(Observable o, Object arg) {
		figure = (FigureGeom)o;
		repaint();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		figure.dessinerFigure(g);
	}
}

