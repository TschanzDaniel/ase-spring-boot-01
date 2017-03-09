package edu.spring.rest.security.stateless;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.spring.rest.security.stateless.RestStatelessApplication;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RestStatelessApplication.class)
@WebAppConfiguration
public class RestStatelessApplicationTests {

	@Test
	public void contextLoads() {
	}

}
