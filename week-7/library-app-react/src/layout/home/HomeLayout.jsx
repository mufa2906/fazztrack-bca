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
      setBooks(res.data);
      console.log(books);
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
                return <CarouselHome image={book.image} key={book.id} />;
              })}
            </CarouselWrapperHome>
            <CardWrapperHome>
              {books.slice(0, 5).map((book) => {
                return <CardHome image={book.image} key={book.id} />;
              })}
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
