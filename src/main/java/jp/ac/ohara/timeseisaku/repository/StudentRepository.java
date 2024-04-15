package jp.ac.ohara.timeseisaku.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.ac.ohara.timeseisaku.model.StudentHyou;


@Repository
public interface StudentRepository  extends JpaRepository<StudentHyou, Long>{

	}

