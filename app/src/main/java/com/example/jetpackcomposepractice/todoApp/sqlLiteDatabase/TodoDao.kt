package com.example.jetpackcomposepractice.todoApp.sqlLiteDatabase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.jetpackcomposepractice.todoApp.model.Todo

@Dao
interface TodoDao {

    @Query("SELECT * from Todo ORDER BY createdAt DESC")
    fun getAllTodo(): LiveData<List<Todo>>

    @Insert
    fun addTodo(todo: Todo)

    @Query("Delete FROM Todo where id=:id")
    fun deleteTodo(id: Int)
}