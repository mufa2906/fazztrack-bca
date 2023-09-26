function HeaderHome() {
  return (
    <>
      <header className="container-fluid p-0 header-logo">
        <nav className="navbar navbar-expand bg-body-tertiary">
          <div className="container-fluid">
            <div
              className="collapse navbar-collapse"
              id="navbarSupportedContent"
            >
              <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                {/* <!-- Bootstrap Dropdown --> */}
                <li className="nav-item dropdown">
                  <a
                    className="nav-link dropdown-toggle fw-bold"
                    href="#"
                    role="button"
                    data-bs-toggle="dropdown"
                    aria-expanded="false"
                  >
                    All Categories
                  </a>
                  <ul className="dropdown-menu">
                    <li>
                      <a className="dropdown-item" href="#">
                        Action
                      </a>
                    </li>
                    <li>
                      <a className="dropdown-item" href="#">
                        Comedy
                      </a>
                    </li>
                    <li>
                      <a className="dropdown-item" href="#">
                        Finance
                      </a>
                    </li>
                  </ul>
                </li>
                {/* <!-- DOM Manipulation Dropdown --> */}
                <li className="nav-item dropdown">
                  <a
                    className="nav-link dropdown-toggle fw-bold"
                    id="dropdown-alltimes"
                    href="#"
                    role="button"
                  >
                    All times
                  </a>
                  <ul className="dropdown-menu" id="menu-dropdown-alltimes">
                    <li>
                      <a className="dropdown-item" href="#">
                        Action
                      </a>
                    </li>
                    <li>
                      <a className="dropdown-item" href="#">
                        Another action
                      </a>
                    </li>
                    <li>
                      <hr className="dropdown-divider" />
                    </li>
                    <li>
                      <a className="dropdown-item" href="#">
                        Something else here
                      </a>
                    </li>
                  </ul>
                </li>
              </ul>
              <section className="search-logo-sect d-flex align-items-center justify-content-between w-75 ps-5">
                <form className="d-flex w-100" role="search">
                  <input
                    className="form-control rounded-pill search"
                    type="search"
                    placeholder="Search book"
                    aria-label="Search"
                  />
                </form>
                <div className="container-fluid d-flex justify-content-end ps-0">
                  <a
                    className="navbar-brand fs-2 d-flex align-items-center justify-content-center"
                    href="#"
                  >
                    <img
                      src="../assets/bookshelf.png"
                      alt="Logo"
                      className="d-inline-block align-text-center logo-image"
                    />
                    <h2 className="m-0 fs-3">Library</h2>
                  </a>
                </div>
              </section>
            </div>
          </div>
        </nav>
      </header>
    </>
  );
}

export default HeaderHome;
