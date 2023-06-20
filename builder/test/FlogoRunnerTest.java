import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import static io.flogo.builder.FlogocRunner.main;


@Ignore
public class FlogoRunnerTest {
	private String home;

	@Before
	public void setUp() {
		home = new File("test-res").getAbsolutePath() + File.separator;
	}

	@Test
	public void exampleM1() {
		main(new String[]{temp(home + File.separator + "m1.txt")});
	}

	private static String temp(String filepath) {
		try {
			File argsFile = new File(filepath);
			String home = System.getProperty("user.home");
			String projectDirectory = projectDirectory();
			String text = Files.readString(argsFile.toPath())
					.replace("$PROJECT_DIRECTORY", projectDirectory)
					.replace("$HOME", home);
			Path temporalFile = Files.createTempFile(argsFile.getName(), ".txt");
			Files.writeString(temporalFile, text, StandardOpenOption.TRUNCATE_EXISTING);
			temporalFile.toFile().deleteOnExit();
			return temporalFile.toFile().getAbsolutePath();
		} catch (IOException e) {
			return null;
		}
	}

	private static String projectDirectory() throws IOException {
		return new File("..").getCanonicalFile().getAbsolutePath();
	}


}