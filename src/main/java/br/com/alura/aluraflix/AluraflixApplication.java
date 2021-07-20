package br.com.alura.aluraflix;

import br.com.alura.aluraflix.orm.Videos;
import br.com.alura.aluraflix.repository.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AluraflixApplication implements CommandLineRunner {

	private final VideoRepository repository;

	public AluraflixApplication(VideoRepository repository) {
		this.repository = repository;
	}

	public static void main(String[] args) {
		SpringApplication.run(AluraflixApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Videos videos = new Videos();
		videos.setDescricao("Viagem");
		videos.setTitulo("Comidas tipicas de Salvador");
		videos.setUrl("https://www.youtube.com/watch?v=Tg4bak7IwAc");

		repository.save(videos);
	}
}
