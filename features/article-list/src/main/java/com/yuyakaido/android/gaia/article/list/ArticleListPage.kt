package com.yuyakaido.android.gaia.article.list

import androidx.annotation.IdRes

enum class ArticleListPage(
  @IdRes val id: Int,
  val source: ArticleListSource
) {
  Popular(
    id = R.id.sort_popular,
    source = ArticleListSource.Popular
  ),
  Best(
    id = R.id.sort_best,
    source = ArticleListSource.Best
  ),
  Hot(
    id = R.id.sort_hot,
    source = ArticleListSource.Hot
  ),
  New(
    id = R.id.sort_new,
    source = ArticleListSource.New
  ),
  Top(
    id = R.id.sort_top,
    source = ArticleListSource.Top
  ),
  Controversial(
    id = R.id.sort_controversial,
    source = ArticleListSource.Controversial
  ),
  Rising(
    id = R.id.sort_rising,
    source = ArticleListSource.Rising
  );

  companion object {
    fun from(id: Int): ArticleListPage {
      return values().first { it.id == id }
    }
  }
}