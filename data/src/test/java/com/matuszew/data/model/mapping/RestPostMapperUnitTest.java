package com.matuszew.data.model.mapping;

import com.matuszew.data.common.mapper.post.RestPostMapper;
import com.matuszew.data.common.model.bo.Post;
import com.matuszew.data.common.model.json.PostJson;
import com.matuszew.data.fixtures.json.ConversationJsonFixture;
import com.matuszew.data.fixtures.json.PostJsonFixture;
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
 * Created by matuszewski on 01/05/2017.
 */

public class RestPostMapperUnitTest {

    ModelFactory postFactory;
    PostJson postJson;

    @Before
    public void setupData() throws RegisterBlueprintException, CreateModelException {
        postFactory = new ModelFactory();
        postFactory.registerBlueprint(PostJsonFixture.class);
        postFactory.registerBlueprint(ConversationJsonFixture.class);
        postJson = postFactory.createModel(PostJson.class);
    }

    @Test
    public void shouldMapPostFromPostJsonWithCorrectData(){
        Post post = RestPostMapper.INSTANCE.map(postJson);

        assertThat(post, is(notNullValue()));
        assertThat(post.getId(), is("123"));
        assertThat(post.getUrl(), is("http://www.example.com/"));
        assertThat(post.getUrlWithSlug(), is("http://www.example.com/with-slug"));
        assertThat(post.getType(), is("regular"));
        assertThat(post.getDateGmt(), is("2017-04-28 22:22:54 GMT"));
        assertThat(post.getDate(), is("Fri, 28 Apr 2017 18:22:54"));
        assertThat(post.getNoteCount(), is("100"));
        assertThat(post.getQuoteText(), is("quote text"));
        assertThat(post.getQuoteSource(), is("http://www.quotesource.com/"));
        assertThat(post.getPhotoUrl1280(), is("http://www.photourl.com/1280"));
        assertThat(post.getPhotoUrl500(), is("http://www.photourl.com/500"));
        assertThat(post.getPhotoUrl400(), is("http://www.photourl.com/400"));
        assertThat(post.getPhotoUrl250(), is("http://www.photourl.com/250"));
        assertThat(post.getPhotoUrl100(), is("http://www.photourl.com/100"));
        assertThat(post.getPhotoUrl75(), is("http://www.photourl.com/75"));
        assertThat(post.getVideoCaption(), is("video caption"));
        assertThat(post.getVideoSource(), is("http://www.videosource.com/"));
        assertThat(post.getVideoPlayer(), is("http://www.videoplayer.com/"));
        assertThat(post.getConversationTitle(), is("conversation title"));
        assertThat(post.getConversationText(), is("conversation text"));
        assertThat(post.getTags().size(), is(3));
        assertThat(post.getConversation().size(), is(3));
        assertThat(post.getId3Artist(), is("audio artist"));
        assertThat(post.getId3Year(), is("audio year"));
        assertThat(post.getId3Track(), is("audio track"));
        assertThat(post.getId3Title(), is("audio title"));
        assertThat(post.getAudioEmbed(), is("audio embeded"));
        assertThat(post.getAudioPlayer(), is("audio player"));
        assertThat(post.getRegularTitle(), is("regular title"));
        assertThat(post.getRegularBody(), is("regular body"));
        assertThat(post.getLinkText(), is("link text"));
        assertThat(post.getLinkUrl(), is("http://www.linkurl.com/"));
        assertThat(post.getLinkDescription(), is("link description"));
    }

    @Test
    public void shouldMapPostFromPostJsonWithEmptyData(){
        Post post = RestPostMapper.INSTANCE.map(new PostJson());

        assertThat(post, is(notNullValue()));
        assertThat(post.getId(), is(nullValue()));
        assertThat(post.getUrl(), is(nullValue()));
        assertThat(post.getUrlWithSlug(), is(nullValue()));
        assertThat(post.getType(), is(nullValue()));
        assertThat(post.getDateGmt(), is(nullValue()));
        assertThat(post.getDate(), is(nullValue()));
        assertThat(post.getNoteCount(), is(nullValue()));
        assertThat(post.getQuoteText(), is(nullValue()));
        assertThat(post.getQuoteSource(), is(nullValue()));
        assertThat(post.getPhotoUrl1280(), is(nullValue()));
        assertThat(post.getPhotoUrl500(), is(nullValue()));
        assertThat(post.getPhotoUrl400(), is(nullValue()));
        assertThat(post.getPhotoUrl250(), is(nullValue()));
        assertThat(post.getPhotoUrl100(), is(nullValue()));
        assertThat(post.getPhotoUrl75(), is(nullValue()));
        assertThat(post.getVideoCaption(), is(nullValue()));
        assertThat(post.getVideoSource(), is(nullValue()));
        assertThat(post.getVideoPlayer(), is(nullValue()));
        assertThat(post.getConversationTitle(), is(nullValue()));
        assertThat(post.getConversationText(), is(nullValue()));
        assertThat(post.getTags(), is(nullValue()));
        assertThat(post.getConversation(), is(nullValue()));
        assertThat(post.getId3Artist(), is(nullValue()));
        assertThat(post.getId3Year(), is(nullValue()));
        assertThat(post.getId3Track(), is(nullValue()));
        assertThat(post.getId3Title(), is(nullValue()));
        assertThat(post.getAudioEmbed(), is(nullValue()));
        assertThat(post.getAudioPlayer(), is(nullValue()));
        assertThat(post.getRegularTitle(), is(nullValue()));
        assertThat(post.getRegularBody(), is(nullValue()));
        assertThat(post.getLinkText(), is(nullValue()));
        assertThat(post.getLinkUrl(), is(nullValue()));
        assertThat(post.getLinkDescription(), is(nullValue()));
    }

}
