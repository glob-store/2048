package com.globalstore.game8192.appodeal

import android.app.Activity
import com.appodeal.ads.Appodeal
import com.appodeal.ads.BannerCallbacks
import com.appodeal.ads.InterstitialCallbacks
import com.appodeal.ads.initializing.ApdInitializationCallback
import com.appodeal.ads.initializing.ApdInitializationError
import com.appodeal.ads.utils.Log
import com.globalstore.game8192.BuildConfig

object AppodealUtils {
    private const val placement = "default"

    fun loadBanner(activity: Activity) {
        Appodeal.setLogLevel(Log.LogLevel.debug)
        Appodeal.initialize(
            activity,
            BuildConfig.AppKey,
            Appodeal.BANNER,
            object : ApdInitializationCallback {
                override fun onInitializationFinished(errors: List<ApdInitializationError>?) {
                    Appodeal.show(activity, Appodeal.BANNER_BOTTOM, placement)
                }
            })

        Appodeal.setBannerCallbacks(object : BannerCallbacks {

            override fun onBannerLoaded(height: Int, isPrecache: Boolean) {

            }

            override fun onBannerFailedToLoad() {

            }

            override fun onBannerClicked() {

            }

            override fun onBannerShowFailed() {

            }

            override fun onBannerShown() {

            }

            override fun onBannerExpired() {

            }
        })
    }

    fun loadRewardedVideo(activity: Activity) {
        Appodeal.setLogLevel(Log.LogLevel.debug)
        Appodeal.initialize(
            activity,
            BuildConfig.AppKey,
            Appodeal.REWARDED_VIDEO,
            object : ApdInitializationCallback {
                override fun onInitializationFinished(errors: List<ApdInitializationError>?) {
                    Appodeal.show(activity, Appodeal.REWARDED_VIDEO, placement)
                }
            })

        Appodeal.setBannerCallbacks(object : BannerCallbacks {

            override fun onBannerLoaded(height: Int, isPrecache: Boolean) {

            }

            override fun onBannerFailedToLoad() {

            }

            override fun onBannerClicked() {

            }

            override fun onBannerShowFailed() {

            }

            override fun onBannerShown() {

            }

            override fun onBannerExpired() {

            }
        })
    }


    fun loadInterstitial(activity: Activity) {
        Appodeal.setLogLevel(Log.LogLevel.debug)
        Appodeal.initialize(
            activity,
            BuildConfig.AppKey,
            Appodeal.INTERSTITIAL,
            object : ApdInitializationCallback {
                override fun onInitializationFinished(errors: List<ApdInitializationError>?) {
                    Appodeal.show(activity, Appodeal.INTERSTITIAL, placement)
                }
            })


        Appodeal.setInterstitialCallbacks(object : InterstitialCallbacks {
            override fun onInterstitialClicked() {

            }

            override fun onInterstitialClosed() {
            }

            override fun onInterstitialExpired() {
            }

            override fun onInterstitialFailedToLoad() {
            }

            override fun onInterstitialLoaded(isPrecache: Boolean) {
            }

            override fun onInterstitialShowFailed() {
            }

            override fun onInterstitialShown() {
            }
        })
    }

}