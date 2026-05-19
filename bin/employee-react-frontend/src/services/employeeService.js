import axios from "axios";

const API_BASE_URL = "http://localhost:8000/api/employees";

// If your backend is running on 8081, use this instead:
// const API_BASE_URL = "http://localhost:8081/api/employees";

export const getAllEmployees = () => {
  return axios.get(API_BASE_URL);
};

export const addEmployee = (employee) => {
  return axios.post(API_BASE_URL, employee);
};

export const deleteEmployee = (id) => {
  return axios.delete(`${API_BASE_URL}/${id}`);
};

export const updateEmployee = (id, employee) => {
  return axios.put(`${API_BASE_URL}/${id}`, employee);
};