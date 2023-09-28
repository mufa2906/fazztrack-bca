import "./SidebarHome.css";
import ppNiki from "../../assets/images/pp-niki.png";
import logoutIcon from "../../assets/icons/logout.png";
import menuIcon from "../../assets/icons/menu.png";
import { Link } from "react-router-dom";

function Sidebar() {
  const clearLocal = () => {
    localStorage.clear();
  };
  return (
    <>
      {" "}
      <aside className="p-0 d-flex flex-fill">
        {/* <!-- Sidebar-Open --> */}
        <div
          className="bg-light-subtle container-fluid collapse collapse-horizontal"
          id="collapseOpen"
        >
          <div className="sidebar-open">
            <section className="user-sect d-flex flex-column justify-content-center align-items-center my-4 gap-2 container-fluid">
              <img src={ppNiki} alt="" className="user-image" />
              <h3
                className="user-name text-center container-fluid text-nowrap"
                id="user-fullname"
              >
                {localStorage.getItem("fullname")}
              </h3>
              <Link to="/" className="logout-btn nav-link" onClick={clearLocal}>
                <img src={logoutIcon} alt="" />
                Logout
              </Link>
            </section>
            <section className="menu-list-sect">
              <ul className="list-unstyled">
                <li className="mb-3">
                  <a href="" className="explore-btn nav-link fs-4">
                    Explore
                  </a>
                </li>
                <li className="mb-3">
                  <a href="" className="history-btn nav-link fs-4">
                    History
                  </a>
                </li>
                <li className="mb-3">
                  {/* <!-- Button trigger add modal --> */}

                  <button
                    type="button"
                    className="btn nav-link fs-4 p-0 text-black"
                    id="add-book-btn"
                    data-bs-toggle="modal"
                    data-bs-target="#addModal"
                  >
                    Add Book
                  </button>
                </li>
              </ul>
            </section>
          </div>
        </div>

        {/* <!-- Sidebar-Close --> */}
        <div className="bg-light-subtle p-4 " id="collapseClose">
          <a
            href=""
            className="menu-icon d-flex justify-content-end sidebar-close"
            data-bs-toggle="collapse"
            data-bs-target="#collapseOpen"
            aria-expanded="false"
            aria-controls="collapseOpen"
          >
            <img src={menuIcon} alt="dasf" />
          </a>
        </div>
      </aside>
    </>
  );
}

export default Sidebar;
