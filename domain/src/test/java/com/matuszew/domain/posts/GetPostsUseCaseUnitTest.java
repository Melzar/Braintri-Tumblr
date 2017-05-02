package com.matuszew.domain.posts;

import com.matuszew.data.common.mapper.tumblr.RestTumblrMapper;
import com.matuszew.data.common.model.bo.Tumblr;
import com.matuszew.data.common.model.json.TumblrJson;
import com.matuszew.data.posts.PostsRepository;
import com.matuszew.data.posts.request.GetPostsRequest;
import com.matuszew.domain.posts.list.GetPostsUseCase;
import com.tobedevoured.modelcitizen.CreateModelException;
import com.tobedevoured.modelcitizen.ModelFactory;
import com.tobedevoured.modelcitizen.RegisterBlueprintException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.observers.TestObserver;

import static org.mockito.Mockito.when;

/**
 * Created by matuszewski on 01/05/2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class GetPostsUseCaseUnitTest {

    @Mock
    PostsRepository postsRepository;
    @Mock
    Scheduler schedulerSubscribe;
    @Mock
    Scheduler schedulerObserve;

    private GetPostsUseCase getPostsUseCase;
    private ModelFactory tumblrModel;
    private TumblrJson tumblrJson;

    private TestObserver<Tumblr> tumblrTestObserver;

    @Before
    public void setupData() throws RegisterBlueprintException, CreateModelException {
        MockitoAnnotations.initMocks(this);
        getPostsUseCase = new GetPostsUseCase(schedulerSubscribe, schedulerObserve, postsRepository);
        tumblrModel = new ModelFactory();
        tumblrModel.setRegisterBlueprintsByPackage("com.matuszew.data.fixtures.json");
        tumblrJson = tumblrModel.createModel(TumblrJson.class);
    }

    @Test
    public void shouldGetTumblrWithPostsData(){

        final Tumblr expectedResult = RestTumblrMapper.INSTANCE.map(tumblrJson);

        evaluateTest(expectedResult);
    }

    @Test
    public void shouldGetTumblrWithEmptyPostsData(){
        final Tumblr expectedResult = RestTumblrMapper.INSTANCE.map(new TumblrJson());

        evaluateTest(expectedResult);
    }

    private void evaluateTest(Tumblr expectedResult){
        GetPostsRequest postsRequest = new GetPostsRequest();

        when(postsRepository.getPostsList(postsRequest))
                .thenReturn(Single.just(expectedResult));

        tumblrTestObserver = TestObserver.create();

        getPostsUseCase.execute(tumblrTestObserver, postsRequest);

        tumblrTestObserver.onSuccess(expectedResult);

        tumblrTestObserver.assertResult(expectedResult);
    }
}
