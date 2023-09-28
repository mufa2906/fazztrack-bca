import axios from "axios";

export const fetchApi = async ({ url, method, data, token }) => {
  try {
    const responseAxios = await axios({
      url,
      method,
      data,
      headers: {
        Authorization: 'Bearer ' + token
      }
    });
    return responseAxios;
  } catch (error) {
    return error.response;
  }
};
