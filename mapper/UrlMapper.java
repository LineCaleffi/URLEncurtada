package com.br.encurtador.url.mapper;

import com.br.encurtador.url.entity.UrlEntity;
import com.br.encurtador.url.request.UrlPostRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class UrlMapper {

    public static final UrlMapper INSTANCE = Mappers.getMapper(UrlMapper.class);

    public abstract UrlEntity toUrl (UrlPostRequest urlPostRequest);
}
