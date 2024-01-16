import React, { useEffect } from 'react';

const Logout = () => {
  useEffect(() => {
    const logoutUser = async () => {
      try {
        const response = await fetch('http://localhost:8080/logout', {
          method: 'GET',
          credentials: 'include',  // Include credentials for session-based authentication
        });

        if (response.ok) {
          console.log('Logout successful');
          
        } else {
          console.error('Logout failed');
        }
      } catch (error) {
        console.error('Error during logout:', error);
      }
    };

    logoutUser();
  }, []);

  return (
    <div>
      <p>Logging out...</p>
    </div>
  );
};

export default Logout;
