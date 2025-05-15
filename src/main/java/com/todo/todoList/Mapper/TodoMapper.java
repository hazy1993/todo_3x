package com.todo.todoList.Mapper;

import com.todo.todoList.vo.Todos;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TodoMapper {

    void createTodos(Todos todos);

    List<Todos> getAllTodos();

    Todos getTodosById(long id);

    int updateTodo(Todos todo);

    int deleteTodos(long id);

    List<Todos> searchTodos(Todos todos);

}
