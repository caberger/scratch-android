package at.htl.todo.service;

import java.util.List;

import at.htl.todo.model.ToDo;
import at.htl.todo.model.ToDoModel;
import at.htl.todo.util.Mapper;
import at.htl.todo.util.RetrofitAdapter;
import io.reactivex.rxjava3.subjects.BehaviorSubject;
import io.reactivex.rxjava3.subjects.Subject;
import retrofit2.converter.gson.GsonConverterFactory;

public class ToDoService {
    public static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    private static final String TAG = ToDoService.class.getName();
    final private ToDoResource api;
    final private BehaviorSubject<ToDoModel> store;

    public ToDoService(BehaviorSubject<ToDoModel> store) {
        this.store = store;
        var retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(ToDoResource.class);
    }
    public void loadAll() {
        new RetrofitAdapter<ToDo[]>().enqueue(api.loadAll(), todos -> {
            var mapper = new Mapper<>(ToDoModel.class);
            var model = mapper.clone(store.getValue());
            model.todos = List.of(todos);
            store.onNext(model);
        });
    }
}
