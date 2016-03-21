package com.yuyakaido.android.genesis.domain.usecase;

import com.yuyakaido.android.genesis.domain.entity.GithubContributor;

import java.util.List;

import rx.Observable;

/**
 * Created by yuyakaido on 3/5/16.
 */
public interface GithubUseCase {

    Observable<List<GithubContributor>> getGithubContributors();

}
