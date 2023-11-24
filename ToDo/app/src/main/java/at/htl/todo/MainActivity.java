package at.htl.todo;

import android.os.Bundle;

import androidx.activity.ComponentActivity;
import androidx.compose.ui.platform.ComposeView;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import at.htl.todo.model.ToDoViewModel;
import at.htl.todo.service.ToDoService;
import at.htl.todo.ui.layout.MainViewKt;

public class MainActivity extends ComponentActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        var view = new ComposeView(this);
        var viewModel = new ViewModelProvider(this).get(ToDoViewModel.class);
        MainViewKt.composeMain(view, viewModel);
        setContentView(view);
        var service = new ToDoService(viewModel.getStore());
        service.loadAll();
    }
}

