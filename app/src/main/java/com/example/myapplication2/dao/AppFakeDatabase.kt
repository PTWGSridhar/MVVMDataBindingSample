package com.example.myapplication2.dao

class AppFakeDatabase private constructor() {
    val empFakeDao = AppDAO()

    companion object {
        @Volatile
        private var instance: AppFakeDatabase? = null

        fun getInstance() = instance ?: synchronized(this) {
            instance ?: AppFakeDatabase().also { instance = it }
        }
    }

}