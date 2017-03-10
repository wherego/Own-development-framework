package com.android.project1.appservice.rxbus;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureError;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.processors.FlowableProcessor;
import io.reactivex.processors.PublishProcessor;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

/**
 * 基于RxJava2针对Android优化的发布/订阅事件总线
 * 替代EventBus
 * Created by oaier on 2017/3/7.
 */

public class RxBus {
    private Subject<Object> subjectBus;
    private FlowableProcessor<Object> processorBus;

    public RxBus() {
        subjectBus = PublishSubject.create().toSerialized();
        processorBus = PublishProcessor.create().toSerialized();
    }

    public Disposable register(Class eventType, Consumer observer) {
        return toObserverable(eventType).subscribe(observer);
    }
    public Disposable register(Class eventType, Consumer observer, Scheduler scheduler) {
        return toObserverable(eventType).observeOn(scheduler).subscribe(observer);
    }
    public Disposable register(Class eventType, Consumer observer,Scheduler scheduler, BackpressureStrategy strategy){
        Flowable o = toFlowable(eventType);
        switch (strategy) {
            case DROP:
                o = o.onBackpressureDrop();
            case LATEST:
                o = o.onBackpressureLatest();
            case MISSING:
                o = o;
            case ERROR:
                o = RxJavaPlugins.onAssembly(new FlowableOnBackpressureError<>(o));
            default:
                o = o.onBackpressureBuffer();
        }
        if(scheduler!=null){
            o.observeOn(scheduler);
        }
        return o.subscribe(observer);
    }
    public Disposable register(Class eventType, Consumer observer, BackpressureStrategy strategy){
        return register(eventType,observer,null,strategy);
    }
    public void unRegister(Disposable disposable) {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }
    public void unRegister(CompositeDisposable compositeDisposable) {
        if (compositeDisposable != null) {
            compositeDisposable.dispose();
        }
    }
    public void post(final Object event) {
        subjectBus.onNext(event);
        processorBus.onNext(event);
    }
    private Observable toObserverable(Class cls) {
        return subjectBus.ofType(cls);
    }
    private Flowable toFlowable(Class cls) {
        return processorBus.ofType(cls);
    }
    public boolean hasObservers() {
        return subjectBus.hasObservers();
    }
    public boolean hasSubscribers() {
        return processorBus.hasSubscribers();
    }
}