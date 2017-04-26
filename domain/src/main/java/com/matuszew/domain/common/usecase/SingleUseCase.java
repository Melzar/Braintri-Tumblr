package com.matuszew.domain.common.usecase;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;

/**
 * Created by matuszewski on 26/04/2017.
 */

public abstract class SingleUseCase<T, R> {

    private final Scheduler subscribeScheduler;
    private final Scheduler observingScheduler;

    public SingleUseCase(Scheduler subscribeScheduler, Scheduler observingScheduler) {
        this.subscribeScheduler = subscribeScheduler;
        this.observingScheduler = observingScheduler;
    }

    public void execute(SingleObserver<T> observer, R request){
        createObservable(request)
                .subscribeOn(subscribeScheduler)
                .observeOn(observingScheduler)
                .subscribeWith(observer);
    }

    protected abstract Single<T> createObservable(R request);
}
