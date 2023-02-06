package com.br.encurtador.url.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.xml.bind.ValidationException;

import org.springframework.stereotype.Service;

import com.br.encurtador.url.entity.UrlEntity;
import com.br.encurtador.url.repository.UrlRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UrlService {

	private final UrlRepository urlRepository;

	private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	public List<UrlEntity> getAll() {
		List<UrlEntity> lista = urlRepository.findAll();
		List<UrlEntity> listaDTO = new ArrayList<>();

		for (UrlEntity usuario : lista) {
			listaDTO.add(usuario);
		}

		return listaDTO;
	}

	public void delete(int id) {
		urlRepository.deleteById(id);
	}

	// SALT -> representa uma sequência de caractere para a URL Encurtada
	private String getSaltUrl() {
		String saltCaractere = "abcdefghijklmnopqrstuvwxyz1234567890";
		StringBuilder saltUrl = new StringBuilder();
		Random random = new Random();
		while (saltUrl.length() < 10) {
			int index = (int) (random.nextFloat() * saltCaractere.length());
			saltUrl.append(saltCaractere.charAt(index));
		}
		String saltStr = saltUrl.toString();
		return saltStr;
	}

	public UrlEntity saveUrl(UrlEntity urlSalva) throws Exception {

		if(urlSalva.getUrl() == null && urlSalva.getUrl() == "") {
			throw new ValidationException("Não foi possível salvar as informações. URL nula ou vazia!");
		}
		Date date = new Date();
		String formatDate = dateFormat.format(date);
		urlSalva.setDate(formatDate);
		urlSalva.setNewUrl(getSaltUrl());
		
//		if (urlSalva.getUrl() != null && urlSalva.getUrl() != "") {
//			urlSalva.setNewUrl(getSaltUrl());
//		} else {
//			throw new Exception("Não foi possível salvar as informações. URL nula ou vazia!");
//		}
		
		return urlRepository.save(urlSalva);
	}

	public List<UrlEntity> findByNewUrl(String newUrl){
		return urlRepository.findByNewUrl(newUrl);
	}
}
