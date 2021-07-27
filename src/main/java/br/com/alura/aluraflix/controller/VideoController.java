package br.com.alura.aluraflix.controller;

import br.com.alura.aluraflix.entity.Videos;
import br.com.alura.aluraflix.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class VideoController {

    @Autowired
    VideoRepository videoRepository;

    //Buscando todos os videos com tratamento.

    @GetMapping("/videos")
    public ResponseEntity<List<Videos>> getAllVideos(){
        List<Videos> videosList = videoRepository.findAll();
        if (videosList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<List<Videos>>(videosList, HttpStatus.OK);
        }
    }

    //Buscando um unico video, com retorno 404, caso video não encontrado.

    @GetMapping("/videos/{id}")
    public Optional<Videos> buscaUnicoVideo(@PathVariable(value = "id")Integer id){
        return videoRepository.findById(id);
    }

    //Inserindo um novo video.
    @PostMapping("/videos")
    public ResponseEntity<Videos> InserindoUmNovoVideo(@Validated @RequestBody Videos videos){
        return new ResponseEntity<Videos>(videoRepository.save(videos), HttpStatus.CREATED);
    }

    //Deletando um Video.
    @DeleteMapping("/videos/{id}")
    public ResponseEntity<?> deletarUmVideo(@PathVariable(value = "id")Integer id){
        Optional<Videos> videos = videoRepository.findById(id);
        if(!videos.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            videoRepository.delete(videos.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }

    }

    //Atualixa Video.
    @PutMapping("/videos/{id}")
    @Transactional
    public ResponseEntity<Videos> AtualizaVideo(@PathVariable(value = "id")Integer id, @RequestBody @Validated Videos videos){
        Optional<Videos> videoS = videoRepository.findById(id);
        if (videoS.isPresent()){
            videos.setId(videoS.get().getId());
            return new ResponseEntity<Videos>(videoRepository.save(videos), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

    }









   /* @Autowired
    private final VideoRepository videoRepository;


    public VideoController(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @RequestMapping(value = "/videos", method = RequestMethod.GET)

    public List<Videos> Get(){
        return videoRepository.findAll();
    }

    @RequestMapping(value = "/videos/{id}", method = RequestMethod.GET)
    public ResponseEntity<Videos> GetById(@PathVariable(value = "id") Integer id) {

        Optional<Videos> videos = videoRepository.findById(id);
        return videos.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/videos", method = RequestMethod.POST)
    public Videos Post(@Validated @RequestBody Videos videos){
        return videoRepository.save(videos);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<Videos> Put(@PathVariable(value = "id")Integer id, @Validated @RequestBody Videos newVideos){

        Optional<Videos> oldVideos = videoRepository.findById(id);
        if (oldVideos.isPresent()){
            Videos videos = oldVideos.get();
            videos.setTitulo(oldVideos.);
            videos.setDescricao(newVideos.getDescricao());
            videos.setUrl(newVideos.getUrl());
            videoRepository.save(videos);
            return new ResponseEntity<Videos>(videos, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(value = "{id}")
    public ResponseEntity<Object> Delete(@PathVariable(value = "{id}") Integer id){
        Optional<Videos> videos = videoRepository.findById(id);
        if (videos.isPresent()){
            videoRepository.delete(videos.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }*/


}
