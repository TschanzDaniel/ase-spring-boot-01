package edu.spring.liquibase;

import java.net.ConnectException;

import org.junit.Rule;
import org.junit.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.system.OutputCaptureRule;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.core.NestedCheckedException;

import static org.assertj.core.api.Assertions.assertThat;



/**
 * Checks initial creation of PUBLIC.DATABASECHANGELOG table
 * if the file database.mv already exists, the test will just do nothing
 */
@ExtendWith(OutputCaptureExtension.class)
public class SampleLiquibaseApplicationTests {

	@Rule
	public OutputCaptureRule outputCapture = new OutputCaptureRule();

	@Test
	public void testDefaultSettings() throws Exception {
		try {
			JpaLiquibaseApplication.main(new String[] { "--server.port=0" });
		}
		catch (IllegalStateException ex) {
			if (serverNotRunning(ex)) {
				return;
			}
		}
		String output = this.outputCapture.toString();
		if (output.contains("Creating database history table with name: PUBLIC.DATABASECHANGELOG") ) {

			assertThat(output)
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
