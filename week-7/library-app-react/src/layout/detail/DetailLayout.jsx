import { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";
import backArrow from "../../assets/icons/arrow-left-solid.svg";
import ModalBook from "../../components/modalBook/ModalBook";
import ModalBookTrigger from "../../components/modalBookTrigger/ModalBookTrigger";
import { getBookById } from "../../services/book";
import "./DetailLayout.css";

function DetailLayout() {
  const [book, setBook] = useState({});
  const token = localStorage.getItem("token");
  const { bookId } = useParams();
  const role = localStorage.getItem("roles");
  const fetchBookById = async (bookId, token) => {
    try {
      const res = await getBookById(bookId, token);
      setBook(res.data.data);
      console.log(res);
    } catch (error) {
      console.log(error);
    }
  };

  useEffect(() => {
    fetchBookById(bookId, token);
  }, [bookId, token]);


  return (
    <>
      <main className="container-fluid d-flex flex-column p-0">
        <ModalBook modalName={"edit"} book={book} setBook={setBook} />
        <ModalBook modalName={"delete"} book={book} />
        <div
          className="image-hero-detail position-relative"
          id="image-hero-detail"
          style={{ backgroundImage: `url(${book?.urlImage})` }}
        >
          <div className="d-flex gap-3 p-3 me-3 text-white justify-content-between align-items-center">
            <div className="rounded-circle bg-white d-flex align-content-center back-arrow-container">
              <Link to="/home">
                <img
                  src={backArrow}
                  alt=""
                  className="position-block back-arrow"
                />
              </Link>
            </div>
            <div className={`justify-content-end gap-3 ${role==="ROLE_ADMIN"?"d-flex":"hide"}`}>
              <ModalBookTrigger modalName={"edit"} />
              <ModalBookTrigger modalName={"delete"} />
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
                {book?.title}
              </h2>
              <p className="fs-5 mb-1">30 Juni 2019</p>
            </div>
            <div className="availability-text-sect d-flex align-items-center w-25 justify-content-end">
              <h2 className="availability-text">Available</h2>
            </div>

            <div className="position-absolute image-detail-container w-25">
              <img
                id="image-detail"
                className="rounded"
                src={book?.urlImage}
                alt=""
              />
            </div>
          </section>
          <section className="d-flex description-sect">
            <p className="w-75 desc-book-detail mb-0" id="description-detail">
              {book?.description}
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
