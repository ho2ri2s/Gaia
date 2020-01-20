package com.yuyakaido.android.storybook

import android.app.Application
import com.yuyakaido.android.gaia.core.domain.app.AppScope
import com.yuyakaido.android.gaia.core.domain.app.GaiaType
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@AppScope
@Component(
  modules = [
    AndroidInjectionModule::class,
    StorybookModule::class,
    FeatureModule::class
  ]
)
interface StorybookComponent : AndroidInjector<GaiaType> {
  @Component.Factory
  interface Factory {
    fun create(@BindsInstance application: Application): StorybookComponent
  }
}