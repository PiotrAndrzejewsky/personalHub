package com.Itransition.personalHub.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class CollectionController {

    @Autowired
    private CollectionServiceImpl mCollectionService;

    @GetMapping("/collection/{id}")
    public CollectionEntity getCollection(@PathVariable Long id) {
        return mCollectionService.getCollection(id);
    }

    @GetMapping("/collection/topic/{id}")
    public String getTopicByTopicId(@PathVariable Long id) {
        return mCollectionService.getTopicByTopicId(id);
    }

    @GetMapping("/collection/topic/all")
    public List<String> getAllTopics() {
        return mCollectionService.getAllTopics();
    }

    @GetMapping("/collection/likes/{id}")
    public int getLikesById(@PathVariable Long id) {
        return mCollectionService.getLikes(id);
    }

    @GetMapping("/collections/{userId}")
    public List<CollectionEntity> getAllCollectionsById(@PathVariable Long userId) {
        return mCollectionService.getAllCollectionsById(userId);
    }

    @PostMapping("/collection")
    public ResponseEntity<Boolean> createCollection(@RequestBody CollectionEntity collectionEntity) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().toUriString());
        return ResponseEntity.created(uri).body(mCollectionService.createCollection(collectionEntity));
    }

    @PostMapping("/collection/topic")
    public ResponseEntity<Boolean> createNewTopic(@RequestBody String topic) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/topic").toUriString());
        return ResponseEntity.created(uri).body(mCollectionService.createNewTopic(topic));
    }

    @PostMapping("/collection/likes/update/{id}")
    public void updateLikes(@RequestBody int amount, @PathVariable Long id) {
        mCollectionService.updateLikes(id, amount);
    }

    @PutMapping("/collection/update/{id}")
    public void updateUser(@RequestBody CollectionEntity collectionEntity, @PathVariable Long id) {
        mCollectionService.updateCollection(collectionEntity, id);
    }

    @DeleteMapping("/collection/delete/{id}")
    public void deleteCollection(@PathVariable Long id) {
        mCollectionService.deleteCollection(id);
    }
}
