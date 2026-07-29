import sys

journal_path = r'c:\Projects\skilonline\ai\journal.html'
context_path = r'c:\Projects\skilonline\ai\appended-context-window.html'

entry = '''
        <!-- Entry -->
        <div class="entry-card" style="border: 3px solid #000; border-radius: 12px; padding: 24px; background: #fff; margin-bottom: 32px; box-shadow: 8px 8px 0px #000;">
            <div style="display: flex; justify-content: space-between; margin-bottom: 16px;">
                <div>
                    <span style="background: #ff65a3; color: #fff; padding: 4px 12px; border-radius: 99px; font-weight: bold; font-size: 0.8rem; border: 2px solid #000;">UI REFINEMENT</span>
                    <span style="margin-left: 12px; color: #5a6072; font-weight: bold;">Date: 2026-07-29</span>
                </div>
                <div style="font-weight: 800; font-size: 1.2rem; color: #0d0e12;">#12</div>
            </div>
            
            <h3 style="margin-top: 0; font-size: 1.5rem; color: #0d0e12; font-weight: 900; text-transform: uppercase;">WASM Image Anti-Aliasing & Premium Footer</h3>
            
            <p style="color: #0d0e12; font-weight: 500; line-height: 1.6; margin-bottom: 16px;">
                Resolved Compose WASM canvas rendering aliasing by permanently downscaling heavy 2000px PNG resources using high-quality Python Lanczos resampling. Re-structured the footer into a premium, responsive 3-column grid to eliminate wasted space.
            </p>
            
            <div style="background: #f4f5f8; border: 2px solid #000; padding: 16px; border-radius: 8px; font-family: monospace; font-size: 0.9rem; margin-bottom: 16px;">
                <strong>Changes:</strong><br>
                - Python PIL script: Resized SKIL, Ajanta, and Impakto logos (max 150px height) to stop WASM nearest-neighbor aliasing.<br>
                - ECommerceScreen.kt: Adjusted logo heights (44.dp, 32.dp) to fit gracefully in a single navigation row.<br>
                - PremiumFooter.kt: Replaced FlowRow with responsive 3-column layout (Brand, Reg Office, Principal Office) and copyright bar.<br>
            </div>
        </div>
'''

try:
    with open(journal_path, 'r', encoding='utf-8') as f:
        content = f.read()
    
    if '<div class="timeline">' in content:
        parts = content.split('<div class="timeline">')
        new_content = parts[0] + '<div class="timeline">\n' + entry + parts[1]
        with open(journal_path, 'w', encoding='utf-8') as f:
            f.write(new_content)
        print('Journal updated.')
    else:
        print('Could not find timeline div in journal.')
        
    with open(context_path, 'a', encoding='utf-8') as f:
        f.write('\n<div style="border:1px solid #ccc; padding:10px; margin-bottom:10px;"><strong>2026-07-29 Update:</strong> Fixed WASM image aliasing by resizing source PNGs. Redesigned PremiumFooter to a responsive 3-column layout. Reduced navbar logo sizes to fit in single row.</div>')
    print('Context updated.')
    
except Exception as e:
    print('Error:', e)
