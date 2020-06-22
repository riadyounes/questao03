package br.com.book.questao03.controller;


import br.com.book.questao03.model.Book;
import br.com.book.questao03.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

        @Autowired
        private BookRepository bookRepository;

    @GetMapping
    public ResponseEntity<List<Book>> findAll(@RequestParam(required = false) String name) {
        if (name == null) {
            return ResponseEntity.ok(bookRepository.findAll());
        }
        return ResponseEntity.ok(bookRepository.findByBookname(name));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Book>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(bookRepository.findById(id));
    }

    @PostMapping
    public ResponseEntity<Book> save(@Valid @RequestBody Book book) {
        return ResponseEntity.ok(bookRepository.save(book));
    }
    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        bookRepository.delete(id);
        return ResponseEntity.ok(null);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Book> converter(@RequestBody Book book) {
        return ResponseEntity.ok(bookRepository.converter(book));
    }
}
