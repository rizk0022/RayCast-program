package raycast.animator;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import raycast.animator.AbstractAnimator;
import raycast.animator.TextAnimator;

/**
 * @author Youssef Rizk
 *
 */
class AbstractAnimatorTest {
	private AbstractAnimator a;

	@BeforeAll
	public static void setUpBeforeAllTests() {

	}

	@AfterAll
	public static void teardownAfterAllTests() {

	}

	@BeforeEach
	public void setUpBeforeEachTest() {
		a = new TextAnimator();

	}

	@AfterEach
	public void teardownAfterEachTest() {
		a = null; // for releasing the memory as protocol

	}

	@ParameterizedTest
	@CsvFileSource(resources = "/datasheet.csv", numLinesToSkip = 1)
	void points(double rsx, double rsy, double rex, double rey, double ssx, double ssy, double sex, double sey,
			boolean intersects, double xpoint, double ypoint, double ray) {
		boolean doesIntersect = a.getIntersection(rsx, rsy, rex, rey, ssx, ssy, sex, sey);
		double[] intersect = a.intersect();
		assertTrue(doesIntersect == intersects);
		if (!intersects)
			return;
		assertEquals(intersect[0], xpoint, 0.00001);
		assertEquals(intersect[1], ypoint, 0.00001);
		assertEquals(intersect[2], ray, 0.00001);

	}

	@Test
	public void testException() {
		try {

			a.intersect();

		} catch (NullPointerException | IllegalStateException e) {
			fail(e.getMessage());
		}
	}

}
