package com.example.androidunittest_rahminajla

import org.junit.Assert.*
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

/**
 * Code dibawah adalah kode pengujian unit untuk class UserInstrumented dan implementasi dari UserRepository
 */

class UserInstrumentedTest {

    private lateinit var userInstrumented: UserInstrumented

    @Before
    fun setup() {
        userInstrumented = UserInstrumented()
    }

    /**
     * Method testGetUsers(), pengujian dilakukan untuk memastikan bahwa
     * method getUsers() mengembalikan daftar kosong saat tidak ada pengguna yang disimpan
     */
    @Test
    fun testGetUsers() {
        val users = userInstrumented.getUsers()
        assertEquals(0, users.size)
    }


    /**
     * method testSaveUser(), pengujian dilakukan untuk memastikan bahwa method saveUser() mengembalikan
     * nilai benar ketika disimpan, dan bahwa pengguna yang disimpan kemudian dapat ditemukan dengan
     * benar menggunakan method getUserById()
     */
    @Test
    fun testSaveUser() {
        val user = User().apply {
            id = 1
            name = "Rahmi Najla"
            email = "rahminajla@gmail.com"
            phone = "1234567890"
        }

        /**
         * Objek User baru dibuat, diisi dengan beberapa data, dan disimpan menggunakan method saveUser()
         */
        val result = userInstrumented.saveUser(user)
        assertEquals(true, result)

        /**
         * Objek User yang baru dibuat ditemukan kembali menggunakan getUserById() dan data pada objek
         * diperiksa untuk memastikan bahwa pengguna telah disimpan dengan benar
         */
        val savedUser = userInstrumented.getUserById(1)
        assertEquals(user.id, savedUser?.id)
        assertEquals(user.name, savedUser?.name)
        assertEquals(user.email, savedUser?.email)
        assertEquals(user.phone, savedUser?.phone)
    }
}