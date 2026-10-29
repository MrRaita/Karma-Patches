# NOW TV (tr.com.nowtv.android) Morphe yamaları

Hedef: NOW (Türkiye) 7.6.258. Kendi depon için, resmi Morphe deposundan bağımsız.

| Yama | Varsayılan | Ne yapar |
|---|---|---|
| Remove banner ads | açık | Google Ad Manager banner'larını hiç yüklemeden gizler |
| Remove video ads | açık | Dizi/film/program videolarındaki IMA (VMAP) reklamlarını kapatır |
| Keep player controls during live ads | açık | Canlı reklam başlayınca kontrol çubuğunun gizlenmesini engeller, ileri sarma tuşları çalışır |
| Live stream without ad insertion (experimental) | kapalı | Canlı yayında DAION'u atlayıp düz yayın adresini dener |

## Önemli notlar
- Canlı yayın reklamları (DAION) yayına gömülüdür; istemcide silinemez. Deneysel yama tek çıkış yolu ama sunucu kabul etmezse yayın açılmaz.
- Derlenmedi ve cihazda denenmedi. `build.gradle.kts` dosyaları ve import yolları Morphe şablonuna göre uyarlanmalı.
- Ayrıntılı analiz: `docs/ANALIZ.md`
