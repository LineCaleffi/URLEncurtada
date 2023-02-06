package com.br.encurtador.url.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.encurtador.url.entity.UrlEntity;

import java.util.List;

public interface UrlRepository extends JpaRepository<UrlEntity, Integer> {

	List<UrlEntity> findByNewUrl(String newUrl);
}
