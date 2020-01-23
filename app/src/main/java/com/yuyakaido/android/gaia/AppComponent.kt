package com.yuyakaido.android.gaia

import android.app.Application
import com.yuyakaido.android.gaia.core.domain.app.AppScope
import com.yuyakaido.android.gaia.core.infrastructure.remote.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@AppScope
@Component(modules = [
  AndroidInjectionModule::class,
  AppModule::class,
  ActivityModule::class,
  FragmentModule::class,
  NetworkModule::class
])
interface AppComponent : AndroidInjector<Gaia> {
  @Component.Builder
  interface Builder {
    fun application(@BindsInstance application: Application): Builder
    fun build(): AppComponent
  }
}
