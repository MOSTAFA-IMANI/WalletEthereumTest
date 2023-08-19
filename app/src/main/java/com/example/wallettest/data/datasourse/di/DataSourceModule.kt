package com.example.wallettest.data.datasourse.di

import com.example.wallettest.data.datasourse.WalletDataSource
import com.example.wallettest.data.datasourse.WalletDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {
    @Binds
    @Singleton
    fun provideWalletDataSource(dataSource: WalletDataSourceImpl): WalletDataSource

}