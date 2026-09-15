# Hello World Native Apps

Minimal native Android and iOS hello world applications with GitHub Actions CI.

## Android

The Android app is in [`android`](android). Build a debug APK with:

The Android build requires JDK 17, matching the CI workflow.

```sh
cd android
./gradlew assembleDebug
```

The APK is written to `android/app/build/outputs/apk/debug/app-debug.apk`.

## iOS

The iOS app is in [`ios/HelloWorld`](ios/HelloWorld). Build it on macOS with:

```sh
xcodebuild \
	-project ios/HelloWorld/HelloWorld.xcodeproj \
	-scheme HelloWorld \
	-sdk iphonesimulator \
	-destination 'generic/platform=iOS Simulator' \
	CODE_SIGNING_ALLOWED=NO \
	build
```

The workflow in [`.github/workflows/ci.yml`](.github/workflows/ci.yml) runs both builds for pushes and pull requests.