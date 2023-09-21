import "./navbar.css";

function Navbar() {
  return (
    <nav className="navbar-container">
      <div className="logo">Logo</div>
      <div className="btn-group">
        <div className="btn-login">Login</div>
        <div className="btn-register">Register</div>
      </div>
    </nav>
  );
}

export default Navbar;
