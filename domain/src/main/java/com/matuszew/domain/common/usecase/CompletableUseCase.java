package com.matuszew.domain.common.usecase;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Scheduler;

/**
 * Created by matuszewski on 26/04/2017.
 */

public abstract class CompletableUseCase<R> {

    private final Scheduler subscribeScheduler;
    private final Scheduler observingScheduler;

    public CompletableUseCase(Scheduler subscribeScheduler, Scheduler observingScheduler) {
        this.subscribeScheduler = subscribeScheduler;
        this.observingScheduler = observingScheduler;
    }

    public void execute(CompletableObserver completableObserver, R request){
        createCompletable(request)
                .subscribeOn(subscribeScheduler)
                .observeOn(observingScheduler)
                .subscribeWith(completableObserver);
    }

    protected abstract Completable createCompletable(R request);
}
