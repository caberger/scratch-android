package at.htl.todo;

import android.os.Bundle;

import androidx.activity.ComponentActivity;
import androidx.compose.ui.platform.ComposeView;

import at.htl.todo.ui.layout.MainViewKt;

public class MainActivity extends ComponentActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        var view = new ComposeView(this);
        MainViewKt.composeMain(view);
        setContentView(view);
    }
}

