import React, { useState, useEffect } from 'react';
import { BrowserRouter as Router, Link, Routes, Route } from 'react-router-dom';
import Header from './components/Header';
import Login from './components/Login';
import Register from './components/Register';
// import AddSeed from './components/Seeds/AddSeed';
// import ViewSeed from './components/Seeds/ViewSeed';
// import AddPlant from './components/Plants/AddPlant';
// import ViewPlant from './components/Plants/ViewPlant';
// import AddSoil from './components/Soils/AddSoil';
// import ViewSoil from './components/Soils/ViewSoil';
// import AddGarden from './components/Gardens/AddGarden';
// import ViewGarden from './components/Gardens/ViewGarden';
// import AddJournal from './components/Journal/AddJournal';
// import ViewJournal from './components/Journal/ViewJournal';
// import Home from './components/Home';

const App = () => {
  const [loggedIn, setLoggedIn] = useState(false);

  useEffect(() => {
    // Add logic to check session status
    const fetchSessionStatus = async () => {
      try {
        const response = await fetch('http://localhost:8080/checkSession');
        if (response.ok) {
          const data = await response.json();
          setLoggedIn(data);
        }
      } catch (error) {
        console.error('Error checking session status:', error);
      }
    };

    fetchSessionStatus();
  }, []);

  return (
    <Router>
      <Header loggedIn={loggedIn} />
      {/* ... rest of your routes */}
      <div className="App">
        <h1>The garden builder application</h1>
      </div>

      <nav>
        <ul>
          {/* Link is like an anchor tag <a>, and to= is like href */}
          <li>
            <Link to="/home">Home</Link>
          </li>
          <li>
            <Link to="/login">Login</Link>
          </li>
          <li>
            <Link to="/register">Register</Link>
          </li>
          {/* ... other navigation links */}
        </ul>
      </nav>

      <Routes>
        {/* path determines the URL, element determines which component is used. */}
        {/* <Route path="/home" element={<Home />} /> */}
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />
        {/* ... other routes */}
      </Routes>
    </Router>
  );
};

export default App;
