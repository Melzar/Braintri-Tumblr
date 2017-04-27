package com.matuszew.data.fixtures.json;

import com.matuszew.data.common.model.json.ConversationJson;
import com.tobedevoured.modelcitizen.annotation.Blueprint;
import com.tobedevoured.modelcitizen.annotation.Default;

/**
 * Created by matuszewski on 28/04/2017.
 */

@Blueprint(ConversationJson.class)
public class ConversationJsonFixture {

    @Default
    private String name = "conversation name";
    @Default
    private String label = "conversation label";
    @Default
    private String phrase = "conversation phrase";

}
