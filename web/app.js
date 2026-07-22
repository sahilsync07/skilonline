// SKIL Lifestyle E-Commerce Store State & Logic Engine (Cloudinary Integrated)

const CLOUDINARY_CLOUD_NAME = 'aiz2tooi';
const CLOUDINARY_PRESET = 'skilonline';
const CLOUDINARY_API_KEY = '981773849764185';

const PRODUCTS = [
    { id: 'prod-1', name: 'SKIL Memphis Oversized Hoodie', category: 'apparel', price: 89, rating: '★★★★★ (48)', icon: '🧥', badge: 'HOT DROP' },
    { id: 'prod-2', name: '120Hz Velocity Retro Kicks', category: 'footwear', price: 149, rating: '★★★★★ (92)', icon: '👟', badge: 'LIMITED' },
    { id: 'prod-3', name: 'Cyber Neon Crossbody Bag', category: 'accessories', price: 45, rating: '★★★★☆ (31)', icon: '🎒', badge: 'NEW' },
    { id: 'prod-4', name: 'Brutalist Tactile Mechanical Board', category: 'tech', price: 129, rating: '★★★★★ (114)', icon: '⌨️', badge: 'BEST SELLER' },
    { id: 'prod-5', name: 'SKIL Signature Graphic Tee', category: 'apparel', price: 39, rating: '★★★★☆ (27)', icon: '👕', badge: 'POPULAR' },
    { id: 'prod-6', name: 'Lime Brutal Wireless Earbuds', category: 'tech', price: 79, rating: '★★★★★ (65)', icon: '🎧', badge: 'NEW' },
    { id: 'prod-7', name: 'Neon Gradient Beanie', category: 'accessories', price: 29, rating: '★★★★☆ (19)', icon: '🧢', badge: 'MUST HAVE' },
    { id: 'prod-8', name: 'High-Top Platform Sneakers', category: 'footwear', price: 139, rating: '★★★★★ (83)', icon: '🥾', badge: 'LIMITED' }
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
        <button class="toast-close-btn" onclick="this.parentElement.remove()">×</button>
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
            
            // Create a new product item dynamically from the uploaded Cloudinary asset!
            const newProd = {
                id: `cloudinary-${Date.now()}`,
                name: file.name.split('.')[0].toUpperCase(),
                category: 'apparel',
                price: 99,
                rating: '★★★★★ (NEW)',
                imageUrl: optimizedUrl,
                icon: file.type.startsWith('video/') ? '🎬' : '📸',
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

        const mediaDisplay = product.imageUrl 
            ? `<img src="${product.imageUrl}" alt="${product.name}" style="width:100%; height:180px; object-fit:cover; border-bottom: 2.5px solid #000;">`
            : `<div class="product-img-box">${product.icon}</div>`;

        card.innerHTML = `
            <span class="product-badge">${product.badge}</span>
            ${mediaDisplay}
            <div class="product-info">
                <span class="product-cat">${product.category}</span>
                <h3 class="product-name">${product.name}</h3>
                <div class="product-rating">${product.rating}</div>
                <div class="product-footer">
                    <span class="product-price">$${product.price}</span>
                    <button class="btn-add-cart" onclick="addToCart('${product.id}')">+ Add To Cart</button>
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
                <div style="font-size: 3rem; margin-bottom: 10px;">🛍️</div>
                YOUR CART IS EMPTY
            </div>
        `;
        return;
    }

    cartState.forEach(item => {
        const itemEl = document.createElement('div');
        itemEl.className = 'cart-item';
        itemEl.innerHTML = `
            <div class="cart-item-icon">${item.icon || '📦'}</div>
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
