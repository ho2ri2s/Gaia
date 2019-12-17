package com.yuyakaido.android.gaia.article.list

import android.app.Application
import com.yuyakaido.android.gaia.core.domain.app.VoteServiceType
import com.yuyakaido.android.gaia.core.infrastructure.ArticleRepository
import dagger.Module
import dagger.Provides

@Module
class ArticleListModule : ArticleListModuleType {

  @Provides
  override fun provideArticleListViewModel(
    application: Application,
    fragment: ArticleListFragment,
    repository: ArticleRepository,
    service: VoteServiceType
  ): ArticleListViewModelType {
    return ArticleListViewModel(
      application = application,
      page = fragment.getArticleListPage(),
      repository = repository,
      service = service
    )
  }

}