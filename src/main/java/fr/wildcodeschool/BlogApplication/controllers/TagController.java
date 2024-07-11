package fr.wildcodeschool.BlogApplication.controllers;


import fr.wildcodeschool.BlogApplication.models.Tag;
import fr.wildcodeschool.BlogApplication.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tags")
public class TagController {

    @Autowired
    private TagRepository tagRepository;

    //Methodes CRUD
    //Create
    @PostMapping
    public ResponseEntity<Tag> createTag(@RequestBody Tag tag) {
        Tag savedTag = tagRepository.save(tag);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTag);
    }
    //Read All
    @GetMapping()
    public ResponseEntity<List<Tag>> getAllTags() {
        List<Tag> tags = tagRepository.findAll();
        if (tags.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(tags);
    }
    //Read One
    @GetMapping("/{id}")
    public ResponseEntity<Tag> getTagById(@RequestParam Long id) {
       Tag tag = tagRepository.findById(id).orElse(null);
       if (tag == null) {
           return ResponseEntity.notFound().build();
       }
       return ResponseEntity.ok().body(tag);
    }
    //Update One
    @PutMapping("/{id}")
    public ResponseEntity<Tag> updateTag(@PathVariable Long id, @RequestBody Tag tagDetails) {
        Tag updatedTag = tagRepository.findById(id).orElse(null);
        if (updatedTag == null) {
            return ResponseEntity.notFound().build();
        }else {
            updatedTag.setName(tagDetails.getName());
            Tag updateTag = tagRepository.save(updatedTag);
            return ResponseEntity.ok().body(updateTag);
        }
    }
    //Delete One
    @DeleteMapping ("/{id}")
    public ResponseEntity<Tag> deleteTag(@PathVariable Long id) {
        Tag tag = tagRepository.findById(id).orElse(null);
        if (tag == null) {
            return ResponseEntity.notFound().build();
        }
        tagRepository.delete(tag);
        return ResponseEntity.noContent().build();
    }
}
