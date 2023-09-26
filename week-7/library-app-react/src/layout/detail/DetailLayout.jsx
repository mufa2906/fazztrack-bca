import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { getBookById } from "../../services/book";
import "./DetailLayout.css";
import { Link } from "react-router-dom";

function DetailLayout() {
  const [book, setBook] = useState({});
  const { bookId } = useParams();

  const fetchBookById = async (bookId) => {
    try {
      const res = await getBookById(bookId);
      setBook(res.data.data);
      console.log(book);
    } catch (error) {
      console.log(error);
    }
  };

  useEffect(() => {
    fetchBookById(bookId);
  });

  return (
    <>
      <main className="container-fluid d-flex flex-column p-0">
        <div
          className="image-hero-detail position-relative"
          id="image-hero-detail"
          style={{ backgroundImage: `url(${book.urlImage})` }}
        >
          <div className="d-flex gap-3 p-3 me-3 text-white justify-content-between align-items-center">
            <div className="rounded-circle bg-white d-flex align-content-center back-arrow-container">
              <Link to="/home">
                <img
                  src="../assets/arrow-left-solid.svg"
                  alt=""
                  className="position-block back-arrow"
                />
              </Link>
            </div>
            <div className="d-flex justify-content-end gap-3">
              {/* <!-- Button trigger edit modal --> */}
              <button
                type="button"
                className="btn text-white fs-4 p-0"
                data-bs-toggle="modal"
                data-bs-target="#editModal"
              >
                Edit
              </button>

              {/* <!-- Modal edit--> */}
              <div
                className="modal fade"
                id="editModal"
                tabIndex="-1"
                aria-labelledby="editModalLabel"
                aria-hidden="true"
              >
                <div className="modal-dialog modal-dialog-centered modal-lg">
                  <div className="modal-content">
                    <div className="modal-header px-5 border-0">
                      <h1
                        className="modal-title fs-3 text-black"
                        id="editModalLabel"
                      >
                        Edit Data
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
                            placeholder="http://gambar.com/dilan.jpg"
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
                            placeholder="Dilan 1990"
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
                            placeholder="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin ac diam eget est rutrum ultrices. Donec laoreet enim a massa dapibus, cursus egestas dui pulvinar."
                          ></textarea>
                        </div>
                      </div>
                    </div>
                    <div className="modal-footer px-5 border-0">
                      <button
                        type="button"
                        className="btn btn-warning save-edit-detail-button fs-5 m-0"
                        id="save-edit-detail-button"
                        data-bs-toggle="modal"
                        data-bs-target="#editModal"
                      >
                        Save
                      </button>
                    </div>
                  </div>
                </div>
              </div>

              {/* <!-- Button trigger delete modal --> */}
              <button
                type="button"
                className="btn text-white fs-4 p-0"
                data-bs-toggle="modal"
                data-bs-target="#deleteModal"
                id="deleteModalBtn"
              >
                Delete
              </button>

              {/* <!-- Modal delete--> */}
              <div
                className="modal fade"
                id="deleteModal"
                tabIndex="-1"
                aria-labelledby="deleteModalLabel"
                aria-hidden="true"
              >
                <div className="modal-dialog modal-dialog-centered modal-lg">
                  <div className="modal-content">
                    <div className="modal-header border-0">
                      <button
                        type="button"
                        className="btn-close"
                        id="button-close"
                        data-bs-dismiss="modal"
                        aria-label="Close"
                      ></button>
                    </div>
                    <div className="modal-body d-flex flex-column align-items-center text-black p-5 m-5 gap-3">
                      <img
                        src="../assets/checked.png"
                        alt=""
                        className="w-25"
                      />
                      <h2 className="text-center">
                        Data{" "}
                        <span className="fw-bold title-book-delete">
                          Dilan 1990
                        </span>{" "}
                        berhasil dihapus !
                      </h2>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div className="image-desc-detail">
          <section className="d-flex mb-4 align-items-center w-100 position-relative title-sect">
            <div className="w-50">
              <h4 className="mb-1">
                <span className="badge bg-warning rounded-pill badge-detail">
                  Novel
                </span>
              </h4>
              <h2 className="fw-bold mb-1 title-book-detail" id="title-detail">
                {book.title}
              </h2>
              <p className="fs-5 mb-1">30 Juni 2019</p>
            </div>
            <div className="availability-text-sect d-flex align-items-center w-25 justify-content-end">
              <h2 className="availability-text">Available</h2>
            </div>

            <div className="position-absolute image-detail-container w-25">
              <img
                id="image-detail"
                className=""
                src="../assets/image-detail-dilan.png"
                alt=""
              />
            </div>
          </section>
          <section className="d-flex description-sect">
            <p className="w-75 desc-book-detail mb-0" id="description-detail">
              {book.description}
            </p>
            <div className="flex-fill d-flex align-items-end justify-content-center">
              <a
                href="./home.html"
                className="btn btn-warning borrow-button fs-4"
              >
                Borrow
              </a>
            </div>
          </section>
        </div>
      </main>
    </>
  );
}

export default DetailLayout;
