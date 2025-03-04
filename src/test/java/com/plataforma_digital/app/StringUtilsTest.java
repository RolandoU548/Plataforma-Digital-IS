package com.plataforma_digital.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import com.plataforma_digital.utils.StringUtils;

public class StringUtilsTest {

    @Test
    public void testNullInput() {
        String result = StringUtils.capitalize(null);
        assertEquals(null, result, "Debería devolver null si la entrada es null");
    }

    @Test
    public void testEmptyString() {
        String result = StringUtils.capitalize("");
        assertEquals("", result, "Debería devolver una cadena vacía si la entrada es vacía");
    }

    @Test
    public void testSpecialCharacters() {
        String resultado = StringUtils.capitalize("!hello");
        assertEquals("!hello", resultado, "No debería cambiar cadenas que empiezan con caracteres especiales");
    }

    public void testSingleLowerCaseLetter() {
        String resultado = StringUtils.capitalize("a");
        assertEquals("A", resultado, "Debería convertir una letra minúscula");
    }

    @Test
    public void testSingleUpperCaseLetter() {
        String resultado = StringUtils.capitalize("A");
        assertEquals("A", resultado, "Debería devolver la letra si ya está en mayúscula");
    }

    @Test
    public void testMultipleLowerCaseLetters() {
        String resultado = StringUtils.capitalize("java");
        assertEquals("Java", resultado,
                "Debería convertir solo la primera letra a mayúscula y poner las demás en minúscula");
    }

    @Test
    public void testMultipleUpperCaseLetters() {
        String resultado = StringUtils.capitalize("JAVA");
        assertEquals("Java", resultado,
                "Debería convertir solo la primera letra a mayúscula y poner las demás en minúscula");
    }

    @Test
    public void testMultipleMixedCaseLetters() {
        String resultado = StringUtils.capitalize("jAvA");
        assertEquals("Java", resultado,
                "Debería convertir solo la primera letra a mayúscula y poner las demás en minúscula");
    }
}
