package at.htl.todo.ui.layout

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rxjava3.subscribeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import at.htl.todo.model.ToDo
import at.htl.todo.model.ToDoModel
import at.htl.todo.model.ToDoViewModel
import at.htl.todo.ui.theme.ToDoTheme

@Composable
fun ToDoList(todos: List<ToDo>, modifier: Modifier = Modifier) {
    LazyColumn {
        items(todos.size) {index ->
            Text(todos[index].title)
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val todos = listOf(ToDo(0, 0, "hallo", false))
    ToDoTheme {
        ToDoList(todos)
    }
}
fun composeMain(
    view: ComposeView,
    viewModel: ToDoViewModel
) {
    view.setContent {
        var model = viewModel.store.subscribeAsState(initial = ToDoModel())
        ToDoTheme {
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                var value = model.value
                var todos = value.todos
                var size = todos.size
                ToDoList(todos)
            }
        }
    }

}