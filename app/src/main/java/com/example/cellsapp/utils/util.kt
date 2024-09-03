package com.example.dogapp.utils

fun String.capitaliseFirst(): String {
    return replaceFirstChar {
        if (it.isLowerCase())
            it.uppercase()
        else it.toString()
    }
}