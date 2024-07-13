package org.example.pdp22;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    // Create - Add a new genre
    public Genre saveGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    // Read - Find a genre by ID
    public Genre findGenreById(UUID id) {
        return genreRepository.findById(id).orElse(null);
    }

    // Read - Get all genres
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    // Update - Update an existing genre
    public void updateGenre(UUID id, Genre updatedGenre) {
        genreRepository.findById(id)
                .map(genre -> {
                    genre.setName(updatedGenre.getName());
                    return genreRepository.save(genre);
                });
    }

    // Delete - Delete a genre by ID
    public void deleteGenre(UUID id) {
        genreRepository.deleteById(id);
    }
}
