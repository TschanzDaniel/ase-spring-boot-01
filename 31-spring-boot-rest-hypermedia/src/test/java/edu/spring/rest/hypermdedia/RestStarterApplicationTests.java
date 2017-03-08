package edu.spring.rest.hypermdedia;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.spring.rest.hypermedia.HypermediaApplication;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = HypermediaApplication.class)
@WebAppConfiguration
public class RestStarterApplicationTests {

	@Test
	public void contextLoads() {
	}

}
