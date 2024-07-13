package org.example.pdp22;

import jakarta.persistence.*;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;
	private String author;

	@ManyToOne
	@JoinColumn(name = "genre_id")
	private Genre genre;

	@ManyToOne
	@JoinColumn(name = "publisher_id")
	private Publisher publisher;

	// constructors, getters, setters
}
