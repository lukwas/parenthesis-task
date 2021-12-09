package pl.lukwas;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ParenthesisCheckerTest {

    @ParameterizedTest
    @MethodSource("parenthesisValidCases")
    void shouldVerifyValidCasesDetection(String text){
        Assertions.assertThat(ParenthesisChecker.isValid(text)).isTrue();

    }

    @ParameterizedTest
    @MethodSource("parenthesisInvalidCases")
    void shouldVerifyInvalidCasesDetection(String text){
        Assertions.assertThat(ParenthesisChecker.isValid(text)).isFalse();
    }

    private static Stream<Arguments> parenthesisValidCases(){
        return Stream.of(
                Arguments.arguments(""),
                Arguments.arguments("()"),
                Arguments.arguments("(((())))"),
                Arguments.arguments("({[]})"),
                Arguments.arguments("({[][]{([])}})"),
                Arguments.arguments("({[]}){}()()()()")
                );
    }

    private static Stream<Arguments> parenthesisInvalidCases(){
        return Stream.of(
                Arguments.arguments("(]"),
                Arguments.arguments("["),
                Arguments.arguments("]"),
                Arguments.arguments("([)]"),
                Arguments.arguments("{{{{{}}}}}}"),
                Arguments.arguments("{{{{{}}}}}}")
        );
    }

}