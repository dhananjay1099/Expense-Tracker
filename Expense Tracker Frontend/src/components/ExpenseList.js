import React, { useEffect, useState } from "react";

function ExpenseList() {
  const [expenses, setExpenses] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/api/expenses")
      .then((res) => res.json())
      .then(setExpenses);
  }, []);

  return (
    <div>
      <h2>Expenses</h2>
      <table border="1" cellPadding="8" style={{ width: "100%" }}>
        <thead>
          <tr>
            <th>ID</th>
            <th>Amount</th>
            <th>Description</th>
            <th>Date</th>
            <th>User</th>
            <th>Category</th>
          </tr>
        </thead>
        <tbody>
          {expenses.map((e) => (
            <tr key={e.id}>
              <td>{e.id}</td>
              <td>{e.amount}</td>
              <td>{e.description}</td>
              <td>{e.date}</td>
              <td>{e.user?.name}</td>
              <td>{e.category?.name}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default ExpenseList; 