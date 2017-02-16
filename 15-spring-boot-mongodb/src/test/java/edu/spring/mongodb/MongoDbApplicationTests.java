package edu.spring.mongodb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MongoDbApplication.class)
@WebAppConfiguration
public class MongoDbApplicationTests {

	@Test
	public void contextLoads() {
	}

}
