package com.cv;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class CvApplicationTests {

	@Test
	void firstTest() {
		System.out.println("Junit works!");
		Assertions.assertTrue(true);
	}
}
