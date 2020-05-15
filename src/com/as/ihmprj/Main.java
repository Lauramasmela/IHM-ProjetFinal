package com.as.ihmprj;

import com.as.ihmprj.model.FigureGeom;
import com.as.ihmprj.view.VueEcranDessin;
import com.as.ihmprj.controller.ControllerListeners;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.util.HashMap;

public class Main {


	public static void main(String[] args) {

		JFrame fenetre = new JFrame("Figures Geometriques");
		HashMap<String, FigureGeom> hm = new HashMap<String,FigureGeom>();
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		VueEcranDessin gv = new VueEcranDessin(hm);
		ControllerListeners c = new ControllerListeners(hm,gv);
		fenetre.setPreferredSize(new Dimension(VueEcranDessin.LARGEUR,VueEcranDessin.HAUTEUR+VueEcranDessin.HAUTEUR_BOUTONS*3)); 
		gv.setPreferredSize(new Dimension(VueEcranDessin.LARGEUR,VueEcranDessin.HAUTEUR));  
		Border bordure = BorderFactory.createLineBorder(Color .black, 1);
		gv.setBorder(bordure);


		JPanel menu = new JPanel();
		menu.setPreferredSize(new Dimension(VueEcranDessin.LARGEUR,VueEcranDessin.HAUTEUR_BOUTONS*2));
		Button bPolygone = new Button("Polygone");
		bPolygone.setPreferredSize(new Dimension(VueEcranDessin.LARGEUR_BOUTONS, VueEcranDessin.HAUTEUR_BOUTONS));
		bPolygone.addActionListener(c);
		Button bTriangle = new Button("Triangle");
		bTriangle.setPreferredSize(new Dimension(VueEcranDessin.LARGEUR_BOUTONS, VueEcranDessin.HAUTEUR_BOUTONS));
		bTriangle.addActionListener(c);
		Button bRectangle = new Button("Rectangle");  
		bRectangle.setPreferredSize(new Dimension(VueEcranDessin.LARGEUR_BOUTONS, VueEcranDessin.HAUTEUR_BOUTONS));
		bRectangle.addActionListener(c);
		Button bCercle = new Button("Cercle");
		bCercle.setPreferredSize(new Dimension(VueEcranDessin.LARGEUR_BOUTONS, VueEcranDessin.HAUTEUR_BOUTONS)); 
		bCercle.addActionListener(c);
		Button dupliquer = new Button("Dupliquer");
		dupliquer.setPreferredSize(new Dimension(VueEcranDessin.LARGEUR_BOUTONS, VueEcranDessin.HAUTEUR_BOUTONS)); 
		dupliquer.addActionListener(c);
		Button remplir = new Button("Remplir");
		remplir.setPreferredSize(new Dimension(VueEcranDessin.LARGEUR_BOUTONS, VueEcranDessin.HAUTEUR_BOUTONS)); 
		remplir.addActionListener(c);
		Button supprimer = new Button("Supprimer");
		supprimer.setPreferredSize(new Dimension(VueEcranDessin.LARGEUR_BOUTONS, VueEcranDessin.HAUTEUR_BOUTONS)); 
		supprimer.addActionListener(c);

		JMenuBar mb=new JMenuBar();  
		JMenu couleurs=new JMenu("Couleurs");  
		JMenuItem i1=new JMenuItem("rouge");  
		i1.addActionListener(c);
		JMenuItem i2=new JMenuItem("bleu"); 
		i2.addActionListener(c);
		JMenuItem i3=new JMenuItem("noir");
		i3.addActionListener(c); 
		JMenuItem i4=new JMenuItem("vert");  
		i4.addActionListener(c);
		JMenuItem i5=new JMenuItem("jaune"); 
		i5.addActionListener(c);
		couleurs.add(i1); couleurs.add(i2); couleurs.add(i3); couleurs.add(i4); couleurs.add(i5); 
		mb.add(couleurs);  

		menu.add(bPolygone);
		menu.add(bTriangle);
		menu.add(bRectangle);
		menu.add(bCercle);
		menu.add(mb);
		menu.add(dupliquer);
		menu.add(remplir);
		menu.add(supprimer);

		fenetre.setResizable(false);
		fenetre.getContentPane().add(gv, BorderLayout.SOUTH);
		fenetre.getContentPane().add(menu, BorderLayout.NORTH);
		fenetre.pack();
		fenetre.setVisible(true);

	}

}
