# SKIL Lifestyle - 120Hz Super Fluid Cross-Platform App Engine

> **Super Fluid Android App engineered to scale seamlessly across Web (Wasm), Desktop PC, and Mobile targets.**
> **Built with Jetpack Compose Multiplatform (CMP) & Light Mode Memphis Brutalist Design System.**

---

## ⚡ Key Highlights & Architecture

- **120Hz Super Fluidity**: Zero recomposition jank using `@Stable` state models, GPU deferred scroll reads (`Modifier.graphicsLayer`), spring physics animations, and unique lazy keys.
- **Cheap Phone Compatible**: Target SDK 36 (Android 16), Min SDK 21 (Android 5.0 Lollipop+) covering 99.5%+ of budget Android phones globally.
- **Light Mode Memphis Aesthetic**: High contrast off-white canvas (`#f4f5f8`), neon yellow accents (`#e2fc52`), 3D hard drop shadows (`5px 5px 0px #000`), and bold black borders (`3px solid #000`).
- **Rule 05 Compliant**: Zero native browser alerts (`window.alert()` banned). Powered by custom Memphis Toast Notifications with auto-timeout and manual `×` close buttons.
- **Google Play Ready**: Target SDK 36, Min SDK 21, Android App Bundle (`.aab`) format, and active [privacy-policy.html](privacy-policy.html).

---

## 💻 Laptop Live Preview

Open **[preview.html](preview.html)** in any web browser to test interactive device viewports (**Budget Phone 360p**, **120Hz Phone 412p**, **Laptop PC**) with live Rule 05 toasts!

Alternatively:
- Native Desktop Window: `./gradlew desktopRun`
- WebAssembly Browser App: `./gradlew wasmJsBrowserDevelopmentRun`

---

## 🧭 System Rulebook Index

- **[SUPER_ADMIN_RULES.md](SUPER_ADMIN_RULES.md)**: Master Rulebook Control Hub
- **[journal.html](journal.html)**: Real-time Light Mode Modification Journal
- **[appended-context-window.html](appended-context-window.html)**: AI Context Window Memory Digest
- **[privacy-policy.html](privacy-policy.html)**: Google Play Privacy Policy Page
- **[rules/](rules/)**: Modular rule files (`JOURNAL_RULES.md`, `DUMP_COLLECTOR_RULES.md`, `CONTEXT_WINDOW_RULES.md`, `SUPER_FLUID_ARCHITECTURE.md`, `TOAST_NOTIFICATION_RULES.md`, `PLAY_STORE_RULES.md`)
