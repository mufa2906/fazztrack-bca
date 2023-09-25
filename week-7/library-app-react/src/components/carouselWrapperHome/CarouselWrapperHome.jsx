import PropTypes from "prop-types";
import Flickity from "react-flickity-component";
// import 'flickity/dist/flickity.pkgd'
import "flickity/dist/flickity.min.css";

const flickityOptions = {
  initialIndex: 0,
  wrapAround: true,
};

function CarouselWrapperHome({ children }) {
  return (
    <Flickity
      className={"carousel my-3 container-fluid p-0"} // default ''
      elementType={"div"} // default 'div'
      options={flickityOptions} // takes flickity options {}
      disableImagesLoaded={true} // default false
      reloadOnUpdate // default false
      static // default false
    >
      {children}
    </Flickity>
  );
}

CarouselWrapperHome.propTypes = {
  children: PropTypes.element,
};

export default CarouselWrapperHome;
