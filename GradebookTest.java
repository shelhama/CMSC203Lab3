package junitLab;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GradebookTest {
    private GradeBook g1;
    private GradeBook g2;

    @BeforeEach
    public void setUp() {
        // Initialize GradeBook objects with a capacity of 5 scores
        g1 = new GradeBook(5);
        g2 = new GradeBook(5);

        // Add some scores to each GradeBook
        g1.addScore(50.0);
        g1.addScore(75.0);
        
        g2.addScore(80.0);
        g2.addScore(90.0);
    }

    @AfterEach
    public void tearDown() {
        // Set the GradeBook objects to null
        g1 = null;
        g2 = null;
    }

    @Test
    public void testAddScore() {
        // Check if scores are added correctly by comparing toString output
        assertTrue(g1.toString().equals("50.0 75.0"));
        assertTrue(g2.toString().equals("80.0 90.0"));

        // Verify that the scores size is correct
        assertEquals(2, g1.getScoreSize());
        assertEquals(2, g2.getScoreSize());
    }

    @Test
    public void testSum() {
        // Check if the sum of scores is correct
        assertEquals(125.0, g1.sum(), 0.0001);
        assertEquals(170.0, g2.sum(), 0.0001);
    }

    @Test
    public void testMinimum() {
        // Check if the minimum score is correct
        assertEquals(50.0, g1.minimum(), 0.0001);
        assertEquals(80.0, g2.minimum(), 0.0001);
    }

    @Test
    public void testFinalScore() {
        // Check if the final score (sum - minimum) is calculated correctly
        assertEquals(75.0, g1.finalScore(), 0.0001);
        assertEquals(90.0, g2.finalScore(), 0.0001);
    }
}

