import React from 'react';
import { Grid, Paper,Avatar,TextField } from '@mui/material';
import LockOutlinedIcon from '@mui/icons-material/LockOutlined';

// import { green, pink } from '@mui/material/colors';
// import Avatar from '@mui/material/Avatar';
// import Stack from '@mui/material/Stack';
// import FolderIcon from '@mui/icons-material/Folder';
// import PageviewIcon from '@mui/icons-material/Pageview';
// import AssignmentIcon from '@mui/icons-material/Assignment';

const Login = () => {

    const paperStyle={ padding: '20px', width: '280px' };
    const avatarStyle={backgroundColor:'#38c4cbeb'}
  return (
    <Grid style={{ height: '70vh' }}>
      <Paper elevation={10} style={paperStyle}>
        <Grid align="center">
        <Avatar style={avatarStyle}> <LockOutlinedIcon></LockOutlinedIcon> </Avatar>
        
        <h2>Sign In</h2>
        </Grid>
        <TextField label='Username' placeholder='Enter Username'required></TextField>
        <TextField label='Password' placeholder='Enter Password'type='password' required></TextField>

        
      </Paper>
    </Grid>
  );
};

export default Login;
