import { Routes, Route } from "react-router-dom";
import EmployeePage from "../pages/EmployeePage";

function AppRoutes() {
  return (
    <Routes>
      <Route path="/" element={<EmployeePage />} />
      <Route path="/employees" element={<EmployeePage />} />
    </Routes>
  );
}

export default AppRoutes;