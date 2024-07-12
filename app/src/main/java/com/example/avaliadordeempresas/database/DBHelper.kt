package com.example.avaliadordeempresas.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) : SQLiteOpenHelper(context, "perguntas.db", null, 1) {

    val sql = arrayOf(
        "CREATE TABLE questions (id INTEGER PRIMARY KEY AUTOINCREMENT, question TEXT)",
        "INSERT INTO questions (question) VALUES ('Empresa com lucro nos últimos 20 trimestres (5 anos)')",
        "INSERT INTO questions (question) VALUES ('Empresa com lucro nos últimos 40 trimestres (10 anos)')",
        "INSERT INTO questions (question) VALUES ('Empresa nunca deu prejuízo (ano fiscal)')",
        "INSERT INTO questions (question) VALUES ('Empresa apresentou crescimento de lucros nos últimos 5 anos')",
        "INSERT INTO questions (question) VALUES ('Empresa apresentou crescimento de receita nos últimos 5 anos')",
        "INSERT INTO questions (question) VALUES ('Empresa possui ROE acima de 10%')",
        "INSERT INTO questions (question) VALUES ('Margem de lucro acima de 15%?')",
        "INSERT INTO questions (question) VALUES ('Empresa possui liquidez diária acima de R$ 2M NAS ON'S')",
        "INSERT INTO questions (question) VALUES ('Empresa pagou +5% de dividendos/ano nos últimos 5 anos')",
        "INSERT INTO questions (question) VALUES ('Empresa possui dívida menor que patrimônio')"
    )

    override fun onCreate(db: SQLiteDatabase) {
        sql.forEach {
            db.execSQL(it)
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun insertQuestion(question: String): Long {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put("question", question)
        val res = db.insert("questions", null, contentValues)
        db.close()
        return res
    }

    fun updateQuestion(id: Int, question: String): Int {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put("question", question)
        val res = db.update("questions", contentValues, "id=?", arrayOf(id.toString()))
        db.close()
        return res
    }

    fun deleteQuestion(id: Int): Int {
        val db = this.writableDatabase
        val res = db.delete("questions", "id=?", arrayOf(id.toString()))
        db.close()
        return res
    }
}