package com.example.demo.model;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@Entity
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @ManyToMany
  @JoinTable(
    name = "author_book", 
    joinColumns = @JoinColumn,
    inverseJoinColumns = @JoinColumn(name = "author_id")
  )
  private Set<Author> authors;

  private String title;
  private String isbn;
  private String publisher;

  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Book)) {
            return false;
        }
        Book book = (Book) o;
        return Objects.equals(id, book.id);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", authors='" + getAuthors() + "'" +
      ", title='" + getTitle() + "'" +
      ", isbn='" + getIsbn() + "'" +
      ", publisher='" + getPublisher() + "'" +
      "}";
  }

  
}