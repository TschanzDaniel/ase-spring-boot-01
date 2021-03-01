package edu.spring.liquibase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest (classes = JpaLiquibaseApplication.class)
@WebAppConfiguration
public class JpaLiquibaseApplicationTests {

	@Test
	public void contextLoads() {
	}

}
