import urllib.request
import os
import shutil

# Directories
res_dir = r"c:\Projects\skilonline\android\composeApp\src\commonMain\composeResources"
font_dir = os.path.join(res_dir, "font")
drawable_dir = os.path.join(res_dir, "drawable")
logo_dir = r"c:\Projects\skilonline\ai\assets\logo"

os.makedirs(font_dir, exist_ok=True)
os.makedirs(drawable_dir, exist_ok=True)

# Copy and rename logos
logos_to_copy = {
    "Ajanta_Transparent_Logo.png": "ajanta_logo.png",
    "SKIL_Lifestyle_Black_Transparent_BG_Logo.png": "skil_logo.png",
    "Xpania_Transparent_Logo.png": "xpania_logo.png"
}

for src_name, dest_name in logos_to_copy.items():
    src_path = os.path.join(logo_dir, src_name)
    dest_path = os.path.join(drawable_dir, dest_name)
    print(f"Copying {src_name} to {dest_name}...")
    shutil.copy2(src_path, dest_path)
    print(f"Copied {dest_path}")

print("Assets setup complete.")
