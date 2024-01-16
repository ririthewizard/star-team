import React, { useState } from 'react';

const LoginForm = () => {
  const [loginForm, setLoginForm] = useState({
    username: '',
    password: '',
  });

  const [errors, setErrors] = useState({
    username: '',
    password: '',
  });

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setLoginForm((prevLoginForm) => ({
      ...prevLoginForm,
      [name]: value,
    }));
    setErrors((prevErrors) => ({
      ...prevErrors,
      [name]: '', // Clear the error when the user starts typing
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    // Validate the form before submission
    if (validateForm()) {
      try {
        const response = await fetch("http://localhost:8080/login", {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify(loginForm),
        });

        if (response.ok) {
          // Login successful, handle redirection or other actions
          console.log('Login successful');
        } else {
          // Login failed, handle errors
          console.error('Login failed');
        }
      } catch (error) {
        console.error('Error during login:', error);
      }
    }
  };

  const validateForm = () => {
    let isValid = true;
    const newErrors = {};

    // Validate username
    if (loginForm.username.trim() === '') {
      isValid = false;
      newErrors.username = 'Username is required';
    } else if (loginForm.username.length < 3 || loginForm.username.length > 20) {
      isValid = false;
      newErrors.username = 'Username must be between 3-20 characters long';
    }

    // Validate password
    if (loginForm.password.trim() === '') {
      isValid = false;
      newErrors.password = 'Password is required';
    } else if (loginForm.password.length < 9 || loginForm.password.length > 20) {
      isValid = false;
      newErrors.password = 'Password must be between 9-20 characters long';
    }

    setErrors(newErrors);
    return isValid;
  };

  return (
    <form method="post" onSubmit={handleSubmit}>
      <div>
        <label htmlFor="username">Username</label>
        <input
          name="username"
          type="text"
          value={loginForm.username}
          onChange={handleInputChange}
        />
        <p className="error">{errors.username}</p>
      </div>
      <div>
        <label htmlFor="password">Password</label>
        <input
          name="password"
          type="password"
          value={loginForm.password}
          onChange={handleInputChange}
        />
        <p className="error">{errors.password}</p>
      </div>
      <button type="submit">Log In</button>
    </form>
  );
};

export default LoginForm;
