package fastrackit.ro.homework.curs5;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@SpringBootTest
class ApplicationTests {




	public List<Country> readCountries() {
		try {
			return Files.lines(Path.of("src/main/resources/people.txt"))
					.map(this::toCountry)
					.toList();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private Country toCountry(String line) {
		String[] tokens = line.split("\\|");
		return new Country(0,tokens[0], tokens[1], Long.parseLong(tokens[2]), Long.parseLong(tokens[3]),tokens[4]);
	}


}
