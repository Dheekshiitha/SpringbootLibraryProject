package net.project.bookDetails.service;

import net.project.bookDetails.dto.BookDto;

import java.util.List;

public interface BookService {
    BookDto createBook(BookDto bookDto);

    BookDto getBookById(Long bookId);

    List<BookDto> getAllBooks();

    BookDto updateBook(Long bookId, BookDto updatedBook);

    void deleteBook(Long bookId);
}
