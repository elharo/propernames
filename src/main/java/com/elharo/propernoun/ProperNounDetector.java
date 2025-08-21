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

    // TODO: Implement multilingual proper noun detection with English precedence
    return new ArrayList<>();
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

    List<DetectionResult> results = detect(word);
    return !results.isEmpty();
  }
}