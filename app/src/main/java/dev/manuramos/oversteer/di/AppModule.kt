package dev.manuramos.oversteer.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.manuramos.oversteer.data.remote.ErgastApi
import dev.manuramos.oversteer.data.repository.DriverRepositoryImpl
import dev.manuramos.oversteer.domain.repository.DriverRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

const val BASE_URL = "https://ergast.com/api/f1/"

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideErgastApi(): ErgastApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ErgastApi::class.java)
    }

    @Provides
    @Singleton
    fun provideDriverRepository(api: ErgastApi): DriverRepository = DriverRepositoryImpl(api)
}
