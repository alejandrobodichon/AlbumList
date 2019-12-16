package com.example.albumlistapplication

import ar.com.wolox.wolmo.core.WolmoApplication
import ar.com.wolox.wolmo.networking.di.DaggerNetworkingComponent
import ar.com.wolox.wolmo.networking.di.NetworkingComponent
import com.example.albumlistapplication.BaseConfiguration.SHARED_PREFERENCES_NAME
import dagger.android.AndroidInjector
import com.facebook.drawee.backends.pipeline.Fresco
import com.google.gson.FieldNamingPolicy
import org.falabella.android.lia.di.DaggerAppComponent


class AlbumListApplication : WolmoApplication() {

    override fun onInit() {
        // Initialize Application stuff here
        Fresco.initialize(this)
    }

    override fun applicationInjector(): AndroidInjector<AlbumListApplication> {
        return DaggerAppComponent.builder().networkingComponent(buildDaggerNetworkingComponent())
            .sharedPreferencesName(SHARED_PREFERENCES_NAME).application(this)
            .create(this)
    }

    private fun buildDaggerNetworkingComponent(): NetworkingComponent {
        val builder = DaggerNetworkingComponent.builder().baseUrl("https://jsonplaceholder.typicode.com")
            .gsonNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        return builder.build()
    }
}