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

The build reads `android/.env` (gitignored) through the [dotenv-android](https://github.com/levibostian/dotenv-android) plugin. Copy [`android/.env.example`](android/.env.example) to `android/.env` first. `ENABLE_LOGS=false` turns off app logging. Run the unit tests with `./gradlew testDebugUnitTest`. The plugin downloads a CLI that has no Apple Silicon macOS build, so on arm64 Macs build with an x86_64 JDK under Rosetta. CI writes `.env` from the `API_KEY` repository secret.

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