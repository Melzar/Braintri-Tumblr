package com.matuszew.data.common.mapper.post;

import com.matuszew.data.common.model.bo.Post;
import com.matuszew.data.common.model.json.PostJson;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Created by matuszewski on 26/04/2017.
 */

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface RestPostMapper {

    RestPostMapper INSTANCE = Mappers.getMapper(RestPostMapper.class);

    @IterableMapping(qualifiedByName = "getPosts")
    List<Post> mapPosts(List<PostJson> postJson);

    @Named("getPosts")
    Post map(PostJson postJson);


}
