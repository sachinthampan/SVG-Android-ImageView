package com.example.svginimageview

import android.app.Activity
import android.graphics.drawable.PictureDrawable
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.example.svginimageview.databinding.MainBinding
import com.example.svginimageview.ui.theme.SVGInImageViewTheme
import com.example.svginimageview.utils.SvgSoftwareLayerSetter

class MainActivity : Activity() {
    private lateinit var request: RequestBuilder<PictureDrawable>
    private lateinit var binding: MainBinding

    companion object{
        const val SVG_IMAGE_URL = "https://bafkreia6lpdwrahiaxsqlpk726qihfi225ltz4teg6zsis434cyum2yone.ipfs.nftstorage.link/"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = MainBinding.inflate(LayoutInflater.from(this))

        setContentView(binding.root)

        request = Glide.with(this)
            .`as`(PictureDrawable::class.java)
            .error(resources.getDrawable(R.drawable.baseline_error))
            .listener(SvgSoftwareLayerSetter())

        request.load(SVG_IMAGE_URL).into(binding.image)
    }
}
