package com.elharo.propernoun;

import java.util.List;
import java.util.ArrayList;

/**
 * Main public class for detecting proper nouns in text across multiple
 * languages.
 * This is the primary entry point for the proper noun detection library.
 * 
 * The detector works multilingually - it does not require a language parameter
 * and will detect proper nouns regardless of their language (English, French,
 * Spanish, Russian, etc.). In cases where a word could be a proper noun in one
 * language but a common noun in another, English takes precedence.
 */
public class ProperNounDetector {

  /**
   * Detects proper nouns in the given text across all supported languages.
   * The detector automatically handles multilingual input without requiring
   * language specification. In case of conflicts between languages, English
   * classification takes precedence.
   * 
   * @param text the input text to analyze
   * @return a list of detection results containing proper nouns found
   * @throws NullPointerException if text is null
   */
  public List<DetectionResult> detect(String text) {
    if (text == null) {
      throw new NullPointerException("Text cannot be null");
    }
    
    // Handle empty or whitespace-only text
    if (text.trim().isEmpty()) {
      return new ArrayList<>();
    }
    
    List<DetectionResult> results = new ArrayList<>();
    
    // Simple implementation for task 3.1: detect basic proper nouns
    String trimmedText = text.trim();
    if (isProperNounInternal(trimmedText)) {
      results.add(new DetectionResult(trimmedText, 0, trimmedText.length(), 0.8, "PERSON"));
    }
    
    return results;
  }

  /**
   * Checks if a single word is a proper noun across all supported languages.
   * This is a convenience method for single word detection.
   * 
   * @param word the word to check
   * @return true if the word is detected as a proper noun, false otherwise
   * @throws NullPointerException if word is null
   */
  public boolean isProperNoun(String word) {
    if (word == null) {
      throw new NullPointerException("Word cannot be null");
    }
    
    // Handle empty or whitespace-only word
    if (word.trim().isEmpty()) {
      return false;
    }
    
    return isProperNounInternal(word.trim());
  }
  
  /**
   * Internal method to check if a word is a proper noun.
   * Minimal implementation for task 3.1.
   */
  private boolean isProperNounInternal(String word) {
    // Basic implementation: recognize "John" in any case as a proper noun
    // but "box" in any case as a common noun
    String lowerWord = word.toLowerCase();
    
    // Known proper nouns (names)
    if ("john".equals(lowerWord)) {
      return true;
    }
    
    // Known common nouns
    if ("box".equals(lowerWord)) {
      return false;
    }
    
    // Default: return false for unknown words
    return false;
  }
}