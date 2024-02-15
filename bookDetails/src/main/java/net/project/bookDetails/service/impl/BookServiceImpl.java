package net.project.bookDetails.service.impl;

import lombok.AllArgsConstructor;
import net.project.bookDetails.dto.BookDto;
import net.project.bookDetails.entity.Book;
import net.project.bookDetails.exception.ResourceNotFoundException;
import net.project.bookDetails.mapper.BookMapper;
import net.project.bookDetails.repository.BookRepository;
import net.project.bookDetails.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;
    @Override
    public BookDto createBook(BookDto bookDto) {
        Book book = BookMapper.mapToBook(bookDto);
        Book savedBook = bookRepository.save(book);
        return BookMapper.mapToBookDto(savedBook);
    }

    @Override
    public BookDto getBookById(Long bookId) {
       Book book = bookRepository.findById(bookId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Book of the given id" +bookId+" does not exist"));
        return BookMapper.mapToBookDto(book);
    }

    @Override
    public List<BookDto> getAllBooks() {
       List<Book> books = bookRepository.findAll();
        return books.stream().map((book) -> BookMapper.mapToBookDto(book))
                .collect(Collectors.toList());
    }

    @Override
    public BookDto updateBook(Long bookId, BookDto updatedBook) {
       Book book = bookRepository.findById(bookId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(" Book does not exist with given id "+bookId));
       book.setBookName(updatedBook.getBookName());
       book.setAuthor(updatedBook.getAuthor());
       book.setEmail(updatedBook.getEmail());

      Book updatedBookObj = bookRepository.save(book);

        return BookMapper.mapToBookDto(updatedBookObj);
    }

    @Override
    public void deleteBook(Long bookId) {

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(" Book does not exist with given id "+bookId));
        bookRepository.deleteById(bookId);

    }
}
