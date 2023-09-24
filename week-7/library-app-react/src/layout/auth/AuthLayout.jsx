import './AuthLayout.css'
import PropTypes from "prop-types";

function AuthLayout({ children }) {
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
        {children}
      </div>
    </>
  );
}

AuthLayout.propTypes = {
  children: PropTypes.element,
};

export default AuthLayout;
