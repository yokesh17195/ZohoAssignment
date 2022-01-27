package com.sample.zoho.di

import com.sample.zoho.ui.userlist.logic.UserListLogic
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class SupportModules {

    @Provides
    @Singleton
    fun provideUserListLogic():UserListLogic = UserListLogic()

}