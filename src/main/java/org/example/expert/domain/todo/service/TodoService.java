package org.example.expert.domain.todo.service;

import org.example.expert.domain.common.dto.AuthUser;
import org.example.expert.domain.todo.dto.request.TodoSaveRequest;
import org.example.expert.domain.todo.dto.response.TodoResponse;
import org.example.expert.domain.todo.dto.response.TodoSaveResponse;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;


public interface TodoService {

  TodoSaveResponse saveTodo(AuthUser authUser, TodoSaveRequest todoSaveRequest);
  Page<TodoResponse> getTodos(int page, int size, String weather, LocalDateTime start, LocalDateTime end);
  TodoResponse getTodo(long todoId);
}
