import CardHome from "../../components/cardHome/CardHome";
import CardWrapperHome from "../../components/cardWrapperHome/CardWrapperHome";
import CarouselHome from "../../components/carouselHome/CarouselHome";
import CarouselWrapperHome from "../../components/carouselWrapperHome/CarouselWrapperHome";
import HeaderHome from "../../components/headerHome/HeaderHome";
import Sidebar from "../../components/sidebarHome/SidebarHome";
import PropTypes from "prop-types";
import './HomeLayout.css'
import { useState } from "react";

function HomeLayout() {
  const [carousels, setCarousels] = useState([]);
  const [books, setBooks] = useState([]);

  const carousels= [
    {
      imgUrl :
    }
  ]



  return (
    <>
      <div className="container-fluid p-0 d-flex">
        <Sidebar />
        <section className="bg-blue container-fluid flex-fill p-0 h-100">
          <HeaderHome />
          <main className="container-fluid p-0">
            <CarouselWrapperHome>
              <CarouselHome />
            </CarouselWrapperHome>
            <CardWrapperHome>
              <CardHome />
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
