package hello.world.ioc;

import javax.inject.Singleton;

@Singleton
public class Vehicle {
	
	private final Engine engine;
	
	private String value;
	
	public Vehicle(Engine engine) {
		this.engine = engine;
	}
	
	public String start() {
		return this.engine.start();
	}
	
	public int getCylinders() {
		return this.engine.getCylinders();
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
