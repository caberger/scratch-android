package at.htl.todo.model;

public record ToDo(
    int userId,
    Integer id,
    String title,
    boolean completed
)
{
}
