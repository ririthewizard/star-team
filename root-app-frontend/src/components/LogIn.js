import React, { useState } from 'react';
import { Grid, Paper, Avatar, TextField, Button, Typography, Link } from '@mui/material';
import LockOutlinedIcon from '@mui/icons-material/LockOutlined';
import Checkbox from '@mui/material/Checkbox';
import FormControlLabel from '@mui/material/FormControlLabel';
import { Routes, Route, Link as RouterLink, useNavigate } from 'react-router-dom';
import Home from './Home';

const Login = () => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const navigate = useNavigate();

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
        console.log('Login successful');
        setIsLoggedIn(true);
        navigate('/home');
      } else {
        console.error('Login failed');
        setIsLoggedIn(false);
      }
    } catch (error) {
      console.error('Error during login:', error);
    }
  };

  const paperStyle = { padding: '20px', width: '280px' };
  const avatarStyle = { backgroundColor: '#38c4cbeb' };
  const btnstyle = { margin: '8px 0' };

  return (
    <Grid style={{ height: '70vh' }}>
      <Paper elevation={10} style={paperStyle}>
        {isLoggedIn ? (
          <>
            <div className="App">
              <h1>The garden builder application</h1>
            </div>
            <nav>
              <ul>
                <li>
                  <Link component={RouterLink} to="/home">
                    Home
                  </Link>
                </li>
              </ul>
            </nav>
            <Routes>
              <Route path="/home" element={<Home />} />
            </Routes>
          </>
        ) : (
          <form onSubmit={handleLogin}>
            <Grid align="center">
              <Avatar style={avatarStyle}>
                <LockOutlinedIcon />
              </Avatar>
              <h2>Sign In</h2>
            </Grid>
            <TextField
              label="Username"
              placeholder="Enter Username"
              required
              value={username}
              onChange={(e) => setUsername(e.target.value)}
            />
            <TextField
              label="Password"
              placeholder="Enter Password"
              type="password"
              required
              value={password}
              onChange={(e) => setPassword(e.target.value)}
            />
            <FormControlLabel
              value="bottom"
              control={<Checkbox />}
              label="Remember me"
              labelPlacement="right"
            />
            <Button type="submit" color="primary" variant="contained" style={btnstyle} fullWidth>
              Sign In
            </Button>
          </form>
        )}
        <Typography>
          <Link href="#">Forgot your password</Link>
        </Typography>
        <Typography>
          Are you registered? <Link href="#">Register</Link>
        </Typography>
      </Paper>
    </Grid>
  );
};

export default Login;
