import { Link } from "react-router-dom";
import "./navbar.css";
import React from "react"


function Navbar() {
  return (
    <nav className="navbar-container">
      <div className="logo">
        <Link to="/">Logo</Link>
        </div>
      <div className="btn-group">
        <div className="btn-login">Login</div>
        <div className="btn-register">Register</div>
      </div>
    </nav>
  );
}

export default Navbar;
