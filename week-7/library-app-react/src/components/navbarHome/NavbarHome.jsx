import "./NavbarHome.css";
import logo from "../../assets/images/bookshelf.png";
import DropdownHome from "../dropdownHome/DropdownHome";

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
                <DropdownHome
                  dropdownName={"All Categories"}
                  dropdownItem={["Action", "Comedy", "Finance"]}
                />
                <DropdownHome
                  dropdownName={"All Times"}
                  dropdownItem={[
                    "Action",
                    "Another action",
                    "Something else here",
                  ]}
                />
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
                      src={logo}
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
