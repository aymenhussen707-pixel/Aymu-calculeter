name: Build AYMU Calculator APK

on:
  workflow_dispatch:
  push:
    branches: [main]

jobs:
  build:
    runs-on: ubuntu-latest

    steps:
      - name: Get source code
        uses: actions/checkout@v4

      - name: Set up Java
        uses: actions/setup-java@v4
        with:
          distribution: temurin
          java-version: "17"

      - name: Build APK
        uses: android-actions/build-android-app@v3
        with:
          project-path: .
          variant: debug

      - name: Save APK
        uses: actions/upload-artifact@v4
        with:
          name: AYMU-Calculator-APK
          path: app/build/outputs/apk/debug/*.apk
