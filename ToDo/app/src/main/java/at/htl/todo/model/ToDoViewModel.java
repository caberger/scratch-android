package at.htl.todo.model;

import androidx.lifecycle.ViewModel;

import io.reactivex.rxjava3.subjects.BehaviorSubject;

public class ToDoViewModel extends ViewModel {
    private BehaviorSubject<ToDoModel> store = BehaviorSubject.createDefault(new ToDoModel());

    public BehaviorSubject<ToDoModel> getStore() {
        return store;
    }
}
