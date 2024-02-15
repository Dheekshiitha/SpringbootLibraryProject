package net.project.bookDetails.repository;

import net.project.bookDetails.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
