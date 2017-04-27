package com.matuszew.data.model.mapping;

import com.matuszew.data.common.mapper.tublelog.RestTumbleLogMapper;
import com.matuszew.data.common.model.bo.TumbleLog;
import com.matuszew.data.common.model.json.TumbleLogJson;
import com.matuszew.data.fixtures.json.TumbleLogJsonFixture;
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

public class RestTumbleLogMapperUnitTest {

    ModelFactory tumbleLogFactory;
    TumbleLogJson tumbleLogJson;

    @Before
    public void setupData() throws RegisterBlueprintException, CreateModelException {
        tumbleLogFactory = new ModelFactory();
        tumbleLogFactory.registerBlueprint(TumbleLogJsonFixture.class);
        tumbleLogJson = tumbleLogFactory.createModel(TumbleLogJson.class);
    }

    @Test
    public void shouldMapTumbleLogFromTumbleLogJsonWithCorrectData(){
        TumbleLog tumbleLog = RestTumbleLogMapper.INSTANCE.map(tumbleLogJson);

        assertThat(tumbleLog, is(notNullValue()));
        assertThat(tumbleLog.getName(), is("test name"));
        assertThat(tumbleLog.getDescription(), is("test description"));
        assertThat(tumbleLog.getTimezone(), is("test timezone"));
        assertThat(tumbleLog.getTitle(), is("test title"));
    }

    @Test
    public  void shouldMapTumbleLogFromTumbleLogJsonWithEmptyData(){
        TumbleLog tumbleLog = RestTumbleLogMapper.INSTANCE.map(new TumbleLogJson());

        assertThat(tumbleLog, is(notNullValue()));
        assertThat(tumbleLog.getName(), is(nullValue()));
        assertThat(tumbleLog.getDescription(), is(nullValue()));
        assertThat(tumbleLog.getTitle(), is(nullValue()));
        assertThat(tumbleLog.getTimezone(), is(nullValue()));
    }
}
