package com.todo.todoList.controller;


import com.todo.todoList.service.TodosService;
import com.todo.todoList.vo.Todos;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodosController {

    private final TodosService todosService;

    public TodosController(TodosService todosService) {
        this.todosService = todosService;
    }


    // 1. POST /todos - 새로운 할 일 생성
    @PostMapping
    public ResponseEntity<Todos> createTodos(HttpServletRequest request, @RequestBody Todos todo) {
        todosService.createTodos(todo);
        return new ResponseEntity<>(todo, HttpStatus.CREATED);
    }

    // 2. GET /todos - 모든 할 일 조회
    @GetMapping
    public ResponseEntity<List<Todos>> getAllTodos() {
        List<Todos> todos = todosService.getAllTodos();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    // 3. GET /todos/{id} - 특정 할 일 조회
    @GetMapping("/{id}")
    public ResponseEntity<Todos> getTodosById(@PathVariable Long id) {
        Todos todo = todosService.getTodosById(id);
        return new ResponseEntity<>(todo, HttpStatus.OK);
    }

    // 4. PUT /todos/{id} - 특정 할 일 수정
    @PutMapping("/{id}")
    public ResponseEntity<?> updateTodo(@PathVariable Long id, @RequestBody Todos todo) {

        todo.setId(id);
        int result = todosService.updateTodo(todo);
        if(result > 0){
            return new ResponseEntity<>(todo,HttpStatus.OK);
        }else{

            return new ResponseEntity<>("수정에 실패하였습니다.",HttpStatus.OK);
        }
    }

    // 5. DELETE /todos/{id} - 특정 할 일 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodos(@PathVariable Long id) {

        try {
            todosService.deleteTodos(id);
            return new ResponseEntity<>("삭제되었습니다.",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("삭제에실패하였습니다.",HttpStatus.BAD_REQUEST);
        }

    }

    // 6. GET /todos/search - 할 일 검색
    @GetMapping("/search")
    public ResponseEntity<?> searchTodos(@RequestParam(required = false ,defaultValue = "") String title,
                                                   @RequestParam(required = false,defaultValue = "") String content) {

        if(("").equals(title) && ("").equals(content)){
            return new ResponseEntity<>("검색어를 입력해주세요", HttpStatus.OK);
        }

        Todos keyword = new Todos(title,content);

        try {
            List<Todos> todos = todosService.searchTodos(keyword);
            return new ResponseEntity<>(todos, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

}
