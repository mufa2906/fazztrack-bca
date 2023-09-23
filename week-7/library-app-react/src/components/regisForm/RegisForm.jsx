import React from "react";
import logo from "../../assets/images/bookshelf.png";
import {Link} from 'react-router-dom';

function RegisForm() {
  return (
    <>
      <section className="form-container">
        <header>
          <img className="logo-image" src={logo} alt="dannnnn" />
        </header>
        <section className="form-desc-sect">
          <h1>Register</h1>
          <p>Welcome Back, Please Register to create account</p>
        </section>
        <section className="form-input-sect">
          <div className="form-input">
            {/* <label for="username-input">Username</label> */}
            <input
              type="text"
              name="username-input"
              id="username-input"
              placeholder="Enter your username"
            />
          </div>
          <div className="form-input">
            {/* <label for="fullname-input">Full name</label> */}
            <input
              type="text"
              name="fullname-input"
              id="fullname-input"
              placeholder="Enter your full name"
            />
          </div>
          <div className="form-input">
            {/* <label for="email-input">Email Address</label> */}
            <input
              type="email"
              name="email-input"
              id="email-input"
              placeholder="Enter your email address"
            />
          </div>
          <div className="form-input">
            {/* <label for="password-input">Password</label> */}
            <input
              type="password"
              name="password-input"
              id="password-input"
              placeholder="Enter your password"
            />
          </div>
        </section>
        <section className="form-button-sect">
          <a href="" className="signup-btn">
            Sign up
          </a>
          <Link to="/" className="login-btn">
            Login
          </Link>
        </section>
        <footer>
          <p>
            By signing up, you agree to Book’s
            <span>Terms and Conditions</span> & <span>Privacy Policy</span>
          </p>
        </footer>
      </section>
    </>
  );
}

export default RegisForm;
