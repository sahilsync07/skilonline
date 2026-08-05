import urllib.request
import json
import os

cloud_name = 'aiz2tooi'
upload_preset = 'skilonline'
url = f'https://api.cloudinary.com/v1_1/{cloud_name}/image/upload'

base_path = r'C:\Users\Sahil Kumar\.gemini\antigravity\brain\0622a490-0b11-4320-a7c1-6a6eeca0896f'
files = [
    os.path.join(base_path, 'oversized_hoodie_1784984022397.jpg'),
    os.path.join(base_path, 'retro_kicks_1784984033342.jpg'),
    os.path.join(base_path, 'crossbody_bag_1784984043160.jpg'),
    os.path.join(base_path, 'mechanical_keyboard_1784984053869.jpg')
]

def upload_file(file_path):
    if not os.path.exists(file_path):
        print(f"NOT FOUND: {file_path}")
        return None

    boundary = '----WebKitFormBoundary7MA4YWxkTrZu0gW'
    body = []
    
    # upload_preset
    body.append(f'--{boundary}'.encode('utf-8'))
    body.append(f'Content-Disposition: form-data; name="upload_preset"'.encode('utf-8'))
    body.append(b'')
    body.append(upload_preset.encode('utf-8'))
    
    # file
    filename = os.path.basename(file_path)
    body.append(f'--{boundary}'.encode('utf-8'))
    body.append(f'Content-Disposition: form-data; name="file"; filename="{filename}"'.encode('utf-8'))
    body.append(b'Content-Type: image/jpeg')
    body.append(b'')
    with open(file_path, 'rb') as f:
        body.append(f.read())
        
    body.append(f'--{boundary}--'.encode('utf-8'))
    body.append(b'')
    
    payload = b'\r\n'.join(body)
    
    req = urllib.request.Request(url, data=payload)
    req.add_header('Content-Type', f'multipart/form-data; boundary={boundary}')
    
    try:
        with urllib.request.urlopen(req) as resp:
            data = json.loads(resp.read().decode('utf-8'))
            print(f"SUCCESS {filename}: {data.get('secure_url')}")
            return data.get('secure_url')
    except Exception as e:
        print(f"FAILED {filename}: {e}")
        return None

for f in files:
    upload_file(f)
