# NOW 7.6.258 reklam analizi (statik, base.apk)

## Banner
- Google Ad Manager. Tek giriş: `AdManagerExtensionsKt.loadAdWithRetry(AdManagerAdView, AdManagerAdRequest, int, long, long)`.
- Adapter'lar (Discover*, Program*), Home/Movies/News/Sport/Series/Programs/ProgramGuide/LiveStream fragment'ları bu yardımcıyı kullanıyor.

## VOD
- `VideoFragment.initPlayer` -> `ProgramHelper.GetVmapUrl` (merlincdn.net VMAP) -> ExoPlayer `MediaItem.AdsConfiguration` + `ImaAdsLoader`.
- `releasePlayer` adsLoader alanını null-güvenli kullanıyor; AdsLoader null dönmesi güvenli.

## Canlı
- `LiveStreamFragment.initPlayer`: `https://nowtv.daioncdn.net/nowtv/nowtv.m3u8` + token, `DaionClient` (Erstream DAION, SSAI).
- `onDaionAdIn/Out` sadece kontrol çubuğunu gösterip gizliyor.
- resources.arsc içinde alternatif düz adres: `https://nowtv-live.ercdn.net/nowtv/playlistm.m3u8` (kullanımı doğrulanmadı).

## DNS ile video açılmama olasılıkları (doğrulanmadı)
- Canlı: akış adresi zaten `daioncdn.net` üzerinde.
- VOD: stream API'si `*.merlincdn.net` üzerinde olabilir; VMAP de aynı alan adında.
