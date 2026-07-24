# SUPER_ADMIN_RULES.md - SKIL Master Control Directives

> **OPERATIONAL MANDATE FOR ALL AI AGENTS & WORKSPACE CONVERSATIONS**  
> **Repository Owner**: `sahilsync07`  
> **Repository**: `skilonline`  
> **Project Scope**: SKIL Lifestyle Super Fluid App System (Web, Android Compose, Multiplatform)

---

## 🚨 1. Repository Layout Directive (STRICT RULE)
The root directory (`c:\Projects\skilonline\`) MUST ONLY contain the following:
1. `SUPER_ADMIN_RULES.md` (This master control document)
2. `index.html` (GitHub Pages Root Router & Portal)
3. `ai/` (Rules, memory logs, journal, app context, assets, privacy policy)
4. `android/` (Native Android Kotlin & Jetpack Compose Multiplatform codebase)
5. `web/` (Production Web Application: `index.html`, `styles.css`, `app.js`, assets)

---

## ⚡ 2. Mandatory Step 1 Protocol (Agent Memory & Continuity)
BEFORE performing any coding, file creation, or system modifications:
- You **MUST** read [ai/appended-context-window.html](file:///c:/Projects/skilonline/ai/appended-context-window.html).
- Verify the current workspace memory state, open logs, and task status.

---

## 📜 3. Eight Mandatory Rules for All AI Workflows

### **Rule 01: Journaling Directive**
After EVERY edit, build, or chat turn, you MUST log your work in [ai/journal.html](file:///c:/Projects/skilonline/ai/journal.html).
- Use **Light Mode Memphis Brutalist** styling.
- Include Log ID (`LOG-001`, `LOG-002`, etc.), timestamp, category tag, detailed changes, touched files, and status badge.

### **Rule 02: Raw File Dump Processing**
When raw asset files (logos, fonts, images) are dropped in raw dumps or `ai/dump/`:
- Process and copy them into `ai/assets/` or `web/assets/` / production locations immediately.

### **Rule 03: Context Window Updates**
At the conclusion of every turn, update [ai/appended-context-window.html](file:///c:/Projects/skilonline/ai/appended-context-window.html) with a condensed digest of current progress.

### **Rule 04: Super Fluidity (120Hz UI Standard)**
Ensure cross-platform 120Hz super fluid performance across `android/` Compose Multiplatform and `web/` vanilla JS/CSS.

### **Rule 05: Memphis Toast Notifications**
NEVER use native browser `window.alert()`. Always use custom theme-based Memphis brutalist toast notifications with auto-timeout and manual `×` dismiss buttons.

### **Rule 06: Play Store Submission Compliance**
Maintain Android Target SDK 36, Min SDK 21, `.aab` bundle format, active privacy policy ([ai/privacy-policy.html](file:///c:/Projects/skilonline/ai/privacy-policy.html)), and a **single unified GitHub Actions workflow** (`android-release.yml`) for Play Store deployment.
- **Mandatory Dynamic Version Code**: All workflow releases MUST calculate `VERSION_CODE` using `AUTO_VERSION_CODE=$(( 100000 + (${{ github.run_number }} * 10) + ${{ github.run_attempt }} ))` to guarantee strictly increasing, collision-proof version numbers on Google Play Console.
- **Single Session Lock**: Deployment to Play Store MUST use a single upload step per job to prevent Google Play API concurrent edit lock contention ("Edit expired" errors) and version reuse failures.

### **Rule 07: No Emojis Standard (In-House Vector Icons)**
NEVER use native OS emojis (e.g. 🧥, 👟, 🎒, 🛒, 🛍️, 🔥, 🎧, 📦) anywhere in the application UI, web components, Compose layouts, or system messages. Always use custom theme-based inline SVG / CSS vector icons or high-impact typography instead.

### **Rule 08: Verification Subagent Directive (Mandatory Workflow Audit)**
Whenever initiating, editing, or triggering background jobs, CI/CD pipelines, build steps, or system tasks:
- You **MUST** spawn a specialized verification subagent (or background task/schedule monitor) to track, inspect, and verify the outcome of the action until 100% successful completion.
- If a failure occurs, the subagent must immediately capture exact un-truncated failure logs and report back to resolve the issue before declaring success.

---

## 🔑 4. GitHub Credentials & Remote Sync
- **GitHub Username**: `sriyasync`
- **GitHub Password**: `Sriya@git07`
- **Target Repository**: `https://github.com/sahilsync07/skilonline.git` (Branch: `main`)
