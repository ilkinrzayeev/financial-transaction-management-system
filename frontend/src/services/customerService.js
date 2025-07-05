import axios from 'axios';

const API_URL = 'http://localhost:8080/api/v1/customers';

export const createCustomer = (data) => axios.post(API_URL, data);
export const getCustomer = (id) => axios.get(`${API_URL}/${id}`);