import { Link } from "react-router-dom";
import PropTypes from "prop-types";
import './CarouselHome.css'
function CarouselHome({ id, image, title }) {
  return (
    <>
      <Link
        to={`../books/${id}`}
        className="carousel-cell rounded-4"
        style={{ backgroundImage: `url(${image})` }}
      >
        <div className="h-100 d-flex flex-column">
          <div className="h-50"></div>
          <div className="desc-book d-flex flex-column justify-content-end p-4 container-fluid h-50 rounded-bottom-4">
            <h2 className="text-white">{title}</h2>
            <h6 className="text-white">Raditya Dika</h6>
          </div>
        </div>
      </Link>
    </>
  );
}

CarouselHome.propTypes = {
  id: PropTypes.string,
  image: PropTypes.string,
  title: PropTypes.string,
};

export default CarouselHome;
