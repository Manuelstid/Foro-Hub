package service;

import com.pardo.foro.hub.model.Topic;
import com.pardo.foro.hub.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public Topic createTopic(Topic topic) {
        topic.setCreationDate(LocalDateTime.now());
        return topicRepository.save(topic);
    }

    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    public Optional<Topic> getTopicById(Long id) {
        return topicRepository.findById(id);
    }

    public Topic updateTopic(Long id, Topic newTopic) {
        return topicRepository.findById(id).map(topic -> {
            topic.setTitle(newTopic.getTitle());
            topic.setMessage(newTopic.getMessage());
            topic.setStatus(newTopic.getStatus());
            topic.setAuthor(newTopic.getAuthor());
            topic.setCourse(newTopic.getCourse());
            return topicRepository.save(topic);
        }).orElseGet(() -> {
            newTopic.setId(id);
            return topicRepository.save(newTopic);
        });
    }

    public void deleteTopic(Long id) {
        topicRepository.deleteById(id);
    }
}

