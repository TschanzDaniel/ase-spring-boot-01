package edu.spring.jpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest (classes = JpaApplication.class)
//@ContextConfiguration(classes=JpaApplication.class, loader=SpringApplicationContextLoader.class)
@WebAppConfiguration
public class JpaApplicationTests {

	@Test
	public void contextLoads() {
	}

}
