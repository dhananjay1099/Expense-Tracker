# Expense Tracker Frontend

This is the React frontend for the Expense Tracker application. It connects to a Spring Boot backend to manage users, categories, and expenses.

## Features
- Add and list users
- Add and list categories
- Add and list expenses
- Simple, clean UI

## Prerequisites
- [Node.js and npm](https://nodejs.org/) installed
- Spring Boot backend running at `http://localhost:8080` (see backend README for setup)

## Setup & Run

1. **Install dependencies:**
   ```bash
   npm install
   ```
2. **Start the React app:**
   ```bash
   npm start
   ```
   The app will open at [http://localhost:3000](http://localhost:3000)

## API Integration
- The frontend expects the backend API to be available at `http://localhost:8080/api/`
- Make sure to enable CORS in your Spring Boot backend for `http://localhost:3000`

## Folder Structure
```
Expense Tracker Frontend/
  ├── public/
  │    └── index.html
  ├── src/
  │    ├── components/
  │    │    ├── AddCategory.js
  │    │    ├── AddExpense.js
  │    │    ├── AddUser.js
  │    │    ├── CategoryList.js
  │    │    ├── ExpenseList.js
  │    │    └── UserList.js
  │    ├── App.js
  │    ├── App.css
  │    └── index.js
  └── package.json
```

## Customization
- You can add more features such as editing/deleting, filtering, or charts.
- Update the API URLs in the components if your backend runs on a different host/port.

## License
MIT 