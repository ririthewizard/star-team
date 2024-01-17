import React, { useState } from 'react';

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
              } else {
                // Login failed, handle error
                console.error('Login failed');
              }
            } catch (error) {
              console.error('Error during login:', error);
            }
          ;
    // If successful, update the loggedIn state:

    const response = await loginUser(username, password);

    // Check if the login was successful based on the response
    if (response.success) {
      // If successful, update the loggedIn state
      setLoggedIn(true);
    } else {
      // If login failed, handle the error (display an error message, etc.)
      console.error('Login failed:', response.error);
    }
  }; catch (error) {
    // Handle other errors (e.g., network issues)
    console.error('Error during login:', error);
  }

    setLoggedIn(true);}
  

  return (
    <div>
      <header>
        {/* ... Header content */}
      </header>
      <main>
        <h1>Login</h1>
        <form onSubmit={handleLogin}>
          {/* ... Form fields for username and password */}
          <button type="submit">Log In</button>
        </form>
        <p className="mt-5">
          Don't have an account? <a href="/register">Register here.</a>
        </p>
      </main>
    </div>
  );
};

export default Login;













// import React, { useState } from 'react';
// import { Grid, Paper, Avatar, TextField, Button, Typography, Link } from '@mui/material';
// import LockOutlinedIcon from '@mui/icons-material/LockOutlined';
// import Checkbox from '@mui/material/Checkbox';
// import FormControlLabel from '@mui/material/FormControlLabel';


// const Login = () => {
//   const [username, setUsername] = useState('');
//   const [password, setPassword] = useState('');

//   const handleLogin = async (e) => {
//     e.preventDefault(); // Prevents the default form submission behavior

//     try {
//       const response = await fetch('http://localhost:8080/login', {
//         method: 'POST',
//         headers: {
//           'Content-Type': 'application/json',
//         },
//         body: JSON.stringify({ username, password }),
//       });

//       if (response.ok) {
//         // Login successful, handle further actions
//         console.log('Login successful');
//       } else {
//         // Login failed, handle error
//         console.error('Login failed');
//       }
//     } catch (error) {
//       console.error('Error during login:', error);
//     }
//   };

//   const paperStyle = { padding: '20px', width: '280px' };
//   const avatarStyle = { backgroundColor: '#38c4cbeb' };
//   const btnstyle = { margin: '8px 0' };

//   return (
//     <Grid style={{ height: '70vh' }}>
//       <Paper elevation={10} style={paperStyle}>
//         <form onSubmit={handleLogin}>
//           <Grid align="center">
//             <Avatar style={avatarStyle}>
//               <LockOutlinedIcon></LockOutlinedIcon>
//             </Avatar>
//             <h2>Sign In</h2>
//           </Grid>
//           <TextField
//             label='Username'
//             placeholder='Enter Username'
//             required
//             value={username}
//             onChange={(e) => setUsername(e.target.value)}
//           />
//           <TextField
//             label='Password'
//             placeholder='Enter Password'
//             type='password'
//             required
//             value={password}
//             onChange={(e) => setPassword(e.target.value)}
//           />
//           <FormControlLabel
//             value="bottom"
//             control={<Checkbox />}
//             label="Remember me"
//             labelPlacement="right"
//           />
//           <Button type='submit' color='primary' variant='contained' style={btnstyle} fullWidth>
//             Sign In
//           </Button>
//         </form>
//         <Typography>
//           <Link href='#'>Forgot your password</Link>
//         </Typography>
//         <Typography>
//           Are you registered? <Link href='#'>Register</Link>
//         </Typography>
//       </Paper>
//     </Grid>
//   );
// };

// export default Login;

