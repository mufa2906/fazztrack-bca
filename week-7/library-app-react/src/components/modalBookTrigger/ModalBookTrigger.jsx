import React from "react";

function ModalBookTrigger({modalName}) {
  return (
    // {/* <!-- Button trigger edit modal --> */}
    <button
      type="button"
      className="btn text-white fs-4 p-0"
      data-bs-toggle="modal"
      data-bs-target={`#${modalName}Modal`}
      style={{ textTransform: "capitalize" }}
    >
      {modalName}
    </button>
  );
}

export default ModalBookTrigger;
