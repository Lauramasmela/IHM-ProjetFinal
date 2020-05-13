package test;

import java.awt.Color;
import java.awt.Point;

import org.junit.jupiter.api.Test;

import controller.FigureGeomController;
import exception.FunctionalException;
import model.*;


import org.junit.Assert;

class TestFigureGeomController {
	
	
	PointFigure pf1 = new PointFigure(2,3, true);	
	PointFigure pf3 = new PointFigure(4,9, true);
	PointFigure pf2 = new PointFigure(pf1.x,pf3.y, false);
	PointFigure pf4 = new PointFigure(pf1.y,pf2.x, false);
	
	PointFigure[] tabPointFigure = {pf1, pf2, pf3, pf4};
	
	FigureGeomController controller = new FigureGeomController();

	
	@Test 
	void testGetSelectedByMouseCoordinates_nOK() throws FunctionalException {
		Point click=new Point(10, 10);		
		Rectangle rect = controller.createRectangle(tabPointFigure, Color.black);
		FigureGeom[] tabFigureGeoms = {rect}; 		
		Assert.assertNull(controller.getSelectedByMouseCoordinates(click,tabFigureGeoms ));	
	}
	
	@Test 
	void testGetSelectedByMouseCoordinates_OK() throws FunctionalException {
		Point click=new Point(2, 6);		
		Rectangle rect = controller.createRectangle(tabPointFigure, Color.black);
		FigureGeom[] tabFigureGeoms = {rect}; 		
		Assert.assertNotNull(controller.getSelectedByMouseCoordinates(click,tabFigureGeoms ));	
	}
	

	@Test
	void testCreateTriangle_nOK() {
		PointFigure[] tabPointFigure = {pf1, pf2};
		assertThrows(FunctionalException.class, ()->controller.createTriangle(tabPointFigure, Color.black));
	}
	
	@Test
	void testCreateTriangle_nOK2() {
		PointFigure[] tabPointFigure = {pf1, pf2, pf3};
		assertThrows(FunctionalException.class, ()->controller.createTriangle(tabPointFigure, Color.black));
	}
	

	@Test
	void testCreateRectangle_nOK() {
		PointFigure[] tabPointFigure = {pf1, pf2, pf3};
		assertThrows(FunctionalException.class, ()->controller.createRectangle(tabPointFigure, Color.black));
	}

	@Test
	void testCreatePolygone_nOK() {
		PointFigure[] tabPointFigure = {pf1, pf2, pf3};
		assertThrows(FunctionalException.class, ()->controller.createPolygone(tabPointFigure, Color.black));
	}
	
	@Test
	void testCreatePolygone_OK() throws FunctionalException {
		PointFigure[] tabPointFigure = {pf1, pf3, pf1, pf3, pf1};
		assertNotNull(controller.createPolygone(tabPointFigure, Color.black));
	}

	@Test
	void testUpdateFigureGeom() throws FunctionalException {
		PointFigure[] tabPointFigure = {pf1, pf3, pf1};
		FigureGeom figureGeom = controller.createTriangle(tabPointFigure, Color.black);
		
		PointFigure[] tabPointFigureUpdate = {new PointFigure(1, 2, false), new PointFigure(1, 2, false),new PointFigure(1, 2, false)};
		controller.updateFigureGeom(figureGeom,tabPointFigure);
		Assert.assertEquals(figureGeom.getPoints()[0].x, 1);
		Assert.assertEquals(figureGeom.getPoints()[0].y, 2);
		Assert.assertTrue(figureGeom instanceof Triangle);
	}

	@Test
	void testDeleteTriangle_OK() throws FunctionalException {
		PointFigure[] tabPointFigure = {pf1, pf3, pf1};
		Triangle triangle = controller.createTriangle(tabPointFigure, Color.black);
		
		controller.deleteTriangle(triangle);
		assertNull(triangle.getPoints());
	}

	@Test
	void testDeletePolygone_OK() throws FunctionalException {
		PointFigure[] tabPointFigure = {pf1, pf3, pf1, pf3, pf3};
		Polygone polygone = controller.createPolygone(tabPointFigure, Color.black);
		
		controller.deletePolygone(polygone);
		assertNull(polygone.getPoints());
	}

	@Test
	void testDeleteRectangle_OK() throws FunctionalException {
		PointFigure[] tabPointFigure = {pf1, pf2, pf1, pf2};
		Rectangle rectangle = controller.createRectangle(tabPointFigure, Color.black);
		
		controller.deleteRectangle(rectangle);
		assertNull(rectangle.getPoints());
	}

}
