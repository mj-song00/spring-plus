package org.example.expert.domain.todo.repository;

import org.example.expert.domain.todo.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    @Query("SELECT t FROM Todo t LEFT JOIN FETCH t.user u WHERE (:weather is null or t.weather = :weather) and (:start is null or t.createdAt >= :start ) and (:end is null or t.modifiedAt <= :end)  ORDER BY t.modifiedAt DESC")
    Page<Todo> findAllByOrderByModifiedAtDesc(
            Pageable pageable,
            @Param("weather") String weather,
            @Param("start")  @DateTimeFormat(pattern ="yyyy-MM-dd'T'HH:mm:ss.SSSXXX") LocalDateTime start,
            @Param("modify") @DateTimeFormat(pattern ="yyyy-MM-dd'T'HH:mm:ss.SSSXXX") LocalDateTime end);

    @Query("SELECT t FROM Todo t " +
            "LEFT JOIN t.user " +
            "WHERE t.id = :todoId")
    Optional<Todo> findByIdWithUser(@Param("todoId") Long todoId);
}
