package edu.spring.liquibase;

import java.net.ConnectException;

import org.junit.Rule;
import org.junit.Test;

import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.core.NestedCheckedException;

import static org.assertj.core.api.Assertions.assertThat;



/**
 * Checks initial creation of PUBLIC.DATABASECHANGELOG table 
 * if the file database.mv already exists, the test will just do nothing
 */
public class SampleLiquibaseApplicationTests {

	@Rule
	public OutputCapture outputCapture = new OutputCapture();

	@Test
	public void testDefaultSettings() throws Exception {
		try {
			JpaApplication.main(new String[] { "--server.port=0" });
		}
		catch (IllegalStateException ex) {
			if (serverNotRunning(ex)) {
				return;
			}
		}
		String output = this.outputCapture.toString();
		if (output.contains("Creating database history table with name: PUBLIC.DATABASECHANGELOG") ) {

			assertThat(output).contains("Successfully acquired change log lock")
			.contains("Creating database history "
					+ "table with name: PUBLIC.DATABASECHANGELOG")
			.contains("Table customer created")
			.contains("ChangeSet classpath:/db/"
					+ "changelog/db.changelog-master.yaml::1::"
					+ "matthiasbachmann ran successfully")
			.contains("New row inserted into customer")
			.contains("ChangeSet classpath:/db/changelog/"
					+ "db.changelog-master.yaml::2::"
					+ "matthiasbachmann ran successfully")
			.contains("Successfully released change log lock");
		}
	}

	@SuppressWarnings("serial")
	private boolean serverNotRunning(IllegalStateException ex) {
		NestedCheckedException nested = new NestedCheckedException("failed", ex) {
		};
		if (nested.contains(ConnectException.class)) {
			Throwable root = nested.getRootCause();
			if (root.getMessage().contains("Connection refused")) {
				return true;
			}
		}
		return false;
	}
}
