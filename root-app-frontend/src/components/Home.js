
import React, { useState, useEffect } from 'react';

const Home = () => {
  const [homes, setHomes] = useState([]);

  useEffect(() => {
    const fetchHomes = async () => {
      try {
        const response = await fetch('http://localhost:8080/home');
        if (response.ok) {
          const data = await response.json();
          setHomes(data);
        } else {
          console.error('Failed to fetch home');
        }
      } catch (error) {
        console.error('Error during fetch:', error);
      }
    };

    fetchHomes();
  }, []); // Empty dependency array ensures this effect runs only once on component mount

  return (
    <div>
      <h1>Homepage</h1>
      <ul>
        {homes.map((home) => (
          <li key={home.id}>{home.name}</li>
        ))}
      </ul>
    </div>
  );
};

export default Home;
