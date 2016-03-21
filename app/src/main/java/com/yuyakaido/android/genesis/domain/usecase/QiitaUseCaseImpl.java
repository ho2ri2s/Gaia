package com.yuyakaido.android.genesis.domain.usecase;

import com.yuyakaido.android.genesis.domain.entity.QiitaItem;
import com.yuyakaido.android.genesis.domain.repository.QiitaRepository;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by yuyakaido on 3/12/16.
 */
public class QiitaUseCaseImpl implements QiitaUseCase {

    private QiitaRepository qiitaRepository;

    @Inject
    public QiitaUseCaseImpl(QiitaRepository qiitaRepository) {
        this.qiitaRepository = qiitaRepository;
    }

    @Override
    public Observable<List<QiitaItem>> getQiitaItems() {
        return qiitaRepository.getQiitaItems();
    }

}
