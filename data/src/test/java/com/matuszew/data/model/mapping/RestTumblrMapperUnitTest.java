package com.matuszew.data.model.mapping;

import com.matuszew.data.common.mapper.tumblr.RestTumblrMapper;
import com.matuszew.data.common.model.bo.Tumblr;
import com.matuszew.data.common.model.json.TumblrJson;
import com.matuszew.data.fixtures.json.ConversationJsonFixture;
import com.matuszew.data.fixtures.json.PostJsonFixture;
import com.matuszew.data.fixtures.json.TumbleLogJsonFixture;
import com.matuszew.data.fixtures.json.TumblrJsonFixture;
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
 * Created by matuszewski on 27/04/2017.
 */

public class RestTumblrMapperUnitTest {

    ModelFactory tumblrModel;
    TumblrJson tumblrJson;

    @Before
    public void setupData() throws RegisterBlueprintException, CreateModelException {
        tumblrModel = new ModelFactory();
        tumblrModel.registerBlueprint(TumblrJsonFixture.class);
        tumblrModel.registerBlueprint(PostJsonFixture.class);
        tumblrModel.registerBlueprint(TumbleLogJsonFixture.class);
        tumblrModel.registerBlueprint(ConversationJsonFixture.class);
        tumblrJson = tumblrModel.createModel(TumblrJson.class);
    }

    @Test
    public void shouldMapTumblrFromTumblrJsonWithCorrectData(){
        Tumblr tumblr = RestTumblrMapper.INSTANCE.map(tumblrJson);

        assertThat(tumblr, is(notNullValue()));
        assertThat(tumblr.getPosts().size(), is(3));
        assertThat(tumblr.getPostsStart(), is(0l));
        assertThat(tumblr.getPostsTotal(), is(50l));
        assertThat(tumblr.getTumblelog(), is(notNullValue()));
    }

    @Test
    public  void shouldMapTumblrFromTumblrJsonWithEmptyData(){
        Tumblr tumblr = RestTumblrMapper.INSTANCE.map(new TumblrJson());

        assertThat(tumblr, is(notNullValue()));
        assertThat(tumblr.getPosts(), is(nullValue()));
        assertThat(tumblr.getPostsStart(), is(nullValue()));
        assertThat(tumblr.getPostsTotal(), is(nullValue()));
        assertThat(tumblr.getTumblelog(), is(nullValue()));
    }
}
