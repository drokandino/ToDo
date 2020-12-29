package com.my.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.desktop.ScreenSleepEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class NoteController {

    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private UserRepository userRepository;

    public NoteController (NoteRepository nr){this.noteRepository = nr;}

    @GetMapping("/notes/{user}")
    List<Note> notes(@PathVariable String user){
        List<Note> notes = new ArrayList<Note>();
        User korisnik = userRepository.findByName(user);

        return noteRepository.findByUser(korisnik);
        //System.out.println(notes);
    }

    @PatchMapping("/changeDone/{noteId}/{done}")
    void changeDone(@PathVariable long noteId, @PathVariable boolean done){
        Note note = noteRepository.findByNoteId(noteId);
        note.setDone(done);
        noteRepository.save(note);
    }

    @DeleteMapping("/deleteNote/{noteId}")
    void deleteNote(@PathVariable long noteId){
        noteRepository.deleteById(noteId);
    }

    @GetMapping("/note")
    List<Note> todo(){
        List<Note> note;

        note = (List<Note>) noteRepository.findAll();
        return  note;
    }

    @GetMapping("/users")
    List<User> users(){return (List<User>) userRepository.findAll();}

    @PostMapping("/addNote")
    void addNote(@RequestBody Note note){
        User user = userRepository.findByName(note.getUserName());
        System.out.println(user.getId());
        note.setUserId(user.getId());
        note.setDone(false);
        System.out.println(note.toString());
        noteRepository.save(note);
    }


}
