# 🛍️ RULE 06: GOOGLE PLAY STORE COMPLIANCE & SUBMISSION PROTOCOL

> **Primary Master Rule for Google Play Store Android App Uploads**

---

## 🎯 Purpose

To ensure the SKIL Lifestyle Android application satisfies **100% of Google Play Store Developer Policy Requirements**, API target mandates, security standards, and privacy disclosures.

---

## 📜 Mandatory Technical Requirements

### 1. Target API & SDK Versions
- **`compileSdk`**: `36` (Android 16).
- **`targetSdk`**: `36` (Android 16) — Mandatory target level for new app submissions.
- **`minSdk`**: `21` (Android 5.0 Lollipop) — Guarantees 99.5%+ global device reach including cheap/budget Android phones.

### 2. App Publishing Format & Architecture
- **Format**: **Android App Bundle (`.aab`)** format is MANDATORY. Plain `.apk` files are rejected for production submissions.
- **64-bit Support**: Native libraries must support 64-bit architectures (`arm64-v8a`, `x86_64`).

---

## 🛡️ Privacy, Permissions & Data Safety

### 3. Mandatory Privacy Policy Page
- A live, publicly accessible Privacy Policy URL is mandatory.
- Project Privacy Policy file: [privacy-policy.html](file:///c:/Projects/skilonline/privacy-policy.html).
- Must include in-app privacy policy link within settings/about screen.

### 4. Data Safety Section & Account Deletion
- **Data Safety Declaration**: Accurately declare all data collection types (analytics, device IDs, user preferences).
- **Account Deletion Rule**: Must provide users an in-app option AND a web URL to request account/data deletion.

### 5. Permission Minimization & System Pickers
- **No Broad Storage Permissions**: Use the native Android Photo Picker (`ActivityResultContracts.PickVisualMedia`) instead of requesting broad `READ_EXTERNAL_STORAGE`.
- **Foreground Services**: Declare explicit `foregroundServiceType` in `AndroidManifest.xml`.

---

## 🧪 Testing & Account Requirements

### 6. Closed Testing Mandate (12-Tester Rule)
- For personal developer accounts created after Nov 13, 2023:
  - Must run a Closed Test with **at least 12 opt-in testers**.
  - Testers must keep the app installed continuously for **14 consecutive days** prior to requesting Production access.
