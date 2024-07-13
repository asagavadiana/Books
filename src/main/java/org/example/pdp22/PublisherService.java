package org.example.pdp22;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    public Publisher getPublisherById(Long id) {
        return publisherRepository.findById(id).orElse(null);
    }

    public Publisher savePublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    public void deletePublisher(Long id) {
        publisherRepository.deleteById(id);
    }
}
