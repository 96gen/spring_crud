package com.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.domain.Student;

@Repository //數據倉庫
//JpaRepository包含CrudReposirory和PagingAndSortRepository
//因此可以進行基本的CRUD操作和排序
public interface StudentRepository extends JpaRepository<Student, Long>{

}
