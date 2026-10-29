# Karma Patches

Yamasını bulamadığım uygulamalar için AI ile hazırlayıp yayınladığım Morphe yama deposu.

## Desteklenen uygulamalar

| Uygulama | Paket | Sürümler | Yamalar |
|---|---|---|---|
| NOW TV | `tr.com.nowtv.android` | 7.6.258, 7.0.305 | [docs/apps/nowtv.md](docs/apps/nowtv.md) |

## Morphe Manager'a ekleme
Kaynak olarak depo adresini ekle: `https://github.com/MrRaita/Karma-Patches`
(Manager, son GitHub Release içindeki `.mpp` dosyasını kullanır; en az bir release yayınlanmış olmalı.)

## Yayınlama
`git tag v1.0.0 && git push origin v1.0.0` ya da Actions > "Release patches" > Run workflow.
Sürüm numarası tag'den gelir, release'e `.mpp` otomatik eklenir.

## Yeni uygulama eklemek
`patches/src/main/kotlin/dev/karmapatches/patches/<uygulama>/` altında ayrı paket aç; uygulamanın
`Compatibility` tanımı o paketin kökünde, fingerprint ve yamalar alt paketlerde olsun.

> Yamalar yalnızca belirtilen sürümler için doğrulanır. Derlemenin başarılı olması çalışma anı uyumluluğunu garanti etmez.
