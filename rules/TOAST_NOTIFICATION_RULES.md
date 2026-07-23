# 🔔 RULE 05: THEME-BASED TOAST & NOTIFICATION SYSTEM PROTOCOL

> **Primary Master Rule Banning Default Browser Alerts (`alert()`, `confirm()`, `prompt()`)**

---

## 🎯 Purpose

Default browser Chrome `alert()`, `confirm()`, and `prompt()` dialogs break user immersion, block UI threads, and clash with our Light Mode Memphis Brutalist design system.

**Default browser native alerts are STRICTLY FORBIDDEN.**

---

## 📜 Mandatory Operational Requirements

1. **Zero Browser Alerts**:
   - Never call `window.alert()`, `alert()`, `window.confirm()`, or `window.prompt()` in any HTML, Web component, or Web target.
2. **Custom Theme-Based Toast Notifications**:
   - All notifications, alerts, success toasts, and info popups MUST use a custom inline, theme-styled Toast notification system.
3. **Toast Specifications & Anatomy**:
   - **Visual Theme**: Light Mode Memphis Brutalist (Background `#ffffff` or `#e2fc52` Lime / `#ff65a3` Pink / `#00f0ff` Cyan, Border `3px solid #000000`, Shadow `4px 4px 0px #000000`, bold typography).
   - **Auto-Dismiss Timeout**: Default 3.5 to 5 seconds auto-fadeout timer.
   - **Manual Close Button**: Prominent `×` cross button styled with a black circular or square border (`2px solid #000`), allowing immediate manual dismissal.
   - **Positioning**: Fixed overlay (e.g. top-right `top: 24px; right: 24px;` or bottom-right).
   - **Animations**: Slide-in & scale animation with spring physics (`transform: translateY(0)` to `translateY(-20px)` on exit).
4. **Implementation Standard**:
   - Web / HTML files (`journal.html`, `appended-context-window.html`, etc.) must include an inline `showToast(message, type, duration)` JavaScript function and container `<div id="toastContainer"></div>`.
   - Android / Compose Multiplatform apps must use custom Compose snackbar/toast components styled with Memphis tokens.
