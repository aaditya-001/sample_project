import { deleteEmployee } from "../services/employeeService";

function EmployeeList({ employees, onEmployeeDeleted }) {
  const handleDelete = async (id) => {
    const confirmDelete = window.confirm("Are you sure you want to delete this employee?");

    if (!confirmDelete) {
      return;
    }

    try {
      await deleteEmployee(id);
      onEmployeeDeleted();
    } catch (error) {
      alert("Error deleting employee");
      console.error(error);
    }
  };

  return (
    <div className="card">
      <h2>Employee List</h2>

      {employees.length === 0 ? (
        <p>No employees found</p>
      ) : (
        <table>
          <thead>
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Email</th>
              <th>Department</th>
              <th>Salary</th>
              <th>Action</th>
            </tr>
          </thead>

          <tbody>
            {employees.map((employee) => (
              <tr key={employee.id}>
                <td>{employee.id}</td>
                <td>{employee.name}</td>
                <td>{employee.email}</td>
                <td>{employee.department}</td>
                <td>₹{employee.salary}</td>
                <td>
                  <button
                    className="delete-btn"
                    onClick={() => handleDelete(employee.id)}
                  >
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
}

export default EmployeeList;