package com.caesarcipher;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;


public class CaesarCipherTest {

    @Test
    void testEncodeWithEmptyStringAnd0Shift() {
        CaesarCipher caesarCipher = new CaesarCipher(0);
        assertEquals("", caesarCipher.encode(""));
    }

    @Test
    void testEncodeASingleCharacterWithAShiftOf0() {
        CaesarCipher caesarCipher = new CaesarCipher(0);
        assertEquals("a", caesarCipher.encode("a"));
    }

    private static Stream<Arguments> caesarShiftEncodeProvider() {
        return Stream.of(
                Arguments.of("", 0, ""),
                Arguments.of("a", 0, "a"),
                Arguments.of("", 1010, ""), //Green bar!
                Arguments.of("a", 1, "b"),
                Arguments.of("ab", 1, "bc"),
                Arguments.of("z", 1, "a"),
                Arguments.of("a", -1, "z"),
                Arguments.of("a", -4, "w"),
                Arguments.of("a", 260, "a"),
                Arguments.of("a", -260, "a"),
                Arguments.of("~", 10, "~"),
                Arguments.of(" ", 10, " "),
                Arguments.of("A", 1, "B"),
                Arguments.of("A", 0, "A"),
                Arguments.of("Z", 1, "A")
        );
    }

    private static Stream<Arguments> caesarShiftDecodeProvider() {
        return Stream.of(
                Arguments.of("", 0, ""),
                Arguments.of("a", 0, "a"),
                Arguments.of("", 1010, ""),
                Arguments.of("b", 1, "a"),
                Arguments.of("z", 1, "y"),
                Arguments.of("a", 1, "z"),
                Arguments.of("a", 260, "a"),
                Arguments.of("a", -260, "a"),
                Arguments.of("~", 10, "~"),
                Arguments.of(" ", 10, " "),
                Arguments.of("A", 1, "Z")
        );
    }

    @ParameterizedTest(name = "{index}, originalString: {0}, shift: {1}, result:{2}")
    @MethodSource(value = {"caesarShiftEncodeProvider"})
    public void testCaesarShiftEncode(String original, int shift, String result) {
        CaesarCipher caesarCipher = new CaesarCipher(shift);
        assertThat(caesarCipher.encode(original)).isEqualTo(result);
    }


    @ParameterizedTest(name = "{index}, originalString: {0}, shift: {1}, result:{2}")
    @MethodSource(value = {"caesarShiftDecodeProvider"})
    public void testCaesarShiftDecode(String original, int shift, String result) {
        CaesarCipher caesarCipher = new CaesarCipher(shift);
        assertThat(caesarCipher.decode(original)).isEqualTo(result);
    }

    @Test
    void testEncodeWithANullAsOriginalStringClassicWay() {
        try {
            CaesarCipher caesarCipher = new CaesarCipher(5);
            caesarCipher.encode(null);
            fail("This line should never be called");
        } catch (NullPointerException npe) {
            assertThat(npe.getMessage())
                    .isEqualTo("Original string cannot be null");
        }
    }

    @Test
    void testEncodeWithANullAsOriginalStringJUnit5() {
        CaesarCipher caesarCipher = new CaesarCipher(5);

        NullPointerException nullPointerException = assertThrows
                (NullPointerException.class, () -> caesarCipher.encode(null));

        assertThat(nullPointerException).hasMessage("Original string cannot be null");
    }

    @Test
    void testEncodeWithANullAsOriginalStringAssertJ() {
        CaesarCipher caesarCipher = new CaesarCipher(5);
        assertThatThrownBy(() -> caesarCipher.encode(null))
                .hasMessage("Original string cannot be null");
    }
}






