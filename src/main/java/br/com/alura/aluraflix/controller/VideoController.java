package br.com.alura.aluraflix.controller;

import br.com.alura.aluraflix.entity.Videos;
import br.com.alura.aluraflix.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class VideoController {

    @Autowired
    private VideoRepository videoRepository;

    @RequestMapping(value = "/videos", method = RequestMethod.GET)
    public List<Videos> Get(){
        return videoRepository.findAll();
    }

    @RequestMapping(value = "/videos/{id}", method = RequestMethod.GET)
    public ResponseEntity<Videos> GetById(@PathVariable(value = "id") Integer id) {

        Optional<Videos> videos = videoRepository.findById(id);
            if (videos.isPresent()){
                return new ResponseEntity<Videos>(videos.get(),HttpStatus.OK);
            }else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
    }
}
