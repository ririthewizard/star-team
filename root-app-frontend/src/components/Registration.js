import React, { useState } from 'react';

const RegistrationForm = () => {
  const [registrationForm, setRegistrationForm] = useState({
    username: '',
    password: '',
    verifyPassword: '',
  });

  const [errors, setErrors] = useState({
    username: '',
    password: '',
    verifyPassword: '',
  });

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setRegistrationForm((prevRegistrationForm) => ({
      ...prevRegistrationForm,
      [name]: value,
    }));
    setErrors((prevErrors) => ({
      ...prevErrors,
      [name]: '', // Clear the error when the user starts typing
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    // Validate the form before submission
    if (validateForm()) {
      // Handle form submission logic using registrationForm state
      console.log('Form submitted:', registrationForm);
    }
  };

  const validateForm = () => {
    let isValid = true;
    const newErrors = {};

    // Validate username
    if (registrationForm.username.trim() === '') {
      isValid = false;
      newErrors.username = 'Username is required';
    } else if (registrationForm.username.length < 3 || registrationForm.username.length > 20) {
      isValid = false;
      newErrors.username = 'Username must be between 3-20 characters long';
    }

    // Validate password
    if (registrationForm.password.trim() === '') {
      isValid = false;
      newErrors.password = 'Password is required';
    } else if (registrationForm.password.length < 9 || registrationForm.password.length > 20) {
      isValid = false;
      newErrors.password = 'Password must be between 9-20 characters long';
    }

    // Validate verifyPassword
    if (registrationForm.verifyPassword.trim() === '') {
      isValid = false;
      newErrors.verifyPassword = 'Verify Password is required';
    } else if (
      registrationForm.verifyPassword.length < 9 ||
      registrationForm.verifyPassword.length > 20
    ) {
      isValid = false;
      newErrors.verifyPassword = 'Verify Password must be between 9-20 characters long';
    } else if (registrationForm.verifyPassword !== registrationForm.password) {
      isValid = false;
      newErrors.verifyPassword = 'Passwords do not match';
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
          value={registrationForm.username}
          onChange={handleInputChange}
        />
        <p className="error">{errors.username}</p>
      </div>
      <div>
        <label htmlFor="password">Password</label>
        <input
          name="password"
          type="password"
          value={registrationForm.password}
          onChange={handleInputChange}
        />
        <p className="error">{errors.password}</p>
      </div>
      <div>
        <label htmlFor="verifyPassword">Verify Password</label>
        <input
          name="verifyPassword"
          type="password"
          value={registrationForm.verifyPassword}
          onChange={handleInputChange}
        />
        <p className="error">{errors.verifyPassword}</p>
      </div>
      <button type="submit">Register</button>
    </form>
  );
};

export default RegistrationForm;
