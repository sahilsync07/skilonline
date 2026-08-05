# 📥 RULE 02: DUMP COLLECTOR PROTOCOL

> **Primary Master Rule for `content-temp-dump/` Handling**

---

## 🎯 Purpose

To maintain a clean working directory by automatically monitoring, organizing, and placing user-dropped assets from `content-temp-dump/` into standard production paths.

---

## 📜 Mandatory Operational Requirements

1. **Dump Directory**: `content-temp-dump/` at project root.
2. **Collection Workflow**:
   - At the beginning of any user request, scan `content-temp-dump/`.
   - Classify incoming content:
     - **Brand & Logos** -> Move to `assets/logo/` with clean snake_case filenames.
     - **UI Mockups & Inspiration** -> Move to `assets/design/`.
     - **Data Dumps / JSON / CSV** -> Process into `data/` or target backend models.
     - **Code Snippets** -> Review and integrate into `src/` modules.
3. **Journal Logging**:
   - Every file moved or processed from `content-temp-dump/` must be logged in `journal.html` under the `ASSETS` category tag.
4. **Cleanup Protocol**:
   - Keep `content-temp-dump/` empty or synced once files have been copied to production locations.
