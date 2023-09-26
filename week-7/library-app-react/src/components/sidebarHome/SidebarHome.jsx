function Sidebar() {
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
              <img src="../assets/pp-niki.png" alt="" className="user-image" />
              <h3
                className="user-name text-center container-fluid text-nowrap"
                id="user-fullname"
              >
                Blablabla
              </h3>
              <a href="./login.html" className="logout-btn nav-link">
                <img src="../assets/logout.png" alt="" />
                Logout
              </a>
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
                  >
                    {/* <!-- data-bs-toggle="modal" */}
                    {/* data-bs-target="#addBookModal" --> */}
                    Add Book
                  </button>
                </li>
              </ul>
            </section>
          </div>
        </div>
        {/* <!-- Modal add--> */}
        <div
          className="modal fade"
          id="addBookModal"
          tabIndex="-1"
          aria-labelledby="addBook
  ModalLabel"
          aria-hidden="true"
        >
          <div className="modal-dialog modal-dialog-centered modal-lg">
            <div className="modal-content">
              <div className="modal-header px-5 border-0">
                <h1
                  className="modal-title fs-3 text-black"
                  id="addBook
            ModalLabel"
                >
                  Add Data
                </h1>
                <button
                  type="button"
                  className="btn-close"
                  id="button-close"
                  data-bs-dismiss="modal"
                  aria-label="Close"
                ></button>
              </div>
              <div className="modal-body px-5 border-0">
                <div className="text-black container-fluid d-grid row-gap-3">
                  <div className="row align-items-center">
                    {/* <label for="url-image-book" className="col-md-4 p-0 fs-5"
                      >Url Image</label
                    > */}
                    <input
                      id="url-image"
                      name="url-image"
                      type="text"
                      className="col-8 rounded-2 border-1 book-detail-input lh-lg"
                      placeholder="Url Image.."
                    />
                  </div>
                  <div className="row align-items-center">
                    {/* <label for="title-book" className="col-md-4 p-0 fs-5"
                      >Title</label
                    > */}
                    <input
                      id="title"
                      name="text"
                      type="text"
                      className="col-8 rounded-2 border-1 book-detail-input lh-lg"
                      placeholder="Title..."
                    />
                  </div>
                  <div className="row align-items-start">
                    {/* <label for="description-book" className="col-md-4 p-0 fs-5"
                      >Description</label
                    > */}
                    <textarea
                      className="col-8 rounded-2 border-1 book-detail-input lh-lg"
                      name="description-book"
                      id="description-book"
                      cols="30"
                      rows="4"
                      placeholder="Description..."
                    ></textarea>
                  </div>
                </div>
              </div>
              <div className="modal-footer px-5 border-0">
                <button
                  type="button"
                  className="btn btn-warning fs-5 m-0 text-white"
                  id="save-add-book-home-button"
                >
                  Save
                </button>
              </div>
            </div>
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
            <img src="../assets/menu.png" alt="dasf" />
          </a>
        </div>
      </aside>
    </>
  );
}

export default Sidebar;
