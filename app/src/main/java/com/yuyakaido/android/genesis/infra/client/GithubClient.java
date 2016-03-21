package com.yuyakaido.android.genesis.infra.client;

import com.yuyakaido.android.genesis.domain.entity.GithubContributor;
import com.yuyakaido.android.genesis.infra.client.common.CommonClient;

import java.util.List;

import javax.inject.Inject;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by yuyakaido on 2/15/16.
 */
public class GithubClient {

    private GithubService githubService;

    @Inject
    public GithubClient(GithubService service) {
        this.githubService = service;
    }

    public Observable<List<GithubContributor>> getGithubContributors(String owner, String repo) {
        return CommonClient.retry(githubService.getGithubContributors(owner, repo));
    }

    public Observable<List<GithubContributor>> getGithubContributors() {
        return getGithubContributors("konifar", "droidkaigi2016");
    }

    public interface GithubService {
        @GET("/repos/{owner}/{repo}/contributors")
        Observable<List<GithubContributor>> getGithubContributors(
                @Path("owner") String owner, @Path("repo") String repo);
    }

}
