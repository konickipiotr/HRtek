package com.hrtek.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrtek.model.MyNote;

@Repository
public interface MyNoteRepository extends JpaRepository<MyNote, Long> {

}
