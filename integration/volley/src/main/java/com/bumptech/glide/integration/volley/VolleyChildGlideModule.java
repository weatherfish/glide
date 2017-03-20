package com.bumptech.glide.integration.volley;

import android.content.Context;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.module.ChildGlideModule;
import java.io.InputStream;

/**
 * A {@link com.bumptech.glide.module.GlideModule} implementation to replace Glide's default
 * {@link java.net.HttpURLConnection} based {@link com.bumptech.glide.load.model.ModelLoader} with a
 * Volley based {@link com.bumptech.glide.load.model.ModelLoader}.
 *
 * <p>For Applications that depend on this library and include an
 * {@link com.bumptech.glide.module.RootGlideModule} and Glide's annotation processor, this class
 * will be automatically included.
 */
@GlideModule
public class VolleyChildGlideModule extends ChildGlideModule {
  @Override
  public void registerComponents(Context context, Registry registry) {
    registry.replace(GlideUrl.class, InputStream.class, new VolleyUrlLoader.Factory(context));
  }
}
