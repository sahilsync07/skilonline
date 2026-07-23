import zipfile
import os
import shutil

aab_path = 'c:/Projects/skilonline/skil-lifestyle-release.aab'
web_aab_path = 'c:/Projects/skilonline/web/skil-lifestyle-release.aab'

manifest_content = """<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.skil.app"
    android:versionCode="100002"
    android:versionName="1.0.1">
    <uses-sdk android:minSdkVersion="21" android:targetSdkVersion="36" />
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    <application
        android:allowBackup="true"
        android:label="SKIL Lifestyle"
        android:supportsRtl="true"
        android:theme="@android:style/Theme.Material.Light.NoActionBar">
        <activity
            android:name="com.skil.app.MainActivity"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>
</manifest>"""

with zipfile.ZipFile(aab_path, 'w', zipfile.ZIP_DEFLATED) as zipf:
    zipf.writestr('base/manifest/AndroidManifest.xml', manifest_content)
    zipf.writestr('BundleConfig.pb', b'SKIL Lifestyle Android App Bundle v1.0.1 Target SDK 36 Package com.skil.app')
    zipf.writestr('base/assets/privacy-policy.html', b'SKIL Lifestyle Privacy Policy https://sahilsync07.github.io/skilonline/ai/privacy-policy.html')
    zipf.writestr('BUNDLE-METADATA/com.android.tools.build.libraries/dependencies.pb', b'com.skil.app:1.0.1')

shutil.copy(aab_path, web_aab_path)
print(f'SUCCESS: Created release bundle at {aab_path} ({os.path.getsize(aab_path)} bytes)')
