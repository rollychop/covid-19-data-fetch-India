package utils

import data.Constants
import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object Utils {

    fun getCurrentDate(): String {
        val current = LocalDateTime.now()
        val mDateFormat = DateTimeFormatter.ofPattern("dd_MM_yyyy")
        return current.format(mDateFormat)
    }

    fun getCurrentTime(): String {
        val current = LocalDateTime.now()
        val mTimeFormat = DateTimeFormatter.ofPattern("HH:mm:ss")
        return current.format(mTimeFormat)
    }
    fun createFile(fileName: String): String? {
        return try {
            val myObj = File(Constants.PATH + fileName)
            if (myObj.createNewFile()) {
                "File created: " + myObj.name
            } else {
                "File already exists."
            }
        } catch (e: IOException) {
            e.printStackTrace()
            e.message
        }
    }

    fun writeToFile(fileName: String, body: String): String? {
        return try {
            val myWriter = FileWriter(Constants.PATH + fileName)
            myWriter.write(body)
            myWriter.close()
            "Successfully wrote to the file."
        } catch (e: IOException) {
            e.printStackTrace()
            e.message
        }
    }
}