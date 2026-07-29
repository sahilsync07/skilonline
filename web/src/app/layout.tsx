import type { Metadata } from "next";
import { Inter } from "next/font/google";
import "./globals.css";

const inter = Inter({
  subsets: ["latin"],
  weight: ["400", "500", "600", "700", "800", "900"],
  variable: "--font-inter",
});

export const metadata: Metadata = {
  title: "SKIL Lifestyle — Modern Light E-Commerce",
  description: "Light, elevated retail for discerning style. Explore curated footwear and lifestyle drops.",
  icons: {
    icon: "https://res.cloudinary.com/aiz2tooi/image/upload/f_auto,q_auto,w_32,h_32/v1784722804/SKIL_Lifestyle_Black_Transparent_BG_Logo.png",
  },
};

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html lang="en" className={inter.variable}>
      <head>
        <link
          rel="icon"
          type="image/x-icon"
          href="https://res.cloudinary.com/aiz2tooi/image/upload/f_auto,q_auto,w_32,h_32/v1784722804/SKIL_Lifestyle_Black_Transparent_BG_Logo.png"
        />
      </head>
      <body>{children}</body>
    </html>
  );
}
