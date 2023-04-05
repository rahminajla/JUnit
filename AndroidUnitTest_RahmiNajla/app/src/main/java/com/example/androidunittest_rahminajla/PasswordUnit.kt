package com.example.androidunittest_rahminajla

/**
 * Code dibawah merupakan sebuah class Kotlin dengan nama class PasswordUnit yang berisi
 * sebuah fungsi bernama validatePassword.
 */

class PasswordUnit {

    /**
     * Fungsi validatePassword digunakan untuk memeriksa kevalidan password yang diberikan dengan
     * memeriksa apakah password tersebut kosong, kurang dari 6 karakter, atau lebih dari 15 karakter.
     * Fungsi ini akan mengembalikan sebuah pesan yang sesuai dengan hasil validasi password tersebut.
     */

    fun validatePassword(input: String) = when {
        input.isBlank() -> {
            "Password is required field"
        }
        input.length < 6 -> {
            "Length of the password should be greater than 6"
        }
        input.length > 15 -> {
            "Length of the password be less than 15"
        }
        else -> {
            "Valid"
        }
    }
}




