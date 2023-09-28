import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { createBook, removeBook, updateBook } from "../../services/book";
import "./ModalBook.css";

function ModalBook({ modalName, book, setBook, books, setBooks }) {
  const navigate = useNavigate();

  const [title, setTitle] = useState("");
  const [urlImage, setUrlImage] = useState("");
  const [description, setDescription] = useState("");
  const token = localStorage.getItem("token");

  const deleteBook = async (e) => {
    try {
      e.preventDefault();

      const res = await removeBook(book.id, token);
      alert(res.data.message);

      if (res.data.status === 200) {
        navigate("/home");
      }
    } catch (error) {
      console.log(error);
    }
  };

  const addBook = async (e) => {
    try {
      e.preventDefault();

      if (title == "" && urlImage == "" && description == "") {
        return alert("Please enter Required Field!");
      }

      const data = {
        title,
        urlImage,
        description,
      };

      const res = await createBook(data, token);
      if (res.data.status === 201) {
        setBooks([...books, res.data.data]);
      }
      alert(res.data.message);
      console.log(books);
    } catch (error) {
      console.log(error);
    }
  };

  const editBook = async (e) => {
    try {
      e.preventDefault();

      if (title == "" && urlImage == "" && description == "") {
        return alert("Please enter Required Field!");
      }

      const data = {
        title,
        urlImage,
        description,
      };

      const res = await updateBook(data, book.id, token);
      alert(res.data.message);
      // console.log(res.data,'resp');
      if (res.data.status === 200) {
        setBook(res.data.data);
      }
      // console.log(book,'book'); //booknya telat berubah, mungkin karena keduluan dari setbooknya
    } catch (error) {
      console.log(error);
    }
  };

  return modalName == "delete" ? (
    // {/* <!-- Modal delete--> */}
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
            <h2 className="text-center">
              Are you sure you want to delete book with title{" "}
              <span className="fw-bold title-book-delete">{book?.title}</span> ?
            </h2>
          </div>
          <div className="modal-footer px-5 border-0 d-flex gap-3">
            <button
              type="button"
              className="btn btn-danger fs-5 m-0 w-25"
              id="confirm-delete-yes-button"
              data-bs-toggle="modal"
              data-bs-target={`#${modalName}Modal`}
              onClick={(e) => deleteBook(e)}
            >
              Yes
            </button>
            <button
              type="button"
              className="btn btn-success fs-5 m-0 w-25"
              id="confirm-delete-no-button"
              data-bs-toggle="modal"
              data-bs-target={`#${modalName}Modal`}
            >
              No
            </button>
          </div>
        </div>
      </div>
    </div>
  ) : (
    // Modal edit/add
    <div
      className="modal fade"
      id={`${modalName}Modal`}
      tabIndex="-1"
      aria-labelledby={`${modalName}ModalLabel`}
      aria-hidden="true"
    >
      <div className="modal-dialog modal-dialog-centered modal-lg">
        <div className="modal-content">
          <div className="modal-header px-5 border-0">
            <h1
              className="modal-title fs-3 text-black"
              id={`${modalName}ModalLabel`}
              style={{ textTransform: "capitalize" }}
            >
              {`${modalName} Data`}
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
                <label htmlFor="title-book" className="col-md-4 p-0 fs-5">
                  Title
                </label>
                <input
                  id="title"
                  name="text"
                  type="text"
                  className="col-8 rounded-2 border-1 book-detail-input lh-lg"
                  placeholder={book ? book.title : "Dilan 1990"}
                  onChange={(e) => setTitle(e.target.value)}
                  // value={book ? book.title : ""}
                />
              </div>
              <div className="row align-items-center">
                <label htmlFor="url-image-book" className="col-md-4 p-0 fs-5">
                  Url Image
                </label>
                <input
                  id="url-image"
                  name="url-image"
                  type="text"
                  className="col-8 rounded-2 border-1 book-detail-input lh-lg"
                  placeholder={
                    book ? book.urlImage : "http://gambar.com/dilan.jpg"
                  }
                  onChange={(e) => setUrlImage(e.target.value)}
                  // value={book ? book.urlImage : ""}
                />
              </div>
              <div className="row align-items-start">
                <label htmlFor="description-book" className="col-md-4 p-0 fs-5">
                  Description
                </label>
                <textarea
                  className="col-8 rounded-2 border-1 book-detail-input lh-lg"
                  name="description-book"
                  id="description-book"
                  cols="30"
                  rows="4"
                  placeholder={
                    book
                      ? book.description
                      : "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin ac diam eget est rutrum ultrices. Donec laoreet enim a massa dapibus, cursus egestas dui pulvinar."
                  }
                  onChange={(e) => setDescription(e.target.value)}
                  // value={book ? book.description : ""}
                ></textarea>
              </div>
            </div>
          </div>
          <div className="modal-footer px-5 border-0">
            <button
              type="button"
              className="btn btn-warning save-button fs-5 m-0"
              id="save-add-detail-button"
              data-bs-toggle="modal"
              data-bs-target={`#${modalName}Modal`}
              onClick={
                modalName == "add" ? (e) => addBook(e) : (e) => editBook(e)
              }
            >
              Save
            </button>
          </div>
        </div>
      </div>
    </div>
  );
}

export default ModalBook;
