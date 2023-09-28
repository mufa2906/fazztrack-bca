import React from "react";
import DropdownItemHome from "./DropdownItemHome";

function DropdownHome({ dropdownName,dropdownItem }) {
  return (
    <>
      <li className="nav-item dropdown">
        <a
          className="nav-link dropdown-toggle fw-bold"
          href="#"
          role="button"
          data-bs-toggle="dropdown"
          aria-expanded="false"
        >
          {dropdownName}
        </a>
        <ul className="dropdown-menu">
          {dropdownItem.map((item) => {
            return <DropdownItemHome key={item} item={item} />;
          })}
        </ul>
      </li>
    </>
  );
}

export default DropdownHome;
