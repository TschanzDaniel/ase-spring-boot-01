package edu.spring.profiles;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.spring.profiles.JpaApplication;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest (classes = JpaApplication.class)
@WebAppConfiguration
public class JpaApplicationTests {

	@Test
	public void contextLoads() {
	}

}
