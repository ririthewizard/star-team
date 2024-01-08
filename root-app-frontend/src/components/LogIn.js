import React from 'react';
import { Grid, Paper,Avatar } from '@mui/material';
import LockOutlinedIcon from '@mui/icons-material/LockOutlined';

// import { green, pink } from '@mui/material/colors';
// import Avatar from '@mui/material/Avatar';
// import Stack from '@mui/material/Stack';
// import FolderIcon from '@mui/icons-material/Folder';
// import PageviewIcon from '@mui/icons-material/Pageview';
// import AssignmentIcon from '@mui/icons-material/Assignment';

const Login = () => {
  return (
    <Grid style={{ height: '70vh' }}>
      <Paper elevation={10} style={{ padding: '20px', width: '280px' }}>
        <Grid align="center">
        <Avatar> <LockOutlinedIcon></LockOutlinedIcon> </Avatar>
        
        <h2>Sign In</h2>
        </Grid>

        
      </Paper>
    </Grid>
  );
};

export default Login;
