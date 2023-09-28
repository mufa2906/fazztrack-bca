import React from "react";
import { Link } from "react-router-dom";

function DropdownItemHome({ item }) {
  return (
    <>
      <li>
        <Link className="dropdown-item" to="#">
          {item}
        </Link>
      </li>
    </>
  );
}

export default DropdownItemHome;
