import React from 'react';
import { Grid, Paper } from '@mui/material';

const Login = () => {
  return (
    <Grid container justifyContent="center" alignItems="center" style={{ height: '100vh' }}>
      <Paper elevation={10} style={{ padding: '20px', width: '300px' }}>
        Sign in
      </Paper>
    </Grid>
  );
};

export default Login;
