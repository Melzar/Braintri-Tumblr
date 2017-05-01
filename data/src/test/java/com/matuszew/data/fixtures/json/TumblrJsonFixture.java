package com.matuszew.data.fixtures.json;

import com.matuszew.data.common.model.json.PostJson;
import com.matuszew.data.common.model.json.TumbleLogJson;
import com.matuszew.data.common.model.json.TumblrJson;
import com.tobedevoured.modelcitizen.annotation.Blueprint;
import com.tobedevoured.modelcitizen.annotation.Default;
import com.tobedevoured.modelcitizen.annotation.Mapped;
import com.tobedevoured.modelcitizen.annotation.MappedList;

import java.util.List;

/**
 * Created by matuszewski on 01/05/2017.
 */

@Blueprint(TumblrJson.class)
public class TumblrJsonFixture {
    @Mapped(target = TumbleLogJson.class)
    private TumbleLogJson tumblelog;
    @Default
    private Long postsStart = 0l;
    @Default
    private Long postsTotal = 50l;
    @MappedList(target = PostJson.class, size = 3)
    private List<PostJson> posts;
}
