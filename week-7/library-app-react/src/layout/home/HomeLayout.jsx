import CardHome from "../../components/cardHome/CardHome";
import CardWrapperHome from "../../components/cardWrapperHome/CardWrapperHome";
import CarouselHome from "../../components/carouselHome/CarouselHome";
import CarouselWrapperHome from "../../components/carouselWrapperHome/CarouselWrapperHome";
import HeaderHome from "../../components/headerHome/HeaderHome";
import Sidebar from "../../components/sidebarHome/SidebarHome";
import PropTypes from "prop-types";
import "./HomeLayout.css";
import { useState } from "react";
import { getBooks } from "../../services/book";
import { useEffect } from "react";

function HomeLayout() {
  // const [carousels, setCarousels] = useState([]);
  const [books, setBooks] = useState([]);

  const fetchBooks = async () => {
    try {
      const res = await getBooks();
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
        <Sidebar />
        <section className="bg-blue container-fluid flex-fill p-0 h-100">
          <HeaderHome />
          <main className="container-fluid p-0">
            <CarouselWrapperHome>
              {books.slice(0, 5).map((book) => {
                return (
                  <CarouselHome
                    key={book.id}
                    id={book.id}
                    image={book.urlImage}
                    title={book.title}
                    description={book.description}
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
              {books.slice(0, 5).map((book) => {
                return (
                  <CardHome
                    key={book.id}
                    id={book.id}
                    image={book.urlImage}
                    title={book.title}
                    description={book.description}
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
