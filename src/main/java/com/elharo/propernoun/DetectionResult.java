package com.elharo.propernoun;

import java.util.Objects;

/**
 * Represents a detected proper noun with its position and confidence.
 */
public class DetectionResult {
    
    private final String text;
    private final int startIndex;
    private final int endIndex;
    private final double confidence;
    private final String type;
    
    /**
     * Creates a new detection result.
     * 
     * @param text the detected proper noun text
     * @param startIndex the starting position in the original text
     * @param endIndex the ending position in the original text
     * @param confidence the confidence score (0.0 to 1.0)
     * @param type the type of proper noun (e.g., "PERSON", "PLACE", "ORGANIZATION")
     */
    public DetectionResult(String text, int startIndex, int endIndex, double confidence, String type) {
        this.text = Objects.requireNonNull(text, "Text cannot be null");
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.confidence = confidence;
        this.type = type;
    }
    
    public String getText() {
        return text;
    }
    
    public int getStartIndex() {
        return startIndex;
    }
    
    public int getEndIndex() {
        return endIndex;
    }
    
    public double getConfidence() {
        return confidence;
    }
    
    public String getType() {
        return type;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        DetectionResult that = (DetectionResult) obj;
        return startIndex == that.startIndex &&
               endIndex == that.endIndex &&
               Double.compare(that.confidence, confidence) == 0 &&
               Objects.equals(text, that.text) &&
               Objects.equals(type, that.type);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(text, startIndex, endIndex, confidence, type);
    }
    
    @Override
    public String toString() {
        return String.format("DetectionResult{text='%s', startIndex=%d, endIndex=%d, confidence=%.2f, type='%s'}", 
                           text, startIndex, endIndex, confidence, type);
    }
}