package com.example.androidunittest_rahminajla


import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

/**
 * Class PasswordUnitTest memiliki 4 buah test case yang akan dijalankan
 * menggunakan @Test annotation
 */

class PasswordUnitTest{

    private lateinit var helper: PasswordUnit

    @Before
    fun setUp() {
        helper = PasswordUnit()
    }

    /**
     * Keempat test case tersebut akan memanggil fungsi validatePassword() pada class PasswordUnit dengan memberikan
     * input password tertentu dan membandingkan hasil yang dikembalikan dengan expected output yang sudah ditentukan
     * menggunakan assertEquals()
     */

    @Test
    fun validatePassword_blankInput_expectedRequired() {
        val result = helper.validatePassword("   ")
        assertEquals("Password is required field", result)
    }

    @Test
    fun validatePassword_2ChrInput_expectedRequired() {
        val result = helper.validatePassword("ab")
        assertEquals("Length of the password should be greater than 6", result)
    }

    @Test
    fun validatePassword_CorrectInput_expectedRequired() {
        val result = helper.validatePassword("123456")
        assertEquals("Valid", result)
    }

    @Test
    fun validatePassword_16ChrInput_expectedRequired() {
        val result = helper.validatePassword("123456123456123456")
        assertEquals("Length of the password be less than 15", result)
    }



}