
package com.lpu.carEngineOTO;

public class CarEngineDriver {

	public static void main(String[] args) {
//		Engine e = new Engine();
//		e.setId(111);
//		e.setCc(2200);
//		
//		Car c = new Car();
//		c.setId(2);
//		c.setBrand("Ertiga");
//		c.setEngine(e);
		
		EngineCRUD engine = new EngineCRUD();
		//engine.saveEngine(e);
		
		
//		CarCRUD car = new CarCRUD();
		//car.saveCar(c);
		
		//car.findByBrand("Thar");
		
		//car.deleteCar(2);
		engine.deleteEngine(111);
	}

}
