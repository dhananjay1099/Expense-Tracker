import React, { useEffect, useState } from "react";

function CategoryList() {
  const [categories, setCategories] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/api/categories")
      .then((res) => res.json())
      .then(setCategories);
  }, []);

  return (
    <div>
      <h2>Categories</h2>
      <ul>
        {categories.map((c) => (
          <li key={c.id}>{c.name}</li>
        ))}
      </ul>
    </div>
  );
}

export default CategoryList; 