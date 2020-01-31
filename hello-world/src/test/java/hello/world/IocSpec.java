package hello.world;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import hello.world.ioc.Vehicle;
import io.micronaut.context.BeanContext;
import io.micronaut.test.annotation.MicronautTest;

@MicronautTest
public class IocSpec {
	
	@Test
	public void whenIocInvoke() {
		Vehicle vehicle = BeanContext.run().getBean(Vehicle.class);
		assertEquals("Starting V8", vehicle.start());
		assertEquals(8, vehicle.getCylinders());
	}
	

}
