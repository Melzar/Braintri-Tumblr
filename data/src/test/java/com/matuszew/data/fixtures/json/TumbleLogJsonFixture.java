package com.matuszew.data.fixtures.json;

import com.matuszew.data.common.model.json.TumbleLogJson;
import com.tobedevoured.modelcitizen.annotation.Blueprint;
import com.tobedevoured.modelcitizen.annotation.Default;

/**
 * Created by matuszewski on 27/04/2017.
 */

@Blueprint(TumbleLogJson.class)
public class TumbleLogJsonFixture {

    @Default
    private String title = "test title";
    @Default
    private String description = "test description";
    @Default
    private String name = "test name";
    @Default
    private String timezone = "test timezone";
}
