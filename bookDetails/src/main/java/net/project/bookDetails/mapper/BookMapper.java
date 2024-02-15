package net.project.bookDetails.mapper;


import net.project.bookDetails.dto.BookDto;
import net.project.bookDetails.entity.Book;


public class BookMapper {

    public static BookDto mapToBookDto(Book book) {
        return new BookDto(
                book.getId(),
                book.getBookName(),
                book.getAuthor(),
                book.getEmail()
        );
    }

    public static Book mapToBook(BookDto bookDto){
        return new Book(
                bookDto.getId(),
                bookDto.getBookName(),
                bookDto.getAuthor(),
                bookDto.getEmail()
        );
    }
}
