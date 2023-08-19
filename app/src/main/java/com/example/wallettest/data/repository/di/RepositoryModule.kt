package com.example.wallettest.data.repository.di

import com.example.wallettest.data.datasourse.WalletDataSource
import com.example.wallettest.data.datasourse.WalletDataSourceImpl
import com.example.wallettest.data.repository.wallet.WalletRepository
import com.example.wallettest.data.repository.wallet.WalletRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun provideWalletRepository(repository: WalletRepositoryImpl): WalletRepository

}