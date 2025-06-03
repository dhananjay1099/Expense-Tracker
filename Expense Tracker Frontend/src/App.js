import React from "react";
import ExpenseList from "./components/ExpenseList";
import AddExpense from "./components/AddExpense";
import CategoryList from "./components/CategoryList";
import AddCategory from "./components/AddCategory";
import UserList from "./components/UserList";
import AddUser from "./components/AddUser";

function App() {
  return (
    <div style={{ maxWidth: 800, margin: "auto", padding: 20 }}>
      <h1>Expense Tracker</h1>
      <AddUser />
      <UserList />
      <AddCategory />
      <CategoryList />
      <AddExpense />
      <ExpenseList />
    </div>
  );
}

export default App; 