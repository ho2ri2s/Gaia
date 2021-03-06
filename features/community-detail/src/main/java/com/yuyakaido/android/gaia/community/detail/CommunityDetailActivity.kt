package com.yuyakaido.android.gaia.community.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.lifecycle.observe
import com.bumptech.glide.Glide
import com.yuyakaido.android.gaia.community.detail.databinding.ActivityCommunityDetailBinding
import com.yuyakaido.android.gaia.core.domain.app.AppRouterType
import com.yuyakaido.android.gaia.core.domain.entity.Community
import com.yuyakaido.android.gaia.core.presentation.ViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class CommunityDetailActivity : DaggerAppCompatActivity() {

  companion object {
    private val COMMUNITY = Community::class.java.simpleName

    fun createIntent(context: Context, community: Community.Summary): Intent {
      return Intent(context, CommunityDetailActivity::class.java)
        .apply { putExtra(COMMUNITY, community) }
    }
  }

  @Inject
  internal lateinit var appRouter: AppRouterType

  @Inject
  internal lateinit var factory: ViewModelFactory<CommunityDetailViewModel>

  private val viewModel: CommunityDetailViewModel by viewModels { factory }
  private val binding by lazy { ActivityCommunityDetailBinding.inflate(layoutInflater) }

  internal fun getCommunity(): Community.Summary {
    return requireNotNull(intent.getParcelableExtra(COMMUNITY))
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(binding.root)
    setupToolbar()
    setupDetail()
    setupViewPager()
    viewModel.onBind()
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    when (item.itemId) {
      android.R.id.home -> finish()
    }
    return super.onOptionsItemSelected(item)
  }

  private fun setupToolbar() {
    supportActionBar?.title = getString(R.string.community_detail_name, getCommunity().name)
    supportActionBar?.setDisplayHomeAsUpEnabled(true)
  }

  private fun setupDetail() {
    viewModel.community
      .observe(this) { community ->
        Glide.with(this)
          .load(community.banner)
          .into(binding.banner)
        Glide.with(this)
          .load(community.icon)
          .circleCrop()
          .into(binding.icon)
        binding.name.text = getString(R.string.community_detail_name, community.name)
        binding.subscribe.setOnClickListener { viewModel.onSubscribe() }
        if (community.isSubscriber) {
          binding.subscribe.text = getString(R.string.community_detail_unsubscribe)
        } else {
          binding.subscribe.text = getString(R.string.community_detail_subscribe)
        }
        binding.subscribers.text = getString(R.string.community_detail_subscribers, community.subscribers)
        binding.description.text = community.description
      }
  }

  private fun setupViewPager() {
    val adapter = CommunityDetailFragmentPagerAdapter(
      manager = supportFragmentManager,
      context = this,
      router = appRouter,
      community = getCommunity()
    )
    binding.viewPager.adapter = adapter
    binding.tabLayout.setupWithViewPager(binding.viewPager)
  }

}