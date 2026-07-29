"use client";

import { useState, useMemo } from "react";
import { Search, ShoppingBag, X, MapPin, Mail, Globe } from "lucide-react";

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
  text: string;
}

export default function Home() {
  const [searchQuery, setSearchQuery] = useState("");
  const [selectedCategory, setSelectedCategory] = useState("ALL DROPS");
  const [cart, setCart] = useState<CartItem[]>([]);
  const [isCartOpen, setIsCartOpen] = useState(false);
  const [toasts, setToasts] = useState<ToastMessage[]>([]);

  const showToast = (message: string) => {
    const id = Date.now();
    setToasts((prev) => [...prev, { id, text: message }]);
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
    showToast(`Added ${product.name} to cart!`);
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
      {/* Toast Notification Overlay Container */}
      <div id="toastContainer">
        {toasts.map((toast) => (
          <div key={toast.id} className="toast lime">
            <span>{toast.text}</span>
            <button className="toast-close" onClick={() => removeToast(toast.id)}>
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
            src="/skil_logo.png"
            alt="SKIL Lifestyle Logo"
            className="brand-logo-main"
          />
        </a>

        <div className="partner-logos-container">
          <img
            src="/ajanta_logo.png"
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
            <Search className="search-icon-inside" size={18} />
            <input
              type="text"
              className="search-input"
              placeholder="Search products, kicks, tech..."
              value={searchQuery}
              onChange={(e) => setSearchQuery(e.target.value)}
            />
          </div>

          <button className="btn-cart" onClick={() => setIsCartOpen(true)}>
            <ShoppingBag size={20} />
            <span className="btn-cart-text">CART</span>
            <span className="cart-badge">{cartTotalCount}</span>
          </button>
        </div>

        <div className="nav-cat-row">
          {["ALL DROPS", "FOOTWEAR"].map((cat) => (
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

      {/* 4. Main Showcase Section */}
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
              <button
                className="btn-primary"
                onClick={() => showToast("Browsing the new SKIL collection")}
              >
                Explore Collection
              </button>
            </div>
          </div>
        </div>

        {/* Products Section */}
        <section className="products-section">
          <div className="section-title">
            <span>Curated essentials for modern living. ({filteredProducts.length})</span>
          </div>

          <div className="products-grid">
            {filteredProducts.map((product) => (
              <div key={product.id} className="product-card">
                <div className="card-img-wrapper">
                  <span className="card-badge-top">{product.tag}</span>
                  <img src={product.image} alt={product.name} />
                </div>
                <span className="card-category">{product.category}</span>
                <h3 className="card-title">{product.name}</h3>
                <p className="card-desc">{product.description}</p>

                <div className="card-bottom-row">
                  <span className="card-price">₹{product.price.toLocaleString("en-IN")}</span>
                  <button className="btn-add-cart" onClick={() => addToCart(product)}>
                    + Add to Cart
                  </button>
                </div>
              </div>
            ))}
          </div>
        </section>
      </main>

      {/* 5. Site Footer */}
      <footer className="site-footer">
        <div className="footer-grid">
          <div className="footer-col">
            <div className="footer-col-header">
              <MapPin size={20} />
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
              <MapPin size={20} />
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
        className={`cart-overlay ${isCartOpen ? "open" : ""}`}
        onClick={() => setIsCartOpen(false)}
      ></div>

      <div className={`cart-drawer ${isCartOpen ? "open" : ""}`}>
        <div className="drawer-header">
          <div className="drawer-title">YOUR SHOPPING CART ({cartTotalCount})</div>
          <button className="btn-close-drawer" onClick={() => setIsCartOpen(false)}>
            <X size={20} />
          </button>
        </div>

        <div className="drawer-body">
          {cart.length === 0 ? (
            <p style={{ textAlign: "center", color: "var(--text-muted)", marginTop: "40px" }}>
              Your shopping cart is currently empty.
            </p>
          ) : (
            cart.map((item) => (
              <div
                key={item.id}
                style={{
                  display: "flex",
                  gap: "14px",
                  marginBottom: "20px",
                  paddingBottom: "16px",
                  borderBottom: "1px solid rgba(18,18,18,0.06)",
                }}
              >
                <img
                  src={item.image}
                  alt={item.name}
                  style={{
                    width: "70px",
                    height: "70px",
                    objectFit: "contain",
                    background: "var(--bg-soft)",
                    borderRadius: "10px",
                    padding: "4px",
                  }}
                />
                <div style={{ flex: 1 }}>
                  <h4 style={{ fontSize: "0.95rem", fontWeight: "700" }}>{item.name}</h4>
                  <span style={{ fontSize: "0.85rem", color: "var(--accent-gold)", fontWeight: "700" }}>
                    ₹{item.price.toLocaleString("en-IN")}
                  </span>
                  <div
                    style={{
                      display: "flex",
                      alignItems: "center",
                      gap: "10px",
                      marginTop: "8px",
                    }}
                  >
                    <button
                      onClick={() => updateQuantity(item.id, -1)}
                      style={{
                        width: "24px",
                        height: "24px",
                        borderRadius: "50%",
                        border: "1px solid rgba(18,18,18,0.2)",
                        background: "#fff",
                        cursor: "pointer",
                        fontWeight: "800",
                      }}
                    >
                      -
                    </button>
                    <span style={{ fontWeight: "700", fontSize: "0.9rem" }}>{item.quantity}</span>
                    <button
                      onClick={() => updateQuantity(item.id, 1)}
                      style={{
                        width: "24px",
                        height: "24px",
                        borderRadius: "50%",
                        border: "1px solid rgba(18,18,18,0.2)",
                        background: "#fff",
                        cursor: "pointer",
                        fontWeight: "800",
                      }}
                    >
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
              showToast("Proceeding to checkout...");
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
