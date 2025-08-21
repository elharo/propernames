package com.elharo.propernoun;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

/**
 * Test class for ProperNounDetector functionality.
 * Tests follow TDD approach with failing tests first, then minimal implementation.
 */
public class ProperNounDetectorTest {

    private ProperNounDetector detector;

    @BeforeEach
    void setUp() {
        detector = new ProperNounDetector();
    }

    // Task 2.1: Test null input handling
    @Test
    void testDetectWithNullThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> {
            detector.detect(null);
        });
    }

    @Test
    void testIsProperNounWithNullThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> {
            detector.isProperNoun(null);
        });
    }

    // Task 2.2: Test empty/whitespace input handling
    @Test
    void testDetectWithEmptyStringReturnsEmptyList() {
        List<DetectionResult> results = detector.detect("");
        assertTrue(results.isEmpty());
    }

    @Test
    void testDetectWithWhitespaceReturnsEmptyList() {
        List<DetectionResult> results = detector.detect("   ");
        assertTrue(results.isEmpty());
    }

    @Test
    void testIsProperNounWithEmptyStringReturnsFalse() {
        assertFalse(detector.isProperNoun(""));
    }

    // Task 3.1: Test simple capitalized word detection
    @Test
    void testIsProperNounWithJohnReturnsTrue() {
        assertTrue(detector.isProperNoun("John"));
    }

    @Test
    void testIsProperNounWithLowercaseJohnReturnsTrue() {
        assertTrue(detector.isProperNoun("john"));
    }

    @Test
    void testIsProperNounWithBoxReturnsFalse() {
        assertFalse(detector.isProperNoun("box"));
    }

    @Test
    void testIsProperNounWithCapitalizedBoxReturnsFalse() {
        assertFalse(detector.isProperNoun("Box"));
    }

    @Test
    void testIsProperNounWithUppercaseJohnReturnsTrue() {
        assertTrue(detector.isProperNoun("JOHN"));
    }

    // Task 3.2: Test DetectionResult creation
    @Test
    void testDetectJohnReturnsListWithOneDetectionResult() {
        List<DetectionResult> results = detector.detect("John");
        assertEquals(1, results.size());
    }

    @Test
    void testDetectionResultHasCorrectTextPositionConfidence() {
        List<DetectionResult> results = detector.detect("John");
        assertEquals(1, results.size());
        
        DetectionResult result = results.get(0);
        assertEquals("John", result.getText());
        assertEquals(0, result.getStartIndex());
        assertEquals(4, result.getEndIndex());
        assertTrue(result.getConfidence() > 0.0);
        assertTrue(result.getConfidence() <= 1.0);
    }

    @Test
    void testDetectLowercaseJohnSmithReturnsEmptyList() {
        List<DetectionResult> results = detector.detect("john smith");
        assertTrue(results.isEmpty());
    }

    // Task 5.1: Test common name patterns
    @Test
    void testIsProperNounWithMcDonaldReturnsTrue() {
        assertTrue(detector.isProperNoun("McDonald"));
    }

    @Test
    void testIsProperNounWithOConnorReturnsTrue() {
        assertTrue(detector.isProperNoun("O'Connor"));
    }

    @Test
    void testIsProperNounWithJohnsonReturnsTrue() {
        assertTrue(detector.isProperNoun("Johnson"));
    }
}