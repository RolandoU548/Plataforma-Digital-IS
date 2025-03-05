package com.plataforma_digital.utils;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class DateUtilsTest {

    @Test
    public void testValidateDate_ValidDate() {
        assertTrue(DateUtils.validateDate("12/12/2023"));
    }

    @Test
    public void testValidateDate_InvalidDate() {
        assertFalse(DateUtils.validateDate("12-12-2023"));
    }

    @Test
    public void testValidateDate_EmptyDate() {
        assertFalse(DateUtils.validateDate(""));
    }

    @Test
    public void testValidateDate_NullDate() {
        assertFalse(DateUtils.validateDate(null));
    }

    @Test
    public void testValidateDate_InvalidFormat() {
        assertFalse(DateUtils.validateDate("2023/12/12"));
    }

    @Test
    public void testValidateDate_InvalidDay00() {
        assertFalse(DateUtils.validateDate("00/04/2025"));
    }

    @Test
    public void testValidateDate_InvalidDay31() {
        assertFalse(DateUtils.validateDate("31/04/2025"));
    }

    @Test
    public void testValidateDate_InvalidDay32() {
        assertFalse(DateUtils.validateDate("32/12/2023"));
    }

    @Test
    public void testValidateDate_InvalidMonth() {
        assertFalse(DateUtils.validateDate("12/13/2023"));
    }

    @Test
    public void testValidateDate_February29() {
        assertTrue(DateUtils.validateDate("29/02/2023"));
    }
}
