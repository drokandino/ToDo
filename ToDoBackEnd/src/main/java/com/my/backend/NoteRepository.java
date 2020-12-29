package com.my.backend;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NoteRepository extends CrudRepository<Note, Long> {
    List<Note> findByUser(User user);
    Note findByNoteId(long noteId);
}
