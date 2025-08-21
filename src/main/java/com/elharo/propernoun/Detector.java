package com.elharo.propernoun;

import java.util.List;

/**
 * Abstract base class for language-specific proper noun detectors.
 * This class is package-protected and not part of the public API.
 * 
 * Each detector handles a specific language and contributes to the multilingual
 * detection process. English detectors have precedence in case of conflicts.
 */
abstract class Detector {
    
    protected final String language;
    
    /**
     * Creates a new detector for the specified language.
     * 
     * @param language the language code this detector supports
     */
    protected Detector(String language) {
        this.language = language;
    }
    
    /**
     * Detects proper nouns in the given text for this detector's language.
     * 
     * @param text the input text to analyze
     * @return a list of detection results containing proper nouns found
     */
    abstract List<DetectionResult> detect(String text);
    
    /**
     * Returns the language code this detector supports.
     * 
     * @return the language code (e.g., "en", "es", "fr", "ru")
     */
    String getLanguage() {
        return language;
    }
    
    /**
     * Returns whether this detector supports the given language.
     * 
     * @param language the language code to check
     * @return true if this detector supports the language, false otherwise
     */
    boolean supportsLanguage(String language) {
        return this.language.equals(language);
    }
    
    /**
     * Returns the priority of this detector for conflict resolution.
     * English detectors return higher priority (lower number = higher priority).
     * 
     * @return priority value (0 = highest priority for English, higher numbers for other languages)
     */
    int getPriority() {
        return "en".equals(language) ? 0 : 1;
    }
}