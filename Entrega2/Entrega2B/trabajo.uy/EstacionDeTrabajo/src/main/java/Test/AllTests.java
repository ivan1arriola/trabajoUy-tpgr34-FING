package main.java.Test;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;




@Suite
@SelectClasses({ControladorUsuarioTest.class,  
				ControladorUsuarioTest2.class,  
				ControladorUsuarioTest3.class,
				ControladorUsuarioTest4.class,
				ctrlOfertaTest.class
				})

public class AllTests {

}
