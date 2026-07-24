// SKIL Lifestyle E-Commerce Store State & Logic Engine (Rule 07 In-House Vector Icons Compliant)

const CLOUDINARY_CLOUD_NAME = 'aiz2tooi';
const CLOUDINARY_PRESET = 'skilonline';
const CLOUDINARY_API_KEY = '981773849764185';

// 🎨 Rule 07 In-House Vector Icons (No Native Emojis)
const ICONS = {
    cart: `<svg width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2.5" stroke-linecap="round" stroke-linejoin="round"><circle cx="9" cy="21" r="1"/><circle cx="20" cy="21" r="1"/><path d="M1 1h4l2.68 13.39a2 2 0 0 0 2 1.61h9.72a2 2 0 0 0 2-1.61L23 6H6"/></svg>`,
    search: `<svg width="18" height="18" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2.5" stroke-linecap="round" stroke-linejoin="round"><circle cx="11" cy="11" r="8"/><line x1="21" y1="21" x2="16.65" y2="16.65"/></svg>`,
    drop: `<svg width="16" height="16" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2.5" stroke-linecap="round" stroke-linejoin="round"><path d="M12 2v6a4 4 0 0 1-4 4H2"/><path d="M12 2a10 10 0 1 1 0 20 10 10 0 0 1 0-20z"/></svg>`,
    apparel: `<svg width="28" height="28" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><path d="M20.38 3.46L16 2a4 4 0 0 1-8 0L3.62 3.46a2 2 0 0 0-1.34 2.23l.58 3.47a1 1 0 0 0 .99.84H6v10a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V10h2.15a1 1 0 0 0 .99-.84l.58-3.47a2 2 0 0 0-1.34-2.23z"/></svg>`,
    footwear: `<svg width="28" height="28" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><path d="M4 16v-3a2 2 0 0 1 2-2h3l3 4h7a3 3 0 0 1 3 3v1a1 1 0 0 1-1 1H5a1 1 0 0 1-1-1z"/><path d="M4 12V8a2 2 0 0 1 2-2h4"/></svg>`,
    tech: `<svg width="28" height="28" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><rect x="2" y="4" width="20" height="16" rx="2"/><line x1="6" y1="8" x2="6.01" y2="8"/><line x1="10" y1="8" x2="10.01" y2="8"/><line x1="14" y1="8" x2="14.01" y2="8"/><line x1="18" y1="8" x2="18.01" y2="8"/><line x1="8" y1="16" x2="16" y2="16"/></svg>`,
    accessories: `<svg width="28" height="28" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><path d="M6 20h12a2 2 0 0 0 2-2V8a2 2 0 0 0-2-2H6a2 2 0 0 0-2 2v10a2 2 0 0 0 2 2z"/><path d="M8 6V4a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2v2"/></svg>`,
    plus: `<svg width="18" height="18" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"><line x1="12" y1="5" x2="12" y2="19"/><line x1="5" y1="12" x2="19" y2="12"/></svg>`,
    close: `<svg width="18" height="18" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"><line x1="18" y1="6" x2="6" y2="18"/><line x1="6" y1="6" x2="18" y2="18"/></svg>`,
    cloud: `<svg width="18" height="18" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2.5" stroke-linecap="round" stroke-linejoin="round"><path d="M18 10h-1.26A8 8 0 1 0 9 20h9a5 5 0 0 0 0-10z"/></svg>`,
    bagEmpty: `<svg width="48" height="48" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><path d="M6 2L3 6v14a2 2 0 0 0 2 2h14a2 2 0 0 0 2-2V6l-3-4z"/><line x1="3" y1="6" x2="21" y2="6"/><path d="M16 10a4 4 0 0 1-8 0"/></svg>`
};

const PRODUCTS = [
    { id: 'prod-1', name: 'SKIL Memphis Oversized Hoodie', category: 'apparel', price: 89, rating: '★★★★★ (48)', iconKey: 'apparel', badge: 'HOT DROP' },
    { id: 'prod-2', name: '120Hz Velocity Retro Kicks', category: 'footwear', price: 149, rating: '★★★★★ (92)', iconKey: 'footwear', badge: 'LIMITED' },
    { id: 'prod-3', name: 'Cyber Neon Crossbody Bag', category: 'accessories', price: 45, rating: '★★★★☆ (31)', iconKey: 'accessories', badge: 'NEW' },
    { id: 'prod-4', name: 'Brutalist Tactile Mechanical Board', category: 'tech', price: 129, rating: '★★★★★ (114)', iconKey: 'tech', badge: 'BEST SELLER' },
    { id: 'prod-5', name: 'SKIL Signature Graphic Tee', category: 'apparel', price: 39, rating: '★★★★☆ (27)', iconKey: 'apparel', badge: 'POPULAR' },
    { id: 'prod-6', name: 'Lime Brutal Wireless Earbuds', category: 'tech', price: 79, rating: '★★★★★ (65)', iconKey: 'tech', badge: 'NEW' },
    { id: 'prod-7', name: 'Neon Gradient Beanie', category: 'accessories', price: 29, rating: '★★★★☆ (19)', iconKey: 'accessories', badge: 'MUST HAVE' },
    { id: 'prod-8', name: 'High-Top Platform Sneakers', category: 'footwear', price: 139, rating: '★★★★★ (83)', iconKey: 'footwear', badge: 'LIMITED' }
];

let cartState = [];
let activeCategory = 'all';
let searchQuery = '';

// Toast Notification Engine (Rule 05 Compliant)
function showToast(message, type = 'lime', duration = 4000) {
    const container = document.getElementById('toastContainer');
    const toast = document.createElement('div');
    toast.className = `memphis-toast ${type}`;
    if (type === 'pink') toast.style.background = 'var(--accent-pink)';
    if (type === 'cyan') toast.style.background = 'var(--accent-cyan)';

    toast.innerHTML = `
        <span>${message}</span>
        <button class="toast-close-btn" onclick="this.parentElement.remove()">${ICONS.close}</button>
    `;

    container.appendChild(toast);

    setTimeout(() => {
        if (toast.parentElement) {
            toast.style.transition = 'all 0.25s ease';
            toast.style.opacity = '0';
            toast.style.transform = 'translateY(-10px)';
            setTimeout(() => toast.remove(), 250);
        }
    }, duration);
}

// ☁️ Cloudinary Upload Engine
async function handleCloudinaryUpload(file) {
    if (!file) return;

    showToast(`Uploading "${file.name}" to Cloudinary...`, 'cyan', 3000);

    const formData = new FormData();
    formData.append('file', file);
    formData.append('upload_preset', CLOUDINARY_PRESET);
    formData.append('api_key', CLOUDINARY_API_KEY);

    const resourceType = file.type.startsWith('video/') ? 'video' : 'image';

    try {
        const response = await fetch(
            `https://api.cloudinary.com/v1_1/${CLOUDINARY_CLOUD_NAME}/${resourceType}/upload`,
            {
                method: 'POST',
                body: formData
            }
        );

        const data = await response.json();

        if (data.secure_url) {
            const optimizedUrl = getOptimizedCloudinaryUrl(data.secure_url);
            
            const newProd = {
                id: `cloudinary-${Date.now()}`,
                name: file.name.split('.')[0].toUpperCase(),
                category: 'apparel',
                price: 99,
                rating: '★★★★★ (NEW)',
                imageUrl: optimizedUrl,
                iconKey: 'apparel',
                badge: 'CLOUDINARY DROP'
            };

            PRODUCTS.unshift(newProd);
            renderProducts();
            showToast(`Success! "${file.name}" uploaded live to Cloudinary CDN!`, 'lime', 5000);
        } else {
            showToast(`Upload Failed: ${data.error?.message || 'Unknown error'}`, 'pink', 5000);
        }
    } catch (err) {
        showToast(`Cloudinary Error: ${err.message}`, 'pink', 5000);
    }
}

// ⚡ Cloudinary 120Hz CDN URL Optimizer
function getOptimizedCloudinaryUrl(url, width = 600) {
    if (!url || !url.includes('cloudinary.com')) return url;
    return url.replace('/upload/', `/upload/f_auto,q_auto,w_${width}/`);
}

// Render Products Grid
function renderProducts() {
    const container = document.getElementById('productsContainer');
    container.innerHTML = '';

    const filtered = PRODUCTS.filter(p => {
        const matchesCat = (activeCategory === 'all' || p.category === activeCategory);
        const matchesSearch = p.name.toLowerCase().includes(searchQuery.toLowerCase());
        return matchesCat && matchesSearch;
    });

    if (filtered.length === 0) {
        container.innerHTML = `
            <div style="grid-column: 1/-1; text-align: center; padding: 40px; background: #fff; border: 2px solid #000; border-radius: 12px; box-shadow: 4px 4px 0px #000;">
                <h3 style="font-size: 1.2rem; font-weight: 900;">NO PRODUCTS FOUND</h3>
                <p style="color: var(--text-muted); font-weight: 600; margin-top: 6px;">Try adjusting your search query or category filter.</p>
            </div>
        `;
        return;
    }

    filtered.forEach(product => {
        const card = document.createElement('div');
        card.className = 'product-card';

        const iconSvg = ICONS[product.iconKey] || ICONS.apparel;
        const mediaDisplay = product.imageUrl 
            ? `<img src="${product.imageUrl}" alt="${product.name}" style="width:100%; height:180px; object-fit:cover; border-bottom: 2.5px solid #000;">`
            : `<div class="product-img-box">${iconSvg}</div>`;

        card.innerHTML = `
            <span class="product-badge">${product.badge}</span>
            ${mediaDisplay}
            <div class="product-info">
                <span class="product-cat">${product.category}</span>
                <h3 class="product-name">${product.name}</h3>
                <div class="product-rating">${product.rating}</div>
                <div class="product-footer">
                    <span class="product-price">$${product.price}</span>
                    <button class="btn-add-cart" onclick="addToCart('${product.id}')">
                        <span class="btn-add-cart-text">${ICONS.plus} ADD TO CART</span>
                        <span class="btn-add-cart-icon">${ICONS.plus}</span>
                    </button>
                </div>
            </div>
        `;
        container.appendChild(card);
    });
}

// Cart State Management
function addToCart(productId) {
    const product = PRODUCTS.find(p => p.id === productId);
    if (!product) return;

    const existing = cartState.find(item => item.id === productId);
    if (existing) {
        existing.quantity += 1;
    } else {
        cartState.push({ ...product, quantity: 1 });
    }

    updateCartUI();
    showToast(`Added "${product.name}" to cart!`, 'lime');
}

function updateQuantity(productId, delta) {
    const item = cartState.find(i => i.id === productId);
    if (!item) return;

    item.quantity += delta;
    if (item.quantity <= 0) {
        cartState = cartState.filter(i => i.id !== productId);
    }
    updateCartUI();
}

function updateCartUI() {
    const badge = document.getElementById('cartBadge');
    const drawerBody = document.getElementById('drawerBody');
    const cartTotalVal = document.getElementById('cartTotalVal');

    const totalCount = cartState.reduce((sum, item) => sum + item.quantity, 0);
    const totalPrice = cartState.reduce((sum, item) => sum + (item.price * item.quantity), 0);

    badge.innerText = totalCount;
    cartTotalVal.innerText = `$${totalPrice}`;

    drawerBody.innerHTML = '';

    if (cartState.length === 0) {
        drawerBody.innerHTML = `
            <div style="text-align: center; padding: 40px 10px; color: var(--text-muted); font-weight: 700;">
                <div style="margin-bottom: 12px;">${ICONS.bagEmpty}</div>
                YOUR CART IS EMPTY
            </div>
        `;
        return;
    }

    cartState.forEach(item => {
        const itemEl = document.createElement('div');
        itemEl.className = 'cart-item';
        const itemSvg = ICONS[item.iconKey] || ICONS.apparel;

        itemEl.innerHTML = `
            <div class="cart-item-icon">${itemSvg}</div>
            <div class="cart-item-info">
                <div class="cart-item-title">${item.name}</div>
                <div class="cart-item-price">$${item.price} each</div>
                <div class="qty-controls">
                    <button class="btn-qty" onclick="updateQuantity('${item.id}', -1)">-</button>
                    <span class="qty-val">${item.quantity}</span>
                    <button class="btn-qty" onclick="updateQuantity('${item.id}', 1)">+</button>
                </div>
            </div>
            <div style="font-weight: 900; font-size: 1rem;">$${item.price * item.quantity}</div>
        `;
        drawerBody.appendChild(itemEl);
    });
}

// Drawer Visibility Toggles
function toggleCartDrawer() {
    const overlay = document.getElementById('cartOverlay');
    const drawer = document.getElementById('cartDrawer');
    overlay.classList.toggle('active');
    drawer.classList.toggle('active');
}

// Category & Search Filters
function setCategory(category, pillBtn) {
    activeCategory = category;
    document.querySelectorAll('.nav-cat-pill').forEach(btn => btn.classList.remove('active'));
    pillBtn.classList.add('active');
    renderProducts();
}

function handleSearch(query) {
    searchQuery = query;
    renderProducts();
}

// Checkout Handler
function checkout() {
    if (cartState.length === 0) {
        showToast('Your cart is empty!', 'pink');
        return;
    }

    const total = cartState.reduce((sum, item) => sum + (item.price * item.quantity), 0);
    cartState = [];
    updateCartUI();
    toggleCartDrawer();
    showToast(`Order Placed Successfully! Total: $${total}. Thanks for shopping SKIL!`, 'cyan', 5000);
}

// Initial Setup
document.addEventListener('DOMContentLoaded', () => {
    renderProducts();
    updateCartUI();
});
