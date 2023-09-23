import React from "react";
import { Outlet } from "react-router-dom";
import "./style-login.css";

function Login() {
  return (
    <>
      <div className="main-container">
        <section className="hero-container">
          <header>
            <h2 className="hero-title">Book is a window to the world</h2>
          </header>
          <footer>
            <p className="hero-credit">Photo by Mark Pan4ratte on Unsplash</p>
          </footer>
        </section>

        <Outlet />
      </div>
    </>
  );
}

export default Login;
