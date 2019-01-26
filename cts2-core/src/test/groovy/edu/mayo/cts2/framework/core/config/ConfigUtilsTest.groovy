package edu.mayo.cts2.framework.core.config
import org.junit.Test

import static org.junit.Assert.assertEquals

class ConfigUtilsTest {

	@Test
	void "Check ENV Variable resolution"(){
		print System.getenv()
		def var = System.getenv().keySet().asList().first()

		def p = new Properties()
		p.setProperty("test", "\${$var}")

		def props = ConfigUtils.resolveEnvironmentVariables(p)

		print props
		assertEquals System.getenv(var), props.getProperty("test")
	}


}
