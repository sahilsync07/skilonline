# 🚀 RULE 04: SUPER FLUID MULTI-PLATFORM ARCHITECTURE PROTOCOL

> **Primary Master Rule for 120Hz Android -> Web (Wasm), PC (Desktop JVM), and Mobile App Development**

---

## 🎯 Purpose

To construct a **super fluid** application engineered for 120Hz frame rates on flagship devices while remaining **100% smooth, lightweight, and responsive on cheap / budget Android phones**.

---

## 📱 Budget / Low-End Phone Optimization Mandates

To ensure budget Android devices (2GB-3GB RAM, low-end chipsets, Android Go Edition) run seamlessly:

1. **Wide Device Reach (`minSdk = 21` / Android 5.0+)**:
   - Target 99.5%+ global Android device compatibility.
2. **Adaptive Performance Fallbacks**:
   - Detect low-RAM devices (`ActivityManager.isLowRamDevice()`) or lower API levels and automatically disable heavy real-time graphic blurs or excessive overdraw.
   - Use simple solid borders (`3dp solid #000`) and flat offset shadows instead of expensive Gaussian blur shaders.
3. **Baseline Profiles (Pre-Compilation)**:
   - Pre-compile critical UI execution paths into native machine code to eliminate JIT stutter on low-tier CPUs.
4. **Memory Hygiene**:
   - Cap image bitmap memory caches and enforce strict `key` recycling in `LazyColumn`/`LazyRow`.

---

## 💻 How to Preview the App on Your Laptop

Since our app is built with **Compose Multiplatform (CMP)**, you have 4 ultra-fast options to preview and test directly on your laptop:

### Option 1: Native Desktop Preview (`./gradlew desktopRun`)
Run the app natively as a desktop application on Windows/macOS. No emulator needed!
```bash
./gradlew desktopRun -t
```

### Option 2: Instant Web Browser Preview (`./gradlew wasmJsBrowserDevelopmentRun`)
Launch the app instantly in Chrome / Edge / Firefox using WebAssembly (Wasm):
```bash
./gradlew wasmJsBrowserDevelopmentRun
```

### Option 3: Standalone Interactive HTML Preview (`preview.html`)
Open `preview.html` directly in any web browser on your laptop for instant visual inspection of the Light Mode Memphis UI components!

### Option 4: Android Studio Composable `@Preview`
Open any `@Composable` file in Android Studio or JetBrains Fleet and toggle the split **Design / Preview** pane.
