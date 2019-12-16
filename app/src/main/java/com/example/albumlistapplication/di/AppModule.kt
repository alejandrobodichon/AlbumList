package org.falabella.android.lia.di

import com.example.albumlistapplication.ui.main.MainActivity
import com.example.albumlistapplication.ui.main.albums.AlbumsFragment
import com.example.albumlistapplication.ui.main.photodetail.PhotoDetailFragment
import com.example.albumlistapplication.ui.main.photos.PhotosFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector
import org.falabella.android.lia.ui.root.RootActivity

@Module
abstract class AppModule {

    @ContributesAndroidInjector
    internal abstract fun rootActivity(): RootActivity

    @ContributesAndroidInjector
    internal abstract fun mainActivity(): MainActivity

    @ContributesAndroidInjector
    internal abstract fun albumsFragment(): AlbumsFragment

    @ContributesAndroidInjector
    internal abstract fun photosFragment(): PhotosFragment

    @ContributesAndroidInjector
    internal abstract fun photosDetailFragment(): PhotoDetailFragment
}