package com.matuszew.braintri_tumblr.posts.list;

import com.matuszew.data.common.mapper.tumblr.RestTumblrMapper;
import com.matuszew.data.common.model.bo.Tumblr;
import com.matuszew.data.common.model.json.TumblrJson;
import com.matuszew.data.posts.PostsRepository;
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

import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleObserver;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.TestObserver;
import io.reactivex.schedulers.TestScheduler;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by matuszewski on 02/05/2017.
 */


@RunWith(MockitoJUnitRunner.class)
public class PostListPresenterUnitTest {

    @Mock
    PostsListContract.ViewModel viewModel;
    @Mock
    PostsRepository postsRepository;

    TestScheduler schedulerSubscribe = new TestScheduler();
    TestScheduler schedulerObserve = new TestScheduler();

    @Mock
    private SingleObserver<Tumblr> singleObserver = TestObserver.create();

    private ModelFactory tumblrModel;
    private TumblrJson tumblrJson;
    private PostsListPresenter postsListPresenter;
    private GetPostsUseCase getPostsUseCase;

    @Before
    public void setupData() throws RegisterBlueprintException, CreateModelException {
        MockitoAnnotations.initMocks(this);
        tumblrModel = new ModelFactory();
        tumblrModel.setRegisterBlueprintsByPackage("com.matuszew.data.fixtures.json");
        getPostsUseCase = new GetPostsUseCase(schedulerSubscribe, schedulerObserve, postsRepository);
        tumblrJson = tumblrModel.createModel(TumblrJson.class);
        postsListPresenter = new PostsListPresenter(viewModel, getPostsUseCase);
    }

    @Test
    public void shouldGetTumblrWithPostsDataWithSuccess(){

        final Tumblr expectedResult = RestTumblrMapper.INSTANCE.map(tumblrJson);

        doReturn(Single.create(new SingleOnSubscribe<Tumblr>() {
            @Override
            public void subscribe(@NonNull SingleEmitter<Tumblr> e) throws Exception {
                e.onSuccess(expectedResult);
            }
        })).when(postsRepository).getPostsList(null);

        postsListPresenter.init();

        schedulerSubscribe.triggerActions();
        schedulerObserve.triggerActions();

        verify(viewModel, times(1) ).update(expectedResult);
        verify(viewModel, times(1) ).setPresenter(postsListPresenter);
    }
}
