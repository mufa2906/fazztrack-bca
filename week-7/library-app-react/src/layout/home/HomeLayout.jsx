import CardHome from "../../components/cardHome/CardHome";
import CardWrapperHome from "../../components/cardWrapperHome/CardWrapperHome";
import CarouselHome from "../../components/carouselHome/CarouselHome";
import CarouselWrapperHome from "../../components/carouselWrapperHome/CarouselWrapperHome";
import Sidebar from "../../components/sidebarHome/SidebarHome";
import NavbarHome from "../../components/navbarHome/NavbarHome";
import PropTypes from "prop-types";
import { useState } from "react";
import { getBooks } from "../../services/book";
import { useEffect } from "react";
import ModalBook from "../../components/modalBook/ModalBook";
import "./HomeLayout.css";

function HomeLayout() {
  // const [token, setToken] = useState([]);
  const [books, setBooks] = useState([]);

  const fetchBooks = async () => {
    try {
      const res = await getBooks();
      console.log(res);
      //filter isDeleted dari front end
      // setBooks(res.data.data.filter((book) => book.isDeleted === false));
      setBooks(res.data.data);
    } catch (error) {
      console.log(error);
    }
  };

  useEffect(() => {
    fetchBooks();
  }, []);

  return (
    <>
      <div className="container-fluid p-0 d-flex">
        <ModalBook modalName={"add"} books={books} setBooks={setBooks} />
        <Sidebar />
        <section className="bg-blue container-fluid flex-fill p-0 h-100">
          <NavbarHome />
          <main className="container-fluid p-0">
            <CarouselWrapperHome>
              {books.map((book) => {
                return (
                  <CarouselHome
                    key={book?.id}
                    id={book?.id}
                    image={book?.urlImage}
                    title={book?.title}
                    description={book?.description}
                  />
                );
              })}
              {/* {books.length > 0 ? (
              books.slice(0, 5).map((book) => {
                return (
                  <CarouselHome
                    key={book.id}
                    id={book.id}
                    image={book.urlImage}
                    title={book.title}
                    description={book.description}
                  />
                );
              })
            ) : (
              <h1>Takde</h1>
            )} */}
            </CarouselWrapperHome>
            <CardWrapperHome>
              {books.map((book) => {
                return (
                  <CardHome
                    key={book?.id}
                    id={book?.id}
                    image={book?.urlImage}
                    title={book?.title}
                    description={book?.description}
                  />
                );
              })}
              {/* {books.length > 0 ? (
              books.slice(0, 5).map((book) => {
                return (
                  <CardHome
                    key={book.id}
                    id={book.id}
                    image={book.urlImage}
                    title={book.title}
                    description={book.description}
                  />
                );
              })
            ) : (
              <h1>Takde</h1>
            )} */}
            </CardWrapperHome>
          </main>
        </section>
      </div>
    </>
  );
}
HomeLayout.propTypes = {
  children: PropTypes.element,
};

export default HomeLayout;
