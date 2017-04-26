package com.matuszew.domain.common.usecase;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;

/**
 * Created by matuszewski on 26/04/2017.
 */

public abstract class ObservableUseCase<T, R> {

    private final Scheduler subscribeScheduler;
    private final Scheduler observingScheduler;

    public ObservableUseCase(Scheduler subscribeScheduler, Scheduler observingScheduler) {
        this.subscribeScheduler = subscribeScheduler;
        this.observingScheduler = observingScheduler;
    }

    public void execute(Observer<T> observer, R request){
        createObservable(request)
                .subscribeOn(subscribeScheduler)
                .observeOn(observingScheduler)
                .subscribeWith(observer);
    }

    protected abstract Observable<T> createObservable(R request);
}
