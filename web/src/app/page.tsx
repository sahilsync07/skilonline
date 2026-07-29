"use client";

import { useState, useMemo } from "react";
import { Search, ShoppingBag, X, MapPin, Mail, Globe, Phone, CheckCircle } from "lucide-react";

interface Product {
  id: string;
  name: string;
  category: string;
  price: number;
  image: string;
  description: string;
  tag: string;
}

const PRODUCTS: Product[] = [
  {
    id: "1",
    name: "SKIL Air Flex Stealth",
    category: "FOOTWEAR",
    price: 4999,
    image: "https://res.cloudinary.com/aiz2tooi/image/upload/f_auto,q_auto,w_600/v1784722805/product_1.jpg",
    description: "Engineered mesh running shoes with responsive nitrogen-infused foam cushioning.",
    tag: "NEW DROP"
  },
  {
    id: "2",
    name: "Ajanta Speedster Pro",
    category: "FOOTWEAR",
    price: 2499,
    image: "https://res.cloudinary.com/aiz2tooi/image/upload/f_auto,q_auto,w_600/v1784722806/product_2.jpg",
    description: "Lightweight daily trainers crafted with high-traction rubber outsole.",
    tag: "AJANTA PARTNER"
  },
  {
    id: "3",
    name: "Impakto Urban Hype Kicks",
    category: "FOOTWEAR",
    price: 3299,
    image: "https://res.cloudinary.com/aiz2tooi/image/upload/f_auto,q_auto,w_600/v1784722807/product_3.jpg",
    description: "Streetwear aesthetic high-top sneakers with reinforced heel support.",
    tag: "POPULAR"
  },
  {
    id: "4",
    name: "SKIL Velocity Nitro",
    category: "FOOTWEAR",
    price: 5499,
    image: "https://res.cloudinary.com/aiz2tooi/image/upload/f_auto,q_auto,w_600/v1784722808/product_4.jpg",
    description: "Ultra-breathable marathon distance shoes with carbon fiber plate propulsors.",
    tag: "PREMIUM"
  }
];

interface CartItem extends Product {
  quantity: number;
}

interface ToastMessage {
  id: number;
  title: string;
  text: string;
}

export default function Home() {
  const [searchQuery, setSearchQuery] = useState("");
  const [selectedCategory, setSelectedCategory] = useState("ALL DROPS");
  const [cart, setCart] = useState<CartItem[]>([]);
  const [isCartOpen, setIsCartOpen] = useState(false);
  const [toasts, setToasts] = useState<ToastMessage[]>([]);

  const showToast = (message: string, title: string = "SKIL STORE") => {
    const id = Date.now();
    setToasts((prev) => [...prev, { id, title, text: message }]);
    setTimeout(() => {
      setToasts((prev) => prev.filter((t) => t.id !== id));
    }, 3500);
  };

  const removeToast = (id: number) => {
    setToasts((prev) => prev.filter((t) => t.id !== id));
  };

  const addToCart = (product: Product) => {
    setCart((prev) => {
      const existing = prev.find((item) => item.id === product.id);
      if (existing) {
        return prev.map((item) =>
          item.id === product.id ? { ...item, quantity: item.quantity + 1 } : item
        );
      }
      return [...prev, { ...product, quantity: 1 }];
    });
    showToast(`Added ${product.name} to cart!`, "CART UPDATED");
  };

  const updateQuantity = (id: string, delta: number) => {
    setCart((prev) =>
      prev
        .map((item) => {
          if (item.id === id) {
            const newQty = item.quantity + delta;
            return newQty > 0 ? { ...item, quantity: newQty } : null;
          }
          return item;
        })
        .filter(Boolean) as CartItem[]
    );
  };

  const cartTotalCount = useMemo(() => {
    return cart.reduce((sum, item) => sum + item.quantity, 0);
  }, [cart]);

  const cartTotalPrice = useMemo(() => {
    return cart.reduce((sum, item) => sum + item.price * item.quantity, 0);
  }, [cart]);

  const filteredProducts = useMemo(() => {
    return PRODUCTS.filter((product) => {
      const matchesSearch =
        product.name.toLowerCase().includes(searchQuery.toLowerCase()) ||
        product.description.toLowerCase().includes(searchQuery.toLowerCase());
      const matchesCategory =
        selectedCategory === "ALL DROPS" || product.category === selectedCategory;
      return matchesSearch && matchesCategory;
    });
  }, [searchQuery, selectedCategory]);

  return (
    <>
      {/* Memphis Toast Notification System (Rule 05 Compliant) */}
      <div id="toastContainer">
        {toasts.map((toast) => (
          <div key={toast.id} className="memphis-toast">
            <div className="toast-icon-wrapper">
              <CheckCircle size={20} />
            </div>
            <div className="toast-body">
              <span className="toast-badge">{toast.title}</span>
              <span className="toast-message">{toast.text}</span>
            </div>
            <button className="toast-close-btn" onClick={() => removeToast(toast.id)}>
              ✕
            </button>
          </div>
        ))}
      </div>

      {/* 1. Announcement Bar */}
      <div className="top-bar">
        SUMMER DROP &apos;26 IS LIVE &bull; FREE SHIPPING ON ORDERS OVER ₹1000 &bull; USE CODE &quot;SKIL26&quot;
      </div>

      {/* 2. Dual Navbar 1: Top Brand & Partner Logo Header */}
      <header className="logo-navbar">
        <a href="#" className="nav-brand">
          <img
            src="https://res.cloudinary.com/aiz2tooi/image/upload/f_auto,q_auto/v1784722804/SKIL_Lifestyle_Black_Transparent_BG_Logo.png"
            alt="SKIL Lifestyle Logo"
            className="brand-logo-main"
          />
        </a>

        <div className="partner-logos-container">
          <img
            src="https://res.cloudinary.com/aiz2tooi/image/upload/f_auto,q_auto/v1784722809/Ajanta_Transparent_Logo.png"
            alt="Ajanta Logo"
            className="partner-logo-item"
            title="Ajanta Official Partner"
          />
          <div className="partner-divider"></div>
          <img
            src="/impakto_logo.png"
            alt="Impakto Logo"
            className="partner-logo-item"
            title="Impakto Official Partner"
          />
        </div>
      </header>

      {/* 3. Dual Navbar 2: Navigation Controls & Cart */}
      <nav className="controls-navbar">
        <div className="controls-top-row">
          <div className="search-input-wrapper">
            <svg
              className="search-icon-inside"
              width="18"
              height="18"
              viewBox="0 0 24 24"
              fill="none"
              stroke="currentColor"
              strokeWidth="2.5"
              strokeLinecap="round"
              strokeLinejoin="round"
            >
              <circle cx="11" cy="11" r="8" />
              <line x1="21" y1="21" x2="16.65" y2="16.65" />
            </svg>
            <input
              id="searchInput"
              type="text"
              className="search-input"
              placeholder="Search products, kicks, tech..."
              value={searchQuery}
              onChange={(e) => setSearchQuery(e.target.value)}
            />
          </div>

          <button className="btn-cart" onClick={() => setIsCartOpen(true)}>
            <svg
              width="20"
              height="20"
              viewBox="0 0 24 24"
              fill="none"
              stroke="currentColor"
              strokeWidth="2.5"
              strokeLinecap="round"
              strokeLinejoin="round"
            >
              <circle cx="9" cy="21" r="1" />
              <circle cx="20" cy="21" r="1" />
              <path d="M1 1h4l2.68 13.39a2 2 0 0 0 2 1.61h9.72a2 2 0 0 0 2-1.61L23 6H6" />
            </svg>
            <span className="btn-cart-text">CART</span>
            <span className="cart-badge" id="cartBadge">{cartTotalCount}</span>
          </button>
        </div>

        <div className="nav-cat-row">
          {["ALL DROPS", "APPAREL", "FOOTWEAR", "TECH", "ACCESSORIES"].map((cat) => (
            <button
              key={cat}
              className={`nav-cat-pill ${selectedCategory === cat ? "active" : ""}`}
              onClick={() => setSelectedCategory(cat)}
            >
              {cat}
            </button>
          ))}
        </div>
      </nav>

      {/* 4. Main Showcase Layout */}
      <main>
        {/* Hero Showcase Section */}
        <div className="hero-container">
          <div className="hero-banner">
            <div className="hero-text">
              <span className="hero-tag">PREMIUM DESIGN, MODERN DROP</span>
              <h1>Light, elevated retail for discerning style.</h1>
              <p>
                Experience a refined daily shopping destination inspired by SKIL’s signature
                branding, clean lines, and premium gold accents.
              </p>
              <div className="hero-actions">
                <button
                  className="btn-primary"
                  onClick={() => showToast("Browsing the new SKIL collection", "COLLECTION")}
                >
                  Explore Collection
                </button>
              </div>
            </div>
          </div>
        </div>

        {/* Products Grid Section */}
        <section className="products-section">
          <div className="section-title">
            <span>Curated essentials for modern living.</span>
          </div>

          <div className="products-grid">
            {filteredProducts.map((product) => (
              <div key={product.id} className="product-card">
                <div className="product-img-box">
                  <span className="product-badge" style={{ position: "absolute", top: "12px", left: "12px", zIndex: 5 }}>
                    {product.tag}
                  </span>
                  <img src={product.image} alt={product.name} />
                </div>
                
                <div className="product-info">
                  <span className="product-cat">{product.category}</span>
                  <h3 className="product-name">{product.name}</h3>
                  <p className="product-desc">{product.description}</p>

                  <div className="product-footer">
                    <span className="product-price">₹{product.price.toLocaleString("en-IN")}</span>
                    <button className="btn-add-cart" onClick={() => addToCart(product)}>
                      + Add to Cart
                    </button>
                  </div>
                </div>
              </div>
            ))}
          </div>
        </section>
      </main>

      {/* 5. Premium Site Footer */}
      <footer className="site-footer">
        <div className="footer-top-accent"></div>

        <div className="footer-grid">
          <div className="footer-col">
            <div className="footer-col-header">
              <MapPin className="footer-icon" size={20} />
              <h4>REGISTERED OFFICE</h4>
            </div>
            <p>
              7-14(1)-9, AST 1085003765,
              <br />
              2nd Floor, New Colony, Srikakulam II Town,
              <br />
              Srikakulam, Srikakulam - 532001, Andhra Pradesh
            </p>
          </div>

          <div className="footer-col">
            <div className="footer-col-header">
              <MapPin className="footer-icon" size={20} />
              <h4>PRINCIPAL PLACE OF BUSINESS</h4>
            </div>
            <p>
              Shop No.7A, D.No. 28-10-4, Third Floor,
              <br />
              Vasavi Plaza, Theatre Road, Revenue Ward No.27,
              <br />
              Jagadamba Jn, Visakhapatnam - 530020, Andhra Pradesh
            </p>
          </div>
        </div>

        <div className="footer-contact-bar">
          <div className="contact-item">
            <Phone size={16} />
            <span>+91 93483 43310 | +91 79895 36155</span>
          </div>
          <div className="contact-item">
            <Mail size={16} />
            <span>skillifestyle.vizag@gmail.com</span>
          </div>
          <div className="contact-item">
            <Globe size={16} />
            <span>www.skillifestyle.in</span>
          </div>
        </div>

        <div className="footer-tagline-wrapper">
          <div className="tagline-line"></div>
          <span className="footer-tagline">STEP INTO EXCELLENCE</span>
          <div className="tagline-line"></div>
        </div>
      </footer>

      {/* 6. Cart Slide-Over Drawer */}
      <div
        className={`cart-overlay ${isCartOpen ? "active" : ""}`}
        onClick={() => setIsCartOpen(false)}
      ></div>

      <div className={`cart-drawer ${isCartOpen ? "active" : ""}`}>
        <div className="drawer-header">
          <h3>YOUR SHOPPING CART ({cartTotalCount})</h3>
          <button className="close-button" onClick={() => setIsCartOpen(false)}>
            <X size={22} />
          </button>
        </div>

        <div className="drawer-body">
          {cart.length === 0 ? (
            <p style={{ textAlign: "center", color: "var(--text-muted)", marginTop: "40px" }}>
              Your shopping cart is currently empty.
            </p>
          ) : (
            cart.map((item) => (
              <div key={item.id} className="cart-item">
                <div className="cart-item-icon">
                  <img
                    src={item.image}
                    alt={item.name}
                    style={{ width: "100%", height: "100%", objectFit: "contain" }}
                  />
                </div>
                <div>
                  <h4 className="cart-item-title">{item.name}</h4>
                  <p className="cart-item-price">₹{item.price.toLocaleString("en-IN")}</p>

                  <div className="qty-controls">
                    <button className="btn-qty" onClick={() => updateQuantity(item.id, -1)}>
                      -
                    </button>
                    <span className="qty-val">{item.quantity}</span>
                    <button className="btn-qty" onClick={() => updateQuantity(item.id, 1)}>
                      +
                    </button>
                  </div>
                </div>
              </div>
            ))
          )}
        </div>

        <div className="drawer-footer">
          <div className="cart-total-row">
            <span>SUBTOTAL:</span>
            <span>₹{cartTotalPrice.toLocaleString("en-IN")}</span>
          </div>
          <button
            className="btn-checkout"
            onClick={() => {
              if (cart.length === 0) return;
              showToast("Proceeding to checkout...", "CHECKOUT");
              setIsCartOpen(false);
            }}
          >
            Proceed To Checkout →
          </button>
        </div>
      </div>
    </>
  );
}
