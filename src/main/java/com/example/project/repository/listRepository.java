package com.example.project.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import com.example.project.model.list;
import java.util.List;
@Repository
public interface listRepository extends JpaRepository<list, Long> {

}
