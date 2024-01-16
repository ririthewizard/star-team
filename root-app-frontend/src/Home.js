// Home.jsx

import React from 'react';

const Home = ({ headingText }) => {
  return (
    <html lang="en">
      <head>
      <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>ROOT</title>
      </head>
      <body>
        {/* <header>
          {/* Include your header content here */}
        {/* </header> */} 
        <main>
          <h2>{headingText}</h2>
          <p>This portal will allow you to help manage your garden.</p>
          <p>
            Please, <a href='/login'>Log In</a> or{' '}
            <a href='/register'>Register</a>.
          </p>
        </main>
      </body>
    </html>
  );
};

export default Home;
