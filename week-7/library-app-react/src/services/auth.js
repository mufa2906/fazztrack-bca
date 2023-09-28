const BASEURL = import.meta.env.VITE_API_URL_DEV;

import { fetchApi } from "../configs/api";

export const registerUser = async ( data ) => {
  try {
    const url = `${BASEURL}/users`;
    const response = await fetchApi({ url, method: "POST", data });

    return response;
  } catch (error) {
    console.log(error);
  }
};

export const loginUser = async ( data ) => {
  try {
    const url = `${BASEURL}/users/login`;
    const response = await fetchApi({ url, method: "POST", data });
    return response;
  } catch (error) {
    console.log(error);
  }
};
