package id.tokobukufarhan.library.services.publisher;

import org.springframework.http.ResponseEntity;

import id.tokobukufarhan.library.payloads.req.PublisherRequest;

public interface PublisherService {
  ResponseEntity<?> addPublisherService(PublisherRequest request);

  ResponseEntity<?> getPublishersService();

  ResponseEntity<?> getPublisherByIdService(String id);
  
  ResponseEntity<?> updatePublisherByIdService(String id, PublisherRequest request);
  
  ResponseEntity<?> deletePublisherByIdService(String id);

  ResponseEntity<?> getPublisherByNameService(String name);

  ResponseEntity<?> getPublisherByIsDeletedService(Boolean isDeleted);
}
