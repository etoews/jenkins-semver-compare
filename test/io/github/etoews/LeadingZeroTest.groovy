package io.github.etoews

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import java.text.ParseException

import static org.assertj.core.api.Assertions.assertThatCode
import static org.assertj.core.api.Assertions.assertThat
import static org.junit.jupiter.api.Assertions.assertThrows
import static org.junit.jupiter.api.Assertions.assertTrue

class LeadingZeroTest {
    private static final Script script = new Script() {
        @Override
        Object run() {
            return null
        }
    }
    SemanticVersion semanticVersion

    @BeforeEach
    void setUp() {
        semanticVersion = new SemanticVersion(script)
    }

    @Test
    void testMajorNoLeading(){
        assertThatCode {
            semanticVersion.setSemanticVersion('3.0.0')
        }.doesNotThrowAnyException()
    }
    @Test
    void testMinorNoLeading(){
        assertThatCode {
            semanticVersion.setSemanticVersion('3.8.0')
            semanticVersion.setSemanticVersion('0.9.0')
            semanticVersion.setSemanticVersion('0.10.0')
        }.doesNotThrowAnyException()
    }
    @Test
    void testPatchNoLeading(){
        assertThatCode {
            semanticVersion.setSemanticVersion('0.9.10')
        }.doesNotThrowAnyException()
    }

    @Test
    void testMajorLeading(){
        Exception exception = assertThrows(ParseException.class, { ->
            semanticVersion.setSemanticVersion('02.3.0')
        })
        assertThat(exception.getMessage()).contains("is not semver format compatible")
    }
    @Test
    void testMinorLeading(){
        Exception exception = assertThrows(ParseException.class, { ->
            semanticVersion.setSemanticVersion('2.03.1')
        })
        assertThat(exception.getMessage()).contains("is not semver format compatible")
    }
    @Test
    void testPatchLeading(){
        Exception exception = assertThrows(ParseException.class, { ->
            semanticVersion.setSemanticVersion('2.3.05')
        })
        assertThat(exception.getMessage()).contains("is not semver format compatible")
    }
}
