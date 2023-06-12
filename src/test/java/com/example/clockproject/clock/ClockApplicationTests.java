package com.example.clockproject.clock;

import com.example.clockproject.clock.controller.UserTimeConverterController;
import com.example.clockproject.clock.service.TimeConverterService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class ClockApplicationTests {

	@Test
	public void testConvertUserTimeToWords_ValidTime_ReturnsConvertedTime() {
		// Arrange
		TimeConverterService timeConverterService = new TimeConverterService();
		UserTimeConverterController userTimeConverterController = new UserTimeConverterController(timeConverterService);
		LocalTime time = LocalTime.of(11, 25);
		String expectedOutput = "It's eleven twenty-five";

		// Act
		ResponseEntity<String> response = userTimeConverterController.convertUserTimeToWords(time);

		// Assert
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(expectedOutput, response.getBody());
	}

	@Test
	public void testConvertUserTimeToWords_InvalidTime_ReturnsBadRequest() {
		// Arrange
		TimeConverterService timeConverterService = new TimeConverterService();
		UserTimeConverterController userTimeConverterController = new UserTimeConverterController(timeConverterService);
		LocalTime time = LocalTime.of(25, 70); // Invalid time

		// Act & Assert
		assertThrows(IllegalArgumentException.class, () -> {
			userTimeConverterController.convertUserTimeToWords(time);
		});
	}


}
