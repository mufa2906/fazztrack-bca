import logo from "../../assets/images/bookshelf.png";
import { Link } from "react-router-dom";
import "./LoginForm.css";

function LoginForm() {
  return (
    <>
      <section className="form-container">
        <header>
          <img className="logo-image" src={logo} alt="dannnnn" />
        </header>
        <section className="form-desc-sect">
          <h1>Login</h1>
          <p>Welcome Back, Please Login to your account</p>
        </section>
        <section className="form-input-sect">
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
        <section className="form-addon-sect">
          <div>
            <input type="checkbox" name="remember-me" id="remember-me" />
            {/* <label for="remember-me">Remember me</label> */}
          </div>
          <a href="" id="forgot-password">
            Forgot Password?
          </a>
        </section>
        <section className="form-button-sect">
          <Link to="/" className="login-btn" id="login-btn-login">Login</Link>
          <Link to="./register" className="signup-btn" id="signup-btn-login" >
            Sign up
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

export default LoginForm;
