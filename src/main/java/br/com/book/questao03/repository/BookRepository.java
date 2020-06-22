package br.com.book.questao03.repository;

import br.com.book.questao03.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository <Book, Long> {
    List<Book> findByBookname(String nameBook);

    void delete(Long id);
}
