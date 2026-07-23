# 📖 RULE 01: JOURNALING PROTOCOL

> **Primary Master Rule for `journal.html`**

---

## 🎯 Purpose

To ensure total transparency, auditability, and historical tracking of every update made by an AI Agent during chat sessions.

---

## 📜 Mandatory Operational Requirements

1. **Target File**: `journal.html` located at project root.
2. **Self-Contained Architecture**:
   - MUST use **inline CSS** and **inline JavaScript**.
   - No external CSS framework dependencies (e.g. Tailwind or Bootstrap CDN).
3. **Visual Aesthetic**:
   - Must adhere to the **Memphis / Neo-Brutalist 80s/90s style** defined in `assets/design/design-inspo.jpeg`.
   - Dark background (`#0f1015` grid pattern), high-contrast neon accents (`#e2fc52` Lime, `#ff65a3` Memphis Pink, `#00f0ff` Cyan, `#9b51e0` Purple).
   - Thick black borders (`3px solid #000`), hard offset drop-shadows (`5px 5px 0px #000`).
   - SKIL Lifestyle transparent logo in header with light/dark toggle capability.
4. **Table Structure & Fields**:
   - **ID**: Sequential tag (e.g., `LOG-001`, `LOG-002`).
   - **Timestamp**: Exact local time formatted as `YYYY-MM-DD HH:MM IST`.
   - **Agent/Role**: AI model/agent identification name (e.g. `Antigravity`).
   - **Category Tag**: Categorized badge (`SETUP`, `RULES`, `ARCH`, `ASSETS`, `FEATURE`, `FIX`).
   - **Changes Summary & Details**: High-level title and expandable details list.
   - **Files Touched**: Clickable chips or list of modified/created relative file paths.
   - **Status**: Status badge (`COMPLETED`, `IN_PROGRESS`).
5. **Interactive Capabilities**:
   - Live search input filter by keyword/file.
   - Category dropdown filter.
   - Export to JSON capability.
