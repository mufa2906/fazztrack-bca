package id.tokobukufarhan.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import id.tokobukufarhan.library.payloads.req.PublisherRequest;
import id.tokobukufarhan.library.payloads.res.ResponseHandler;
import id.tokobukufarhan.library.services.publisher.PublisherService;

@RestController
@RequestMapping("/admin/publishers")
public class PublisherController {
  @Autowired
  PublisherService publisherService;

  @PostMapping
  public ResponseEntity<?> createPublisher(@RequestBody PublisherRequest request) {
    try {
      return publisherService.addPublisherService(request);
    } catch (Exception e) {
      return ResponseHandler.responseError(500, e.getMessage(), null);
    }
  }

  @GetMapping
  public ResponseEntity<?> getPublishers() {
    try {
      return publisherService.getPublishersService();
    } catch (Exception e) {
      return ResponseHandler.responseError(500, e.getMessage(), null);
    }
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getPublisherById(@PathVariable String id) {
    try {
      return publisherService.getPublisherByIdService(id);
    } catch (Exception e) {
      return ResponseHandler.responseError(500, e.getMessage(), null);
    }
  }
  
    @GetMapping("/")
    public ResponseEntity<?> getPublisherByName(@RequestParam String name) {
      try {
        return publisherService.getPublisherByNameService(name);
      } catch (Exception e) {
        return ResponseHandler.responseError(500, e.getMessage(), null);
      }
    }
  
    @GetMapping("/deleted/{isDeleted}")
    public ResponseEntity<?> getPublisherByIsDeleted(@PathVariable Boolean isDeleted) {
      try {
        return publisherService.getPublisherByIsDeletedService(isDeleted);
      } catch (Exception e) {
        return ResponseHandler.responseError(500, e.getMessage(), null);
      }
    }
  
  @PutMapping("/{id}")
  public ResponseEntity<?> updatePublisherById(@PathVariable String id, @RequestBody PublisherRequest request) {
    try {
      return publisherService.updatePublisherByIdService(id, request);
    } catch (Exception e) {
      return ResponseHandler.responseError(500, e.getMessage(), null);
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deletePublisherById(@PathVariable String id) {
    try {
      return publisherService.deletePublisherByIdService(id);
    } catch (Exception e) {
      return ResponseHandler.responseError(500, e.getMessage(), null);
    }
  }

}
