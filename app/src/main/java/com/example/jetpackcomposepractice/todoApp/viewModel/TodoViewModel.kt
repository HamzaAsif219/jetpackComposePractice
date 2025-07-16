package com.example.jetpackcomposepractice.todoApp.viewModel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcomposepractice.quoteApp.dataManager.DataManager
import com.example.jetpackcomposepractice.todoApp.MainApplication
import com.example.jetpackcomposepractice.todoApp.datamanager.TodoManager
import com.example.jetpackcomposepractice.todoApp.model.Todo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.Instant
import java.util.Date

class TodoViewModel:ViewModel() {
//    private val _todoList =MutableLiveData<List<Todo>>()

//    var todoList : LiveData<List<Todo>> = _todoList
    val todoDao = MainApplication.todoDatabase.getTodoDao()
    var todoList : LiveData<List<Todo>> = todoDao.getAllTodo()

//    fun getAllTodo(){
//        _todoList.value = TodoManager.getAllTodo().reversed()
//    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun addTodo(title:String){
        viewModelScope.launch(Dispatchers.IO) {
            todoDao.addTodo(Todo(title=title, createdAt = Date.from(Instant.now())))
        }
//        TodoManager.addTodo(title)
//        getAllTodo()

    }

    fun deleteTodo(id:Int){
        viewModelScope.launch(Dispatchers.IO) {
            todoDao.deleteTodo(id)
        }
//        TodoManager.deleteTodo(id)
//        getAllTodo()

    }
}