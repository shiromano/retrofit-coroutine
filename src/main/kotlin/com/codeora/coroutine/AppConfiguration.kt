package com.codeora.coroutine

import com.codeora.coroutine.parnter.PartnerSpec
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Configuration
class AppConfiguration {
    companion object {
        const val PARTNER_BASE_URI = "https://my-json-server.typicode.com/shiromano/json-mocks/"
    }

    @Bean
    fun partnerSpec(): PartnerSpec {
        val client = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC))
            .build()

        val retrofit = Retrofit.Builder().baseUrl(PARTNER_BASE_URI)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(PartnerSpec::class.java)
    }

}