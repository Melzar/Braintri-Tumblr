package com.matuszew.data.common.mapper.conversation;

import com.matuszew.data.common.model.bo.Conversation;
import com.matuszew.data.common.model.json.ConversationJson;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Created by matuszewski on 27/04/2017.
 */

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface RestConversationMapper {

    RestConversationMapper INSTANCE = Mappers.getMapper(RestConversationMapper.class);

    @IterableMapping(qualifiedByName = "getConversations")
    List<Conversation> mapPosts(List<ConversationJson> conversationJsons);

    @Named("getConversations")
    Conversation map(ConversationJson conversationJson);
}
