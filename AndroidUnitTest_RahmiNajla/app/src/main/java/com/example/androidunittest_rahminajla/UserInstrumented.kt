package com.example.androidunittest_rahminajla


/**
 * Class User merepresentasikan data user yang memiliki beberapa properti seperti id, name, email, dan phone
 */
class User{
    var id: Int = 0
    var name: String? = null
    var email: String? = null
    var phone: String? = null
}

/**
 * Interface UserRepository adalah sebuah abstraksi untuk mengakses data dari berbagai sumber seperti database atau web service
 */
interface UserRepository {
    fun getUsers(): List<User>
    fun getUserById(id: Int): User?
    fun saveUser(user: User): Boolean
}

/**
 * UserInstrumented adalah sebuah class yang mengimplementasikan interface tersebut
 * dengan menggunakan List sederhana sebagai sumber data. class UserInstrumented memiliki sumber
 * data berupa userList, yaitu sebuah List mutable yang berisi semua user yang telah disimpan.
 */
class UserInstrumented : UserRepository {

    private val userList = mutableListOf<User>()

    /**
     * Fungsi getUsers() mengembalikan list dari semua user yang tersimpan
     * Fungsi getUsers() mengambil data dari userList
     */
    override fun getUsers(): List<User> {
        return userList
    }

    /**
     * Fungsi getUserById(id: Int) mengembalikan user dengan id yang sesuai atau null jika user tidak ditemukan
     * Fungsi getUserById(id: Int) mengambil data dari userList
     */
    override fun getUserById(id: Int): User? {
        for (user in userList) {
            if (user.id == id) {
                return user
            }
        }
        return null
    }

    /**
     * Fungsi saveUser(user: User) menyimpan user baru ke sumber data dan mengembalikan true jika operasi berhasil
     * dan false jika user dengan id yang sama sudah ada
     * Fungsi saveUser(user: User) menambahkan user baru ke dalam userList jika user belum ada dan mengembalikan nilai true,
     * jika sudah ada maka tidak ada user yang ditambahkan dan mengembalikan nilai false
     */
    override fun saveUser(user: User): Boolean {
        for (existingUser in userList) {
            if (existingUser.id == user.id) {
                return false
            }
        }
        userList.add(user)
        return true
    }
}

