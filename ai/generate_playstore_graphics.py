from PIL import Image, ImageDraw, ImageFont
import os

out_dir = r"c:\Projects\skilonline\ai\assets\playstore_graphics"
os.makedirs(out_dir, exist_ok=True)

logo_path = r"c:\Projects\skilonline\ai\assets\logo\SKIL_Lifestyle_Black_Transparent_BG_Logo.png"
logo_img = Image.open(logo_path).convert("RGBA")

# Load font
try:
    font_large = ImageFont.truetype("arial.ttf", 64)
    font_title = ImageFont.truetype("arialbd.ttf", 52)
    font_subtitle = ImageFont.truetype("arialbd.ttf", 28)
    font_badge = ImageFont.truetype("arialbd.ttf", 22)
    font_body = ImageFont.truetype("arialbd.ttf", 32)
except Exception:
    font_large = font_title = font_subtitle = font_badge = font_body = ImageFont.load_default()

# -------------------------------------------------------------
# 1. APP ICON (512 x 512 PNG)
# -------------------------------------------------------------
icon = Image.new("RGBA", (512, 512), (244, 245, 248, 255))
draw = ImageDraw.Draw(icon)

# Draw Memphis brutalist rounded box
padding = 32
box_shape = [padding, padding, 512 - padding, 512 - padding]
# Shadow
draw.rounded_rectangle([padding + 12, padding + 12, 512 - padding + 12, 512 - padding + 12], radius=32, fill=(0, 0, 0, 255))
# Main Lime Yellow Card
draw.rounded_rectangle(box_shape, radius=32, fill=(226, 252, 82, 255), outline=(0, 0, 0, 255), width=8)

# Center Logo
logo_w = 340
aspect = logo_img.height / logo_img.width
logo_h = int(logo_w * aspect)
logo_resized = logo_img.resize((logo_w, logo_h), Image.Resampling.LANCZOS)

logo_x = (512 - logo_w) // 2
logo_y = (512 - logo_h) // 2
icon.paste(logo_resized, (logo_x, logo_y), logo_resized)

icon_path = os.path.join(out_dir, "app_icon_512x512.png")
icon.convert("RGB").save(icon_path, "PNG")
print(f"Generated App Icon: {icon_path} ({os.path.getsize(icon_path)} bytes)")


# -------------------------------------------------------------
# 2. FEATURE GRAPHIC (1024 x 500 PNG)
# -------------------------------------------------------------
fg = Image.new("RGBA", (1024, 500), (244, 245, 248, 255))
draw_fg = ImageDraw.Draw(fg)

# Draw subtle grid background
for x in range(0, 1024, 40):
    draw_fg.line([(x, 0), (x, 500)], fill=(0, 0, 0, 15), width=1)
for y in range(0, 500, 40):
    draw_fg.line([(0, y), (1024, y)], fill=(0, 0, 0, 15), width=1)

# Left Accent Card (Lime Yellow)
draw_fg.rounded_rectangle([60, 60, 500, 440], radius=24, fill=(0, 0, 0, 255))
draw_fg.rounded_rectangle([52, 52, 492, 432], radius=24, fill=(226, 252, 82, 255), outline=(0, 0, 0, 255), width=6)

# Paste Logo inside left card
logo_fg_w = 360
logo_fg_h = int(logo_fg_w * aspect)
logo_fg_resized = logo_img.resize((logo_fg_w, logo_fg_h), Image.Resampling.LANCZOS)
fg.paste(logo_fg_resized, (92, 242 - logo_fg_h // 2), logo_fg_resized)

# Right Text & Badges
draw_fg.rounded_rectangle([540, 70, 960, 120], radius=12, fill=(0, 240, 255, 255), outline=(0, 0, 0, 255), width=4)
draw_fg.text((560, 80), "120Hz SUPER FLUID APP", fill=(0, 0, 0, 255), font=font_subtitle)

draw_fg.text((540, 150), "SKIL LIFESTYLE", fill=(0, 0, 0, 255), font=font_title)
draw_fg.text((540, 220), "Cross-Platform E-Commerce &\nMultiplatform System Architecture", fill=(90, 96, 114, 255), font=font_subtitle)

# Feature Pills
pills = ["LIGHT MODE MEMPHIS", "TARGET SDK 36", "PEGI 3 RATED"]
px = 540
for pill in pills:
    draw_fg.rounded_rectangle([px, 340, px + 260, 390], radius=10, fill=(255, 255, 255, 255), outline=(0, 0, 0, 255), width=3)
    draw_fg.text((px + 14, 352), pill, fill=(0, 0, 0, 255), font=font_badge)
    px += 140

fg_path = os.path.join(out_dir, "feature_graphic_1024x500.png")
fg.convert("RGB").save(fg_path, "PNG")
print(f"Generated Feature Graphic: {fg_path} ({os.path.getsize(fg_path)} bytes)")


# -------------------------------------------------------------
# 3. PHONE SCREENSHOT 1: E-Commerce Store (1080 x 1920 PNG)
# -------------------------------------------------------------
s1 = Image.new("RGBA", (1080, 1920), (244, 245, 248, 255))
d1 = ImageDraw.Draw(s1)

# Status Bar
d1.rectangle([0, 0, 1080, 80], fill=(255, 255, 255, 255))
d1.text((50, 25), "09:41", fill=(0, 0, 0, 255), font=font_subtitle)
d1.text((920, 25), "120Hz ⚡", fill=(0, 0, 0, 255), font=font_subtitle)

# Header Card
d1.rounded_rectangle([48, 120, 1032, 340], radius=24, fill=(0, 0, 0, 255))
d1.rounded_rectangle([40, 112, 1024, 332], radius=24, fill=(255, 255, 255, 255), outline=(0, 0, 0, 255), width=6)
d1.text((80, 150), "SKIL LIFESTYLE", fill=(0, 0, 0, 255), font=font_title)
d1.text((80, 230), "Super Fluid Memphis E-Commerce", fill=(90, 96, 114, 255), font=font_subtitle)

# Cart Button
d1.rounded_rectangle([780, 150, 980, 220], radius=16, fill=(0, 240, 255, 255), outline=(0, 0, 0, 255), width=4)
d1.text((810, 168), "CART: 2", fill=(0, 0, 0, 255), font=font_subtitle)

# Filter Pills
cats = [("ALL", True), ("APPAREL", False), ("FOOTWEAR", False), ("TECH", False)]
cx = 40
for cat, active in cats:
    bg_col = (226, 252, 82, 255) if active else (255, 255, 255, 255)
    d1.rounded_rectangle([cx, 370, cx + 220, 440], radius=30, fill=bg_col, outline=(0, 0, 0, 255), width=4)
    d1.text((cx + 40, 388), cat, fill=(0, 0, 0, 255), font=font_subtitle)
    cx += 245

# Grid Product Cards (2 Columns)
products = [
    ("SKIL OVERSIZED HOODIE", "$89", "HOODIE", "HOT DROP", (226, 252, 82, 255)),
    ("120Hz RETRO KICKS", "$149", "KICKS", "LIMITED", (255, 101, 163, 255)),
    ("CYBER CROSSBODY BAG", "$45", "BAG", "NEW DROP", (0, 240, 255, 255)),
    ("MECHANICAL KEYBOARD", "$129", "KEYS", "BESTSELLER", (155, 81, 224, 255))
]

grid_coords = [(40, 480), (550, 480), (40, 1160), (550, 1160)]
for idx, (pname, price, label, badge, bcol) in enumerate(products):
    gx, gy = grid_coords[idx]
    # Card shadow
    d1.rounded_rectangle([gx + 12, gy + 12, gx + 490, gy + 640], radius=24, fill=(0, 0, 0, 255))
    # Card main
    d1.rounded_rectangle([gx, gy, gx + 478, gy + 628], radius=24, fill=(255, 255, 255, 255), outline=(0, 0, 0, 255), width=6)
    
    # Badge
    d1.rounded_rectangle([gx + 20, gy + 20, gx + 200, gy + 65], radius=10, fill=bcol, outline=(0, 0, 0, 255), width=3)
    d1.text((gx + 30, gy + 28), badge, fill=(0, 0, 0, 255), font=font_badge)

    # Product visual box
    d1.rounded_rectangle([gx + 20, gy + 80, gx + 458, gy + 380], radius=16, fill=(244, 245, 248, 255), outline=(0, 0, 0, 255), width=4)
    d1.text((gx + 140, gy + 200), label, fill=(0, 0, 0, 255), font=font_title)

    # Details
    d1.text((gx + 20, gy + 400), pname, fill=(0, 0, 0, 255), font=font_subtitle)
    d1.text((gx + 20, gy + 450), price, fill=(0, 0, 0, 255), font=font_title)

    # Add button
    d1.rounded_rectangle([gx + 300, gy + 530, gx + 458, gy + 600], radius=14, fill=(226, 252, 82, 255), outline=(0, 0, 0, 255), width=4)
    d1.text((gx + 330, gy + 548), "+ ADD", fill=(0, 0, 0, 255), font=font_subtitle)

# Memphis Toast Overlay (Rule 05)
d1.rounded_rectangle([60, 1780, 1020, 1880], radius=20, fill=(0, 0, 0, 255))
d1.rounded_rectangle([52, 1772, 1012, 1872], radius=20, fill=(226, 252, 82, 255), outline=(0, 0, 0, 255), width=6)
d1.text((90, 1805), "Added '120Hz RETRO KICKS' to cart!", fill=(0, 0, 0, 255), font=font_subtitle)

s1_path = os.path.join(out_dir, "phone_screenshot_1_1080x1920.png")
s1.convert("RGB").save(s1_path, "PNG")
print(f"Generated Phone Screenshot 1: {s1_path} ({os.path.getsize(s1_path)} bytes)")


# -------------------------------------------------------------
# 4. PHONE SCREENSHOT 2: Activity Log Dashboard (1080 x 1920 PNG)
# -------------------------------------------------------------
s2 = Image.new("RGBA", (1080, 1920), (244, 245, 248, 255))
d2 = ImageDraw.Draw(s2)

# Status Bar
d2.rectangle([0, 0, 1080, 80], fill=(255, 255, 255, 255))
d2.text((50, 25), "09:41", fill=(0, 0, 0, 255), font=font_subtitle)
d2.text((920, 25), "LOGS ⚡", fill=(0, 0, 0, 255), font=font_subtitle)

# Header Card
d2.rounded_rectangle([48, 120, 1032, 340], radius=24, fill=(0, 0, 0, 255))
d2.rounded_rectangle([40, 112, 1024, 332], radius=24, fill=(255, 255, 255, 255), outline=(0, 0, 0, 255), width=6)
d2.text((80, 150), "SYSTEM METRICS", fill=(0, 0, 0, 255), font=font_title)
d2.text((80, 230), "120Hz Performance & Rulebook Integrity", fill=(90, 96, 114, 255), font=font_subtitle)

# Metric Cards
m_data = [
    ("LOG ENTRIES", "34", (226, 252, 82, 255), 40),
    ("FILES TOUCHED", "18", (255, 101, 163, 255), 550)
]
for title, val, col, mx in m_data:
    d2.rounded_rectangle([mx + 12, 372, mx + 490, 600], radius=20, fill=(0, 0, 0, 255))
    d2.rounded_rectangle([mx, 360, mx + 478, 588], radius=20, fill=col, outline=(0, 0, 0, 255), width=6)
    d2.text((mx + 30, 390), title, fill=(0, 0, 0, 255), font=font_subtitle)
    d2.text((mx + 30, 460), val, fill=(0, 0, 0, 255), font=font_large)

# Logs List
d2.text((40, 630), "SYSTEM ACTIVITY LOGS", fill=(0, 0, 0, 255), font=font_title)

logs = [
    ("LOG-034", "Rule 07 No Emojis Compliance Audit", "2026-07-23 12:05 IST", "RULES"),
    ("LOG-033", "Target SDK 36 Upgrade & Version Code 100002", "2026-07-23 12:04 IST", "DEPLOY"),
    ("LOG-032", "Google Play Release Key SHA1 Alignment", "2026-07-23 11:40 IST", "DEPLOY"),
    ("LOG-031", "Release SigningConfig Debug Fallback Fix", "2026-07-23 08:21 IST", "DEPLOY"),
    ("LOG-030", "Android Release AAB CI Build Success", "2026-07-23 08:16 IST", "DEPLOY")
]

ly = 710
for lid, ltitle, ltime, lcat in logs:
    d2.rounded_rectangle([48, ly + 10, 1032, ly + 200], radius=20, fill=(0, 0, 0, 255))
    d2.rounded_rectangle([40, ly, 1024, ly + 190], radius=20, fill=(255, 255, 255, 255), outline=(0, 0, 0, 255), width=5)
    
    # ID Pill
    d2.rounded_rectangle([68, ly + 20, 240, ly + 65], radius=10, fill=(226, 252, 82, 255), outline=(0, 0, 0, 255), width=3)
    d2.text((88, ly + 28), lid, fill=(0, 0, 0, 255), font=font_badge)
    
    d2.text((260, ly + 28), ltime, fill=(90, 96, 114, 255), font=font_badge)
    d2.text((68, ly + 90), ltitle, fill=(0, 0, 0, 255), font=font_subtitle)
    
    ly += 220

s2_path = os.path.join(out_dir, "phone_screenshot_2_1080x1920.png")
s2.convert("RGB").save(s2_path, "PNG")
print(f"Generated Phone Screenshot 2: {s2_path} ({os.path.getsize(s2_path)} bytes)")
