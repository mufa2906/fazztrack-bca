const BASEURL = "https://ecommerce-api-dummy-a441c517136b.herokuapp.com/v1/api";

import { fetchApi } from "../configs/api";

export const getBooks = async () => {
  try {
    const url = `${BASEURL}/products`;
    const response = await fetchApi({ url, method: "GET" });

    // validasi kalau status error bukan success
    if (response.status !== 200) {
      const error = {
        status: true,
        message: "Error get data!",
      };
      return error;
    }
    return response;
  } catch (error) {
    console.log(error);
  }
};
