package com.matuszew.data.common.mapper.tumblr;

import com.matuszew.data.common.mapper.post.RestPostMapper;
import com.matuszew.data.common.mapper.tublelog.RestTumbleLogMapper;
import com.matuszew.data.common.model.bo.Tumblr;
import com.matuszew.data.common.model.json.TumblrJson;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * Created by matuszewski on 26/04/2017.
 */

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        uses = {
                RestPostMapper.class,
                RestTumbleLogMapper.class
        })
public interface RestTumblrMapper {

    RestTumblrMapper INSTANCE = Mappers.getMapper(RestTumblrMapper.class);

    Tumblr map(TumblrJson json);
}
