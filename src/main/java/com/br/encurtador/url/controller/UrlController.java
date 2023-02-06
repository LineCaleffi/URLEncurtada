package com.br.encurtador.url.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.ValidationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.encurtador.url.entity.UrlEntity;
import com.br.encurtador.url.service.UrlService;

import lombok.RequiredArgsConstructor;

@RequestMapping("url")
@RestController
@RequiredArgsConstructor
public class UrlController {

	private final UrlService urlService;

	@GetMapping
	public ResponseEntity<List<UrlEntity>> getAll() {
		return ResponseEntity.ok().body(urlService.getAll());
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		urlService.delete(id);
	}

	@PostMapping
	public ResponseEntity<UrlEntity> save(@RequestBody UrlEntity urlPostRequest) throws Exception {
		//ValidationException -> valida a Exception, senão apresenta erro do servidor 
		try {
			return new ResponseEntity<>(urlService.saveUrl(urlPostRequest), HttpStatus.CREATED);
		} catch (ValidationException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR); 
		}
	}

	@GetMapping(path = "/{newUrl}")
	public void findByNewUrl(@PathVariable String newUrl, HttpServletResponse httpServletResponse) {
		List<UrlEntity> list = urlService.findByNewUrl(newUrl);
		httpServletResponse.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY); // Define o código de status para esta resposta.
		httpServletResponse.setHeader("Location", list.get(0).getUrl()); // Define um cabeçalho de resposta com o nome e o valor fornecidos
		httpServletResponse.setHeader("Connection", "close");
	}
}
