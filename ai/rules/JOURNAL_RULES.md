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
   - Must adhere to the **Modern Elegant Light style** defined in legacy `modern.css`.
   - Background `#FCFBF8`, elegant gold accents (`#C19652`), and refined rounded components.
   - Soft offset drop-shadows and thin borders.
   - SKIL Lifestyle transparent logo in header.
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
