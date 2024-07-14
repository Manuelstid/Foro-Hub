
package controller;

import com.pardo.foro.hub.model.Topic;
import com.pardo.foro.hub.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/topics")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @PostMapping
    public Topic createTopic(@RequestBody Topic topic) {
        return topicService.createTopic(topic);
    }

    @GetMapping
    public List<Topic> getAllTopics() {
        return topicService.getAllTopics();
    }

    @GetMapping("/{id}")
    public Topic getTopicById(@PathVariable Long id) {
        return topicService.getTopicById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Topic updateTopic(@PathVariable Long id, @RequestBody Topic newTopic) {
        return topicService.updateTopic(id, newTopic);
    }

    @DeleteMapping("/{id}")
    public void deleteTopic(@PathVariable Long id) {
        topicService.deleteTopic(id);
    }
}
