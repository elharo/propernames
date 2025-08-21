# Implementation Plan

- [x] 1. Set up project structure and core interfaces
  - Create Maven project structure with standard directories (src/main/java, src/test/java)
  - Define main package structure using com.elharo.propernoun
  - Create core classes: ProperNounDetector, Detector, DetectionResult
  - _Requirements: 1.1, 1.4_

- [x] 2. Implement basic ProperNounDetector functionality (TDD)
  - [x] 2.1 Test and implement null input handling
    - Write test: ProperNounDetector.detect(null) throws NullPointerException
    - Verify test fails
    - Implement minimal code to make test pass
    - Write test: ProperNounDetector.isProperNoun(null) throws NullPointerException
    - Implement code to make test pass
    - _Requirements: 1.2, 1.3_

  - [x] 2.2 Test and implement empty/whitespace input handling
    - Write test: detect("") returns empty list
    - Write test: detect("   ") returns empty list
    - Write test: isProperNoun("") returns false
    - Verify tests fail, implement minimal code to make them pass
    - _Requirements: 1.2, 1.3_

- [x] 3. Test and implement basic proper noun detection (TDD)
  - [x] 3.1 Test and implement simple capitalized word detection
    - Write test: isProperNoun("John") returns true
    - Write test: isProperNoun("john") returns true
    - Write test: isProperNoun("box") returns false
    - Write test: isProperNoun("Box") returns false
    - Write test: isProperNoun("JOHN") returns true
    - Verify tests fail, implement minimal detection
    - _Requirements: 2.1, 3.1_

  - [x] 3.2 Test and implement DetectionResult creation
    - Write test: detect("John") returns list with one DetectionResult
    - Write test: DetectionResult has correct text, position, confidence
    - Verify tests fail, implement DetectionResult class and basic detection
    - Write test: detect("john smith") returns empty list (lowercase)
    - Implement code to make test pass
    - _Requirements: 5.1, 5.2_

- [ ] 4. Test and implement multi-word text detection (TDD)
  - [ ] 4.1 Test and implement text parsing and word detection
    - Write test: detect("John Smith") returns two DetectionResults
    - Write test: detect("John went home") returns one DetectionResult for "John"
    - Write test: detect("john SMITH") returns one DetectionResult for "SMITH"
    - Verify tests fail, implement text parsing and word-by-word detection
    - _Requirements: 1.1, 2.1_

  - [ ] 4.2 Test and implement position tracking in text
    - Write test: DetectionResult for "Smith" in "John Smith" has correct start/end indices
    - Write test: DetectionResult for "John" in "Hello John!" has correct positions
    - Verify tests fail, implement position tracking in detection logic
    - _Requirements: 5.1, 5.2_

- [ ] 5. Test and implement enhanced heuristic detection (TDD)
  - [ ] 5.1 Test and implement common name patterns
    - Write test: isProperNoun("McDonald") returns true (Mc prefix)
    - Write test: isProperNoun("O'Connor") returns true (O' prefix)
    - Write test: isProperNoun("Johnson") returns true (-son suffix)
    - Verify tests fail, implement pattern-based detection for name prefixes/suffixes
    - _Requirements: 2.1, 2.4, 3.1_

  - [ ] 5.2 Test and implement title and honorific detection
    - Write test: isProperNoun("Dr") returns true
    - Write test: isProperNoun("Mr") returns true
    - Write test: isProperNoun("Prof") returns true
    - Write test: isProperNoun("dr") returns true (case insensitive)
    - Verify tests fail, implement title/honorific detection
    - _Requirements: 2.3, 2.7_

- [ ] 6. Test and implement basic dictionary-based detection (TDD)
  - [ ] 6.1 Test and implement simple name dictionary
    - Write test: isProperNoun("John") returns true (common first name)
    - Write test: isProperNoun("Smith") returns true (common surname)
    - Write test: isProperNoun("table") returns false (common noun)
    - Verify tests fail, implement basic hardcoded name dictionary
    - _Requirements: 2.1, 2.5_

  - [ ] 6.2 Test and implement place name detection
    - Write test: isProperNoun("London") returns true
    - Write test: isProperNoun("Paris") returns true
    - Write test: isProperNoun("Canada") returns true
    - Verify tests fail, add place names to detection logic
    - _Requirements: 2.2, 2.5_

- [ ] 7. Test and implement confidence scoring (TDD)
  - [ ] 7.1 Test and implement basic confidence calculation
    - Write test: DetectionResult for "John" has confidence > 0.8
    - Write test: DetectionResult for "McDonald" has confidence > 0.6
    - Write test: DetectionResult confidence is between 0.0 and 1.0
    - Verify tests fail, implement confidence scoring based on detection method
    - _Requirements: 5.1, 5.3, 5.4_

  - [ ] 7.2 Test and implement detection type classification
    - Write test: DetectionResult for "John" has type "PERSON"
    - Write test: DetectionResult for "London" has type "PLACE"
    - Write test: DetectionResult for "Dr" has type "TITLE"
    - Verify tests fail, implement type classification in DetectionResult
    - _Requirements: 5.1, 5.2_

- [ ] 8. Test and implement multilingual support (TDD)
  - [ ] 8.1 Test and implement basic non-English name detection
    - Write test: isProperNoun("José") returns true (Spanish name)
    - Write test: isProperNoun("François") returns true (French name)
    - Write test: isProperNoun("Müller") returns true (German name)
    - Verify tests fail, implement Unicode-aware name detection
    - _Requirements: 2.5, 6.2, 6.6_

  - [ ] 8.2 Test and implement English precedence in conflicts
    - Write test: word that's common noun in English but proper in Spanish returns false
    - Write test: word that's proper in English but common in Spanish returns true
    - Verify tests fail, implement language precedence logic
    - _Requirements: 1.6, 6.5_

- [ ] 9. Test and implement advanced detection features (TDD)
  - [ ] 9.1 Test and implement acronym detection
    - Write test: isProperNoun("NASA") returns true
    - Write test: isProperNoun("FBI") returns true
    - Write test: isProperNoun("WHO") returns true
    - Write test: isProperNoun("who") returns false (lowercase)
    - Verify tests fail, implement all-caps acronym detection
    - _Requirements: 2.3, 2.7_

  - [ ] 9.2 Test and implement organization name detection
    - Write test: isProperNoun("Microsoft") returns true
    - Write test: isProperNoun("Google") returns true
    - Write test: isProperNoun("Apple") returns true (but not the fruit context)
    - Verify tests fail, add organization names to detection
    - _Requirements: 2.2, 2.5_

- [ ] 10. Test and implement edge cases and robustness (TDD)
  - [ ] 10.1 Test and implement special character handling
    - Write test: isProperNoun("Jean-Luc") returns true (hyphenated names)
    - Write test: isProperNoun("Mary's") returns true (possessive)
    - Write test: detect("Hello, John!") finds "John" correctly (punctuation)
    - Verify tests fail, implement robust text parsing with special characters
    - _Requirements: 1.2, 6.4_

  - [ ] 10.2 Test and implement ambiguous word handling
    - Write test: confidence scoring for ambiguous words like "Will" vs "will"
    - Write test: context-aware detection where possible
    - Write test: consistent behavior for edge cases
    - Verify tests fail, implement ambiguity handling logic
    - _Requirements: 2.6, 5.5_

- [ ] 11. Test and implement performance requirements (TDD)
  - [ ] 11.1 Test and implement performance benchmarks
    - Write test: detect() completes within 100ms for typical input
    - Write test: isProperNoun() completes within 10ms for single word
    - Write test: memory usage stays reasonable for large inputs
    - Verify tests fail, optimize implementation to meet performance requirements
    - _Requirements: 1.4, 6.1_

  - [ ] 11.2 Test and implement integration scenarios
    - Write test: end-to-end detection with mixed language text
    - Write test: batch processing of multiple sentences
    - Write test: thread safety for concurrent access
    - Verify tests fail, implement final integration and thread safety
    - _Requirements: 1.4, 6.4_