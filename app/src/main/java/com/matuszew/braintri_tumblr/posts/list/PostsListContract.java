package com.matuszew.braintri_tumblr.posts.list;

import com.matuszew.braintri_tumblr.BasePresenterContract;
import com.matuszew.braintri_tumblr.BaseViewModelContract;
import com.matuszew.data.common.model.bo.Tumblr;

/**
 * Created by matuszewski on 25/04/2017.
 */

public interface PostsListContract {

    interface Presenter extends BasePresenterContract<Tumblr, ViewModel>{

    }

    interface ViewModel extends BaseViewModelContract<Tumblr, Presenter>{

    }
}
