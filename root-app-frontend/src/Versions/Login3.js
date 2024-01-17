import React, { useState } from 'react';
import { Link } from 'react-router-dom';

const Login = ({ setLoggedIn }) => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');

  const handleLogin = async (e) => {
    e.preventDefault();

    try {
      const response = await fetch('http://localhost:8080/login', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ username, password }),
      });

      if (response.ok) {
        // Login successful, handle further actions
        console.log('Login successful');
        // If successful, update the loggedIn state:
        setLoggedIn(true);
      } else {
        // Login failed, handle error
        console.error('Login failed');
      }
    } catch (error) {
      // Handle network errors
      console.error('Error during login:', error);
    }
  };

  return (
    <main>
      <h1>Log In</h1>
      <form onSubmit={handleLogin}>
        <div className="container">
          <div className="row">
            <div className="form-item col-4">
              <label htmlFor="username">Username</label>
              <input
                type="text"
                id="username"
                value={username}
                onChange={(e) => setUsername(e.target.value)}
              />
            </div>
          </div>
        </div>
        <div className="container">
          <div className="row">
            <div className="form-item col-4">
              <label htmlFor="password">Password</label>
              <input
                type="password"
                id="password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
              />
            </div>
          </div>
        </div>

        <button type="submit">Log In</button>
      </form>

      <p className="mt-5">
        Don't have an account? <Link to="/register">Register here.</Link>
      </p>
    </main>
  );
};

export default Login;