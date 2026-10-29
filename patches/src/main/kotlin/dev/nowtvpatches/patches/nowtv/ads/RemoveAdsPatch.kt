package dev.nowtvpatches.patches.nowtv.ads

// NOT: import yolları Morphe sürümüne göre kontrol edilmeli.
import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.patch.bytecodePatch

private const val NOW_PACKAGE = "tr.com.nowtv.android"
private const val NOW_VERSION = "7.6.258"

/** Banner reklamları (Google Ad Manager) hiç yüklemeden gizler. */
@Suppress("unused")
val removeBannerAdsPatch = bytecodePatch(
    name = "Remove banner ads",
    description = "Removes Google Ad Manager banners across the NOW app.",
    default = true,
) {
    compatibleWith(NOW_PACKAGE(NOW_VERSION))

    execute {
        // p0 = AdManagerAdView. GONE (8) yapıp çık; reklam isteği hiç gitmez.
        loadAdWithRetryFingerprint.method.addInstructions(
            0,
            """
                const/16 v0, 0x8
                invoke-virtual { p0, v0 }, Lcom/google/android/gms/ads/admanager/AdManagerAdView;->setVisibility(I)V
                return-void
            """,
        )
    }
}

/**
 * Dizi/film/program videolarındaki IMA (VMAP) reklamlarını kapatır.
 * ExoPlayer 2.18 DefaultMediaSourceFactory, AdsLoader null dönerse
 * "Playing media without ads" diyerek içeriği reklamsız oynatır.
 */
@Suppress("unused")
val removeVideoAdsPatch = bytecodePatch(
    name = "Remove video ads",
    description = "Disables IMA/VMAP pre-roll and mid-roll ads in on-demand videos.",
    default = true,
) {
    compatibleWith(NOW_PACKAGE(NOW_VERSION))

    execute {
        vodAdsLoaderProviderFingerprint.method.addInstructions(
            0,
            """
                const/4 v0, 0x0
                return-object v0
            """,
        )
    }
}
