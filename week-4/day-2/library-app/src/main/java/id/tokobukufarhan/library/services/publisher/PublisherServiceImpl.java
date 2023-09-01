package id.tokobukufarhan.library.services.publisher;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import id.tokobukufarhan.library.models.Publisher;
import id.tokobukufarhan.library.payloads.req.PublisherRequest;
import id.tokobukufarhan.library.payloads.res.ResponseHandler;
import id.tokobukufarhan.library.repositories.PublisherRepository;

@Service
public class PublisherServiceImpl implements PublisherService {
  @Autowired
  PublisherRepository publisherRepository;

  @Override
  public ResponseEntity<?> addPublisherService(PublisherRequest request) {
    if (request.getName() == null || request.getName() == "") {
      throw new IllegalArgumentException("Name is required");
    }

    Publisher publisher = new Publisher(request.getName(), request.getAddress());

    publisherRepository.save(publisher);

    return ResponseHandler.responseData(HttpStatus.CREATED.value(), "Publisher successfully added!", publisher);
  }

  @Override
  public ResponseEntity<?> getPublishersService() {
    List<Publisher> publishers = publisherRepository.findAll();

    return ResponseHandler.responseData(HttpStatus.CREATED.value(), "getAll Publishers succesfully!", publishers);

  }

  @Override
  public ResponseEntity<?> getPublisherByIdService(String id) {
    if (!publisherRepository.existsById(id)) {
      throw new NoSuchElementException("id not found");
    }

    Publisher publisher = publisherRepository.findById(id).orElseThrow(() -> {
      throw new NoSuchElementException("id is not found");
    });

    return ResponseHandler.responseData(HttpStatus.CREATED.value(), "Publisher successfully find!", publisher);
  }

  @Override
  public ResponseEntity<?> updatePublisherByIdService(String id, PublisherRequest request) {
    Publisher publisher = publisherRepository.findById(id).orElseThrow(() -> {
      throw new NoSuchElementException("id is not found");
    });

    if (request.getName() != "") {
      publisher.setName(request.getName());
    }

    if (request.getAddress() != "") {
      publisher.setAddress(request.getAddress());
    }

    publisherRepository.save(publisher);

    return ResponseHandler.responseData(HttpStatus.CREATED.value(), "Publisher successfully update!", publisher);
  }

  @Override
  public ResponseEntity<?> deletePublisherByIdService(String id) {
    Publisher publisher = publisherRepository.findById(id).orElseThrow(() -> {
      throw new NoSuchElementException("id is not found");
    });

    publisher.setIsDeleted(true);
    publisherRepository.save(publisher);

    return ResponseHandler.responseData(200, "Publisher successfully deleted!", null);
  }

  @Override
  public ResponseEntity<?> getPublisherByNameService(String name) {
    List<Publisher> publishers = publisherRepository.getPublisherByLikeName(name);

    return ResponseHandler.responseData(HttpStatus.CREATED.value(), "Publisher successfully get by name!", publishers);
  }

  @Override
  public ResponseEntity<?> getPublisherByIsDeletedService(Boolean isDeleted) {
    List<Publisher> publishers = publisherRepository.findByIsDeleted(isDeleted);

    return ResponseHandler.responseData(HttpStatus.CREATED.value(), "Publisher successfully get by isDeleted!", publishers);
  }

}
