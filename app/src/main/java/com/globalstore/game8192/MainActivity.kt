package com.globalstore.game8192

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.appodeal.ads.Appodeal
import com.globalstore.game8192.appodeal.AppodealUtils
import com.globalstore.game8192.appodeal.REPEAT_TIME_MILLIS
import com.globalstore.game8192.appodeal.timer
import com.globalstore.game8192.ui.game.GameScreen
import com.globalstore.game8192.ui.theme.Compose2048Theme

class MainActivity : ComponentActivity() {

    private val appodealUtils = AppodealUtils()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appodealUtils.setActivity(this)
        setContent {
            Compose2048Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = Color(0xffe6dbc9)
                ) {
                    Box(
                        Modifier.padding(16.dp)
                    ) {
                        GameScreen()
                    }
                }
            }
        }
        // loadBanner
        appodealUtils.show(Appodeal.BANNER)
        // loadInterstitial
        REPEAT_TIME_MILLIS.timer {
            appodealUtils.show(Appodeal.REWARDED_VIDEO)
        }
    }
}
