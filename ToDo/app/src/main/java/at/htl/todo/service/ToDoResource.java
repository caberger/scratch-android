package at.htl.todo.service;

import at.htl.todo.model.ToDo;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ToDoResource {
    @GET("todos")
    Call<ToDo[]> loadAll();
}
