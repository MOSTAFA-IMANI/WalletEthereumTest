package com.example.wallettest.data.repository.di

import com.example.wallettest.data.datasourse.WalletDataSource
import com.example.wallettest.data.datasourse.WalletDataSourceImpl
import com.example.wallettest.data.repository.wallet.WalletRepository
import com.example.wallettest.data.repository.wallet.WalletRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    @Singleton
    fun provideWalletRepository(repository: WalletRepositoryImpl): WalletRepository

}