import { useEffect, useState } from "react";
import EmployeeForm from "../components/EmployeeForm";
import EmployeeList from "../components/EmployeeList";
import { getAllEmployees } from "../services/employeeService";

function EmployeePage() {
  const [employees, setEmployees] = useState([]);

  const fetchEmployees = async () => {
    try {
      const response = await getAllEmployees();
      setEmployees(response.data);
    } catch (error) {
      console.error("Error fetching employees", error);
    }
  };

  useEffect(() => {
    fetchEmployees();
  }, []);

  return (
    <div className="container">
      <EmployeeForm onEmployeeAdded={fetchEmployees} />
      <EmployeeList
        employees={employees}
        onEmployeeDeleted={fetchEmployees}
      />
    </div>
  );
}

export default EmployeePage;