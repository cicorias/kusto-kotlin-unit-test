package me.reference.kotlintesting

import java.io.FileInputStream
import java.util.*

class PropertyLoader {
    fun fromFile(fileName: String) : Properties {
        val prop = Properties()
        FileInputStream(fileName).use {prop.load(it)}
        return prop
    }
}