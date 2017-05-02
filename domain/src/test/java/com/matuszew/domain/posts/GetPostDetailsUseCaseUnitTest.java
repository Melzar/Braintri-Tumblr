package com.matuszew.domain.posts;

import com.matuszew.data.common.mapper.post.RestPostMapper;
import com.matuszew.data.common.model.bo.Post;
import com.matuszew.data.common.model.json.PostJson;
import com.matuszew.data.posts.PostsRepository;
import com.matuszew.data.posts.request.GetPostDetailsRequest;
import com.matuszew.domain.posts.details.GetPostDetailsUseCase;
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
 * Created by matuszewski on 02/05/2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class GetPostDetailsUseCaseUnitTest {

    @Mock
    PostsRepository postsRepository;
    @Mock
    Scheduler schedulerSubscribe;
    @Mock
    Scheduler schedulerObserve;

    private GetPostDetailsUseCase getPostDetailsUseCase;
    private ModelFactory postModel;
    private PostJson postJson;

    private TestObserver<Post> tumblrTestObserver;

    @Before
    public void setupData() throws RegisterBlueprintException, CreateModelException {
        MockitoAnnotations.initMocks(this);
        getPostDetailsUseCase =
                new GetPostDetailsUseCase(schedulerSubscribe, schedulerObserve, postsRepository);
        postModel = new ModelFactory();
        postModel.setRegisterBlueprintsByPackage("com.matuszew.data.fixtures.json");
        postJson = postModel.createModel(PostJson.class);
    }

    @Test
    public void shouldGetPostWithData(){

        final Post expectedResult = RestPostMapper.INSTANCE.map(postJson);

        evaluateTest(expectedResult);
    }

    @Test
    public void shouldGetPostWithEmpty(){

        final Post expectedResult = RestPostMapper.INSTANCE.map(new PostJson());

        evaluateTest(expectedResult);
    }

    private void evaluateTest(Post expectedResult){

        GetPostDetailsRequest postsRequest = new GetPostDetailsRequest("1");

        when(postsRepository.getPostDetails(postsRequest))
                .thenReturn(Single.just(expectedResult));

        tumblrTestObserver = TestObserver.create();

        getPostDetailsUseCase.execute(tumblrTestObserver, postsRequest);

        tumblrTestObserver.onSuccess(expectedResult);

        tumblrTestObserver.assertResult(expectedResult);
    }
}
