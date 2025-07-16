package com.example.jetpackcomposepractice.todoApp.datamanager

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.jetpackcomposepractice.todoApp.model.Todo
import java.time.Instant
import java.util.Date

object TodoManager {
    private val todolist= mutableListOf<Todo>()

    fun getAllTodo():List<Todo>{
        return todolist
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun addTodo(title:String){
        todolist.add(Todo(System.currentTimeMillis().toInt(),title, Date.from(Instant.now())))

    }

    fun deleteTodo(id:Int){
        todolist.removeIf {
            it.id==id
        }

    }
}