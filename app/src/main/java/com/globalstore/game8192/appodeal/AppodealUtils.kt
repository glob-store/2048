package com.globalstore.game8192.appodeal

import android.app.Activity
import com.appodeal.ads.Appodeal
import com.appodeal.ads.BannerCallbacks
import com.appodeal.ads.InterstitialCallbacks
import com.appodeal.ads.initializing.ApdInitializationCallback
import com.appodeal.ads.initializing.ApdInitializationError
import com.appodeal.ads.utils.Log
import com.globalstore.game8192.BuildConfig

class AppodealUtils {
    private val placement = "default"

    private var activity: Activity? = null

    fun setActivity(activity: Activity) {
        this.activity = activity

        // Initialize
        initBanner()
        initRewardedVideo()
        initInterstitial()
    }

    init {
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


    private fun initBanner() {
        activity?.let {
            Appodeal.initialize(
                it,
                BuildConfig.AppKey,
                Appodeal.BANNER,
                object : ApdInitializationCallback {
                    override fun onInitializationFinished(errors: List<ApdInitializationError>?) {
                    }
                })
        }
    }

    fun show(appodealType: Int) {
        activity?.let {
            when (appodealType) {
                Appodeal.BANNER -> {
                    Appodeal.show(it, Appodeal.BANNER, placement)
                }

                Appodeal.REWARDED_VIDEO -> {
                    Appodeal.show(it, Appodeal.REWARDED_VIDEO, placement)
                }

                Appodeal.INTERSTITIAL -> {
                    Appodeal.show(it, Appodeal.INTERSTITIAL, placement)
                }

                else -> Unit
            }
        }
    }

    private fun initRewardedVideo() {
        activity?.let {
            Appodeal.setTesting(BuildConfig.DEBUG)
            Appodeal.setLogLevel(Log.LogLevel.debug)
            Appodeal.initialize(
                it,
                BuildConfig.AppKey,
                Appodeal.REWARDED_VIDEO,
                object : ApdInitializationCallback {
                    override fun onInitializationFinished(errors: List<ApdInitializationError>?) {
                    }
                })
        }
    }


    private fun initInterstitial() {
        activity?.let {
            Appodeal.setTesting(BuildConfig.DEBUG)
            Appodeal.setLogLevel(Log.LogLevel.debug)
            Appodeal.initialize(
                it,
                BuildConfig.AppKey,
                Appodeal.INTERSTITIAL,
                object : ApdInitializationCallback {
                    override fun onInitializationFinished(errors: List<ApdInitializationError>?) {
                    }
                })
        }

    }

}