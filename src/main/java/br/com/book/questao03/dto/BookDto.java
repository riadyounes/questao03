package br.com.book.questao03.dto;

import br.com.book.questao03.model.Book;

import java.util.List;
import java.util.stream.Collectors;

public class BookDto {
    private Long id;
    private String name;
    private String isbn;

    public BookDto(Book book){
        this.id = book.getId();
        this.name = book.getName();
        this.isbn = book.getIsbn();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIsbn() {
        return isbn;
    }
    public static List<BookDto> converter(List<Book> books) {
        return books.stream().map(BookDto::new).collect(Collectors.toList());
    }
}
