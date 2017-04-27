package com.matuszew.data.model.mapping;

import com.matuszew.data.common.mapper.conversation.RestConversationMapper;
import com.matuszew.data.common.model.bo.Conversation;
import com.matuszew.data.common.model.json.ConversationJson;
import com.matuszew.data.fixtures.json.ConversationJsonFixture;
import com.tobedevoured.modelcitizen.CreateModelException;
import com.tobedevoured.modelcitizen.ModelFactory;
import com.tobedevoured.modelcitizen.RegisterBlueprintException;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;


/**
 * Created by matuszewski on 28/04/2017.
 */

public class RestConversationMapperUnitTest {

    ModelFactory conversationFactory;
    ConversationJson conversationJson;

    @Before
    public void setupData() throws RegisterBlueprintException, CreateModelException {
        conversationFactory = new ModelFactory();
        conversationFactory.registerBlueprint(ConversationJsonFixture.class);
        conversationJson = conversationFactory.createModel(ConversationJson.class);
    }

    @Test
    public void shouldMapConversationFromConversationJsonWithCorrectData(){
        Conversation conversation = RestConversationMapper.INSTANCE.map(conversationJson);

        assertThat(conversation, is(notNullValue()));
        assertThat(conversation.getName(), is("conversation name"));
        assertThat(conversation.getLabel(), is("conversation label"));
        assertThat(conversation.getPhrase(), is("conversation phrase"));
    }

    @Test
    public void shouldMapConversationFromConversationJsonWithEmptyData(){
        Conversation conversation = RestConversationMapper.INSTANCE.map(new ConversationJson());

        assertThat(conversation, is(notNullValue()));
        assertThat(conversation.getName(), is(nullValue()));
        assertThat(conversation.getLabel(), is(nullValue()));
        assertThat(conversation.getPhrase(), is(nullValue()));
    }
}
